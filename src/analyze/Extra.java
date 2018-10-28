package analyze;

import org.json.JSONObject;

public class Extra extends Data {

    public Extra(JSONObject jsonObject) {
        super(jsonObject);
    }

    public String getKey() {
        return dataGetString("key");
    }

    public String getValue() {
        return dataGetString("value");
    }
}
