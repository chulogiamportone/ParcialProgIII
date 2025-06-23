package parcial.prog3.STRATEGYp3;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

//EXAMEN PARTE 3
//IMPLEMENTACIONES DE LA INTERFAZ
public class DocxConversionStrategy implements ConversionStrategy {
    public byte[] convert(DocumentJob job, SystemLog log) {
        log.info("Convirtiendo a DOCX...");
        return new byte[120]; // simulación
    }
}
