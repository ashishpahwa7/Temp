
package org.vipsace.ace_thetechnicalsocietyofvsit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ash on 16/2/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper
{

    public static SQLiteDatabase  abc;

    public DataBaseHelper(Context context) {


        super(context, "mydatabase.sqlite", null, 3);

        abc = getWritableDatabase();
    }

    @Override


    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table my_table(" +
                "name varchar(20)," +
                "password varchar(20));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
