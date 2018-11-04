package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import analyze.Analyzer;
import analyze.Extra;
import analyze.Organization;
import analyze.Resource;
import analyze.Result;
import analyze.Tag;
import crawler.CkanCrawler;
import crawler.Source;

public class DatabaseController {
    private Connection connection;

    public DatabaseController(String user, String password, String database) {
        try {
            connection = DriverManager.getConnection(String.format(
                    "jdbc:mysql://localhost/%s?user=%s&password=%s&serverTimezone=GMT", database, user, password));
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    privated
//
//    public boolean saveDataset(Result dataset) {
//        Statement statement = connection.createStatement();
//        statement
//    }

    public boolean isConnected() {
        return connection != null;
    }

    public void close() throws SQLException {
        connection.close();
    }

    private String sqlEncoding(String string) {
        if (string == null) {
            return "NULL";
        } else {
            return String.format("'%s'", string);
        }
    }

    private String sqlEncoding(Integer integer) {
        if (integer == null) {
            return "NULL";
        } else {
            return String.format("%d", integer);
        }
    }

    private String sqlEncoding(Boolean var) {
        if (var == null) {
            return "NULL";
        } else {
            int temp = (var ? 1 : 0);
            return String.format("%d", temp);
        }
    }

    public static void main(String[] args) {
        DatabaseController dbc = new DatabaseController("root", "", "datasets");
        if (!dbc.isConnected()) {
            System.out.println("connect error");
            return;
        }

        String info = CkanCrawler.getPackageSearchResponse(Source.OLD_DATAHUB, 1, 0);
        Analyzer analyzer = new Analyzer(info);
        Result[] results = analyzer.getResults();
        for (Result result : results) {
            dbc.saveDataset(result);
        }

        try {
            dbc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean saveDataset(Result dataset) {

        try {
            Statement statement = connection.createStatement();

            Organization organization = dataset.getOrganization();
            String metadataSql = String.format(
                    "INSERT INTO metadata VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
                    sqlEncoding(dataset.getLicenseTitle()), sqlEncoding(dataset.getMaintainer()),
                    sqlEncoding(dataset.getMaintainerEmail()), sqlEncoding(dataset.getId()),
                    sqlEncoding(dataset.getMetadataCreated()), sqlEncoding(dataset.getMetadataModified()),
                    sqlEncoding(dataset.getAuthor()), sqlEncoding(dataset.getAuthorEmail()),
                    sqlEncoding(dataset.getState()), sqlEncoding(dataset.getVersion()),
                    sqlEncoding(dataset.getCreatorUserId()), sqlEncoding(dataset.getType()),
                    sqlEncoding(dataset.getLicenseId()), sqlEncoding(dataset.getName()), sqlEncoding(dataset.getUrl()),
                    sqlEncoding(dataset.getNotes()), sqlEncoding(dataset.getOwnerOrg()),
                    sqlEncoding(dataset.getTitle()), sqlEncoding(dataset.getRevisionId()),
                    sqlEncoding(organization.getDescription()), sqlEncoding(organization.getCreated()),
                    sqlEncoding(organization.getTitle()), sqlEncoding(organization.getName()),
                    sqlEncoding(organization.getIsOrganization()), sqlEncoding(organization.getState()),
                    sqlEncoding(organization.getImageUrl()), sqlEncoding(organization.getRevisionId()),
                    sqlEncoding(organization.getType()), sqlEncoding(organization.getId()),
                    sqlEncoding(organization.getApprovalStatus()), sqlEncoding(dataset.getPrivate()),
                    sqlEncoding(dataset.getNumTags()), sqlEncoding(dataset.getNumResources()),
                    sqlEncoding(dataset.getIsopen()));
            statement.execute(metadataSql);

            Resource[] resources = dataset.getResources();
            for (Resource resource : resources) {
                String resourceSql = String.format(
                        "INSERT INTO resource VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
                        sqlEncoding(dataset.getId()), sqlEncoding(resource.getMimetype()),
                        sqlEncoding(resource.getCacheUrl()), sqlEncoding(resource.getHash()),
                        sqlEncoding(resource.getDescription()), sqlEncoding(resource.getName()),
                        sqlEncoding(resource.getFormat()), sqlEncoding(resource.getUrl()),
                        sqlEncoding(resource.getCacheLastUpdated()), sqlEncoding(resource.getPackageId()),
                        sqlEncoding(resource.getCreated()), sqlEncoding(resource.getState()),
                        sqlEncoding(resource.getMimetypeInner()), sqlEncoding(resource.getLastModified()),
                        sqlEncoding(resource.getPosition()), sqlEncoding(resource.getRevisionId()),
                        sqlEncoding(resource.getUrlType()), sqlEncoding(resource.getId()),
                        sqlEncoding(resource.getResourceType()), sqlEncoding(Boolean.FALSE));
                statement.execute(resourceSql);
            }

            Tag[] tags = dataset.getTags();
            for (Tag tag : tags) {
                String tagSql = String.format("INSERT INTO tag VALUES (%s,%s,%s,%s,%s,%s)",
                        sqlEncoding(dataset.getId()), sqlEncoding(tag.getVocabularyId()), sqlEncoding(tag.getState()),
                        sqlEncoding(tag.getDisplayName()), sqlEncoding(tag.getId()), sqlEncoding(tag.getName()));
                statement.execute(tagSql);
            }

            Extra[] extras = dataset.getExtras();
            for (Extra extra : extras) {
                String extraSql = String.format("INSERT INTO extra VALUES (%s,%s,%s)", sqlEncoding(dataset.getId()),
                        sqlEncoding(extra.getKey()), sqlEncoding(extra.getValue()));
                statement.execute(extraSql);
            }

            connection.commit();
            return true;

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new RuntimeException("Error when database rollback");
            }
            e.printStackTrace();
        }
        return false;

    }

}
