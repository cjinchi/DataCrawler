package crawler;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;

public class CkanCrawler {
    private final static String charset = StandardCharsets.UTF_8.name();

    public static int getSourceTotalCount(Source source) {
        String info = getPackageSearchResponse(source, 0, 0);
        if (info == null) {
            return -1;
        }

        JSONObject object = new JSONObject(info);
        int count = object.getJSONObject("result").getInt("count");
        return count;
    }

    public static String getPackageSearchResponse(Source source, int rows, int start) {
        if (rows < 0 || start < 0) {
            return null;
        }
        try {
            String query = String.format("action/package_search?rows=%s&start=%s",
                    URLEncoder.encode(String.valueOf(rows), charset),
                    URLEncoder.encode(String.valueOf(start), charset));
            return getHttpResponseInformation(source.getHeader() + query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getHttpResponseInformation(String targetUrl) {
        URLConnection connection;
        try {
            connection = new URL(targetUrl).openConnection();
            connection.setConnectTimeout(100000);
            connection.setReadTimeout(100000);
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0)");
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String result = scanner.useDelimiter("\\A").next();
            scanner.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPackageSearchResponse(Source.DATAGOV, 10, 0));
    }
}
