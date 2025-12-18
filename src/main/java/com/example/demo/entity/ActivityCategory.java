import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Entity
public class ActivityCategory
{
private long id;
@column (unique=true)
private String categoryName;
private String description;
@PrePersist
private LocalDateTime createdAt;


public long getId(){
    return id; 
}
public void setId(Long id){
    this.id=id;
}

}