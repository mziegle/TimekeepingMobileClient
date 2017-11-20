package ziegler0.edu.hm.timekeepingmobileclient;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.joda.time.LocalDate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class TimekeepingActivity extends AppCompatActivity {

    private ListView lv;

    private Worker thisWorker;

    public static final String ASSIGNMENT_RESOURCE_URL = "http://192.168.0.111:8080/worker/{username}/assignments?year={year}&month={month}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timekeeping);

        Intent intent = getIntent();

        Worker worker = (Worker) intent.getSerializableExtra(LoginActivity.INTENT_KEY_WORKER);

        thisWorker = worker;

        lv = (ListView) findViewById(R.id.assignmentListView);


        new AssignmentDataProvider().execute((Void) null);

    }

    public class AssignmentDataProvider extends AsyncTask <Void, Void, List<Assignment>> {


        @Override
        protected List<Assignment> doInBackground(Void... params) {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            LocalDate now = LocalDate.now();
            List<Assignment> assignments = restTemplate.getForObject(
                    ASSIGNMENT_RESOURCE_URL,
                    List.class,thisWorker.getUsername(),
                    now.getYear(),
                    now.getMonthOfYear());

            return assignments;
        }


        @Override
        protected void onPostExecute(List<Assignment> assignments){

            lv.setAdapter(new ArrayAdapter<Assignment>(TimekeepingActivity.this,android.R.layout.simple_list_item_1,assignments));


        }
    }

}
