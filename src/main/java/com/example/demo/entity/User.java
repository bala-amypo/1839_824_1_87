import.jarkata.persistance.Entity;
import.jar
@Entity
public class User{
    private Long id;
    @Column(unique=true)
    private String categoryNmae;
    private String description;
    @PrePersist
    private LocalDateTime createdAt;

}