import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class joinPanel extends mainFrame {
    boolean idck = true;
    boolean auck = true;
    static public boolean emailck = true;
    int key = 0;
    sendEmail mt = new sendEmail();
    Timer time = new Timer();
    static JLabel timer;
    public joinPanel() {
        setTitle("회원가입");

        title.setText("회원가입");
        title.setBounds(210, 10, 100, 40);

        timer = new JLabel("");
        timer.setFont(font);
        timer.setBounds(300, 10, 100, 40);

        JLabel name = new JLabel("이름 : ");
        name.setFont(font);
        name.setBounds(40, 60, 150, 30);

        JTextField namef = new JTextField(10);
        namef.setFont(font);
        namef.setBounds(150,60,290,30);

        JLabel id = new JLabel("아이디 : ");
        id.setFont(font);
        id.setBounds(40, 100, 120, 30);

        JTextField idf = new JTextField(10);
        idf.setFont(font);
        idf.setBounds(150,100,163,30);

        JButton idckf = new JButton("중복확인");
        idckf.setFont(font);
        idckf.setBounds(318, 100, 120, 30);
        idckf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkUsers(new User("", idf.getText(), "", "", 1), "id")) {
                    JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //아이디 중복 아님
                    idck=false;
                    System.out.println("아이디 중복 아님");
                }
            }
        });

        JLabel email = new JLabel("이메일 : ");
        email.setFont(font);
        email.setBounds(40, 140, 120, 30);

        JTextField emailf = new JTextField(10);
        emailf.setFont(font);
        emailf.setBounds(150,140,163,30);

        JButton emailckf = new JButton("인증");
        emailckf.setFont(font);
        emailckf.setBounds(318, 140, 120, 30);
        emailckf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(emailf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "이메일을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    try {
                        auck=true;
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

                        emailck=false;

                        // 메일보내기
                        mt.sendEmail(from, emailf.getText(), subject, content);
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
        });

        JLabel au = new JLabel("인증번호 : ");
        au.setFont(font);
        au.setBounds(40, 180, 120, 30);

        JTextField auf = new JTextField(10);
        auf.setFont(font);
        auf.setBounds(150,180,163,30);

        JButton auckf = new JButton("확인");
        auckf.setFont(font);
        auckf.setBounds(318, 180, 120, 30);
        auckf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(emailck) {
                    JOptionPane.showMessageDialog(null, "이메일을 인증해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //인증 확인
                    System.out.println(Integer.toString(key));
                    if(auf.getText().equals(Integer.toString(key))) {
                        System.out.println("ok");
                        auck=false;
                        time.cancel();
                        timer.setText("");
                    } else { // 인증 X
                        JOptionPane.showMessageDialog(null, "인증번호를 확인해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        JLabel pw = new JLabel("비밀번호 : ");
        pw.setFont(font);
        pw.setBounds(40,220, 120, 30);

        JPasswordField pwf = new JPasswordField(10);
        pwf.setFont(font);
        pwf.setBounds(150,220, 290, 30);

        JLabel pwck = new JLabel("비밀번호확인 : ");
        pwck.setFont(font);
        pwck.setBounds(40,260, 150, 30);

        JPasswordField pwckf = new JPasswordField(10);
        pwckf.setFont(font);
        pwckf.setBounds(180,260, 260, 30);

        JButton join_btn = new JButton("가입하기");
        join_btn.setFont(font);
        join_btn.setBounds(90, 330, 150, 30);
        join_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(namef.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(idf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(emailf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "이메일을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pwf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pwckf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "비밀번호확인을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(idck) {//아이디 중복확인했는지
                    JOptionPane.showMessageDialog(null, "아이디 중복 확인해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(auck) {//인증번호가 맞는지
                    JOptionPane.showMessageDialog(null, "인증번호를 확인해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(!pwf.getText().equals(pwckf.getText())) {
                    JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호확인을 확인해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    User user = new User(namef.getText(), idf.getText(), emailf.getText(), pwf.getText(), 0);

                    new joinOkPanel(user);

                    setVisible(false);
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                }
            }
        });

        JButton go_back_btn = new JButton("뒤로가기");
        go_back_btn.setFont(font);
        go_back_btn.setBounds(250, 330, 150, 30);
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
        p.add(id);
        p.add(idf);
        p.add(idckf);
        p.add(email);
        p.add(emailf);
        p.add(emailckf);
        p.add(au);
        p.add(auf);
        p.add(auckf);
        p.add(pw);
        p.add(pwf);
        p.add(pwck);
        p.add(pwckf);
        p.add(join_btn);
        p.add(go_back_btn);
        p.add(timer);

        setVisible(true);
    }
}
