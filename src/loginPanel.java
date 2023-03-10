import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class loginPanel extends mainFrame {

    public loginPanel() {
        setTitle("로그인");

        title.setText("로그인");
        title.setBounds(220, 30, 100, 40);

        JLabel id = new JLabel("아이디 : ");
        id.setFont(font);
        id.setBounds(40, 100, 120, 30);

        JTextField idf = new JTextField(10);
        idf.setFont(font);
        idf.setBounds(150,100,290,30);

        JLabel pw = new JLabel("비밀번호 : ");
        pw.setFont(font);
        pw.setBounds(40,140, 120, 30);

        JPasswordField pwf = new JPasswordField(10);
        pwf.setFont(font);
        pwf.setBounds(150,140, 290, 30);

        JButton login_btn = new JButton("로그인");
        login_btn.setFont(font);
        login_btn.setBounds(200, 190, 100, 30);
        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pwf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    User user = new User("", idf.getText(), "", pwf.getText(), 0);

                    new loginOkPanel(user);

                    setVisible(false);
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                }
            }
        });

        JLabel id_find = new JLabel("forgot id?");
        id_find.setFont(font.deriveFont(attributes));
        id_find.setForeground(Color.BLUE);
        id_find.setBounds(200, 250, 90, 30);
        id_find.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new idFind1Panel();
                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                id_find.setForeground(Color.MAGENTA);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                id_find.setForeground(Color.BLUE);
            }
        });

        JLabel pw_find = new JLabel("forgot password?");
        pw_find.setFont(font.deriveFont(attributes));
        pw_find.setForeground(Color.BLUE);
        pw_find.setBounds(170, 280, 160, 30);
        pw_find.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new pwChange1Panel();
                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pw_find.setForeground(Color.MAGENTA);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pw_find.setForeground(Color.BLUE);
            }
        });

        JLabel join = new JLabel("create new account");
        join.setFont(font.deriveFont(attributes));
        join.setForeground(Color.BLUE);
        join.setBounds(155, 325, 180, 30);
        join.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new joinPanel();
                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                join.setForeground(Color.MAGENTA);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                join.setForeground(Color.BLUE);
            }
        });

        p.add(id);
        p.add(idf);
        p.add(pw);
        p.add(pwf);
        p.add(login_btn);
        p.add(id_find);
        p.add(pw_find);
        p.add(join);

        setVisible(true);

    }
}
