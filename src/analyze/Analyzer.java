package analyze;

import org.json.JSONArray;
import org.json.JSONObject;

import crawler.CkanCrawler;
import crawler.Source;

public class Analyzer {
    JSONObject data;
    private Result[] results;

    public Analyzer(String info) {
        if (info != null) {
            data = new JSONObject(info);
        }
    }

    public boolean success() {
        if (data != null && data.getBoolean("success")) {
            return true;
        } else {
            return false;
        }
    }

    public int getCount() {
        return data.getJSONObject("result").getInt("count");
    }

    public String getSort() {
        return data.getJSONObject("result").getString("sort");
    }

    public Result[] getResults() {
        if (results == null) {
            JSONArray resultsJsonArray = data.getJSONObject("result").getJSONArray("results");
            results = new Result[resultsJsonArray.length()];
            for (int i = 0; i < results.length; i++) {
                results[i] = new Result(resultsJsonArray.getJSONObject(i));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String info = CkanCrawler.getPackageSearchResponse(Source.OLD_DATAHUB, 2, 0);
        Analyzer analyzer = new Analyzer(info);
        System.out.println(analyzer.getResults()[0].getTags()[1].getName());
    }

}
