package client;

import helma.xmlrpc.XmlRpcClient;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;

public class Client {

    static XmlRpcClient server = null;
    static Vector params = new Vector();

    public Client() {
        try {
            // connect server
            server = new XmlRpcClient("http://localhost:8081/RPCclient");

            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.println("=== MENU ===");
                System.out.println("1. Insert Mahasiswa");
                System.out.println("2. View Detail Mahasiswa");
                System.out.println("3. View All Mahasiswa");
                System.out.print("Select Menu : ");
                String menu = scan.nextLine();

                switch (menu) {
                    case "1":
                        insertData();
                        break;
                    case "2":
                        viewDetailDataMahasiswa();
                        break;
                    case "3":
                        viewAllDataMahasiswa();
                        break;
                }


                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insertData() {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Masukkan data mahasiswa");
            System.out.print("NIM : ");
            int nim = Integer.parseInt(scan.nextLine());
            System.out.print("Nama : ");
            String nama = scan.nextLine();
            System.out.print("Jurusan : ");
            String jurusan = scan.nextLine();

            // create struct
            Hashtable mahasiswa = new Hashtable();
            mahasiswa.put("nim", nim);
            mahasiswa.put("nama", nama);
            mahasiswa.put("jurusan", jurusan);
            params.addElement(mahasiswa);

            // send struct to server
            Object result = server.execute("myServer.sendDataMahasiswa", params);
            params.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void viewDetailDataMahasiswa() {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.print("NIM Mahasiswa : ");
            int nimSearch = Integer.parseInt(scan.nextLine());
            params.add(nimSearch);

            Object result = server.execute("myServer.getDetailDataMahasiswa", params);
            if (result == null) {
                System.out.println("Data not found");
            } else {
                Hashtable mahasiswa = (Hashtable) result;
                int nim = (Integer) mahasiswa.get("nim");
                String nama = (String) mahasiswa.get("nama");
                String jurusan = (String) mahasiswa.get("jurusan");
                System.out.println(nim + " - " + nama + " - " + jurusan);
            }

            params.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void viewAllDataMahasiswa() {
        try {
            System.out.println("DAFTAR MAHASISWA");
            Object result = server.execute("myServer.getAllDataMahasiswa", params);
            if (result == null) {
                System.out.println("Data not found");
            } else {
                Vector daftarMahasiswa = (Vector) result;
                for (int i = 0; i < daftarMahasiswa.size(); i++) {
                    Hashtable mahasiswa = (Hashtable) daftarMahasiswa.get(i);
                    int nim = (Integer) mahasiswa.get("nim");
                    String nama = (String) mahasiswa.get("nama");
                    String jurusan = (String) mahasiswa.get("jurusan");
                    System.out.println((i + 1) + ". " + nim + " - " + nama + " - " + jurusan);
                }
            }

            params.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
