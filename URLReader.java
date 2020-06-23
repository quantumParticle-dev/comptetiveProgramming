import java.net.*;
import java.io.*;
import java.util.Base64;

public class URLReader {
    public static void main(String[] args) throws Exception {


        String name = "admin";
        String password = "AlAsHiMa@2015";

        String authString = name + ":" + password;
        System.out.println("auth string: " + authString);
        byte[] authEncBytes= Base64.getEncoder().encode(authString.getBytes());
        //byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        System.out.println("Base64 encoded auth string: " + authStringEnc);

        URL oracle = new URL("https://uat.mydb-upgrade.global.intranet.db.com/api/core/v3/search/contents?filter=search(We%20serve%20Latin%20America%20out%20of%20two%20booking%20locations%20Brazil%20and%20New%20York)&filter=subjectonly(true)");
        URLConnection urlConnection = oracle.openConnection();
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);



        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}