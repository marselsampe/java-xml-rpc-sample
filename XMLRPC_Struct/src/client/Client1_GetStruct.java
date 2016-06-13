package client;

import helma.xmlrpc.XmlRpcClient;
import java.util.Hashtable;
import java.util.Vector;

public class Client1_GetStruct {

    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();

            Object result = server.execute("myServer.getDataMahasiswa1", params);
            Hashtable mahasiswa = (Hashtable) result;
            int nim = (Integer) mahasiswa.get("nim");
            String nama = (String) mahasiswa.get("nama");
            String jurusan = (String) mahasiswa.get("jurusan");
            System.out.println(nim + " - "+ nama + " - "+ jurusan);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
