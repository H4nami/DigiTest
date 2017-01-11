package com.digitest;

/**
 * Created by onobrac on 11/6/15.
 */
public class PreguntasT1 {
    String[] preguntas = {
            "¿Has sentido temor a que suceda una situación trágica?",
            "¿Te has sentido con inquietud, imposibilidad para relajarte?",
            "¿Has sentido temor a desconocidos, oscuridad, tráfico, animales, etc.?",
            "Dificultad para conciliar el sueño, sueño interrumpido.",
            "Problemas de concentracion.",
            "Perdida de interés, falta de pasatiempos.",
            "Dolores musculares, espasmos musculares.",
            "Zumbido de oidos, vision borrosa.",
            "Taquicardia, palpitaciones, dolor precordial.",
            "Opresión o constricción en el tórax.",
            "Dolor abdominal, nauseas, vomito.",
            "Problemas en la intimidad.",
            "Boca seca, vértigos, dolor de cabeza.",
            "Inquietud, impaciencia o intranquilidad.",

    };

    public String getPregunta(int posicion){
        return preguntas[posicion];
    }
}
