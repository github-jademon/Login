import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class pwChange2Panel extends mainFrame {
    int key = 0;
    sendEmail mt = new sendEmail();
    Timer time = new Timer();
    JLabel timer = new JLabel("");
    String email;
    String id;
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public pwChange2Panel(String email, String id) {
        setEmail(email);
        setId(id);

        sendEmail();

        setTitle("비밀번호 변경");

        title.setText("비밀번호 변경");
        title.setBounds(180, 60, 130, 40);

        timer.setFont(font);
        timer.setBounds(300, 10, 100, 40);

        JLabel au = new JLabel("인증번호 : ");
        au.setFont(font);
        au.setBounds(40, 150, 120, 30);

        JTextField auf = new JTextField(10);
        auf.setFont(font);
        auf.setBounds(150,150,290,30);

        JButton pw_find_btn = new JButton("인증");
        pw_find_btn.setFont(font);
        pw_find_btn.setBounds(90, 250, 150, 30);
        pw_find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(auf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "인증번호을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    if(auf.getText().equals(Integer.toString(key))) {
                        time.cancel();
                        timer.setText("");

                        new pwChange3Panel(email, id);

                        setVisible(false);
                        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    } else {
                        System.out.println("re");
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
                time.cancel();
                timer.setText("");
                new pwChange1Panel();

                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });

        JLabel retry = new JLabel("이메일이 오지 않으셨나요?");
        retry.setFont(font.deriveFont(attributes));
        retry.setForeground(Color.BLUE);
        retry.setBounds(120, 325, 250, 30);
        retry.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sendEmail();
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

        p.add(timer);
        p.add(au);
        p.add(auf);
        p.add(pw_find_btn);
        p.add(go_back_btn);
        p.add(retry);

        setVisible(true);
    }

    public void sendEmail() {
        try {
            if(mt.isAlive()) {
                mt.stop();
                time.cancel();
            }

            mt = new sendEmail();
            time = new Timer();
            String from = "josubyn05@naver.com";
            String subject = "이메일 인증";
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            key = random.nextInt(1000000) % 1000000;
            String content = "안녕하세요. 반갑습니다.\n인증번호 : "+key+"\n 감사합니다.";

            // 메일보내기
            mt.sendEmail(from, email, subject, content);
            mt.start();


            time.scheduleAtFixedRate(new TimerTask() {
                int i = 180;

                public void run() {

                    timer.setText(""+i);
                    i--;

                    if (i < 0) {
                        time.cancel();
                        timer.setText("");
                    }
                }
            }, 0, 1000);

        }
        catch (AddressException addr_e) {
            addr_e.printStackTrace();
        }
        catch(MessagingException me) {
            System.out.println("메일 전송에 실패하였습니다.");
            System.out.println("실패 이유 : " + me.getMessage());
            me.printStackTrace();
        }
        catch (InterruptedException ex) {
            System.out.println("interruptedException");
            throw new RuntimeException(ex);
        }
        catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
