package com.example.appventas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppVentasBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="AppVentasBD.bd";
    private static final int VERSION_BD=1;
    private static final String CREAR_TABLA="CREATE TABLE IF NOT EXISTS ";
    private static final String BORRAR_TABLA="DROP TABLE IF EXISTS ";
    private static final String TABLA_USUARIOS="USUARIOS(USERID INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                         " USERNAME TEXT," +
                                                         " PASSWORD TEXT)";
    private static final String TABLA_CLIENTES="CLIENTES(CLIID INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                         " CLINOMBRE TEXT," +
                                                         " APELLIDOS TEXT," +
                                                         " CREDITO REAL," +
                                                         " TELEFONO TEXT," +
                                                         " DOMICILIO TEXT," +
                                                         " FECHANACIMIENTO TEXT)";
    private static final String TABLA_PRODUCTOS="PRODUCTOS(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                         " PRODNOMBRE TEXT," +
                                                         " DESCRIPCION TEXT," +
                                                         " MARCA TEXT," +
                                                         " CANTIDAD INTEGER," +
                                                         " PRECIO REAL)";
    private static final String TABLA_VENTAS="VENTAS(FOLIO INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                         " CLIENTE INTEGER," +
                                                         " PRODUCTOS TEXT," +
                                                         " IMPORTE REAL," +
                                                         " FECHAVENTA TEXT)";

    public AppVentasBD(Context context){
        super(context, NOMBRE_BD, null,VERSION_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_USUARIOS);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_CLIENTES);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_PRODUCTOS);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_VENTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(BORRAR_TABLA+TABLA_USUARIOS);
        sqLiteDatabase.execSQL(BORRAR_TABLA+TABLA_CLIENTES);
        sqLiteDatabase.execSQL(BORRAR_TABLA+TABLA_PRODUCTOS);
        sqLiteDatabase.execSQL(BORRAR_TABLA+TABLA_VENTAS);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_USUARIOS);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_CLIENTES);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_PRODUCTOS);
        sqLiteDatabase.execSQL(CREAR_TABLA+TABLA_VENTAS);
    }

    public void agregarUsuario(String username, String password){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO USUARIOS (USERNAME,PASSWORD)" +
                    " VALUES('"+username+"','"+password+"')");
            bd.close();
        }
    }
    public void agregarCliente(String nombre, String apellidos, Double credito, String telefono, String domicilio, String fechaNacimiento){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null) {
            bd.execSQL("INSERT INTO CLIENTES (CLINOMBRE,APELLIDOS,CREDITO,TELEFONO,DOMICILIO,FECHANACIMIENTO)" +
                    " VALUES('" + nombre + "','" + apellidos + "',"+credito+",'"+telefono+"','"+domicilio+"','"+fechaNacimiento+"')");
            bd.close();
        }
    }
    public void agregarProducto(String nombre, String descripcion, String marca, int cantidad, double precio){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null) {
            bd.execSQL("INSERT INTO PRODUCTOS (PRODNOMBRE,DESCRIPCION,MARCA,CANTIDAD,PRECIO)" +
                    " VALUES('" + nombre + "','" + descripcion + "','"+marca+"',"+cantidad+","+precio+")");
            bd.close();
        }
    }
    public void agregarVenta(int clienteID, String productos, double importe, String fechaVenta){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null) {
            bd.execSQL("INSERT INTO VENTAS (CLIENTE,PRODUCTOS,IMPORTE,FECHAVENTA)" +
                    " VALUES('" + clienteID + "','" + productos + "',"+importe+",'"+fechaVenta+"')");
            bd.close();
        }
    }



    public void eliminarUsuario(int userID){

    }
    public void eliminarCliente(int cliID){

    }
    public void eliminarProducto(int codigo){

    }
    public void eliminarVenta(int folio){

    }
}

























