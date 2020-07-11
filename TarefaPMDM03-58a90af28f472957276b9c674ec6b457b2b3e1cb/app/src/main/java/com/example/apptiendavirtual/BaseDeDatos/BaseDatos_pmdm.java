package com.example.apptiendavirtual.BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos_pmdm extends SQLiteOpenHelper{
    public final static String NOME_BD="BaseDatosUsuarios.db";
    public final static int VERSION_BD=1;
    private SQLiteDatabase operacionesBD;

    private String CREAR_TABLA_USUARIOS ="CREATE TABLE Usuarios ( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "usuario VARCHAR( 50 )  NOT NULL, "+
            "contra VARCHAR ( 50) NOT NULL, " +
            "nombre VARCHAR (50) NOT NULL," +
            "apellidos VARCHAR (50) NOT NULL, " +
            "email VARCHAR (80) NOT NULL, " +
            "tipoCliente VARCHAR (50) NOT NULL)";
    private String CREAR_TABLA_DIRECCIONES ="CREATE TABLE Direcciones ( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "direccion VARCHAR( 80 )  NOT NULL," +
            "ciudad VARCHAR (50) NOT NULL," +
            "idCliente VARCHAR (50) NOT NULL,"+
            "cp VARCHAR(50) NOT NULL)";
    private String CREAR_TABLA_PEDIDOS ="CREATE TABLE Pedidos ( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "categoria VARCHAR( 50 )  NOT NULL," +
            "producto VARCHAR (50) NOT NULL," +
            "idCliente VARCHAR (50) NOT NULL,"+
            "cantidad INTEGER" +
            " NOT NULL)";
    private String CREAR_TABLA_CONFIRMADOS ="CREATE TABLE Confirmados ( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "categoria VARCHAR( 50 )  NOT NULL," +
            "producto VARCHAR (50) NOT NULL," +
            "idCliente VARCHAR (50) NOT NULL,"+
            "cantidad INTEGER NOT NULL,"+
            "direccion VARCHAR( 80 )  NOT NULL," +
            "ciudad VARCHAR (50) NOT NULL," +
            "cp VARCHAR(50) NOT NULL)";
    private String CREAR_TABLA_RECHAZADOS ="CREATE TABLE Rechazados ( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "categoria VARCHAR( 50 )  NOT NULL," +
            "producto VARCHAR (50) NOT NULL," +
            "idCliente VARCHAR (50) NOT NULL,"+
            "cantidad INTEGER NOT NULL,"+
            "direccion VARCHAR( 80 )  NOT NULL," +
            "ciudad VARCHAR (50) NOT NULL," +
            "cp VARCHAR(50) NOT NULL)";
    private String CREAR_TABLA_NOMBRELOGIN ="CREATE TABLE NombreLogin ( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre VARCHAR( 50 )  NOT NULL,"+
            "apellidos VARCHAR( 50 ) NOT NULL,"+
            "indice INTEGER NOT NULL)";
    private String CREAR_TABLA_NPEDIDO ="CREATE TABLE NPedido( " +
            "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "indicePedido INTEGER NOT NULL)";


    public BaseDatos_pmdm(Context context) {
        super(context, NOME_BD, null, VERSION_BD);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREAR_TABLA_USUARIOS);
        db.execSQL(CREAR_TABLA_DIRECCIONES);
        db.execSQL(CREAR_TABLA_PEDIDOS);
        db.execSQL(CREAR_TABLA_CONFIRMADOS);
        db.execSQL(CREAR_TABLA_RECHAZADOS);
        db.execSQL(CREAR_TABLA_NOMBRELOGIN);
        db.execSQL("INSERT INTO NombreLogin (_id, nombre, apellidos, indice) VALUES (0,'Default','Default',0)");
        db.execSQL(CREAR_TABLA_NPEDIDO);
        db.execSQL("INSERT INTO NPedido (_id, indicePedido) VALUES (0, 0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS Pedidos");
        db.execSQL("DROP TABLE IF EXISTS Confirmados");
        db.execSQL("DROP TABLE IF EXISTS Direcciones");
        db.execSQL("DROP TABLE IF EXISTS Rechazados");
        db.execSQL("DROP TABLE IF EXISTS NombreLogin");
        db.execSQL("DROP TABLE IF EXISTS NPedido");
        onCreate(db);
    }
    public void asigarSQLiteDatabase(SQLiteDatabase operacionsBD){
        this.operacionesBD = operacionesBD;
    }
}
