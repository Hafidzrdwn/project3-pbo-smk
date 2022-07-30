package project_3_hafidzridwancahya_32;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */
class TiketKeretaApi {
    int kelas, jumlah_penumpang, total_price, uang_bayar, kembalian;
    String ket_bayar;
    Scanner input = new Scanner(System.in);
    
    String toRupiahWithRP(String price) {
        int newPrice = Integer.parseInt(price);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(newPrice);
    }
    
    String getKelasKereta(int kelas) {
        String result;
        switch(kelas){
            case 1:
                result = "EKONOMI";
                break;
            case 2:
                result = "BISNIS";
                break;
            case 3:
                result = "EKSEKUTIF";
                break;
            default:
                result = "";
        }
        
        return result;
    }
    
    void daftar_kelas() {
        System.out.println("Daftar Kelas : ");
        System.out.println("1. Ekonomi(Rp. 15.000)");
        System.out.println("2. Bisnis(Rp. 80.000)");
        System.out.println("3. Eksekutif(Rp. 110.000)");
    }
    
    void inputAwal() {
        System.out.println("\nSistem Tiket Kereta Api Sby - Malang");
        this.daftar_kelas();
        System.out.print("Silahkan pilih kelas(1,2,3) = ");
        this.kelas = this.input.nextInt();
        System.out.print("Masukkan jumlah penumpang = ");
        this.jumlah_penumpang = this.input.nextInt();
    }
    
    int processHarga() {
        int price;
        switch(this.kelas){
            case 1:
                price = 15000;
                break;
            case 2:
                price = 80000;
                break;
            case 3:
                price = 110000;
                break;
            default:
                price = 0;
        }
        this.total_price = price * this.jumlah_penumpang;
        return price;
    }
    
    void outputStruk() {
        System.out.println("\n----------Struk Kereta Api Sby - Malang----------\n");
        System.out.println("Kelas Kereta : "+ this.getKelasKereta(this.kelas));
        System.out.println("Tujuan : Surabaya - Malang");
        System.out.println("Jumlah Penumpang : "+ this.jumlah_penumpang + " orang");
        System.out.println("Harga Tiket : "+ this.toRupiahWithRP(Integer.toString(this.processHarga())));
        System.out.println("Total Harga : " + this.toRupiahWithRP(Integer.toString(this.total_price)));
        System.out.println("\n----------Terimakasih, Silahkan Membayar---------");
        this.inputBayar();
    }
    
    void inputBayar() {
        System.out.print("Masukkan uang anda = ");
        this.uang_bayar = this.input.nextInt();
        this.outputKembalian();
    }
    
    boolean processUang() {
        if(this.uang_bayar >= this.total_price){
            this.kembalian = this.uang_bayar - this.total_price;
            this.ket_bayar = "Selamat, Transaksi Anda Telah Berhasil!!";
            return true;
        }else {
            this.kembalian = 0;
            this.ket_bayar = "Maaf uang anda tidak mencukupi!!";
            return false;
        }
    }
    
    void outputKembalian() {
        System.out.println("\nNominal uang anda : "+ this.toRupiahWithRP(Integer.toString(this.uang_bayar)));
        if(this.processUang()) {
            System.out.println("Uang kembalian : "+ this.toRupiahWithRP(Integer.toString(this.kembalian)));
        } 
        System.out.println("-------------------------------------------------");
        System.out.println(this.ket_bayar);
        while(this.uang_bayar < this.total_price) {
            this.inputBayar();
        }
    }
    
    public static void main(String[] args) {
        TiketKeretaApi ka = new TiketKeretaApi();
        ka.inputAwal();
        ka.processHarga();
        ka.outputStruk();
    }
}
