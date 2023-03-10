import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class joinOkPanel extends mainFrame {
    public joinOkPanel(User user) {
        try {
            FileWriter fw_append = new FileWriter(users, true);
            fw_append.write(user.getName()+" "+user.getId()+" "+user.getEmail()+" "+ user.getPw()+"\n");
            fw_append.close();

            user_list.add(user);

            JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "", JOptionPane.INFORMATION_MESSAGE);
            new loginPanel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
