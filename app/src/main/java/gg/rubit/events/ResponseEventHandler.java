package gg.rubit.events;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.data.ConversationDataValues;

public class ResponseEventHandler {

    List<ConversationDataValues> fuente = new ArrayList<>();
    List<ConversationDataValues> Arrlst = new ArrayList<>();
    Context context;


    public void setContext(Context c) {
        context = c;
    }

    public int responseReceived(List<ConversationDataValues> d) {

        for(int i=0;i<d.size();i++) {
            ConversationDataValues obj = new ConversationDataValues();
            obj.setId(d.get(i).getId());
            obj.setLecciones_id(d.get(i).getLecciones_id());
            obj.setPersona(d.get(i).getPersona());
            obj.setDialog(d.get(i).getDialog());
            obj.setAudio(d.get(i).getAudio());
            fuente.add(obj);
        }
        return  fuente.size();
    }

    public List<ConversationDataValues> datos (int count)  {

        ConversationDataValues datos = new ConversationDataValues();

        datos.setId(fuente.get(count).getId());
        datos.setLecciones_id(fuente.get(count).getLecciones_id());
        datos.setPersona(fuente.get(count).getPersona());
        datos.setDialog(fuente.get(count).getDialog());
        datos.setAudio(fuente.get(count).getAudio());
        Arrlst.add(datos);

        playMp3(fuente.get(count).getAudio());
        return Arrlst;
    }

    public void playMp3(String Audio) {

        try {
            MediaPlayer mPlayer = MediaPlayer.create(context, context.getResources().getIdentifier(Audio, "raw", context.getPackageName()));
            mPlayer.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
