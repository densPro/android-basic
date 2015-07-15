package com.example.denis.weather;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 15/07/2015.
 */
public class WeatherActivity extends ActionBarActivity {

    private TextView tempView, pressureView, humidityView, temp_minView, temp_maxView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setTitle(getIntent().getExtras().getString("cityKey"));
        new HttpGetTask().execute();
        tempView = (TextView)findViewById(R.id.tempView);
        pressureView = (TextView)findViewById(R.id.pressureView);
        humidityView = (TextView)findViewById(R.id.humidityView);
        temp_minView = (TextView)findViewById(R.id.temp_minView);
        temp_maxView = (TextView)findViewById(R.id.temp_maxView);
    }

    private class HttpGetTask extends AsyncTask<Void, Void, List<String>> {

        // Get your own user name at http://www.geonames.org/login
        private String PLACE;

        private String URL = "http://api.openweathermap.org/data/2.5/weather?q=";


        AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

        @Override
        protected List<String> doInBackground(Void... params) {
            PLACE  = getIntent().getExtras().getString("cityKey");
            if(PLACE.isEmpty()){
                PLACE = "cochabamba";
            }
            HttpGet request = new HttpGet(URL + PLACE);
            JSONResponseHandler responseHandler = new JSONResponseHandler();
            try {
                return mClient.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<String> result) {
            if (null != mClient)
                mClient.close();
            // kelvin to celsius
            Double celsius = Double.parseDouble(result.get(0)) -272.15;

            tempView.setText(celsius.toString()+" C");
            pressureView.setText(result.get(1));
            humidityView.setText(result.get(2));
            temp_minView.setText(result.get(3));
            temp_maxView.setText(result.get(4));
        }
    }

    private class JSONResponseHandler implements ResponseHandler<List<String>> {

        private static final String MAIN_TAG = "main";
        private static final String TEMPERATURE_TAG = "temp";
        private static final String PRESSURE_TAG = "pressure";
        private static final String HUMIDITY_TAG = "humidity";
        private static final String TEMP_MIN_TAG = "temp_min";
        private static final String TEMP_MAX_TAG = "temp_max";


        @Override
        public List<String> handleResponse(HttpResponse response)
                throws ClientProtocolException, IOException {
            List<String> result = new ArrayList<String>();
            String JSONResponse = new BasicResponseHandler()
                    .handleResponse(response);
            try {

                // Get top-level JSON Object - a Map
                JSONObject responseObject = (JSONObject) new JSONTokener(
                        JSONResponse).nextValue();

                // Extract value of "weatherArray" key -- a List
                JSONObject weatherObject = responseObject.getJSONObject(MAIN_TAG);

                result.add(weatherObject.get(TEMPERATURE_TAG).toString());
                result.add(PRESSURE_TAG + " : " + weatherObject.get(PRESSURE_TAG));
                result.add(HUMIDITY_TAG + " : " + weatherObject.get(HUMIDITY_TAG));
                result.add(TEMP_MIN_TAG + " : " + weatherObject.get(TEMPERATURE_TAG));
                result.add(TEMP_MAX_TAG + " : " + weatherObject.get(TEMP_MAX_TAG));


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
