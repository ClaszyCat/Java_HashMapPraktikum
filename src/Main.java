import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
    HashMap<String, String> tabelData = new HashMap<String, String>();
    HashMap<String, String> tabelSesiLogin = new HashMap<String, String>();
    static Main dp = new Main();
    static Scanner scanner = new Scanner(System.in);
    static String username;
    static String password;


    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (nimPraktikan.startsWith("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Data berhasil ditambahkan.");
            tampilMenu();
        } else {
            System.out.println("Data gagal ditambahkan.");
            tampilMenu();
        }
        return true;
    }

    public void tampil() {
        System.out.println("Total Data Yang Tersimpan : " + tabelData.size());
        for (Entry<String, String> entry : tabelData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("NIM Praktikan: " + key + " Nama Asisten : " + value);
        }
    }

    public void listNimPraktikan() {
        System.out.println("--List NIM--");
        for (Entry<String, String> entry : tabelData.entrySet()) {
            String key = entry.getKey();
            System.out.println("NIM Praktikan: " + key);
        }
    }

    public void listNamaAsisten() {
        System.out.println("--List Nama--");
        for (Entry<String, String> entry : tabelData.entrySet()) {
            String value = entry.getValue();
            System.out.println("Nama Asisten : " + value);
        }
        dp.tampilMenu();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data gagal dihapus.");
        }
        return true;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.containsValue(namaAsisten)) {

            System.out.println("====================================");
            System.out.println("Masukkan data baru!");

            tabelData.remove(nimPraktikan);
            Scanner nimB = new Scanner(System.in);
            System.out.print("Masukkan NIM: ");
            String nimBaru = nimB.nextLine();

            System.out.print("Masukkan Nama Asisten: ");
            Scanner namaB = new Scanner(System.in);
            String namaBaru = namaB.nextLine();

            tabelData.put(nimBaru, namaBaru);
            System.out.println("Data berhasil diubah");
        } else {
            System.out.println("Data tidak ada");
        }
    }

    public void searchData(String nimPraktikan) {
        for (Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getKey() == nimPraktikan) {
                System.out.println("Found NIM " + entry.getKey() + " Nama Asisten " +
                        entry.getValue());
            }
        }
    }

    public int totalEmail() {
        return tabelData.size();
    }

    public void login(String user, String pass) {
        dp.tabelSesiLogin.put("yovi", "likeabigbo55");
        if (username.contains("@umm.ac.id")) {
            String[] split = username.split("@");
            username = split[0];

            if (dp.tabelSesiLogin.containsKey(username) && dp.tabelSesiLogin.get(username).equals(password)) {
                dp.tampilMenu();
            } else {
                System.out.println("Username atau password anda tidak benar");
                main(null);
            }
        } else {
            System.out.println("Domain anda bukan @umm.ac.id");
            main(null);
        }
    }

    public void logout() {
        System.out.println("Anda Berhasil Logout");
    }

    public void tampilMenu(){
        System.out.println("Selamat datang " + username);
        System.out.println("1. Tambah Data" +
                "\n2. Tampil Data" +
                "\n3. List NIM Praktikan" +
                "\n4. List Nama Asisten" +
                "\n5. Total Email" +
                "\n6. Hapus Data" +
                "\n7. Edit Data" +
                "\n8. Logout");

        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1: {
                System.out.println("--- Tambah Data ---");
                System.out.println("Masukkan NIM: ");
                String tambahNIM = scanner.next();

                System.out.println("Masukkan Nama Asisten: ");
                String tambahNama = scanner.next();

                dp.tambahData(tambahNIM, tambahNama);
                break;
            }
            case 2: {
                System.out.println("--- Tampil Data ---");
                dp.tampil();
                dp.tampilMenu();
                break;
            }
            case 3: {
                dp.listNimPraktikan();
                dp.tampilMenu();
                break;
            }
            case 4: {
                dp.listNamaAsisten();
                break;
            }
            case 5: {

                System.out.println("Total data: " + dp.totalEmail());
//                dp.totalEmail();
                dp.tampilMenu();
                break;
            }
            case 6: {
                Scanner nimS = new Scanner(System.in);
                System.out.print("Masukkan NIM praktikan yang ingin dihapus (dimulai dengan IF) : ");
                String nim = nimS.nextLine();
                System.out.print("Masukkan nama asisten: ");
                Scanner namaS = new Scanner(System.in);
                String nama = namaS.nextLine();
                dp.hapusData(nim, nama);
                dp.tampilMenu();
                break;
            }
            case 7: {
                System.out.println("Masukkan NIM praktikan yang ingin diedit : ");
                Scanner nimS = new Scanner(System.in);
                String nim = nimS.nextLine();
                System.out.println("Masukkan nama asisten yang ingin diedit : ");
                Scanner namaS = new Scanner(System.in);
                String nama = namaS.nextLine();
                dp.editData(nim, nama);
                dp.tampilMenu();
                break;
            }
            case 8: {
                dp.logout();
                break;
            }
            default: {
                System.out.println("Pilihan tidak ada");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();
        dp.login(username,password);

        dp.tampilMenu();
        scanner.close();
    }
}
