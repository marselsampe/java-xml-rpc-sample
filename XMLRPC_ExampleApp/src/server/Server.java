package server;

import helma.xmlrpc.WebServer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import model.Mahasiswa;

// Description : Return Struct to client
public class Server {

    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

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

    // Method to get data (struct) from client
    public void sendDataMahasiswa(Hashtable data) {
        System.out.println("Get data from client");

        int nim = (Integer) data.get("nim");
        String nama = (String) data.get("nama");
        String jurusan = (String) data.get("jurusan");

        Mahasiswa mhs = new Mahasiswa();
        mhs.setNim(nim);
        mhs.setNama(nama);
        mhs.setJurusan(jurusan);
        daftarMahasiswa.add(mhs);
    }

    // Method to send Multidimensional Struct with Vector to client
    public Vector getAllDataMahasiswa() {
        System.out.println("Send data to client");

        if (daftarMahasiswa.size() == 0) {
            return null;
        } else {
            Vector result = new Vector();

            for (Mahasiswa mhs : daftarMahasiswa) {
                Hashtable data = new Hashtable();
                data.put("nim", mhs.getNim());
                data.put("nama", mhs.getNama());
                data.put("jurusan", mhs.getJurusan());
                result.addElement(data);
            }
            return result;
        }
    }

    // Method to send Struct to client
    public Hashtable getDetailDataMahasiswa(int nimSearch) {
        System.out.println("Send data to client");

        // Search process
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim() == nimSearch) {
                Hashtable result = new Hashtable();
                result.put("nim", mhs.getNim());
                result.put("nama", mhs.getNama());
                result.put("jurusan", mhs.getJurusan());
                return result;
            }
        }
        return null;
    }
}
