import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.misc.BASE64Encoder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class NetClientGet {
    public static int count =0;

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        String searchQuery="mazedaar";
        String url1 = "https://uat.mydb.intranet.db.com/api/core/v3/search/contents?origin=searchpage&collapse=true&depth=none&socialSearch=false&returnScore=false&fields=rootType,type,subject,author,parentPlace,parentContent,binaryURL&filter=search("+ URLEncoder.encode(searchQuery, "UTF-8") + ")";
        PrintStream out = new PrintStream(new FileOutputStream("/Users/dhuphim/StandAloneJava/src/output.txt"));
        System.setOut(out);
        scanForDocs(url1,25);

        System.out.println("Count" + " " + count);

    }

    private static void scanForDocs(String incomingURL, int incomingCurrentCount) {

        try {
            String url = incomingURL;
            String name = "admin";
            String password = "AlAsHiMa2015";
            String authString = name + ":" + password;
            String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
            // System.out.println("Base64 encoded auth string: " + authStringEnc);
            Client restClient = Client.create();
            WebResource webResource = restClient.resource(url);
            ClientResponse resp = webResource.accept("application/json")
                    .header("Authorization", "Basic " + authStringEnc)
                    .get(ClientResponse.class);
            if (resp.getStatus() != 200) {
                System.err.println("Unable to connect to the server");
            }

            String output = resp.getEntity(String.class);

            String replaceMe = "throw 'allowIllegalResourceCall is false.';";
            output = output.replace(replaceMe, "");

            JSONObject json = new JSONObject(output);
            System.out.println(json);
            JSONArray array = json.getJSONArray("list");
            List<String> list = new ArrayList<String>();

            for (int i = 0; i < array.length(); i++) {
                //if(array.getJSONObject(i).getString("type").equals("file")){
                JSONObject resourcesObj = (JSONObject) array.getJSONObject(i).get("resources");
                JSONObject htmlObj = (JSONObject) resourcesObj.get("html");
                String refObj = htmlObj.get("ref").toString();
                String id =  array.getJSONObject(i).get("id").toString();
                JSONObject author = (JSONObject) array.getJSONObject(i).get("author");
                if (author.has("displayName") && !refObj.toString().equals(null) && id!= null) {
                    System.out.println("Doc URL:" + " " + refObj.toString() + " || " + "Author Name:" + " " + author.get("displayName") + " || " + "ID:" + " " +id);
                    count++;
                } else {
                    System.out.println("No Author or content URL");
                }


            }//end for loop

            if (json.has("links")) {
                JSONObject links = json.getJSONObject("links");
                String nextLink;
                if (links.has("next")) {
                    nextLink = links.get("next").toString();
                    //System.out.println(nextLink);
                    if (!nextLink.equals(null)) {
                        //System.out.println("----------------------------------------------------------------------(current count:" + incomingCurrentCount);
                        scanForDocs(nextLink, incomingCurrentCount + 25);   //recursive method call
                        //System.out.println(nextLink);
                    }
                } else {
                    System.out.println("Scan complete!");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}