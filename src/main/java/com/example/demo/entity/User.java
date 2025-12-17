import.jarkata.persistance.Entity;
import.jarkata.persistance.Column;
import.jarkata.persistance.PrePersist;
@Entity
public class User{
    private Long id;
    @Column(unique=true)
    private String categoryNmae;
    private String description;
    @PrePersist
    private LocalDateTime createdAt;
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id=id;
    }
}