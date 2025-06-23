package parcial.prog3.SINGLETONandDIp2;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance;

    //EXAMEN PARTE 2
    //Este es el singleton, se instancia el configuration manager solo una vez 
    private ConfigurationManager() {
        // Cargar configuración solo una vez
        System.out.println("🛠️ Configuración cargada");
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
    //hasta aca es el cambio del singleton


    public long getMaxFileSize() {
        return 10_000_000; // Ejemplo: 10 MB
    }
}
