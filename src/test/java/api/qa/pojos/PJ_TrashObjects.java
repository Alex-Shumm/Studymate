package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class PJ_TrashObjects {
    private String id;
    private String name;
    private String type;
    private String entityId;
    private String createdAt;
    private String restorer;
    private String courseId;
}
