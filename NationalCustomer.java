/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05160000241_05160000163;

/**
 *
 * @author Göksenin
 */
public class NationalCustomer extends Customer {
    
    private int LicancePlateNumber;
    private String Occupation;

    public NationalCustomer() {
        super();
        this.LicancePlateNumber = 0;
        this.Occupation = "No Occupation";
    }

    public NationalCustomer(int CustomerID,String Name,String Surname,
            int LicancePlateNumber, String Occupation) {
        super(CustomerID,Name,Surname);
        this.LicancePlateNumber = LicancePlateNumber;
        this.Occupation = Occupation;
    }
    
    public NationalCustomer (NationalCustomer original){
        super(original.getCustomerID(),original.getName(),original.getSurname());
        this.LicancePlateNumber = original.LicancePlateNumber;
        this.Occupation = original.Occupation;
        
        
    }

    /**
     * @return the LicancePlateNumber
     */
    public int getLicancePlateNumber() {
        return LicancePlateNumber;
    }

    /**
     * @param LicancePlateNumber the LicancePlateNumber to set
     */
    public void setLicancePlateNumber(int LicancePlateNumber) {
        this.LicancePlateNumber = LicancePlateNumber;
    }

    /**
     * @return the Occupation
     */
    public String getOccupation() {
        return Occupation;
    }

    /**
     * @param Occupation the Occupation to set
     */
    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }
    
    @Override
    public String toString(){
      return  "Müşterinin numarası: "+getCustomerID()+" Müşterinin adı: "+ getName()+
              " "+ getSurname()+" ||Müşterinin plaka kodu: "+this.getLicancePlateNumber()+
              " ||Müşterinin Mesleği: "+this.getOccupation();
        
    }
    
    
    public static NationalCustomer musteriOlustur(String ex){
        EnhancedStringTokenizer str = new EnhancedStringTokenizer(ex,",");
        str.nextToken();
        /*Düzenli bir dosyamız olduğu için basit bir sistem ile yalnızca 
       nextToken() metodundan yeni token alarak müşteri bilgilerini çektik*/
    int musteriID = Integer.valueOf(str.nextToken());
    String ad = str.nextToken();
    String soyad= str.nextToken();
    int plaka = Integer.valueOf(str.nextToken());
    String meslek = str.nextToken();
    
    NationalCustomer musteri = new NationalCustomer(musteriID,ad,soyad,plaka,meslek);
    
    return musteri;
    
    
    }
    
    
    
}
