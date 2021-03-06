package physiotherapy.mcgill.com.frailtyquestionnaire.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.DBAdapter;
import physiotherapy.mcgill.com.frailtyquestionnaire.Dialogs.DialogQuestionnaireSelector;
import physiotherapy.mcgill.com.frailtyquestionnaire.DataManagers.ItemSection;
import physiotherapy.mcgill.com.frailtyquestionnaire.R;

public class SelectPatientActivity extends AppCompatActivity {

    private ArrayList<String> items;
    public static ListAdapter adapter;
    private ListView listView;
    private boolean[] selectedArray;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_patient);

        context = this;
        listView = (ListView) findViewById(R.id.list);

        Cursor cursor = HomeActivity.myDb.getAllRowData();

        items = new ArrayList<>();
        final int[] IDarray = new int[cursor.getCount()];

        if (cursor.moveToFirst()) {
            do {
                // Process the data:
                int id = cursor.getInt(cursor.getColumnIndex(DBAdapter.KEY_ROWID));
                String hospitalID = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_HOSPITALID))!=null ? cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_HOSPITALID)): "";

                IDarray[cursor.getPosition()] = id;
                items.add(hospitalID);

            } while(cursor.moveToNext());
        }
        selectedArray = new boolean[items.size()];


        adapter = new ListAdapter(this, items);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Capture total checked items
                final int checkedCount = listView.getCheckedItemCount();
                // Set the CAB title according to total checked items
                mode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from ListViewAdapter Class
                adapter.toggleSelection(position);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu_select_patient, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        // Calls getSelectedIds method from ListViewAdapter Class
                        SparseBooleanArray selected = adapter.getSelectedIds();
                        // Captures all selected ids with a loop
                        for (int i = (selected.size() - 1); i >= 0; i--) {
                            if (selected.valueAt(i)) {
                                String selecteditem = adapter.getItem(selected.keyAt(i));
                                // Remove selected items following the ids
                                HomeActivity.myDb.deleteRowData(IDarray[selected.keyAt(i)]);
                                adapter.remove(selecteditem);
                            }
                        }
                        // Close CAB
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                adapter.removeSelection();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomeActivity.currentPatientID = IDarray[i];
                showQuestionnaireSelector();

            }
        });

    }

    public void showQuestionnaireSelector(){
        final Intent intent = new Intent(context, QuestionnaireActivity.class);
        DialogQuestionnaireSelector.ClickHandler selectHandler = new DialogQuestionnaireSelector.ClickHandler() {
            @Override
            public void onSocioClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.SOCIO);
                startActivity(intent);
                ((Activity) context).finish();
            }

            @Override
            public void onNurseClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.NURSE);
                startActivity(intent);
                ((Activity) context).finish();
            }

            @Override
            public void onEvaluatorClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.EVALUATOR);
                startActivity(intent);
                ((Activity) context).finish();
            }

            @Override
            public void onPhysicalClick() {
                intent.putExtra("questionnaire_name", ItemSection.Questionnaire.PHYSICAL);
                startActivity(intent);
                ((Activity) context).finish();
            }
        };
        DialogQuestionnaireSelector selectorDialog = new DialogQuestionnaireSelector(context, selectHandler);
        selectorDialog.show();
    }


    public class ListAdapter extends ArrayAdapter<String> {
        private Context context;
        private List<String> items;
        private SparseBooleanArray mSelectedItemsIds;

        public ListAdapter(Context context, List<String> items){
            super(context, R.layout.cell_select_patient, items);
            this.context = context;
            this.items = items;
            mSelectedItemsIds = new SparseBooleanArray();
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

            convertView.setSelected(selectedArray[position]);

            return convertView;
        }

        @Override
        public void remove(String object) {
            items.remove(object);
            notifyDataSetChanged();
        }

        public void toggleSelection(int position) {
            selectView(position, !mSelectedItemsIds.get(position));
        }


        public void removeSelection() {
            mSelectedItemsIds = new SparseBooleanArray();
            notifyDataSetChanged();
        }

        public void selectView(int position, boolean value) {
            if (value)
                mSelectedItemsIds.put(position, value);
            else
                mSelectedItemsIds.delete(position);
            notifyDataSetChanged();
        }

        public int getSelectedCount() {
            return mSelectedItemsIds.size();
        }

        public SparseBooleanArray getSelectedIds() {
            return mSelectedItemsIds;
        }
    }
}
