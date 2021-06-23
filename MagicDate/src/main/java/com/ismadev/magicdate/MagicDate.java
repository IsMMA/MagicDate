package com.ismadev.magicdate;

import android.content.Context;

import java.util.ArrayList;

public class MagicDate {

    private Context cnt;

    public MagicDate(Context context) {
        this.cnt = context;
    }

    public MagicDate() {
    }

    public String formateadorHora(String fecha) {

        String response = "";
        String hora = fecha.substring(11, 13);
        String minutos = fecha.substring(14, 16);

        response = hora + ":" + minutos;
        return response;

    }

    public boolean cambiaDia(String fecha1, String fecha2) {

        if (fecha1.length() > 9 && fecha2.length() > 9) {
            String año1 = fecha1.substring(0, 4);
            String mes1 = fecha1.substring(5, 7);
            String dia1 = fecha1.substring(8, 10);

            String año2 = fecha2.substring(0, 4);
            String mes2 = fecha2.substring(5, 7);
            String dia2 = fecha2.substring(8, 10);

            if (!año1.equals(año2)) {
                return true;
            }

            if (!mes1.equals(mes2)) {
                return true;
            }

            if (!dia1.equals(dia2)) {
                return true;
            }

            return false;
        } else {
            return false;
        }

    }

    public String formateadorDia(String fecha) {
        String response = "";
        String mes = fecha.substring(5, 7);
        String dia = fecha.substring(8, 10);
        String year = fecha.substring(0, 4);
        response = dia + " " + cnt.getString(R.string.de) + " " + obtenerMesLetra(mes) + " " + cnt.getString(R.string.de) + " " + year;
        return response;
    }

    public String obtenerMesLetra(String mes) {

        String response = "";
        int mesint = Integer.parseInt(mes);

        switch (mesint) {

            case 1:
                response = cnt.getString(R.string.enero);
                break;

            case 2:
                response = cnt.getString(R.string.febrero);
                break;

            case 3:
                response = cnt.getString(R.string.marzo);
                break;

            case 4:
                response = cnt.getString(R.string.abril);
                break;

            case 5:
                response = cnt.getString(R.string.mayo);
                break;

            case 6:
                response = cnt.getString(R.string.junio);
                break;

            case 7:
                response = cnt.getString(R.string.julio);
                break;

            case 8:
                response = cnt.getString(R.string.agosto);
                break;

            case 9:
                response = cnt.getString(R.string.septiembre);
                break;

            case 10:
                response = cnt.getString(R.string.octubre);
                break;

            case 11:
                response = cnt.getString(R.string.noviembre);
                break;

            case 12:
                response = cnt.getString(R.string.diciembre);
                break;
        }
        return response;
    }


    public String fancyTimeFormat(int duration) {
        // Hours, minutes and seconds
        int hrs = ~~(duration / 3600);
        int mins = ~~((duration % 3600) / 60);
        int secs = ~~duration % 60;

        // Output like "1:01" or "4:03:59" or "123:03:59"
        String ret = "";

        if (hrs > 0) {
            ret += "" + hrs + ":" + (mins < 10 ? "0" : "");
        }

        ret += "" + mins + ":" + (secs < 10 ? "0" : "");
        ret += "" + secs;
        return ret;
    }


}
