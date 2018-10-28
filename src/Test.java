import analyze.Analyzer;
import analyze.Result;
import crawler.CkanCrawler;
import crawler.Source;

public class Test {
    public static void main(String[] args) {
//        int totalDatasetNum = CkanCrawler.getSourceTotalCount(Source.OLD_DATAHUB);
        int max_author_len = 0;
        String max_author = null;
        for (int i = 0; i < 10; i++) {
            Analyzer analyzer = new Analyzer(CkanCrawler.getPackageSearchResponse(Source.OLD_DATAHUB, 1000, i * 1000));
            Result[] results = analyzer.getResults();
            for (Result result : results) {
//            System.out.println(result.getId());
                if (result.getAuthor() != null)
                    if (result.getAuthor().length() > max_author_len) {
                        max_author_len = result.getAuthor().length();
                        max_author = result.getAuthor();
                    }
            }
        }
        System.out.println(max_author_len);
        System.out.println(max_author);

//        }
    }
}
