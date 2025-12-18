import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

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
public String getCategoryName(){
    return categoryName;
}
public void setCategoryName(String categoryName){
    this.category=category;
}
public String getDescription(){
    return description;
}
public void setDescription(String description){
    this.description=description;
}
public LocalDateTime getCreatedAt(){
    return createdAt;

}
public void setCreatedAt(LocalDateTime createdAt){
this.createdAt=createdAt;
}
public ActivityCategory(){}
public ActivityCategory(Long id,)
}