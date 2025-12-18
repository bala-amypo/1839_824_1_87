import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class ActivityCategory
{
    private Long id;
    private 

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
    this.categoryName=categoryName;
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
public ActivityCategory(Long id,String categoryName,String description,LocalDateTime createdAt){
    this.id=id;
    this.categoryName=categryName;
    this.description=description;
    this.createdAt=createdAt;
}
}