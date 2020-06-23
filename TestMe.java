import com.sun.org.apache.xpath.internal.operations.Equals;
import org.apache.poi.util.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dhuphim on 5/8/17.
 */
public class TestMe {
    private static final String FILE_TO = "/Users/dhuphim/StandAloneJava/src/goog.txt";

    public static void main(String[] args) {
        try {


            System.out.println("Hello");
            SocketAddress addr = new
                    InetSocketAddress("userproxy.intranet.db.com", 8080);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

            URL url = new URL("https://www.google.com/");
            URLConnection conn = url.openConnection(proxy);
            InputStream in = conn.getInputStream();
            String res= convertStreamToString(in);
            System.out.println(res);

            System.out.println("In " + proxy.toString());

            System.out.println("Is " + conn.getContent().toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    private void stat(InputStream inputStream){
//
//
//    String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//
//    }


    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}




//
//                Calendar calc1 = Calendar.getInstance();
//                calc1.add(Calendar.MONTH, -3);
//                Date startDatec = calc1.getTime();
//
//                Calendar calc2 = Calendar.getInstance();
//                calc2.add(Calendar.MONTH, -1);
//                Date endDatec = calc2.getTime();
//
//                SimpleDateFormat dfc1 = new SimpleDateFormat("dd-MMM-yyyy");
//                String beginc= dfc1.format(startDatec);
//            System.out.println(beginc);
//                String endc = dfc1.format(endDatec);
//            System.out.println(endc);
//
////May8th User exceeded License limit Quick fix
//                String query2= "Select count(*) as total from jiveuser where userenabled =1 and\n" +
//                        "TO_DATE('01-JAN-1970 00:00','DD-MON-YYYY HH24:MI')+(lastloggedin/1000/60/60/24)\n" +
//                        "between TO_DATE('" + beginc + "','DD-MON-YYYY HH24:MI') and  TO_DATE('" + endc + "','DD-MON-YYYY HH24:MI')";
//
//
//
//
//                String fullURL = "jdbc:oracle:thin:@//LNMYD4U.uk.db.com:1725/LNMYD4U.UK.DB.COM";
//            String username = "jive_owner";
//            String pwd = "Temp#12345";
//            conn = DriverManager.getConnection(fullURL, username, pwd);
//            statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//            rs = statement.executeQuery(query2);
//            int count = 0;
//            if(rs!=null){
//               while(rs.next()){
//
//                  String bb= rs.getString("total");
//                   count = count +1;
//                   System.out.println(bb);
//
//
//                   Map<String, Object> map = new HashMap<>();
//
//                   map.put("aa", new String("123"));
//                   map.put("bb", new String("456"));
//                   //System.out.println(map.values());
//                   List <Object> list = new ArrayList<Object>(map.values());
//                   System.out.println(list);
//
//
//           // System.out.println(email);
//                    //JiveUser jiveUser = new JiveUser(email, jiveID, directoryID, dbURL, firstName, lastName, lastLoggedOn, creationDate);
//
//                    //System.out.println(email);
//
//                    //users.put(email, jiveUser);
//                }
//
//
//
//
//                System.out.println(count);
//        }
//
//        }
//
//
//        catch (Exception eu) {
//            eu.printStackTrace();
//
//        }
//            finally {
//            try {
////                    writer.close();
//                rs.close();
//                conn.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }
//
//
//
//        }
//
//
//    }
//}
//
//
