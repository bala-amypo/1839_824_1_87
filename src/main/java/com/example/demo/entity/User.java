import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.email;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
@Entity
public class User{
    @Id
    private Long id;
    private String fullName;
    @column (unique=true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role=Role.USER;
    public enum Role(){
        ADMIN;
        USER;
    }
    private LocalDateTime  createdAt;
    public Long getid(){
        return id;
    }
    public void setid(Long id){
        this.id=id;
    }
        public String getfullName(){
        return fullName;
    }
    public void setfullName(String fullName){
        this.fullName=fullName;
    }
            public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }
            public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password=password;
    }
            public String getfullName(){
        return fullName;
    }
    public void setfullName(String fullName){
        this.fullName=fullName;
    }



}