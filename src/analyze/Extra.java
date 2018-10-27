package analyze;

import org.json.JSONObject;

public class Extra {
    JSONObject data;

    public Extra(JSONObject jsonObject) {
        data = jsonObject;
    }

    public String getKey() {
        return data.getString("key");
    }

    public String getValue() {
        return data.getString("value");
    }
}
