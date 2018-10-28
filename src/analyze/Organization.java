package analyze;

import org.json.JSONObject;

public class Organization extends Data {

    public Organization(JSONObject jsonObject) {
        super(jsonObject);
    }

    public String getDescription() {
        return dataGetString("description");
    }

    public String getCreated() {
        return dataGetString("created");
    }

    public String getTitle() {
        return dataGetString("title");
    }

    public String getName() {
        return dataGetString("name");
    }

    public Boolean getIsOrganization() {
        return dataGetBoolean("is_organization");
    }

    public String getState() {
        return dataGetString("state");
    }

    public String getImageUrl() {
        return dataGetString("image_url");
    }

    public String getRevisionId() {
        return dataGetString("revision_id");
    }

    public String getType() {
        return dataGetString("type");
    }

    public String getId() {
        return dataGetString("id");
    }

    public String getApprovalStatus() {
        return dataGetString("approval_status");
    }
}
