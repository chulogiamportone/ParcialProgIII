package parcial.prog3.CHAINofRESPONSIBILITYp5;

import java.io.File;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

public class FileExistenceHandler extends ValidationHandler {
    @Override
    protected boolean check(DocumentJob job, File file, SystemLog log) {
        if (job.getRequestingUser() == null) {
            log.error("Usuario no especificado.");
            return false;
        }

        if (!file.exists()) {
            log.error("Archivo no encontrado.");
            return false;
        }

        return true;
    }
}
