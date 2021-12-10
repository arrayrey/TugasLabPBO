import java.util.Scanner;
import java.util.ArrayList;
/** 
 * Class Bus adalah class yang mewakili bus yang ditumpangi oleh penumpang
 * dimana hanya memuat 40 kursi penumpang
 *
 * @author Raihan Karuna, Yuslinar
 * @version 21-11-2021
 */
public class Bus
{
    private ArrayList<Penumpang> penumpangBiasa;
    private ArrayList<Penumpang> penumpangPrioritas;
    private ArrayList<Penumpang> penumpangBerdiri;
    private ArrayList<Penumpang> dataPenumpang;
    private static final int ongkosBus = 2000;
    private int totalPendapatanBus;
    
    /**
     * method constructor bus akan menciptakan array objek bus serta tempat duduk penumpang bagi setiap kategorinya
     */
    public Bus()
    {
      penumpangBiasa = new ArrayList<>();
      penumpangPrioritas = new ArrayList<>();
      penumpangBerdiri = new ArrayList<>();
      dataPenumpang = new ArrayList<>(); 
      totalPendapatanBus = 0;
    }
    
    /**
     * @return penumpangBiasa
     * method accessor ini akan mengembalikan penumpang biasa
     */
    public ArrayList<Penumpang> getPenumpangBiasa()
    {
        return penumpangBiasa;
    }
    
    /**
     * @return penumpangPrioritas
     * method accessor ini akan mengembalikan penumpang prioritas
     */
    public ArrayList<Penumpang> getPenumpangPrioritas()
    {
        return penumpangPrioritas;
    }
    
    /**
     * @return penumpangBerdiri
     * method accessor ini akan mengembalikan penumpang berdiri
     */
    public ArrayList<Penumpang> getPenumpangBerdiri()
    {
        return penumpangBerdiri;
    }
    
    /**
     * @return dataPenumpang
     * method accessor ini akan mengembalikan data-data penumpang yang sudah pernah naik bus
     */
    public ArrayList<Penumpang> dataPenumpang()
    {
        return dataPenumpang();
    }
    
    /**
     * @return penumpangBiasa.size()
     * method accessor ini akan mengembalikan berapa banyak penumpang biasa
     */
    public int getJumlahPenumpangBiasa()
    {
        return penumpangBiasa.size();
    }
    
    /**
     * @return penumpangPrioritas.size();
     * method accessor ini akan mengembalikan berapa banyak penumpang prioritas
     */
    public int getJumlahPenumpangPrioritas()
    {
        return penumpangPrioritas.size();
    }
    
    /**
     * @return penumpangBerdiri.size();
     * method accessor ini akan mengembalikan berapa banyak penumpang berdiri
     */
    public int getJumlahPenumpangBerdiri()
    {
        return penumpangBerdiri.size();
    }
    
    /**
     * @return penumpangDataPenumpang.size();
     * method accessor ini akan mengembalikan berapa banyak penumpang yang pernah naik bus
     */
    public int getJumlahDataPenumpang()
    {
        return dataPenumpang.size();
    }
    
