
package client;

import helma.xmlrpc.XmlRpcClient;
import java.util.Vector;

public class Client2_MultiDimensional {
    
    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();

            // get Vector from server
            Object result = server.execute("myServer.getAllDataMahasiswa", params);
            Vector daftarMahasiswa = (Vector) result;
            
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                Vector mahasiswa= (Vector) daftarMahasiswa.get(i);
                String nim = (String) mahasiswa.get(0);
                String nama = (String) mahasiswa.get(1);
                String jurusan = (String) mahasiswa.get(2);
                
                System.out.println(nim + " - "+ nama + " - "+ jurusan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            
            
}
