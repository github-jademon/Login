import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class idFind1Panel extends mainFrame {
    public idFind1Panel() {
        setTitle("아이디 찾기");

        title.setText("아이디 찾기");
        title.setBounds(190, 60, 120, 40);

        JLabel name = new JLabel("이름 : ");
        name.setFont(font);
        name.setBounds(40, 150, 120, 30);

        JTextField namef = new JTextField(10);
        namef.setFont(font);
        namef.setBounds(150,150,290,30);

        JLabel email = new JLabel("이메일 : ");
        email.setFont(font);
        email.setBounds(40,190, 120, 30);

        JTextField emailf = new JTextField(10);
        emailf.setFont(font);
        emailf.setBounds(150,190, 290, 30);

        JButton pw_find_btn = new JButton("찾기");
        pw_find_btn.setFont(font);
        pw_find_btn.setBounds(90, 250, 150, 30);
        pw_find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(namef.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(emailf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "이메일을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    User user = new User(namef.getText(), "", emailf.getText(), "", 1);
                    if(checkUsers(user, "name&email")) {
                        // 아이디(2개)나머지(*) 보여주기
                        // 전체보기는 이메일로 보내기 (링크)
                        new idFind2Panel(emailf.getText(), userId(user));

                        setVisible(false);
                        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    } else {
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

        p.add(name);
        p.add(namef);
        p.add(email);
        p.add(emailf);
        p.add(pw_find_btn);
        p.add(go_back_btn);

        setVisible(true);
    }
}