    /**
     * @return boolean
     * method ini akan menentukan penumpang berhasil naik atau tidak
     */
    public boolean naikPenumpang (Penumpang penumpang){
        int temp =  penumpangBiasa.size()+penumpangPrioritas.size()+penumpangBerdiri.size();
        int a = 0;
        String nama = penumpang.getNama();
        for (int i = 0; i < dataPenumpang.size(); i ++) {  
          if(nama.equals(dataPenumpang.get(i).getNama())){
            for ( int j = 0; j < penumpangBiasa.size(); j ++) {  
                if(nama.equals(penumpangBiasa.get(j).getNama())){
                    System.out.println("Nama penumpang sudah terdaftar didalam bus, inputkan nama berbeda");
                    a=1;
                } 
            }
           
            for (int k = 0; k < penumpangPrioritas.size(); k ++) {  
                if(nama.equals(penumpangPrioritas.get(k).getNama())){
                    System.out.println("Nama penumpang sudah terdaftar didalam bus, inputkan nama berbeda");
                    a=1;
                }
            }
       
            for (int l = 0; l < penumpangBerdiri.size(); l++) {  
                if(nama.equals(penumpangPrioritas.get(l).getNama())){
                    System.out.println("Nama penumpang sudah terdaftar didalam bus, inputkan nama berbeda");
                    a=1;
                }
            }
                
            if (a != 1){
                
                if((getJumlahPenumpangPrioritas() < 4) && ((penumpang.getUmur()<10) || (penumpang.getUmur() > 60) || (penumpang.getHamil()==true)) && (penumpang.getSaldo() >= 2000) ){
                   System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <BERHASIL> ditambahkan!");
                   penumpangPrioritas.add(penumpang);
                   dataPenumpang.get(i).kurangiSaldo(ongkosBus); 
                   totalPendapatanBus += ongkosBus;
                   return true;
                }
                else if(getJumlahPenumpangBiasa() < 16 && (penumpang.getSaldo() >= 2000) ){
                    System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <BERHASIL> ditambahkan!");
                    penumpangBiasa.add(penumpang);
                    dataPenumpang.get(i).kurangiSaldo(ongkosBus);
                    totalPendapatanBus += ongkosBus;
                    return true;
                }
                else if(getJumlahPenumpangBerdiri() < 20 && (penumpang.getSaldo() >= 2000) ){
                    System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <BERHASIL> ditambahkan!");
                    penumpangBiasa.add(penumpang);
                    dataPenumpang.get(i).kurangiSaldo(ongkosBus);
                    totalPendapatanBus += ongkosBus;
                    return true;
                }
                else{
                    System.out.print("\n==> Penumpang bernama " +penumpang.getNama()+ " <GAGAL> ditambahkan!");
                    System.out.println("<Tidak Ada Kursi Kosong!>");
                    System.out.println("");
                    return false;
                } 
              }
           }
         }
            int tump =  penumpangBiasa.size()+penumpangPrioritas.size()+penumpangBerdiri.size();
          
            if(((getJumlahPenumpangPrioritas() < 4) && ((penumpang.getUmur()<10) || (penumpang.getUmur() > 60) || (penumpang.getHamil()==true)) && (penumpang.getSaldo() >= 2000)) && (a!=1)){
                System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <BERHASIL> ditambahkan!");
                penumpangPrioritas.add(penumpang);
                dataPenumpang.add(penumpang);
                penumpang.kurangiSaldo(ongkosBus);    
                totalPendapatanBus += ongkosBus;
                return true;
            }
            else if((getJumlahPenumpangBiasa() < 16) && (penumpang.getSaldo() >= 2000) && (a!=1) ){
                System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <BERHASIL> ditambahkan!");
                penumpangBiasa.add(penumpang);
                dataPenumpang.add(penumpang);
                penumpang.kurangiSaldo(ongkosBus);
                totalPendapatanBus += ongkosBus;
                return true;
            }
            else if((getJumlahPenumpangBerdiri() < 20) && (penumpang.getSaldo() >= 2000) && (a!=1) ){
                System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <BERHASIL> ditambahkan!");
                penumpangBerdiri.add(penumpang);
                dataPenumpang.add(penumpang);
                penumpang.kurangiSaldo(ongkosBus);
                totalPendapatanBus += ongkosBus;
                return true;
            }
            else if (a!=1){
                System.out.println("\n==> Penumpang bernama "+penumpang.getNama()+" <GAGAL> ditambahkan!");
                System.out.println("<Tidak Ada Kursi Kosong!>");
                System.out.println("");
                return false;
            }
            else{
                return false;
            }
        
    }
    
    /**
     * @return boolean
     * method ini akan menentukan penumpang berhasil turun atau tidak
     */
    public boolean turunkanPenumpang(String nama){
       int a = penumpangBiasa.size()+penumpangPrioritas.size()+penumpangBerdiri.size(); 
       for (int i = 0; i < penumpangBiasa.size(); i ++) {  
           if(nama.equals(penumpangBiasa.get(i).getNama())){
              penumpangBiasa.remove(i);
              System.out.println("Penumpang bernama "+nama+" telah diturunkan!");
           } 
       }
           
       for (int i = 0; i < penumpangPrioritas.size(); i ++) {  
            if(nama.equals(penumpangPrioritas.get(i).getNama())){
              penumpangPrioritas.remove(i);
              System.out.println("Penumpang bernama "+nama+" telah diturunkan");
            }
       }
       
       for (int i = 0; i < penumpangBerdiri.size(); i ++) {  
            if(nama.equals(penumpangPrioritas.get(i).getNama())){
              penumpangPrioritas.remove(i);
              System.out.println("Penumpang bernama "+nama+" telah diturunkan");
            }
        }
        
       if (a == (penumpangBiasa.size()+penumpangPrioritas.size()+penumpangBerdiri.size())){
            System.out.println("Penumpang tidak ditemukan"); 
       }
     
       if (a > (penumpangBiasa.size()+penumpangPrioritas.size()+penumpangBerdiri.size())){
            return true;
       }
       else {
           return false;
       }
    }

     
    
