/**
 * Created with IntelliJ IDEA.
 * User: talbjad
 * Date: 5/07/14
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        String replaceMe = "throw 'allowIllegalResourceCall is false.';";
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText.replace(replaceMe,""));
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        //scanForDocs("http://mydb1u05.uk.db.com:8080/api/core/v3/search/contents?filter=type(document)&filter=search(Confidential)&count=25&startIndex=25",25);
        //scanForDocs("http://mydb1u05.uk.db.com:8080/api/core/v3/contents?filter=search(Confidential)",25);
        scanForDocs("http://mydb1u05.uk.db.com:8080/api/core/v3/contents?filter=search(confidential)",25);
    }

    private static void scanForDocs(String incomingURL, int incomingCurrentCount) {
        String url = incomingURL;
        JSONObject json = null;
        try {
            json = readJsonFromUrl(url);
            JSONArray array = json.getJSONArray("list");
            List<String> list = new ArrayList<String>();
            for(int i=0; i<array.length();i++){
                //if(array.getJSONObject(i).getString("type").equals("file")){
                JSONObject resourcesObj = (JSONObject) array.getJSONObject(i).get("resources");
                JSONObject htmlObj = (JSONObject) resourcesObj.get("html");
                JSONObject versionsObj = (JSONObject) resourcesObj.get("versions");
                String ownerObj = versionsObj.get("ref").toString();
                String refObj =  htmlObj.get("ref").toString();
                //System.out.println(refObj.toString() + "     " + getDocOwner(ownerObj));
                System.out.println(refObj.toString());
            }//end for loop

            System.out.println(json.getJSONObject("links").toString());
          JSONObject links = json.getJSONObject("links");
            String nextLink = links.get("next").toString();
            if(!nextLink.equals(null)){
                //System.out.println("----------------------------------------------------------------------(current count:" + incomingCurrentCount);
                scanForDocs(nextLink, incomingCurrentCount+25);   //recursive method call
                System.out.println(nextLink);
            }
            else{
                System.out.println("Scan complete!");
            }

            return;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error in scanForDocs() method");
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    } //end scanForDocs method

    private static String getDocOwner(String ownerURL) {
        String url = ownerURL;
        JSONObject json = null;
        String emailArray = null;
        try {
            json = readJsonFromUrl(ownerURL);
            JSONArray array = json.getJSONArray("list");
            List<String> list = new ArrayList<String>();
            JSONObject authorObj = (JSONObject) array.getJSONObject(0).get("author");
            emailArray = authorObj.getJSONArray("emails").getJSONObject(0).get("value").toString();

        } catch (IOException e) {
            System.out.println("error in getDocOwner() method");
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return emailArray;
    }
}
