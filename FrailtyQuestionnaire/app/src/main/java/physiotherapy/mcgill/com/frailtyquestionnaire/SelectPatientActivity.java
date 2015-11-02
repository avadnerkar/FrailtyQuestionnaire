package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SelectPatientActivity extends AppCompatActivity {

    private ArrayList<String> items;
    public static ListAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_patient);

        final Context context = this;
        listView = (ListView) findViewById(R.id.list);

        Cursor cursor = HomeActivity.myDb.getAllRowData();

        items = new ArrayList<>();
        final int[] IDarray = new int[cursor.getCount()];

        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(cursor.getColumnIndex(DBAdapter.KEY_ROWID));
                String hospitalID = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_HOSPITALID))!=null ? cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_HOSPITALID)): "";
                String firstName = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_FIRSTNAME)) != null ? cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_FIRSTNAME)) : "";
                String lastName = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_LASTNAME)) != null ? cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_LASTNAME)) : "";

                IDarray[cursor.getPosition()] = id;
                items.add(hospitalID + " " + firstName + " " + lastName);

            } while(cursor.moveToNext());
        }


        adapter = new ListAdapter(this, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomeActivity.currentPatientID = IDarray[i];
                Intent intent = new Intent(context, QuestionnaireActivity.class);
                startActivity(intent);
                ((Activity)context).finish();

            }
        });

    }


    public class ListAdapter extends ArrayAdapter<String> {
        private Context context;
        private List<String> items;

        public ListAdapter(Context context, List<String> items){
            super(context, R.layout.cell_select_patient, items);
            this.context = context;
            this.items = items;
        }


        //******************************* Array adapter methods ***********************************//
        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.cell_select_patient, parent, false);
            }

            TextView title = (TextView) convertView.findViewById(R.id.title);
            title.setText(items.get(position));

            return convertView;
        }
    }
}
