package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloader {
    public static boolean download(String url, String filename) {
        FileOutputStream fos = null;
        try {
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            fos = new FileOutputStream(filename);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }
}
