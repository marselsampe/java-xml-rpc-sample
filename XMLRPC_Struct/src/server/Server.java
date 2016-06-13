package server;

import helma.xmlrpc.WebServer;
import java.util.Hashtable;
import java.util.Vector;

// Description : Return Struct to client
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

    // Method to send Struct to client
    public Hashtable getDataMahasiswa1() {
        Hashtable result = new Hashtable();
        result.put("nim", new Integer(672011061));
        result.put("nama", "Marsel");
        result.put("jurusan", "TI");
        return result;
    }

    // Method to send Multidimensional Struct to client
    public Hashtable getDataMahasiswa2() {
        Hashtable result = new Hashtable();
        result.put("nim", new Integer(672011061));
        result.put("nama", "Marsel");
        result.put("jurusan", "Teknik Informatika");
        Hashtable alamatMahasiswa = new Hashtable();
        alamatMahasiswa.put("jalan", "Jl.Sudirman no.1");
        alamatMahasiswa.put("kota", "Kota Salatiga");
        alamatMahasiswa.put("provinsi", "Jawa Tengah");
        result.put("alamat", alamatMahasiswa);

        return result;
    }

    // Method to send Multidimensional Struct with Vector to client
    public Vector getAllDataMahasiswa() {
        Vector result = new Vector();

        Hashtable mahasiswa1 = new Hashtable();
        mahasiswa1.put("nim", new Integer(672011061));
        mahasiswa1.put("nama", "Marsel");
        mahasiswa1.put("jurusan", "TI");
        result.addElement(mahasiswa1);

        Hashtable mahasiswa2 = new Hashtable();
        mahasiswa2.put("nim", new Integer(682011001));
        mahasiswa2.put("nama", "Adi");
        mahasiswa2.put("jurusan", "SI");
        result.addElement(mahasiswa2);

        return result;
    }
    
    // Method to get data (struct) from client
    public void sendDataMahasiswa(Hashtable mahasiswa) {
        int nim = (Integer) mahasiswa.get("nim");
        String nama = (String) mahasiswa.get("nama");
        String jurusan = (String) mahasiswa.get("jurusan");
        System.out.println("Data from client : "+ nim + " - " + nama + " - " + jurusan);
    }
}
