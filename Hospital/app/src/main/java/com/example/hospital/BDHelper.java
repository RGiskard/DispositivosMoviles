package com.example.hospital;

import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.security.MessageDigest;
import java.util.*;

import android.os.Build;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BDHelper extends SQLiteOpenHelper {
    private static final String Nombre_BD="SALUDSB";
    private static final int Version_BD=1;
    private static final String Tables="CREATE TABLE IF NOT EXISTS DOCTOR (Doc_ID TEXT,Name TEXT,Addres TEXT,HOSP TEXT,Phone TEXT,PRIMARY KEY(Doc_ID));";
    private static final String Tables2="CREATE TABLE IF NOT EXISTS HOSPITAL (HOS_ID TEXT,Name TEXT,Addres TEXT,PRIMARY KEY(HOS_ID));";
    private static final String Tables3="CREATE TABLE IF NOT EXISTS PACIENTE (PAC_ID TEXT,Name TEXT,Addres TEXT,DOC TEXT,Phone TEXT,PRIMARY KEY(PAC_ID));";
    private static final String Tables4="CREATE TABLE IF NOT EXISTS CITA (CITA_ID TEXT,Name TEXT,PRIMARY KEY(CITA_ID));";
    public BDHelper(@Nullable Context context) {
        super(context, Nombre_BD,  null, Version_BD);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //boolean deleted = SQLiteDatabase.deleteDatabase(Nombre_BD);
        sqLiteDatabase.execSQL(Tables);
        sqLiteDatabase.execSQL(Tables2);
        sqLiteDatabase.execSQL(Tables3);
        sqLiteDatabase.execSQL(Tables4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void agregarDoctor(String name,String address,String fono,String hospital) throws Exception
    {
        String original = name;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String name_id=sb.toString();
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("INSERT INTO DOCTOR VALUES('" + name_id + "','" + name + "','" + address+"','"+hospital+ "','"+ fono+"')");
            bd.close();
        }
        Log.i("El id",name_id);
       // System.out.println(name_id);
    }
    public void agregarHospital(String name,String address) throws Exception
    {
        String original = name;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String name_id=sb.toString();
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("INSERT INTO HOSPITAL VALUES('" + name_id + "','" + name + "','" + address +"')");
            bd.close();
        }
        Log.i("El id",name_id);
    }

    public void agregarPaciente(String name,String address,String fono,String doctor) throws Exception
    {
        String original = name;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String name_id=sb.toString();
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null) {
            bd.execSQL("INSERT INTO PACIENTE VALUES('" + name_id + "','" + name + "','" + address+"','"+doctor+ "','"+ fono+"')");
            bd.close();
        }
        Log.i("El id",name_id);
        // System.out.println(name_id);
    }

    public  List<String> getAllPacientes()
    {
        List<String> listAll = new ArrayList<String>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + "PACIENTE";

        SQLiteDatabase db = getWritableDatabase();
        android.database.Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                MedicoDetails operatorTable = new MedicoDetails();
                //here get all data from cursor and set it into setter method like below
                //operatorTable.getId(Integer.parseInt(cursor.getString(0)));
                //operatorTable.set_Operator(cursor.getString(1));
                listAll.add(cursor.getString(1));
                //operatorList.add(operatorTable);

            } while (cursor.moveToNext());
        }

// returnlist
        return listAll;
    }

    // Getting All data
    public List<MedicoDetails> getAllMedicos() {
        List<MedicoDetails> listAll = new ArrayList<MedicoDetails>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + "DOCTOR";

        SQLiteDatabase db = getWritableDatabase();
        android.database.Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                MedicoDetails operatorTable = new MedicoDetails();
                //here get all data from cursor and set it into setter method like below
                //operatorTable.getId(Integer.parseInt(cursor.getString(0)));
                //operatorTable.set_Operator(cursor.getString(1));
                listAll.add(new MedicoDetails(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
                //operatorList.add(operatorTable);

            } while (cursor.moveToNext());
        }

// returnlist
        return listAll;
    }
    public List<String> getAllHospitales() {
        List<String> listAll = new ArrayList<String>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + "HOSPITAL";

        SQLiteDatabase db = getWritableDatabase();
        android.database.Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                MedicoDetails operatorTable = new MedicoDetails();
                //here get all data from cursor and set it into setter method like below
                //operatorTable.getId(Integer.parseInt(cursor.getString(0)));
                //operatorTable.set_Operator(cursor.getString(1));
                listAll.add(cursor.getString(1));
                //operatorList.add(operatorTable);

            } while (cursor.moveToNext());
        }

// returnlist
        return listAll;
    }

    public List<String> getAllNombresMedicos() {
        List<String> listAll = new ArrayList<String>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + "DOCTOR";

        SQLiteDatabase db = getWritableDatabase();
        android.database.Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                MedicoDetails operatorTable = new MedicoDetails();
                //here get all data from cursor and set it into setter method like below
                //operatorTable.getId(Integer.parseInt(cursor.getString(0)));
                //operatorTable.set_Operator(cursor.getString(1));
                listAll.add(cursor.getString(1));
                //operatorList.add(operatorTable);

            } while (cursor.moveToNext());
        }

// returnlist
        return listAll;
    }
    public  List<String> getDoctorsByHospital(String hospital)
    {
        List<String> listAll = new ArrayList<String>();
        String query="SELECT * FROM DOCTOR WHERE TRIM(HOSP) = '"+hospital.trim()+"'";
        SQLiteDatabase db = getWritableDatabase();
        android.database.Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {

                MedicoDetails operatorTable = new MedicoDetails();
                //here get all data from cursor and set it into setter method like below
                //operatorTable.getId(Integer.parseInt(cursor.getString(0)));
                //operatorTable.set_Operator(cursor.getString(1));
                listAll.add(cursor.getString(1));
                //operatorList.add(operatorTable);

            } while (cursor.moveToNext());
        }
        return  listAll;
    }
}
