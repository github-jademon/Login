import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author Ray
 *
 */
public class SMTPAuthenticator extends Authenticator {

    protected PasswordAuthentication getPasswordAuthentication() {
        String username = "josubyn05@naver.com"; // naver 사용자;
        String password = "josubyn05+";  // 패스워드;
        return new PasswordAuthentication(username, password);
    }

}