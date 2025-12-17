import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.email;
@Entity
public class User{
    @Id
    private Long id;
    private String fullName;
    @column (unique=true)
    private String email;
    private String 


}