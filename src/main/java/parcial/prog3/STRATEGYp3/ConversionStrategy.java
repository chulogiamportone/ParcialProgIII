package parcial.prog3.STRATEGYp3;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

//EXAMEN PARTE 3
// INTERFAZ del PATRÓN STRATEGY
public interface ConversionStrategy {
    byte[] convert(DocumentJob job, SystemLog log);
}
