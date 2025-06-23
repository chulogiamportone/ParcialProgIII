package parcial.prog3.CHAINofRESPONSIBILITYp5;

import java.io.File;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

public class PriorityAccessHandler extends ValidationHandler {
    @Override
    protected boolean check(DocumentJob job, File file, SystemLog log) {
        if (job.isHighPriority() && !"Premium".equals(job.getRequestingUser().getPlan())) {
            log.error("Solo usuarios Premium pueden usar alta prioridad.");
            return false;
        }
        return true;
    }
}
