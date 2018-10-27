package analyze;

import org.json.JSONArray;
import org.json.JSONObject;

public class Result {
    JSONObject data;
    Resource[] resources;
    Tag[] tags;
    Organization organization;
    Extra[] extras;

    public Result(JSONObject jsonObject) {
        data = jsonObject;
    }

    public String getLicenseTitle() {
        return data.getString("license_title");
    }

    public String getMaintainer() {
        return data.getString("maintainer");
    }

//    public JSONArray getRelationshipsAsObject() {
//        return data.getJSONArray("relationships_as_object");
//    }

    public boolean getPrivate() {
        return data.getBoolean("private");
    }

    public String getMaintainerEmail() {
        return data.getString("maintainer_email");
    }

    public int getNumTags() {
        return data.getInt("num_tags");
    }

    public String getId() {
        return data.getString("id");
    }

    public String getMetadataCreated() {
        return data.getString("metadata_created");
    }

    public String getMetadataModified() {
        return data.getString("metadata_modified");
    }

    public String getAuthor() {
        return data.getString("author");
    }

    public String getAuthorEmail() {
        return data.getString("author_email");
    }

    public String getState() {
        return data.getString("state");
    }

    public String getVersion() {
        return data.getString("version");
    }

    public String getCreatorUserId() {
        return data.getString("creator_user_id");
    }

    public String getType() {
        return data.getString("type");
    }

    public Resource[] getResources() {
        if (resources == null) {
            JSONArray resourceJsonArray = data.getJSONArray("resources");
            resources = new Resource[resourceJsonArray.length()];
            for (int i = 0; i < resources.length; i++) {
                resources[i] = new Resource(resourceJsonArray.getJSONObject(i));
            }
        }
        return resources;
    }

    public int getNumResources() {
        return data.getInt("num_resources");
    }

    public Tag[] getTags() {
        if (tags == null) {
            JSONArray tagJsonArray = data.getJSONArray("tags");
            tags = new Tag[tagJsonArray.length()];
            for (int i = 0; i < tags.length; i++) {
                tags[i] = new Tag(tagJsonArray.getJSONObject(i));
            }
        }
        return tags;
    }

    public String getLicenseId() {
        return data.getString("license_id");
    }

    public Organization getOrganization() {
        if (organization == null) {
            organization = new Organization(data.getJSONObject("organization"));
        }
        return organization;
    }

    public String getName() {
        return data.getString("name");
    }

    public boolean getIsopen() {
        return data.getBoolean("isopen");
    }

    public String getUrl() {
        return data.getString("url");
    }

    public String getNotes() {
        return data.getString("notes");
    }

    public String getOwnerOrg() {
        return data.getString("owner_org");
    }

    public Extra[] getExtras() {
        if (extras == null) {
            JSONArray extraJsonArray = data.getJSONArray("extras");
            extras = new Extra[extraJsonArray.length()];
            for (int i = 0; i < extras.length; i++) {
                extras[i] = new Extra(extraJsonArray.getJSONObject(i));
            }
        }
        return extras;
    }

    public String getTitle() {
        return data.getString("title");
    }

    public String getRevisionId() {
        return data.getString("revision_id");
    }
}
