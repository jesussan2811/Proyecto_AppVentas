package com.example.appventas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.appventas.entidades.ModeloClientes;
import com.example.appventas.entidades.ModeloProductos;
import com.example.appventas.entidades.ModeloUsuarios;
import com.example.appventas.entidades.ModeloVentas;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<ModeloClientes> mostrarClientes(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM CLIENTES",null);
        ArrayList<ModeloClientes> clientes=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                clientes.add(new ModeloClientes(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return clientes;
    }

    public ArrayList<ModeloProductos> mostrarProductos(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM PRODUCTOS",null);
        ArrayList<ModeloProductos> productos=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                productos.add(new ModeloProductos(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getDouble(5)));
            }while (cursor.moveToNext());
        }
        return productos;
    }

    public ArrayList<ModeloUsuarios> mostrarUsuarios(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM USUARIOS",null);
        ArrayList<ModeloUsuarios> usuarios=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                usuarios.add(new ModeloUsuarios(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return usuarios;
    }

    public ArrayList<ModeloVentas> mostrarVentas(){
        SQLiteDatabase bd=getReadableDatabase();
        Cursor cursor=bd.rawQuery("SELECT * FROM VENTAS",null);
        ArrayList<ModeloVentas> ventas=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                ventas.add(new ModeloVentas(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        return ventas;
    }

    public void eliminarUsuario(int userID){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM USUARIOS WHERE='"+userID+"'");
            bd.close();
        }
    }
    public void eliminarCliente(int cliID){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM CLIENTES WHERE='"+cliID+"'");
            bd.close();
        }
    }
    public void eliminarProducto(int codigo){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM PRODUCTOS WHERE='"+codigo+"'");
            bd.close();
        }
    }
    public void eliminarVenta(int folio){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("DELETE FROM VENTAS WHERE='"+folio+"'");
            bd.close();
        }
    }

    public void editarUsuario(int userID, String username, String password){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("UPDATE USUARIOS SET USERNAME='"+username+"',PASSWORD='"+password+"' WHERE USERID="+userID);
            bd.close();
        }
    }
    public void editarCliente(int cliID, String nombre, String apellidos, Double credito, String telefono, String domicilio, String fechaNacimiento){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("UPDATE CLIENTES SET CLINOMBRE='"+nombre+"',APELLIDOS='"+apellidos+"',CREDITO="+credito+",TELEFONO='"+telefono+"',DOMICILIO='"+domicilio+"',FECHANACIMIENTO='"+fechaNacimiento+"' WHERE CLIID="+cliID);
            bd.close();
        }
    }
    public void editarProducto(int codigo, String nombre, String descripcion, String marca, int cantidad, double precio){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("UPDATE PRODUCTOS SET PRODNOMBRE='"+nombre+"',DESCRIPCION='"+descripcion+"',MARCA='"+marca+"',CANTIDAD="+cantidad+",PRECIO="+precio+" WHERE CODIGO="+codigo);
            bd.close();
        }
    }
    public void editarVenta(int folio, int clienteID, String productos, double importe, String fechaVenta){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("UPDATE VENTAS SET CLIENTE="+clienteID+",PRODUCTOS='"+productos+"',IMPORTE="+importe+",FECHAVENTA='"+fechaVenta+"' WHERE FOLIO="+folio);
            bd.close();
        }
    }
}

























