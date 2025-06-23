package parcial.prog3.CHAINofRESPONSIBILITYp5;

import java.io.File;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.SystemLog;

//EXAMEN PARTE 5
//MANEJA LAS DISTINTAS VALIDACIONES A TRAVES DE UNA CLASE ABSTRACTA
public abstract class ValidationHandler {
    private ValidationHandler next;

    public ValidationHandler linkWith(ValidationHandler next) {
        this.next = next;
        return next;
    }

    public boolean validate(DocumentJob job, File file, SystemLog log) {
        if (!check(job, file, log))
            return false;
        if (next == null)
            return true;
        return next.validate(job, file, log);
    }

    protected abstract boolean check(DocumentJob job, File file, SystemLog log);
}
