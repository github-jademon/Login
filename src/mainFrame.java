import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mainFrame extends JFrame {
    File users = new File("C:/Users/jademon/Documents/academy/java/PJT_Login/login.txt");
    ArrayList<User> user_list = new ArrayList<User>();
    Font font = new Font("맑은 고딕", Font.PLAIN, 20);
    Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
    JPanel p = new JPanel();
    JLabel title = new JLabel();

    public void setUsers() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(users));

            if (users.exists() && users.length() != 0L) {
                String str = br.readLine();
                while (str != null) {
                    String[] strArr = str.split(" ");
                    User user = new User(strArr[0], strArr[1], strArr[2], strArr[3], 1);
                    user_list.add(user);
                    str = br.readLine();
                }
            }

            br.close();
        } catch (NullPointerException e){ // null이 있을 경우
            e.getStackTrace();
        } catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
            e.getStackTrace();
        } catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
            e.getStackTrace();
        }
    }

    public String userId(User user) {
        for(int i = 0; i < user_list.size(); i++){
            User user1 = user_list.get(i);
            if(user1.getEmail().equals(user.getEmail())&&user1.getName().equals(user.getName())) {
                return user1.getId();
            }
        }
        return "";
    }

    public boolean checkUsers(User user, String type) {
        if(type.equals("id")) {
            // 아이디 확인 (아이디 중복)
            for(int i = 0; i < user_list.size(); i++){
                User user1 = user_list.get(i);
                if(user1.getId().equals(user.getId())) {
                    return true;
                }
            }
        }
        else if(type.equals("name&email")) {
            // 이름, 이메일 확인 (아이디 찾기)
            for(int i = 0; i < user_list.size(); i++){
                User user1 = user_list.get(i);
                if(user1.getName().equals(user.getName())&&user1.getEmail().equals(user.getEmail())) {
                    return true;
                }
            }
        }
        else if(type.equals("pw")) {
            // 비밀번호 확인 (비밀번호)
            for(int i = 0; i < user_list.size(); i++){
                User user1 = user_list.get(i);
                System.out.println(user1.getPw());
                if(user1.getPw().equals(user.getPw())) {
                    return true;
                }
            }
        }
        else if(type.equals("id&email")) {
            // 아이디, 이메일 확인 (비밀번호 찾기)
            for(int i = 0; i < user_list.size(); i++){
                User user1 = user_list.get(i);
                if(user1.getId().equals(user.getId())&&user1.getEmail().equals(user.getEmail())) {
                    return true;
                }
            }
        }
        return false;
    }

    public mainFrame() {
        setUsers();
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(p);

        p.setLayout(null);
        p.setBackground(new Color(242, 242, 242));

        title.setFont(font);

        p.add(title);
    }
}
