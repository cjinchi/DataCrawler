package analyze;

import org.json.JSONObject;

public class Resource extends Data {

    public Resource(JSONObject jsonObject) {
        super(jsonObject);
    }

    public String getMimetype() {
        return dataGetString("mimetype");
    }

    public String getCacheUrl() {
        return dataGetString("cache_url");
    }

    public String getHash() {
        return dataGetString("hash");
    }

    public String getDescription() {
        return dataGetString("description");
    }

    public String getName() {
        return dataGetString("name");
    }

    public String getFormat() {
        return dataGetString("format");
    }

    public String getUrl() {
        return dataGetString("url");
    }

//    public Boolean getDatastoreActive() {
//        return dataGetBoolean("datastore_active");
//    }

    public String getCacheLastUpdated() {
        return dataGetString("cache_last_updated");
    }

    public String getPackageId() {
        return dataGetString("package_id");
    }

    public String getCreated() {
        return dataGetString("created");
    }

    public String getState() {
        return dataGetString("state");
    }

    public String getMimetypeInner() {
        return dataGetString("mimetype_inner");
    }

    public String getLastModified() {
        return dataGetString("last_modified");
    }

    public Integer getPosition() {
        return dataGetInt("position");
    }

    public String getRevisionId() {
        return dataGetString("revision_id");
    }

    public String getUrlType() {
        return dataGetString("url_type");
    }

    public String getId() {
        return dataGetString("id");
    }

    public String getResourceType() {
        return dataGetString("resource_type");
    }

//    public String getSize() {
//        
//    }

}
