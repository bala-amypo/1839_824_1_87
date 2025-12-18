import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class ActivityLog
{
    private Long id;
    private String typeName;
    private String unit;
    private LocalDateTime createdAt;

public Long getId(){
    return id; 
}
public void setId(Long id){
    this.id=id;
}
public String getTypeName(){
    return typeName;
}
public void setTypeName(String typeName){
    this.typeName=typeName;
}
public String getUnit(){
    return unit;
}
public void setUnit(String unit){
    this.unit=unit;
}
public LocalDateTime getCreatedAt(){
    return createdAt;

}
public void setCreatedAt(LocalDateTime createdAt){
this.createdAt=createdAt;
}
public ActivityLog(){}
public ActivityLog(Long id,String typeName,String unit,LocalDateTime createdAt){
    this.id=id;
    this.typeName=typeName;
    this.unit=unit;
    this.createdAt=createdAt;
}
}