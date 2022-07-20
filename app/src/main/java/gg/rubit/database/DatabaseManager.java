package gg.rubit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.Entidades.Partida;
import gg.rubit.Entidades.Usuarios;

public class DatabaseManager {

    DatabaseHelper databaseHelper;

    public DatabaseManager(Context context) {
        databaseHelper = new DatabaseHelper(context, "juego", null, 1);
    }

    public long insertGameAnswer(Partida partida, int numPartida) {
        try {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            if (db != null) {
                ContentValues values = new ContentValues();
                values.put("partida", numPartida);
                values.put("jugador", partida.getJugador());
                return db.insert("partida", null, values);
            }
        } catch (Exception e) {
            int x = 1;
        }

        return 0;
    }

    public List<Partida> getGameById(int partida) {
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            List<Partida> partidas = new ArrayList<>();
            if (db != null) {
                String[] campos = {"partida", "jugador", "juego", "nivel", "pregunta", "respuestas", "puntaje", "fecha", "hora"};
                Cursor cursor = db.query("partida", campos, "partida=" + partida, null, null, null, "hora DESC");
                if (cursor.moveToFirst()) {
                    do {
                        Partida part = new Partida();
                        part.setJugador(cursor.getString(1));
                        part.setPuntaje(cursor.getInt(6));
                        partidas.add(part);
                    } while (cursor.moveToNext());
                }
            }
            return partidas;
        } catch (Exception e) {
            int x = 1;
        }

        return null;
    }

    public int getNextGame() {
        int partida = 1;
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            if (db != null) {
                String[] campo = {"partida"};
                Cursor cursor = db.query("partida", campo, "juego='3'", null, "partida", null, "partida DESC", "1");
                cursor.moveToFirst();
                do {
                    partida = cursor.getInt(0) + 1;
                } while (cursor.moveToNext());

                return partida;
            }
        } catch (Exception e) {
            int x = 1;
        }

        return partida;
    }

    public int getNextGame(String juego) {
        int partida = 1;
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            if (db != null) {
                String[] campo = {"partida"};
                Cursor cursor = db.query("partida", campo, "juego='" + juego + "'", null, "partida", null, "partida DESC", "1");
                cursor.moveToFirst();
                do {
                    partida = cursor.getInt(0) + 1;
                } while (cursor.moveToNext());

                return partida;
            }
        } catch (Exception e) {
            int x = 1;
        }

        return partida;
    }

    /*public List<CVID_Usuario> ObtenerRanking() {
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            if (db != null) {
                String[] campos = new String[]{"firstName", "lastName", "email"};
                List<CVID_Usuario> U = new ArrayList<>();

                Cursor cursor = db.query("cvid_usuario", campos, null, null, "ID_usuario", null, null); //2. CREAR UN CURSOR Y PASO NOMBRE DE LA TABLA Y CAMPOS A CONSULTAR DE ESA TABLA
                if (cursor.moveToFirst()) {
                    do {
                        CVID_Usuario user = new CVID_Usuario(
                                cursor.getString(0),
                                cursor.getString(1),
                                cursor.getString(2)
                        );
                        U.add(user);
                    } while (cursor.moveToNext());
                }
                db.close();
                return U;
            }

        } catch (Exception e) {}
        return null;

    }

    public List<CVID_Puntaje> ObtenerRanking2() {
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            if (db != null) {
                String[] campos = new String[]{"experienciaAvance"};//1. CREO UN ARRREGLO PARA CONSULTAR LOS CAMPOS EN LA BD//
                List<CVID_Puntaje> P = new ArrayList<>();

                Cursor cursor = db.query("puntaje", campos, null, null, null, null, null); //2. CREAR UN CURSOR Y PASO NOMBRE DE LA TABLA Y CAMPOS A CONSULTAR DE ESA TABLA
                if (cursor.moveToFirst()) {// VERIFICA SI EL CURSOR TIENE DATOS PARA MOVERSE Y LO MUEVE A LA PRIMERA POSICION PARA SABER SI TIENE DATOS//
                    do {//PARA VERIFIACR QUE EXISTA ALGO POR LO MENOS EN LA PRIMERA POSICION
                        CVID_Puntaje pun = new CVID_Puntaje(// JALAR LOS DATOS DE CADA FILA
                                cursor.getInt(0)
                        );
                        P.add(pun);
                    } while (cursor.moveToNext());
                }
                db.close();
                return P;
            }

        } catch (Exception e) {}
        return null;

    }*/

    public Boolean saveUserSession(Usuarios usuario) {
        try {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            if (db != null) {
                db.delete("session", null, null);
                ContentValues values = new ContentValues();
                values.put("id", usuario.getId());
                values.put("correo", usuario.getCorreo());
                values.put("nombre", usuario.getNombre());

                db.insert("session", null, values);
                db.close();

                return true;
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    public Usuarios getUserSession() {
        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();
            if (db != null) {
                String[] campos = new String[]{"id", "correo", "nombre"};
                Cursor cursor = db.query("session", campos, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    return new Usuarios(cursor.getInt(0), cursor.getString(1), "", cursor.getString(2));
                }
            }
        } catch (Exception c) {
            return null;
        }

        return null;
    }

    public Boolean closeUserSession() {
        try {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            if (db != null) {
                // NOMBRE DE LA TABLA , NULL, VALORES DE INSERTAR(REGISTROS CONTENT VALUES)
                db.delete("session", "id", null);
                return true;
            }
        } catch (Exception ignored) {
        }

        return false;
    }
}
