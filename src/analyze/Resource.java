package analyze;

import org.json.JSONObject;

public class Resource {
    JSONObject data;

    public Resource(JSONObject jsonObject) {
        data = jsonObject;
    }

    public String getMimetype() {
        return data.getString("mimetype");
    }

    public String getCacheUrl() {
        return data.getString("cache_url");
    }

    public String getHash() {
        return data.getString("hash");
    }

    public String getDescription() {
        return data.getString("description");
    }

    public String getName() {
        return data.getString("name");
    }

    public String getFormat() {
        return data.getString("format");
    }

    public String getUrl() {
        return data.getString("url");
    }

//    public boolean getDatastoreActive() {
//        return data.getBoolean("datastore_active");
//    }

    public String getCacheLastUpdated() {
        return data.getString("cache_last_updated");
    }

    public String getPackageId() {
        return data.getString("package_id");
    }

    public String getCreated() {
        return data.getString("created");
    }

    public String getState() {
        return data.getString("state");
    }

    public String getMimetypeInner() {
        return data.getString("mimetype_inner");
    }

    public String getLastModified() {
        return data.getString("last_modified");
    }

    public int getPosition() {
        return data.getInt("position");
    }

    public String getRevisionId() {
        return data.getString("revision_id");
    }

    public String getUrlType() {
        return data.getString("url_type");
    }

    public String getId() {
        return data.getString("id");
    }

    public String getResourceType() {
        return data.getString("resource_type");
    }

//    public String getSize() {
//        
//    }

}
