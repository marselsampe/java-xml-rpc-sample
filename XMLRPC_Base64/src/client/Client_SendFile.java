package client;

import helma.xmlrpc.XmlRpcClient;
import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;

public class Client_SendFile {

    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();
            
            // Convert File to Byte
            String projectPath = System.getProperty("user.dir");
            String imagePath = projectPath + "/gambarClient/gambar2.jpg";
            File myFile = new File(imagePath);
            byte[] myByteArray = new byte[(int) myFile.length()];
            FileInputStream fileInputStream = new FileInputStream(myFile);
            fileInputStream.read(myByteArray);
            fileInputStream.close();
            
            // send byte to server
            params.addElement(myByteArray);            
            Object result = server.execute("myServer.sendFile", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
