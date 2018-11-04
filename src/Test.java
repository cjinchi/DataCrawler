import analyze.Analyzer;
import analyze.Result;
import crawler.CkanCrawler;
import crawler.Source;

public class Test {
    public static int check(int num, String string) {
        if (string == null || num > string.length()) {
            return num;
        } else {
            return string.length();
        }

    }

    public static void main(String[] args) {
        int maxLicenseTitle = 0;
        int maxMaintainer = 0;
        int maxMaintainerEmail = 0;
        int maxId = 0;
        int maxMetadataCreated = 0;
        int maxMetadataModified = 0;
        int maxAuthor = 0;
        int maxAuthorEmail = 0;
        int maxState = 0;
        int maxVersion = 0;
        int maxCreatorUserId = 0;
        int maxType = 0;
        int maxLicenseId = 0;
        int maxName = 0;
        int maxUrl = 0;
        int maxNotes = 0;
        int maxOwnerOrg = 0;
        int maxTitle = 0;
        int maxRevisionId = 0;

//        int totalDatasetNum = CkanCrawler.getSourceTotalCount(Source.EUROPEAN_DATA_PORTAL);
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            Analyzer analyzer = new Analyzer(
                    CkanCrawler.getPackageSearchResponse(Source.EUROPEAN_DATA_PORTAL, 1000, i * 1000));
            if (!analyzer.success())
                continue;
            Result[] results = analyzer.getResults();
            for (Result result : results) {
                maxLicenseTitle = check(maxLicenseTitle, result.getLicenseTitle());
                maxMaintainer = check(maxMaintainer, result.getMaintainer());
                maxMaintainerEmail = check(maxMaintainerEmail, result.getMaintainerEmail());
                maxId = check(maxId, result.getId());
                maxMetadataCreated = check(maxMetadataCreated, result.getMetadataCreated());
                maxMetadataModified = check(maxMetadataModified, result.getMetadataModified());
                maxAuthor = check(maxAuthor, result.getAuthor());
                maxAuthorEmail = check(maxAuthorEmail, result.getAuthorEmail());
                maxState = check(maxState, result.getState());
                maxVersion = check(maxVersion, result.getVersion());
                maxCreatorUserId = check(maxCreatorUserId, result.getCreatorUserId());
                maxType = check(maxType, result.getType());
                maxLicenseId = check(maxLicenseId, result.getLicenseId());
                maxName = check(maxName, result.getName());
                maxUrl = check(maxUrl, result.getUrl());
                maxNotes = check(maxNotes, result.getNotes());
                maxOwnerOrg = check(maxOwnerOrg, result.getOwnerOrg());
                maxTitle = check(maxTitle, result.getTitle());
                maxRevisionId = check(maxRevisionId, result.getRevisionId());

            }
        }

        System.out.println(maxLicenseTitle);
        System.out.println(maxMaintainer);
        System.out.println(maxMaintainerEmail);
        System.out.println(maxId);
        System.out.println(maxMetadataCreated);
        System.out.println(maxMetadataModified);
        System.out.println(maxAuthor);
        System.out.println(maxAuthorEmail);
        System.out.println(maxState);
        System.out.println(maxVersion);
        System.out.println(maxCreatorUserId);
        System.out.println(maxType);
        System.out.println(maxLicenseId);
        System.out.println(maxName);
        System.out.println(maxUrl);
        System.out.println(maxNotes);
        System.out.println(maxOwnerOrg);
        System.out.println(maxTitle);
        System.out.println(maxRevisionId);
    }

}
