package com.example.finanzasbackend.compartido.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormateadorFechas {

  
    private static final DateTimeFormatter FORMATO_ESTANDAR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    public static String formatearAString(LocalDate fecha) {
        if (fecha == null) return null;
        return fecha.format(FORMATO_ESTANDAR);
    }

   
    public static LocalDate parsearAFecha(String fechaStr) {
        if (fechaStr == null || fechaStr.trim().isEmpty()) return null;
        return LocalDate.parse(fechaStr, FORMATO_ESTANDAR);
    }
}