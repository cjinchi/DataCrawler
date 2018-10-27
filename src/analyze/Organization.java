package analyze;

import org.json.JSONObject;

public class Organization {
    JSONObject data;

    public Organization(JSONObject jsonObject) {
        data = jsonObject;
    }

    public String getDescription() {
        return data.getString("description");
    }

    public String getCreated() {
        return data.getString("created");
    }

    public String getTitle() {
        return data.getString("title");
    }

    public String getName() {
        return data.getString("name");
    }

    public boolean getIsOrganization() {
        return data.getBoolean("is_organization");
    }

    public String getState() {
        return data.getString("state");
    }

    public String getImageUrl() {
        return data.getString("image_url");
    }

    public String getRevisionId() {
        return data.getString("revision_id");
    }

    public String getType() {
        return data.getString("type");
    }

    public String getId() {
        return data.getString("id");
    }

    public String getApprovalStatus() {
        return data.getString("approval_status");
    }
}
