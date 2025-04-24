package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_AnnouncementObjects {
    private String text;
    private String createdBy;
    private String announcementType;
    private String groupName;
    private String groupId;
    private String date;
    private String id;
}
