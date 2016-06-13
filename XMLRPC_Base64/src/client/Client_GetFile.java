package client;

import helma.xmlrpc.XmlRpcClient;
import java.io.FileOutputStream;
import java.util.Vector;

public class Client_GetFile {

    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();
            
            // get Byte from server
            Object result = server.execute("myServer.getFile", params);
            byte[] myByteArray = (byte[]) result;
            // Convert Byte to File
            String projectPath = System.getProperty("user.dir");
            String imagePath = projectPath + "/gambarClient/gambar1.jpg";
            FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
            fileOutputStream.write(myByteArray);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
