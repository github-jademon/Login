import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pwChange1Panel extends mainFrame {
    public pwChange1Panel() {
        setTitle("비밀번호 변경");

        title.setText("비밀번호 변경");
        title.setBounds(180, 60, 130, 40);

        JLabel id = new JLabel("아이디 : ");
        id.setFont(font);
        id.setBounds(40, 150, 120, 30);

        JTextField idf = new JTextField(10);
        idf.setFont(font);
        idf.setBounds(150,150,290,30);

        JLabel email = new JLabel("이메일 : ");
        email.setFont(font);
        email.setBounds(40,190, 120, 30);

        JTextField emailf = new JTextField(10);
        emailf.setFont(font);
        emailf.setBounds(150,190, 290, 30);

        JButton pw_find_btn = new JButton("변경");
        pw_find_btn.setFont(font);
        pw_find_btn.setBounds(90, 250, 150, 30);
        pw_find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(emailf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "이메일을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    User user = new User("", idf.getText(), emailf.getText(), "", 1);
                    if(checkUsers(user, "id&email")) {
                        // 이메일 인증번호 받기
                        // 인증 완료시 비밀번호 재설정

                        new pwChange2Panel(emailf.getText(), idf.getText());
                        setVisible(false);
                        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.", "", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        });

        JButton go_back_btn = new JButton("뒤로가기");
        go_back_btn.setFont(font);
        go_back_btn.setBounds(250, 250, 150, 30);
        go_back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginPanel();

                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });

        p.add(id);
        p.add(idf);
        p.add(email);
        p.add(emailf);
        p.add(pw_find_btn);
        p.add(go_back_btn);

        setVisible(true);
    }
}
