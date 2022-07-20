package gg.rubit.BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    String cvid_partida = "CREATE TABLE partida (partida INTEGER,jugador TEXT, juego TEXT, nivel TEXT, pregunta TEXT, respuestas TEXT, puntaje INTEGER, fecha TEXT, hora TEXT)";
    String cvid_usuario = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT,correo TEXT, password TEXT)";
    String cvid_sesion = "CREATE TABLE session (id INTEGER, user TEXT, nombre TEXT)";

    public DatabaseHelper(Context contex, String dbName, SQLiteDatabase.CursorFactory cursor, int dbVersion) {
        super(contex, dbName, cursor, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cvid_partida);
        db.execSQL(cvid_usuario);
        db.execSQL(cvid_sesion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int lastDb, int newDb) {

    }
}
