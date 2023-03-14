package id.kawahedukasi.tugas6.service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MailService {
    @Inject
    Mailer mailer;

    @Inject
    ExportService exportService;

    public void sendEmail(String recipientEmail) throws RuntimeException {
        try {
            Mail emailMessage = Mail.withHtml(recipientEmail,
                "CRUD API Quarkus Batch 6",
                "<h1>Halo,</h1> this is Quarkus Item-Service");

            mailer.send(emailMessage);
        } catch (RuntimeException e) {
            throw new RuntimeException("Gagal mengirim email ke " + recipientEmail, e);
        }
    }

    public void sendExcelToEmail(String recipientEmail) throws RuntimeException {
        try {
            byte[] excelByteArray = exportService.excelItem().toByteArray();
            Mail emailMessage = Mail.withHtml(recipientEmail,
                            "Excel List Item (Kawah Edukasi)",
                            "<h1>Halo,</h1> berikut merupakan file excel dari list item.")
                    .addAttachment(
                            "list-item.xlsx", excelByteArray,
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            mailer.send(emailMessage);
        } catch (RuntimeException e) {
            throw new RuntimeException("Gagal mengirim email dengan attachment Excel ke " + recipientEmail, e);
        }
    }
}
