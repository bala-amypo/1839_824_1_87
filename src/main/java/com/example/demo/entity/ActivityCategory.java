import jakarta.persistence.Entity;
import jakarta.persistence.Column;
@Entity
public class ActivityCategory
{
private long id;
@column (unique=true)
private String categoryName;
private String description;
}