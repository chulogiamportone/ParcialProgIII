//EXAMEN PARCIAL 4
//CLASES DE DATOS PARA UTILIZAR EN LA INTERFACE
package parcial.prog3.APARTERp4;
public class DocumentFile {
    private final byte[] content;
    private final String fileName;

    public DocumentFile(byte[] content, String fileName) {
        this.content = content;
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public String getFileName() {
        return fileName;
    }
}
