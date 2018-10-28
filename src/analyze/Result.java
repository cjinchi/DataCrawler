package analyze;

import org.json.JSONArray;
import org.json.JSONObject;

public class Result extends Data {
    Resource[] resources;
    Tag[] tags;
    Organization organization;
    Extra[] extras;

    public Result(JSONObject jsonObject) {
        super(jsonObject);
    }

    public String getLicenseTitle() {
        return dataGetString("license_title");
    }

    public String getMaintainer() {
        return dataGetString("maintainer");
    }

//    public JSONArray getRelationshipsAsObject() {
//        return data.getJSONArray("relationships_as_object");
//    }

    public Boolean getPrivate() {
        return dataGetBoolean("private");
    }

    public String getMaintainerEmail() {
        return dataGetString("maintainer_email");
    }

    public Integer getNumTags() {
        return dataGetInt("num_tags");
    }

    public String getId() {
        return dataGetString("id");
    }

    public String getMetadataCreated() {
        return dataGetString("metadata_created");
    }

    public String getMetadataModified() {
        return dataGetString("metadata_modified");
    }

    public String getAuthor() {
        return dataGetString("author");
    }

    public String getAuthorEmail() {
        return dataGetString("author_email");
    }

    public String getState() {
        return dataGetString("state");
    }

    public String getVersion() {
        return dataGetString("version");
    }

    public String getCreatorUserId() {
        return dataGetString("creator_user_id");
    }

    public String getType() {
        return dataGetString("type");
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

    public Integer getNumResources() {
        return dataGetInt("num_resources");
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
        return dataGetString("license_id");
    }

    public Organization getOrganization() {
        if (organization == null) {
            organization = new Organization(data.getJSONObject("organization"));
        }
        return organization;
    }

    public String getName() {
        return dataGetString("name");
    }

    public Boolean getIsopen() {
        return dataGetBoolean("isopen");
    }

    public String getUrl() {
        return dataGetString("url");
    }

    public String getNotes() {
        return dataGetString("notes");
    }

    public String getOwnerOrg() {
        return dataGetString("owner_org");
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
        return dataGetString("title");
    }

    public String getRevisionId() {
        return dataGetString("revision_id");
    }
}
