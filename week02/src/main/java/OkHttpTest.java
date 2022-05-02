import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author dengzhe
 * @date 2022/5/2
 */
public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("http://localhost:8801")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
