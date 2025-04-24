package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_Teacher {
    private String id;
    private String name;
    private String fullName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;
    private String message;
    private List<PJ_TeacherObject> objects;
    private List<String> courses;
    private String count;

}
