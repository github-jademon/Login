import java.util.Objects;

public class User {
    public String name;
    public String id;

    public String email;

    public String pw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String id, String pw) {
        Encrypt encrypt = new Encrypt();
        this.pw = encrypt.getEncrypt(id, pw);
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public User(String name, String id, String email, String pw, int type) {
        setName(name);
        setId(id);
        setEmail(email);
        if(type==1) {
            setPw(pw);
        } else {
            setPw(id, pw);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name) && Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(pw, user.pw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, email, pw);
    }
}
