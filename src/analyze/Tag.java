package analyze;

import org.json.JSONObject;

public class Tag {
    JSONObject data;

    public Tag(JSONObject jsonObject) {
        data = jsonObject;
    }

    public String getVocabularyId() {
        return data.getString("vocabulary_id");
    }

    public String getState() {
        return data.getString("state");
    }

    public String getDisplayName() {
        return data.getString("display_name");
    }

    public String getId() {
        return data.getString("id");
    }

    public String getName() {
        return data.getString("name");
    }

}
