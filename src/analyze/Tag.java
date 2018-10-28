package analyze;

import org.json.JSONObject;

public class Tag extends Data {

    public Tag(JSONObject jsonObject) {
        super(jsonObject);
    }

    public String getVocabularyId() {
        return dataGetString("vocabulary_id");
    }

    public String getState() {
        return dataGetString("state");
    }

    public String getDisplayName() {
        return dataGetString("display_name");
    }

    public String getId() {
        return dataGetString("id");
    }

    public String getName() {
        return dataGetString("name");
    }

}
