package com.digitest;

/**
 * Test2 depresion
 */
public class PreguntasT2 {
    String[] preguntas = {
            "¿Has sentido humor depresivo(Tristeza, sentimiento de inutilidad)?",
            "¿Has sentido sentimientos de culpa?",
            "¿Has pensado en suicidarte?",
            "¿Has sentido insomnio precoz?",
            "¿Te has sentido con insomnio intermedio?",
            "¿Has sentido insomnio tardio?",
            "¿Has tenido dificultades en tus trabajos y actividades?",
            "¿Has tenido lentitud de pensamiento y lenguaje, facultad de concentración disminuida, disminución de la actividad motora ?",
            "¿Has sentido ultimamente agitación psicomotora ?",
            "¿Te has sentido con ansiedad psíquica ?",
            "¿Te has sentido con diarrea, sequedad en la boca, eructos, hiperventilacion, suspiros ?",
            "¿Te has sentido con síntomas somáticos gastrointestinales ?",
            "¿Te has sentido con síntomas somáticos generales?",
            "¿Has sentido sintomas genitales?",
            "¿Te has sentido con Hipocondría?",
            "¿Has perdido peso ultimamente?",
            "¿Te has sentido con introspeccion?",
    };
    public String getPregunta(int posicion){
        return preguntas[posicion];
    }
}
