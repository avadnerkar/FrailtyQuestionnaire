package physiotherapy.mcgill.com.frailtyquestionnaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Abhishek Vadnerkar on 15-10-29.
 */
public class DBAdapter {

    /////////////////////////////////////////////////////////////////////
    //	Constants & Data
    /////////////////////////////////////////////////////////////////////
    // For logging:
    private static final String TAG = "DBAdapter";


    // Common fields Fields
    public static final String KEY_ROWID = "_id";
    public static final String KEY_FIRSTNAME = "FirstName";
    public static final String KEY_LASTNAME = "LastName";
    public static final String KEY_HOSPITALID = "HospitalID";
    public static final String KEY_LANGUAGE = "Language";


    // DB info: its name, and the tables we are using
    public static final String DATABASE_NAME = "FrailtyQuestionnaire";
    public static final String DATA_TABLE = "dataTable";

    // Track DB version if a new version of your app changes the format.
    public static final int DATABASE_VERSION = 4;


    //Table Create Statements



    // Context of application who uses us.
    private final Context context;

    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    /////////////////////////////////////////////////////////////////////
    //	Public methods:
    /////////////////////////////////////////////////////////////////////

    private static String DATA_CREATE_SQL;

    public DBAdapter(Context ctx) {
        this.context = ctx;

        DATA_CREATE_SQL =
                "create table " + DATA_TABLE
                        + " (" + KEY_ROWID + " integer primary key autoincrement, "
                        + KEY_FIRSTNAME + " text, "
                        + KEY_LASTNAME + " text, "
                        + KEY_HOSPITALID + " text, "
                        + KEY_LANGUAGE + " text, ";

        for (ItemSection section : DataSource.sections){

            for (ItemQuestion question : section.questions){
                if (question.dbKey != null){
                    DATA_CREATE_SQL = DATA_CREATE_SQL + question.dbKey + " text, ";
                }

            }

        }

        DATA_CREATE_SQL = DATA_CREATE_SQL.substring(0, DATA_CREATE_SQL.length()-2); //Trim last comma
        DATA_CREATE_SQL = DATA_CREATE_SQL + ");";


        myDBHelper = new DatabaseHelper(context);
    }

    // Open the database connection.
    public DBAdapter open() {
        db = myDBHelper.getWritableDatabase();
        return this;
    }

    // Close the database connection.
    public void close() {
        myDBHelper.close();
    }


    /////////////////////////////////////////////////////////////////////
    //	Data methods:
    /////////////////////////////////////////////////////////////////////

    // Add a new set of values to the database.


    public long createData(String firstName, String lastName, String hospitalId, String language){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_FIRSTNAME, firstName);
        initialValues.put(KEY_LASTNAME, lastName);
        initialValues.put(KEY_HOSPITALID, hospitalId);
        initialValues.put(KEY_LANGUAGE, language);

        return db.insert(DATA_TABLE, null, initialValues);
    }

    // Delete a row from the database, by rowId (primary key)
    public boolean deleteRowData(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATA_TABLE, where, null) != 0;
    }

    public void deleteAllData() {
        Cursor c = getAllRowData();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst()) {
            do {
                deleteRowData(c.getLong((int) rowId));
            } while (c.moveToNext());
        }
        c.close();
    }

    // Return all data in the database.
    public Cursor getAllRowData() {
        String where = null;
        Cursor c = 	db.query(true, DATA_TABLE, null,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Get a specific row (by rowId)
    public Cursor getRowData(long rowId) {
        String where = KEY_ROWID + "=" + rowId;
        Cursor c = 	db.query(true, DATA_TABLE, null,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Get a specific field
    public Cursor getField(long rowId, String key) {
        String where = KEY_ROWID + "=" + rowId;
        Cursor c = 	db.query(true, DATA_TABLE, new String[]{key},
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    // Change an existing row to be equal to new data.
    public boolean updateAnswer(long rowId, String key, String answer) {

        String where = KEY_ROWID + "=" + rowId;

        // Create row's data:
        ContentValues newValues = new ContentValues();

        newValues.put(key, answer);

        // Insert it into the database.
        return db.update(DATA_TABLE, newValues, where, null) != 0;
    }



    /////////////////////////////////////////////////////////////////////
    //	Private Helper Classes:
    /////////////////////////////////////////////////////////////////////

    /**
     * Private class which handles database creation and upgrading.
     * Used to handle low-level database access.
     */
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            Log.v(TAG, DATA_CREATE_SQL);
            _db.execSQL(DATA_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading application's database from version " + oldVersion
                    + " to " + newVersion + ", which will destroy all old data!");

            // Destroy old database:
            _db.execSQL("DROP TABLE IF EXISTS " + DATA_TABLE);

            // Recreate new database:
            onCreate(_db);
        }
    }

}
