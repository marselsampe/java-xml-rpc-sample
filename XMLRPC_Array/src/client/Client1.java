package client;

import helma.xmlrpc.XmlRpcClient;
import java.util.Vector;

public class Client1 {

    public static void main(String[] args) {
        try {
            // connect server
            XmlRpcClient server = new XmlRpcClient("http://localhost:8081/RPCclient");
            Vector params = new Vector();

            // get Vector from server
            Object result = server.execute("myServer.getDaftarNama", params);
            Vector daftarNama=(Vector) result;
            
            for (int i = 0; i < daftarNama.size(); i++) {
                System.out.println(daftarNama.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
