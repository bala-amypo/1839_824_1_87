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
        public String fullName(){
        return fullName;
    }
    public void setfullName(Long id){
        this.id=id;
    }



}