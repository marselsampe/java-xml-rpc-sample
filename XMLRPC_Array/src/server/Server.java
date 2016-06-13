package server;

import helma.xmlrpc.WebServer;
import java.util.Vector;

// Description : Return array to client
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

    // Method to send Vector to client
    public Vector getDaftarNama() {
        Vector daftarNama = new Vector();
        daftarNama.addElement("Marsel");
        daftarNama.addElement("Adi");
        daftarNama.addElement("Budi");

        return daftarNama;
    }
    
    // Method to send Multidimensional Vector to client
    public Vector getAllDataMahasiswa(){
        Vector result = new Vector();
        
        Vector mahasiswa1=new Vector();
        mahasiswa1.addElement("672011061");
        mahasiswa1.addElement("Marsel");
        mahasiswa1.addElement("TI");
        result.addElement(mahasiswa1);
        
        Vector mahasiswa2=new Vector();
        mahasiswa2.addElement("682011001");
        mahasiswa2.addElement("Adi");
        mahasiswa2.addElement("SI");
        result.addElement(mahasiswa2);
        
        return result;
    }
}
