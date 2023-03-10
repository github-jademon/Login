import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Ray
 *
 */
public class sendEmail extends Thread {
    private static final String HOST = "smtp.naver.com";
    private static final String PORT = "587";
    public void sendEmail(String from, String to, String subject, String content)
            throws Exception {

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", HOST);
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);

        // create a message
        Message msg = new MimeMessage(mailSession);

        // set the from and to address
        msg.setFrom(new InternetAddress(from));//보내는 사람 설정
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//받는 사람설정

        // Setting the Subject and Content Type
        msg.setSubject(subject); // 제목 설정
        msg.setText(content);  // 내용 설정
        msg.setSentDate(new Date());// 보내는 날짜 설정

        Transport.send(msg);  // 메일 보내기

        System.out.println("메일 전송에 성공하였습니다.");

    }

    @Override
    public void run() {
        System.out.println("1");
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        joinPanel.emailck=true;
        System.out.println("인증 만료");
    }
}