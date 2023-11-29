/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan8;

/**
 *
 * @author naufa
 */
import java.util.Scanner;
public class toserba1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi data barang
        String[] kodeBarang = {"a001", "a002", "a003", "a004", "a005", "a006", "a007", "a008", "a009", "a010"};
        String[] namaBarang = {"Buku", "Pensil", "Pulpen", "Penghapus", "Penggaris", "Jangka", "Busur", "Serutan", "Pensil Warna", "Kanvas"};
        int[] hargaBarang = {5000, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};

        // Input data transaksi
        
        System.out.println("TOKO SERBA ADA");
        System.out.println("**************");
        System.out.print("Masukkan jumlah barang yang akan dibeli: ");
        int jumlahBarang = input.nextInt();

        // Inisialisasi array untuk menyimpan data transaksi
        int[] jumlahBeli = new int[jumlahBarang];
        String[] kodeBeli = new String[jumlahBarang];

        // Input data transaksi
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("Data Barang ke-" + (i + 1));
            System.out.print("Masukkan Kode Barang (a001 - a010): ");
            kodeBeli[i] = input.next();

            // Validasi kode barang
            if (!isValidKodeBarang(kodeBeli[i], kodeBarang)) {
                System.out.println("Kode Barang tidak valid. Silakan masukkan kembali.");
                i--; // Mengulang input data barang yang tidak valid
                continue;
            }

            System.out.print("Masukkan Jumlah Beli: ");
            jumlahBeli[i] = input.nextInt();
        }

        System.out.println("\nTOKO SERBA ADA");
        System.out.println("**************");
        // Output data transaksi
        
        System.out.println("No\tKode Barang\tNama Barang\tHarga\tJumlah Beli\tJumlah Bayar\tTotal Bayar");
        System.out.println("===============================================================================================");
        int totalBayar = 0;
        for (int i = 0; i < jumlahBarang; i++) {
            int indexBarang = getIndexBarang(kodeBeli[i], kodeBarang);
            int harga = hargaBarang[indexBarang];
            int jumlahBayar = harga * jumlahBeli[i];
            totalBayar += jumlahBayar;

            System.out.println((i + 1) + "\t" + kodeBeli[i] + "\t\t" + namaBarang[indexBarang] + "\t\t" +
                    harga + "\t" + jumlahBeli[i] + "\t\t" + jumlahBayar + "\t\t" + totalBayar);
        }

        // Menampilkan total pembayaran
        System.out.println("===============================================================================================");
        System.out.println("Total Pembayaran:                                                                   " + totalBayar);
        System.out.println("===============================================================================================");

        // Menutup scanner
        input.close();
    }

    // Method untuk validasi kode barang
    private static boolean isValidKodeBarang(String kode, String[] kodeBarang) {
        for (String kodeValid : kodeBarang) {
            if (kodeValid.equals(kode)) {
                return true;
            }
        }
        return false;
    }

    // Method untuk mendapatkan index barang berdasarkan kode barang
    private static int getIndexBarang(String kode, String[] kodeBarang) {
        for (int i = 0; i < kodeBarang.length; i++) {
            if (kodeBarang[i].equals(kode)) {
                return i;
            }
        }
        return -1; // Kode barang tidak ditemukan
    }
}
