package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_TeacherObject {
    private String id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String specialization;
}
