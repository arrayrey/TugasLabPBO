import java.util.*;
/**
 * Class TestBus adalah class utama yang akan mensimulasikan program bus trans koetaradja
 * dimana akan diciptakan sebuah objek bus
 *
 * @author Raihan Karuna,Yuslinar
 * @version 21-11-2021
 */
public class TestBus {
    
    /**
     * Method static void main akan menyimulasikan program
     * setiap program dijalankan akan disediakan menu yang akan dipilih user
     */
    public static void main(String[] args) {
        String pilihan;
        boolean run = true;
        Scanner input = new Scanner(System.in);
        Bus bus = new Bus();
          
            while(run ==true){
            
                System.out.println("\n~~~~~~~~~~~~~~ SISTEM PENGELOLA BUS TRANSKOETARADJA ~~~~~~~~~~~~~~~");
                System.out.println("MENU : ");
                System.out.println("1. Naikkan Penumpang");
                System.out.println("2. Turunkan Penumpang");
                System.out.println("3. Informasi Bus");
                System.out.println("4. Layanan Saldo");
                System.out.println("5. Keluar");
                System.out.print("Masukkan pilihan : ");
            
                pilihan = input.next();
            
                try{
                
                        switch(pilihan){ 
                
                           case "1" :                     
                            System.out.print("\nMasukkan nama : ");
                            String nama = input.next();                      
                                try{
                                    System.out.print("Masukkan umur : ");
                                    int umur = input.nextInt();
                                    if(umur<=0){
                                        throw new Exception();
                                    }
                                    System.out.print("Apakah anda Hamil ? (yes/no) : ");
                                    boolean hamil = new Scanner(System.in).nextLine().equalsIgnoreCase("yes")?true:false;

                                    Penumpang penumpang = new Penumpang(nama, umur, hamil);
                                    bus.naikPenumpang(penumpang);
                                    bus.toString();
                                    System.out.println("");
                                    System.out.println("======================================================================");
                                } catch (Exception ex){
                                    System.out.println("Input umur tidak boleh negatif atau nol");
                                }                
                                break;
                
                          case "2": 
                                System.out.print("\nMasukan nama penumpang: ");
                                nama = input.next();
                                bus.turunkanPenumpang(nama);
                                bus.toString();
                                System.out.println("======================================================================");
                                System.out.println("");
                                break;
                    
                          case "3":
                                bus.toString(); 
                                System.out.println("Total pendapatan bus sebesar "+bus.getPendapatanBus());
                                System.out.println("=========================================================================");
                                System.out.println("");
                                break;    
                
                          case "4" :
                                System.out.println("\t1. Lihat Saldo");
                                System.out.println("\t2. Tambah Saldo");
                                System.out.print("\t    Masukkan pilihan : ");
                                pilihan = input.next();
                                    switch(pilihan){
                                        case "1" :
                                            System.out.print("\n\tMasukan nama : ");
                                            nama = input.next(); 
                                            bus.getSaldoPenumpang(nama);
                                            break;
                                        case "2" :
                                            System.out.print("Masukan nama : ");
                                            nama = input.next();
                                            try{
                                                System.out.print("Masukan nominal : ");
                                                int nominal = input.nextInt();
                                                    if (nominal <= 0){
                                                        throw new Exception();
                                                    }
                                                    bus.TambahSaldoPenumpang(nama, nominal);
                                                } catch(Exception e){
                                                    System.out.println("Input nominal tidak boleh negatif atau nol");
                                                }
                                                break;
                                        default :
                                            System.out.println("Pilihan tidak tersedia!");
                                     }
                                     break;
                    
                         case "5" :
                            run = false;
                            break;
                 
                         default:
                            System.out.println("Pilihan tidak tersedia, silahkan input ulang!");
                            break;
                     }
                }
                catch (InputMismatchException e){
                    System.out.println("Terjadi kesalahan pada : "+e);
                }
            
       
        }
        
    }
}
        

       
    
