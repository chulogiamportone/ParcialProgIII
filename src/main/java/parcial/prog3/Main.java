package parcial.prog3;

import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.ORIGINAL.EmailService;
import parcial.prog3.ORIGINAL.LegacyArchiver;
import parcial.prog3.ORIGINAL.SystemLog;
import parcial.prog3.ORIGINAL.User;
import parcial.prog3.SINGLETONandDIp2.ConfigurationManager;

public class Main {
    public static void main(String[] args) {
        User user = new User("juan", "Premium");
        //EXAMEN PARTE 1
        //Cambia l
        //DocumentJob job = new DocumentJob("src/sample.txt", "PDF", "Confidencial", true, user);
        //utilizamos el Builder
        DocumentJob job = new DocumentJob.Builder()
            .setSourceFilePath("src/example.txt")
            .setOutputFormat("PDF")
            .setWatermarkText("Confidencial")
            .setHighPriority(true)
            .setUserEmail("juan@mail.com")
            .setRequestingUser(user)
            .build();

        
        //EXAMEN PARTE 2
        //INYECCION DE DEPENDENCIA DEL SINGLETON
        //DocumentProcessor processor = new DocumentProcessor();

        ConfigurationManager config = ConfigurationManager.getInstance();
        SystemLog log = new SystemLog();
        EmailService email = new EmailService();
        LegacyArchiver archiver = new LegacyArchiver();
        DocumentProcessor processor = new DocumentProcessor(config, log, email,archiver);
        //hasta aca 



        processor.processDocument(job);
    }}
