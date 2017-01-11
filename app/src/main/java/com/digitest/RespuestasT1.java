package com.digitest;

import java.util.StringTokenizer;

/**
 * Created by onobrac on 11/6/15.
 */
public class RespuestasT1 {
    String[] radioR = {
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
            "Ausente,Leve,Moderada,Grave",
    };


    public String[] separar(String cadena, String separador){
        StringTokenizer token = new StringTokenizer(cadena,separador);

        String[] a = new String[14];
        int i = 1;

        while(token.hasMoreTokens()){
            a[i] = token.nextToken();
            i++;

        }
        return a;
    }

    public String[] setRespuestas(int posicion){
        String s1 = radioR[posicion];
        String[] s2 = separar(s1,",");
        return s2;
    }

}
