package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_Students {
    private String name;
    private String lastName;
    private String fullName;
    private String phoneNumber;
    private String email;
    private int groupId;
    private String studyFormat;
    private String message;
    private List<PJ_StudentsObjects> objects;
}
