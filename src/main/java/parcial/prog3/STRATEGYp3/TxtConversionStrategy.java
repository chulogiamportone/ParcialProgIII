package parcial.prog3.STRATEGYp3;
//EXAMEN PARTE 3
//IMPLEMENTACIONES DE LA INTERFAZ

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

public class TxtConversionStrategy implements ConversionStrategy {
    public byte[] convert(DocumentJob job, SystemLog log) {
        log.info("Convirtiendo a TXT...");
        return new byte[50]; // simulación
    }
}
