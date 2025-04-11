package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_Login {
    private String workspaceId;
    private String email;
    private String authority;
    private String language;
    private String status;
    private String message;
}
