package parcial.prog3.BUILDERp1;

import parcial.prog3.ORIGINAL.User;

public class DocumentJob {
    private String sourceFilePath;
    private String outputFormat;
    private String watermarkText;
    private boolean highPriority;
    private String userEmail;
    private User requestingUser;
    private int encryptionLevel;

    private DocumentJob() {} // Solo construible por el builder

    //EXAMEN PARTE 1
    //BUILDER PARA LA CONSTRUCCION DEL OBJETO
    public static class Builder {
        private final DocumentJob job = new DocumentJob();

        public Builder setSourceFilePath(String path) {
            job.sourceFilePath = path;
            return this;
        }

        public Builder setOutputFormat(String format) {
            job.outputFormat = format;
            return this;
        }

        public Builder setWatermarkText(String text) {
            job.watermarkText = text;
            return this;
        }

        public Builder setHighPriority(boolean priority) {
            job.highPriority = priority;
            return this;
        }

        public Builder setUserEmail(String email) {
            job.userEmail = email;
            return this;
        }

        public Builder setRequestingUser(User user) {
            job.requestingUser = user;
            return this;
        }

        public Builder setEncryptionLevel(int level) {
            job.encryptionLevel = level;
            return this;
        }

        public DocumentJob build() {
            return job;
        }
    }

    // Getters...
    public String getSourceFilePath() { return sourceFilePath; }
    public String getOutputFormat() { return outputFormat; }
    public boolean isHighPriority() { return highPriority; }
    public String getUserEmail() { return userEmail; }
    public User getRequestingUser() { return requestingUser; }
}

