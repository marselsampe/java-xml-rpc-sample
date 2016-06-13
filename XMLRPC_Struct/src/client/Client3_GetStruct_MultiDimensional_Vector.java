package client;

import helma.xmlrpc.XmlRpcClient;
import java.util.Hashtable;
import java.util.Vector;

public class Client3_GetStruct_MultiDimensional_Vector {

    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();

            Object result = server.execute("myServer.getAllDataMahasiswa", params);
            Vector daftarMahasiswa = (Vector) result;
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                Hashtable mahasiswa = (Hashtable) daftarMahasiswa.get(i);
                int nim = (Integer) mahasiswa.get("nim");
                String nama = (String) mahasiswa.get("nama");
                String jurusan = (String) mahasiswa.get("jurusan");
                System.out.println(nim + " - "+ nama + " - "+ jurusan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
