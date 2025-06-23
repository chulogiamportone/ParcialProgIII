package parcial.prog3.CHAINofRESPONSIBILITYp5;

import java.io.File;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;
import parcial.prog3.SINGLETONandDIp2.ConfigurationManager;

public class FileSizeHandler extends ValidationHandler {

    private final ConfigurationManager config;

    public FileSizeHandler(ConfigurationManager config) {
        this.config = config;
    }

    @Override
    protected boolean check(DocumentJob job, File file, SystemLog log) {
        if (file.length() > config.getMaxFileSize()) {
            log.error("Archivo demasiado grande.");
            return false;
        }
        return true;
    }
}
