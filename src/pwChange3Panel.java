import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class pwChange3Panel extends mainFrame {
    public pwChange3Panel(String email, String id) {
        setTitle("비밀번호 변경");

        title.setText("비밀번호 변경");
        title.setBounds(180, 60, 130, 40);

        JLabel pw1 = new JLabel("비밀번호 : ");
        pw1.setFont(font);
        pw1.setBounds(40, 150, 150, 30);

        JPasswordField pw1f = new JPasswordField(10);
        pw1f.setFont(font);
        pw1f.setBounds(180,150,260,30);

        JLabel pw2 = new JLabel("비밀번호확인 : ");
        pw2.setFont(font);
        pw2.setBounds(40,190, 150, 30);

        JPasswordField pw2f = new JPasswordField(10);
        pw2f.setFont(font);
        pw2f.setBounds(180,190, 260, 30);

        JButton pw_find_btn = new JButton("변경");
        pw_find_btn.setFont(font);
        pw_find_btn.setBounds(90, 250, 150, 30);
        pw_find_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pw1f.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pw2f.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "비밀번호확인을 입력해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pw1f.getText().equals(pw2f.getText())) {
                    System.out.println("0");
                    // 비밀번호 재저장
                    String dummy = "";
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(users)));

                        //1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
                        String str = br.readLine();
                        while (str != null) {
                            if(str.contains(id+" "+email)) {
                                String[] strArr = str.split(" ");
                                User user = new User(strArr[0], strArr[1], strArr[2], pw1f.getText(), 0);

                                dummy += (user.getName()+" "+user.getId()+" "+user.getEmail()+" "+user.getPw()+"\r\n");

                                user_list.add(user);
                                str = br.readLine();

                                System.out.println("1");
                                continue;
                            }

                            dummy += (str + "\r\n" );
                            str = br.readLine();
                        }
                        System.out.println("2");

                        //4. FileWriter를 이용해서 덮어쓰기
                        FileWriter fw = new FileWriter(users);
                        fw.write(dummy);
                        fw.close();
                        br.close();

                        System.out.println("ok");
                        JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.", "", JOptionPane.INFORMATION_MESSAGE);

                        new loginPanel();

                        setVisible(false);
                        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                    } catch (Exception exception) {
                        exception.printStackTrace();

                        JOptionPane.showMessageDialog(null, "비밀번호 변경 중 오류가 발생하였습니다.", "", JOptionPane.INFORMATION_MESSAGE);

                        new pwChange1Panel();

                        setVisible(false);
                        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호확인을 확인해주세요", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton go_back_btn = new JButton("뒤로가기");
        go_back_btn.setFont(font);
        go_back_btn.setBounds(250, 250, 150, 30);
        go_back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pwChange2Panel(email, id);

                setVisible(false);
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });

        p.add(pw1);
        p.add(pw1f);
        p.add(pw2);
        p.add(pw2f);
        p.add(pw_find_btn);
        p.add(go_back_btn);

        setVisible(true);
    }
}
