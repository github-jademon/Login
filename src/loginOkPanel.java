import javax.swing.*;

public class loginOkPanel extends mainFrame {
    public loginOkPanel(User user) {
        if(!checkUsers(user, "id")) {
            JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.", "", JOptionPane.INFORMATION_MESSAGE);
            new joinPanel();
        }
        else if (!checkUsers(user, "pw")) {
            JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요", "", JOptionPane.INFORMATION_MESSAGE);
            new loginPanel();
        }
        else {
            new Hello();
        }
    }
}
