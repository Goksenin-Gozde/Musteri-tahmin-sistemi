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
public class InternationalCustomer extends Customer{
    private String Country;
    private String City;

    
    
    
    public InternationalCustomer() {
        super();
        this.Country = "No Country";
        this.City = "No City";
    }

    public InternationalCustomer(int CustomerID, String Name, String Surname,String Country, String City) {
        super(CustomerID, Name, Surname);
        this.Country = Country;
        this.City = City;
    }
    
    public InternationalCustomer (InternationalCustomer original){
    super(original.getCustomerID(),original.getName(),original.getSurname());
    this.Country = original.Country;
    this.City = original.City;
    }

    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    @Override
    public String toString() {
        return "Müşterinin Numarası: "+ getCustomerID()+" Müşterinin Adı: "+getName()+
                "  "+getSurname()+" ||Müşterinin Ülkesi: "+getCountry()+
                " ||Müşterinin Şehri: "+getCity();
    }
    
    
   public static InternationalCustomer musteriOlustur(String ex){
       EnhancedStringTokenizer str = new EnhancedStringTokenizer(ex,",");
       str.nextToken();
       /*Düzenli bir dosyamız olduğu için basit bir sistem ile yalnızca 
       nextToken() metodundan yeni token alarak müşteri bilgilerini çektik*/
    int musteriID = Integer.valueOf(str.nextToken());
    String ad = str.nextToken();
    String soyad= str.nextToken();
    String country = str.nextToken();
    String city = str.nextToken();
    
    InternationalCustomer musteri = new InternationalCustomer(musteriID,ad,soyad,country,city);
    
    return musteri;
    
    }
  
    
    
}
