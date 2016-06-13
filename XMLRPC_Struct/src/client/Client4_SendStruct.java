package client;

import helma.xmlrpc.XmlRpcClient;
import java.util.Hashtable;
import java.util.Vector;

public class Client4_SendStruct {

    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();

            // create struct
            Hashtable mahasiswa = new Hashtable();
            mahasiswa.put("nim", new Integer(672011061));
            mahasiswa.put("nama", "Marsel");
            mahasiswa.put("jurusan", "TI");
            params.addElement(mahasiswa);
            // send struct to server
            Object result = server.execute("myServer.sendDataMahasiswa", params);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
