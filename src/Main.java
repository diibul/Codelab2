import java.util.Scanner;

class Mahasiswa {
    public String nama;
    public String nim; // Menggunakan String untuk NIM agar dapat memeriksa panjangnya
    public String jurusan;

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    // Method untuk menampilkan detail mahasiswa
    public String tampilDataMahasiswa() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nJurusan: " + jurusan;
    }

    // Method untuk menampilkan nama universitas (static method)
    public static String tampilUniversitas() {
        return "Universitas ABC";
    }
}

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[10]; // misalnya maksimal 10 mahasiswa
        int pilihan;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampil Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahMahasiswa(daftarMahasiswa, scanner);
                    break;
                case 2:
                    tampilDataMahasiswa(daftarMahasiswa);
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
        scanner.close();
    }

    public static void tambahMahasiswa(Mahasiswa[] daftarMahasiswa, Scanner scanner) {
        scanner.nextLine(); // consume newline
        System.out.println("Masukkan data mahasiswa:");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM (15 angka): ");
        String nim = scanner.nextLine();

        // cek panjang NIM
        if (nim.length() != 15) {
            System.out.println("Panjang NIM harus 15 angka.");
            return;
        }

        System.out.print("Jurusan: ");
        String jurusan = scanner.nextLine();

        // tambahkan mahasiswa ke array
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] == null) {
                daftarMahasiswa[i] = new Mahasiswa(nama, nim, jurusan);
                System.out.println("Mahasiswa berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Kapasitas mahasiswa penuh.");
    }

    public static void tampilDataMahasiswa(Mahasiswa[] daftarMahasiswa) {
        System.out.println("=== Data Mahasiswa ===");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa != null) {
                System.out.println(mahasiswa.tampilDataMahasiswa());
                System.out.println("Universitas: " + Mahasiswa.tampilUniversitas());
                System.out.println("======================");
            }
        }
    }
}