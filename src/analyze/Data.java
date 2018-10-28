package analyze;

import org.json.JSONObject;

public class Data {
    JSONObject data;

    public Data(JSONObject jsonObject) {
        data = jsonObject;
    }

    public Data(String info) {
        if (info != null) {
            data = new JSONObject(info);
        }
    }

    public boolean isDataNull() {
        return data == null;
    }

    protected String dataGetString(String key) {
        // Debug
        assert (!isDataNull() && data.has(key));

        if (data.isNull(key)) {
            return null;
        } else {
            return data.getString(key);
        }
    }

    protected Integer dataGetInt(String key) {
        // Debug
        assert (!isDataNull() && data.has(key));

        if (data.isNull(key)) {
            return null;
        } else {
            return Integer.valueOf(data.getInt(key));
        }
    }

    protected Boolean dataGetBoolean(String key) {
        // Debug
        assert (!isDataNull() && data.has(key));

        if (data.isNull(key)) {
            return null;
        } else {
            return Boolean.valueOf(data.getBoolean(key));
        }
    }

}
