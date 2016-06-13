package server;

import helma.xmlrpc.WebServer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Description : Send and Get file (base64) from client
public class Server {

    public static void main(String[] args) {
        try {
            System.out.println("Start XML-RPC Server...");
            WebServer webServer = new WebServer(8081);
            webServer.addHandler("myServer", new Server());
            webServer.start();

            System.out.println("Started successfully.");
        } catch (Exception exception) {
            System.err.println("Server : " + exception);
        }
    }

    // Method to send file to client
    public byte[] getFile() {
        try {
            // Convert File to Byte
            String projectPath = System.getProperty("user.dir");
            String imagePath = projectPath + "/gambarServer/gambar1.jpg";
            File myFile = new File(imagePath);
            byte[] myByteArray = new byte[(int) myFile.length()];
            FileInputStream fileInputStream = new FileInputStream(myFile);
            fileInputStream.read(myByteArray);
            fileInputStream.close();
            
            return myByteArray;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    // Method to Get file from client
    public void sendFile(byte[] myByteArray){
        try {
            // Convert Byte to File
            String projectPath = System.getProperty("user.dir");
            String imagePath = projectPath + "/gambarServer/gambar2.jpg";
            FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
            fileOutputStream.write(myByteArray);
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
