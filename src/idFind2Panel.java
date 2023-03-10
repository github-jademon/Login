import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class idFind2Panel extends mainFrame {
    sendEmail mt = new sendEmail();
    public idFind2Panel(String email, String id) {
        setTitle("아이디 찾기");

        title.setText("아이디 찾기");
        title.setBounds(180, 60, 130, 40);

        JLabel label = new JLabel("아이디 : ");
        label.setFont(font);
        label.setBounds(40, 150, 120, 30);

        JLabel label1 = new JLabel((id.length()>3?id.substring(0, 3)+"******":id));
        label1.setFont(font);
        label1.setBounds(150, 150, 120, 30);

        JButton pw_find_btn = new JButton("로그인하기");
        pw_find_btn.setFont(font);
        pw_find_btn.setBounds(90, 250, 150, 30);
        pw_find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginPanel();

                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });

        JButton go_back_btn = new JButton("뒤로가기");
        go_back_btn.setFont(font);
        go_back_btn.setBounds(250, 250, 150, 30);
        go_back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new idFind1Panel();

                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });

        JLabel retry = new JLabel("아이디 전체 이메일로 받기");
        retry.setFont(font.deriveFont(attributes));
        retry.setForeground(Color.BLUE);
        retry.setBounds(120, 325, 250, 30);
        retry.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String from = "josubyn05@naver.com";
                String subject = "아이디 찾기";
                String content = "안녕하세요. 반갑습니다.\n아이디 : "+id+"\n감사합니다.";

                // 메일보내기
                try {
                    mt.sendEmail(from, email, subject, content);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                retry.setForeground(Color.MAGENTA);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                retry.setForeground(Color.BLUE);
            }
        });

        p.add(label);
        p.add(label1);
        p.add(pw_find_btn);
        p.add(go_back_btn);
        p.add(retry);

        setVisible(true);
    }
}
