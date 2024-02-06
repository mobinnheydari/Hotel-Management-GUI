import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Emailvalidator {

    public Emailvalidator() {

        // مشخصات حساب ایمیل فرستنده
        String senderEmail = "mobin.heydari1398@gmail.com";
        String senderPassword = "09359529824";

        // مشخصات حساب ایمیل گیرنده
        String recipientEmail = "mobin.heydariii@gmail.com";

        // تنظیمات SMTP سرور برای ارسال ایمیل
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // ایجاد جلسه برای اتصال به سرور SMTP
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // ایجاد پیام
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Test Email");
            message.setText("This is a test email sent from Java.");

            // ارسال پیام
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
