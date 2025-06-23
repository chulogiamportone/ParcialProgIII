package parcial.prog3.STRATEGYp3;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

//EXAMEN PARTE 3
//IMPLEMENTACIONES DE LA INTERFAZ
public class PdfConversionStrategy implements ConversionStrategy {
    public byte[] convert(DocumentJob job, SystemLog log) {
        log.info("Convirtiendo a PDF...");
        return new byte[100]; // simulación
    }
}
