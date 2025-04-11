package api.qa.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PJ_Announcement {
    private String message;
    private List<PJ_AnnouncementObjects> objects;
    private String id;
    private String text;
    private String createdBy;
    private String announcementType;
    private String groupName;
    private String groupId;
    private String active;
    private String date;
    private String workspaceId;
    private String status;
}
