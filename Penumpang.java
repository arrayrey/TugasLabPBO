/**
 * Ini adalah class Penumpang yang akan mewakili satu object dari penumpang
 *
 * @author Raihan Karuna, Yuslinar
 * @version 21-11-2021
 */
public class Penumpang
{
   // atribut yang dibutukan nama, umur dan status hamil dan saldo
    private String nama;
    private int umur;
    private boolean hamil;
    private int saldo;
    
    /**
     * Ini adalah method constructor dengan parameter yang akan memberikan nilai awal 
     * dimana nama, umur dan status hamil akan diinputkan oleh user
     */
    public Penumpang(String nama, int umur, boolean hamil)
    {
        this.nama = nama;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;
    }
    
    /**
     * @return nama
     * Ini adalah method accessor yang akan mengembalikan nama penumpang
     */
    public String getNama()
    {
        return nama;
    }
    
    /**
     * @return umur
     * Ini adalah method accessor yang akan mengembalikan umur penumpang
     */
    public int getUmur()
    {
        return umur;
    }
    
    /**
     * @return hamil
     * Ini adalah method accessor yang akan mengembalikan status hamil penumpang
     * apakah true atau false
     */
    public boolean getHamil()
    {
        return hamil;
    }
    
    /**
     * @return saldo
     * Ini adalah method accessor yang akan mengembalikan nilai saldo
     */
    public int getSaldo()
    {
        return saldo;
    }
    
    /**
     * 
     * method yang akan menambahkan nilai saldo
     */
    public void tambahSaldo(int saldobaru)
    {
        saldo += saldobaru;
    }
    
    /**
     * 
     * method yang akan mengurangi nilai saldo
     */
    public void kurangiSaldo(int ongkos)
    {
        saldo -= ongkos;
    }
    
}
