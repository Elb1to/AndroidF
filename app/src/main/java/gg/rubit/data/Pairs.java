/*package gg.rubit.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.database.DatabaseHelper;

public class Pairs {

    private int questionId;
    private int answerId;
    private int pairsOrder;
    private String question;
    private String answer;

    public Pairs(int questionId, int answerId, int pairsOrder, String question, String answer) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.pairsOrder = pairsOrder;
        this.question = question;
        this.answer = answer;
    }

    public Pairs(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Pairs() {

    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getPairsOrder() {
        return pairsOrder;
    }

    public void setPairsOrder(int pairsOrder) {
        this.pairsOrder = pairsOrder;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean insertPairsGame(Context context) {
        try {
            DatabaseHelper dbHelper = new DatabaseHelper(context, "frograming");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if (db != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pregunta_id", this.getQuestionId());
                contentValues.put("respuesta_id", this.getAnswerId());
                contentValues.put("orden_pareo", this.getPairsOrder());
                contentValues.put("pre", this.getQuestion());
                contentValues.put("res", this.getAnswer());
                db.insert("Pairs", null, contentValues);
                return true;
            }
        } catch (Exception e) {
            Toast.makeText(context, "Error en insercion =>" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return false;
    }

    public List<Pairs> getPair(int pregunta, Context context) {
        List<Pairs> pairsE = new ArrayList<>();
        try {
            DatabaseHelper dbHelper = new DatabaseHelper(context, "frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if (db != null) {
                String[] campos = new String[]{"pre", "res"};
                Cursor cursor = db.query("Pairs", campos, "pregunta_id= " + pregunta, null, null, null, null, "10");
                if (cursor.moveToFirst()) {
                    do {
                        Pairs Pairs = new Pairs(cursor.getString(0), cursor.getString(1));
                        pairsE.add(Pairs);
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            Toast.makeText(context, "Error en obtener datos de Pairs =>" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return pairsE;
    }

    public int getPairsGameId(String texto, Context context) {
        int id = 0;
        try {
           DatabaseHelper dbHelper = new DatabaseHelper(context, "frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if (db != null) {
                String[] campos = new String[]{"orden_pareo"};
                Cursor cursor = db.query("Pairs", campos, "texto=" + "'" + texto + "'", null, null, null, null, "1");
                if (cursor.moveToFirst()) {
                    do {
                        id = cursor.getInt(0);
                    } while (cursor.moveToNext());
                }
            }
            return id;
        } catch (SQLiteException e) {
            Toast.makeText(context, "Error en obtener datos de Pairs SQLiteException =>" + e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Error en obtener datos de Pairs =>" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return 0;
    }
}*/
