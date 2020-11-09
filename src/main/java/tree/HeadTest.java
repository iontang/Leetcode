package tree;

import java.io.IOException;
import java.net.*;

public class HeadTest {


    public static void main(String[] args) {

        URL url = null;
        try {
            url = new URL("http://yutuo.net");
//            System.out.println(URLDecoder.decode("https%3A%2F%2Fwww.clarins.com.cn%2Fcart.html","utf-8"));
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            System.out.println(connection.getResponseCode());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
