package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import analyze.Extra;
import analyze.Organization;
import analyze.Resource;
import analyze.Result;
import analyze.Tag;

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

    public boolean isConnected() {
        return connection != null;
    }

    public void close() throws SQLException {
        connection.close();
    }

//    public static void main(String[] args) {
//    }

    public boolean saveDataset(Result dataset) {

        PreparedStatement statement = null;
        Organization organization = dataset.getOrganization();

        try {
            statement = connection.prepareStatement(
                    "INSERT INTO metadata VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, dataset.getLicenseTitle());
            statement.setString(2, dataset.getMaintainer());
            statement.setString(3, dataset.getMaintainerEmail());
            statement.setString(4, dataset.getId());
            statement.setString(5, dataset.getMetadataCreated());
            statement.setString(6, dataset.getMetadataModified());
            statement.setString(7, dataset.getAuthor());
            statement.setString(8, dataset.getAuthorEmail());
            statement.setString(9, dataset.getState());
            statement.setString(10, dataset.getVersion());
            statement.setString(11, dataset.getCreatorUserId());
            statement.setString(12, dataset.getType());
            statement.setString(13, dataset.getLicenseId());
            statement.setString(14, dataset.getName());
            statement.setString(15, dataset.getUrl());
            statement.setString(16, dataset.getNotes());
            statement.setString(17, dataset.getOwnerOrg());
            statement.setString(18, dataset.getTitle());
            statement.setString(19, dataset.getRevisionId());
            statement.setString(20, organization.getDescription());
            statement.setString(21, organization.getCreated());
            statement.setString(22, organization.getTitle());
            statement.setString(23, organization.getName());
            statement.setObject(24, organization.getIsOrganization());
            statement.setString(25, organization.getState());
            statement.setString(26, organization.getImageUrl());
            statement.setString(27, organization.getRevisionId());
            statement.setString(28, organization.getType());
            statement.setString(29, organization.getId());
            statement.setString(30, organization.getApprovalStatus());
            statement.setObject(31, dataset.getPrivate());
            statement.setObject(32, dataset.getNumTags());
            statement.setObject(33, dataset.getNumResources());
            statement.setObject(34, dataset.getIsopen());

            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new RuntimeException("Error when database rollback");
            }
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }

        Resource[] resources = dataset.getResources();
        for (Resource resource : resources) {
            try {
                statement = connection
                        .prepareStatement("INSERT INTO resource VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1, dataset.getId());
                statement.setString(2, resource.getMimetype());
                statement.setString(3, resource.getCacheUrl());
                statement.setString(4, resource.getHash());
                statement.setString(5, resource.getDescription());
                statement.setString(6, resource.getName());
                statement.setString(7, resource.getFormat());
                statement.setString(8, resource.getUrl());
                statement.setString(9, resource.getCacheLastUpdated());
                statement.setString(10, resource.getPackageId());
                statement.setString(11, resource.getCreated());
                statement.setString(12, resource.getState());
                statement.setString(13, resource.getMimetypeInner());
                statement.setString(14, resource.getLastModified());
                statement.setObject(15, resource.getPosition());
                statement.setString(16, resource.getRevisionId());
                statement.setString(17, resource.getUrlType());
                statement.setString(18, resource.getId());
                statement.setString(19, resource.getResourceType());
                statement.setObject(20, Boolean.FALSE);

                statement.executeUpdate();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    throw new RuntimeException("Error when database rollback");
                }
                e.printStackTrace();
                return false;
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        Tag[] tags = dataset.getTags();
        for (Tag tag : tags) {
            try {
                statement = connection.prepareStatement("INSERT INTO tag VALUES (?,?,?,?,?,?)");

                statement.setString(1, dataset.getId());
                statement.setString(2, tag.getVocabularyId());
                statement.setString(3, tag.getState());
                statement.setString(4, tag.getDisplayName());
                statement.setString(5, tag.getId());
                statement.setString(6, tag.getName());

                statement.executeUpdate();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    throw new RuntimeException("Error when database rollback");
                }
                e.printStackTrace();
                return false;
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        Extra[] extras = dataset.getExtras();
        for (Extra extra : extras) {

            try {
                statement = connection.prepareStatement("INSERT INTO extra VALUES (?,?,?)");

                statement.setString(1, dataset.getId());
                statement.setString(2, extra.getKey());
                statement.setString(3, extra.getValue());

                statement.executeUpdate();
            } catch (SQLException e) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    throw new RuntimeException("Error when database rollback");
                }
                e.printStackTrace();
                return false;
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }

        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Error when database commit");
        }

        return true;

    }

}