    /**
     * @return String
     * method ini akan mengembalikan list penumpang 
     */
    public String toString(){
           String daftar1 = "  ";
           String daftar2 = "  ";
           String daftar3 = "  ";
           int i=0, j=0, k=0;
           
            for(Penumpang p : penumpangBiasa) {
               daftar1 += p.getNama().toString();
               if (i<(penumpangBiasa.size()-1) ){
                 daftar1 += ", "; 
                }
                else {
                  daftar1 += " "; 
                }
                
                i++;
            }
            
            for(Penumpang p : penumpangPrioritas) {
               daftar2 += p.getNama().toString();
               if (j<(penumpangPrioritas.size()-1) ){
                 daftar2 += ", "; 
                }
                else {
                  daftar2 += " "; 
                }
                
                j++;
            }
            
            for(Penumpang p : penumpangBerdiri) {
               daftar2 += p.getNama().toString();
               if (k<(penumpangBerdiri.size()-1) ){
                 daftar3 += ", "; 
                }
                else {
                  daftar3 += " "; 
                }
                
                k++;
            }
            
            if(penumpangBiasa.isEmpty() == true ){  
              System.out.println("\nDaftar nama penumpang Biasa : <kosong>") ;
            }else{
              System.out.println("\nDaftar nama penumpang biasa : " +daftar1);
            }
            
            if(penumpangPrioritas.isEmpty() == true ){  
              System.out.println("Daftar nama penumpang prioritas : <kosong>") ;
            }else{
              System.out.println("Daftar nama penumpang prioritas : " +daftar2);
            }
            
            if(penumpangBerdiri.isEmpty() == true ){  
              System.out.println("Daftar nama penumpang berdiri : <kosong>") ;
            }else{
              System.out.println("Daftar nama penumpang berdiri : " +daftar2);
            }
          
           System.out.println("Jumlah semua penumpang : " +(penumpangBiasa.size()+penumpangPrioritas.size()+penumpangBerdiri.size()));
           
          return "\nDaftar nama penumpang biasa :"+daftar1+"daftar nama penumpang prioritas :"+daftar2+"daftar nama penumpang berdiri :"+daftar3+
          "jumlah1 semua penumpang : "+(penumpangBiasa.size()+penumpangPrioritas.size())+"\n";
    }
    
    /**
     * @return int
     * method ini akan mengembalikan total pendapatan bus 
     */
    public int getPendapatanBus(){
        return totalPendapatanBus;
    }
    
    /**
     * 
     * method ini akan menambah saldo penumpang dengan parameter nama dan nominal
     */
    public void TambahSaldoPenumpang(String nama, int nominal){
        String keterangan = "";
            for (int i = 0; i < dataPenumpang.size(); i ++) {  
                if(nama.equals(dataPenumpang.get(i).getNama())){
                    dataPenumpang.get(i).tambahSaldo(nominal);
                    keterangan = "Saldo berhasil ditambahkan"; 
                    System.out.println(keterangan);
                } else{ 
                    continue;
                }
            }
            
            if (keterangan == ""){
            System.out.println("Penumpang belum terdaftar");
        }
    }
    
    /**
     * @return int
     * method ini akan mengembalikan nilai saldo dari penumpang dengan param 
     */
    public int getSaldoPenumpang(String nama){
        int uang = 0;
        String keterangan = "";
        for (int i = 0; i < dataPenumpang.size(); i ++) {  
           if(nama.equals(dataPenumpang.get(i).getNama())){
              uang = dataPenumpang.get(i).getSaldo();
              keterangan = "Saldo "+nama+" sebesar "+uang;
              System.out.println(keterangan);
           } else{ 
            continue;
          }
        }
      
        if (keterangan == ""){
            System.out.println("Penumpang belum terdaftar");
        }
       return uang;
    }

}