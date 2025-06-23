package parcial.prog3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import parcial.prog3.APARTERp4.ArchiveService;
import parcial.prog3.APARTERp4.DocumentFile;
import parcial.prog3.APARTERp4.LegacyArchiverAdapter;
import parcial.prog3.BUILDERp1.DocumentJob;
import parcial.prog3.CHAINofRESPONSIBILITYp5.FileExistenceHandler;
import parcial.prog3.CHAINofRESPONSIBILITYp5.FileSizeHandler;
import parcial.prog3.CHAINofRESPONSIBILITYp5.PriorityAccessHandler;
import parcial.prog3.CHAINofRESPONSIBILITYp5.ValidationHandler;
import parcial.prog3.ORIGINAL.EmailService;
import parcial.prog3.ORIGINAL.LegacyArchiver;
import parcial.prog3.ORIGINAL.SystemLog;
import parcial.prog3.ORIGINAL.User;
import parcial.prog3.SINGLETONandDIp2.ConfigurationManager;
import parcial.prog3.STRATEGYp3.ConversionStrategy;
import parcial.prog3.STRATEGYp3.DocxConversionStrategy;
import parcial.prog3.STRATEGYp3.PdfConversionStrategy;
import parcial.prog3.STRATEGYp3.TxtConversionStrategy;

public class DocumentProcessor {
    // EXAMEN PARTE 2
    // se agregan variables y constructor documentprocesor para
    // inyeccion de dependencia
    private final ConfigurationManager configManager;
    private final SystemLog log;
    private final EmailService emailService;

    // EXAMEN PARTE 3
    // STRATEGY MAP
    private final Map<String, ConversionStrategy> strategyMap = new HashMap<>();

    public DocumentProcessor(ConfigurationManager configManager,
            SystemLog log,
            EmailService emailService,
            LegacyArchiver archiver) {
        this.configManager = configManager;
        this.log = log;
        this.emailService = emailService;

        // PARTE 3
        // Registramos los algoritmos disponibles
        strategyMap.put("PDF", new PdfConversionStrategy());
        strategyMap.put("DOCX", new DocxConversionStrategy());
        strategyMap.put("TXT", new TxtConversionStrategy());
    }

    // hasta aca
    public void processDocument(DocumentJob job) {
        
        // EXAMEN PARTE 2
        // CAMBIO ya no se instancia en funcion sino en constructor
        // ConfigurationManager configManager = new ConfigurationManager();

        // SystemLog log = new SystemLog();
        log.info("Iniciando procesamiento del trabajo...");

        if (job.getRequestingUser() == null) {
            log.error("Usuario no especificado.");
            return;
        }

        System.out.println("Ruta absoluta: " + new File(job.getSourceFilePath()).getAbsolutePath());

        // EXAMN PARTE 5
        // ENLACE DE MANEJADORES
        // File file = new File(job.getSourceFilePath());
        // if (file.exists()) {
        // log.error("Archivo no encontrado.");
        // return;
        // }

        // if (file.length() > configManager.getMaxFileSize()) {
        // log.error("Archivo demasiado grande.");
        // return;
        // }

        // if (job.isHighPriority() &&
        // !"Premium".equals(job.getRequestingUser().getPlan())) {
        // log.error("Solo usuarios Premium pueden usar alta prioridad.");
        // return;
        // }
        File file = new File(job.getSourceFilePath());

        ValidationHandler chain = new FileExistenceHandler();
        chain.linkWith(new FileSizeHandler(configManager))
                .linkWith(new PriorityAccessHandler());

        if (!chain.validate(job, file, log)) {
            return; // corta si falla alguna validación
        }


        // byte[] convertedFile;

        // EXAMEN PARTE 3
        // CAMBIO DE SWICTH POR STRATEGY
        // witch (job.getOutputFormat()) {
        // case "PDF":
        // log.info("Convirtiendo a PDF...");
        // convertedFile = new byte[100];
        // break;
        // case "DOCX":
        // log.info("Convirtiendo a DOCX...");
        // convertedFile = new byte[120];
        // break;
        // default:
        // log.info("Convirtiendo a TXT...");
        // convertedFile = new byte[50];
        // break;
        // }
        // PARTE NUEVA
        ConversionStrategy strategy = strategyMap.getOrDefault(
                job.getOutputFormat(),
                new TxtConversionStrategy() // fallback
        );

        byte[] convertedFile = strategy.convert(job, log);
        // hasta aca





        // EXAMEN PARTE 4
        // UTILIZAMOS LA INTERFA PARA EL LEGACY ARCHIVER ADAPTER
        // LegacyArchiver archiver = new LegacyArchiver();
        // archiver.save(convertedFile, "archive/" + UUID.randomUUID());

        ArchiveService archiver = new LegacyArchiverAdapter(new LegacyArchiver());
        String fileName = UUID.randomUUID().toString();
        archiver.archive(new DocumentFile(convertedFile, fileName));
        // hasta aca

        // EmailService emailService = new EmailService();
        emailService.send(job.getUserEmail(), "Procesamiento completado", "Su documento está listo.");

        triggerBilling(job.getRequestingUser(), job.getOutputFormat());
        log.info("Trabajo finalizado.");
    }

    private void triggerBilling(User user, String format) {
        System.out.println("Facturación ejecutada para " + user.getUsername() + ", formato: " + format);
    }
}
