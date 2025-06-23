//EXAMEN PARCIAL 4
//ADAPTER QUE IMPLEMENTA LA INTERFAZ Y SEGUN EL DOCUMENTO EJECUTA.

package parcial.prog3.APARTERp4;

import parcial.prog3.ORIGINAL.LegacyArchiver;

public class LegacyArchiverAdapter implements ArchiveService {

    private final LegacyArchiver legacyArchiver;

    public LegacyArchiverAdapter(LegacyArchiver legacyArchiver) {
        this.legacyArchiver = legacyArchiver;
    }

    @Override
    public void archive(DocumentFile file) {
        String fullPath = "archive/" + file.getFileName();
        legacyArchiver.save(file.getContent(), fullPath);
    }
}
