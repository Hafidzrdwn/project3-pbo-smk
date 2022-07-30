package project_3_hafidzridwancahya_32;

import java.util.Scanner;

/**
 *
 * @author Hafidz Ridwan
 */
public class NilaiAkhir {
    double nilai_tugas, nilai_uts, nilai_uas, nilai_akhir;
    String keterangan, grade;
    Scanner input = new Scanner(System.in);
    
    void inputNilai() {
        System.out.println("\n\nPerhitungan Nilai Akhir");
        System.out.println("-----------------------");
        System.out.print("Masukkan nilai tugas = ");
        this.nilai_tugas = input.nextDouble();
        System.out.print("Masukkan nilai UTS = ");
        this.nilai_uts = input.nextDouble();
        System.out.print("Masukkan nilai UAS = ");
        this.nilai_uas = input.nextDouble();
    }
    
    double getNilaiAkhir() {
        this.nilai_akhir = (0.3 * this.nilai_tugas) + (0.3 * this.nilai_uts) + (0.4 * this.nilai_uas);
        return this.nilai_akhir;
    }
    
    void process() {
        this.keterangan = (this.getNilaiAkhir() >= 75) ? "LULUS" : "TIDAK LULUS";
        
        double na = this.getNilaiAkhir();
        if(na >= 86 && na <= 100){
            this.grade = "A";
        } else if(na >= 76 && na <= 85) {
            this.grade = "B";
        } else if(na >= 65 && na <= 75) {
            this.grade = "C";
        } else {
            this.grade = "D";
        }
    }
    
    void output() {
        System.out.println("\n---------- Hasil ----------");
        System.out.println("Nilai Akhir : "+ this.getNilaiAkhir());
        System.out.println("Grade : "+ this.grade);
        System.out.println("Keterangan : "+ this.keterangan);
        System.out.println("---------------------------\n\n");
    }
    
    
    public static void main(String[] args) {
        NilaiAkhir nilai = new NilaiAkhir();
        nilai.inputNilai();
        nilai.process();
        nilai.output();
    }
}
