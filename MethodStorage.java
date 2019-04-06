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
public class MethodStorage {
    /*
    Okumanın daha kolay hale gelmesi için belli bir class altında olması zorunlu
    olmayan bütün methodlarımızı bu classta toplayıp mainde çağırdık. Başka Sınıflardaki
    methodlara erişim gerektiğinde uyarılar yapılarak daha kolay bir okuma sağlamaya
    çalıştık
    */
    
    
    
    
    public static Customer[] musteriArrayDuzenle(Customer[] customerArray,Customer customer) {
        /* Değerlendirme puanlarını aldığımız arrayden çok daha basit bir yapıya
        sahip tek yaptığımız parametre olarak aldığımız müşteriyi diziye 
        yerleştirmek*/
        for(int i= 0; i<customerArray.length;i++){
            if (customerArray[i] == null && customer != null){
                /*Olası hataları önlemek için null değerlere sahip müşterileri
                almıyor ve dolu olan dizi elemanlarını değiştirmiyoruz*/
            customerArray[i] = customer;
            break;/*Dizide bir eleman atandıktan sonra durdurduk ki sürekli
            kendini tekrar edip istemediğimiz yerlere müşteri ataması yapmsın*/
             
            }
        
        }
        return customerArray;
    }
    
    
    
    public static Customer musteriOlustur(String ex,String ilkToken) {
     
        
        Customer customer = null;
        /*İlk olarak fonksiyonumuzun ulusal müşteri mi yoksa uluslar arası 
        müşteri mi üreteceğine karar vermesini sağlıyoruz.
        Bu kısımda polymorphism kullanarak modülerliği arttırmayı planladık.*/
        if (ilkToken.equalsIgnoreCase("n")){
        
        customer = NationalCustomer.musteriOlustur(ex);/*Methodun içeriği 
        NationalCustomer sınıfında bulunmaktadır
        */
        
            
        }
        else if (ilkToken.equalsIgnoreCase("i")){
        
          customer = InternationalCustomer.musteriOlustur(ex);/*Methodun içeriği 
        NationalCustomer sınıfında bulunmaktadır
        */
                
                
                }
        /*Customer tipinde aldığımız objeyi fonksiyon içerisinde NationalCustomer
        veya İnternationalCustomer tipine dönüştürüp return ediyoruz
        */
       return customer;
    } 
    
    public static void klavyedenGirilenMusterileriYaz(Customer[] customerArray,int baslangic){
    for (int i = baslangic;i<customerArray.length;i++){
        if(customerArray[i] != null){
        System.out.println(customerArray[i]);
        }
    }
    
    
    }
    
    /* puanları toplu almak için ek dizi kullanmamız gerekeceğinden her bir 
    token'ı puana dönüştüren bir lise yazıp arrayOlusturma listemizde çağırdık*/
    public static int puanAl(String token){
        int puan = Integer.valueOf(token);
        return puan;
    }
    
    public static int satirSay(int count){
    count++;
    return count;
    }
    
    public static int[][] ratingsArrayOlustur(int[][] ratingsArray,String ex,int count){
    EnhancedStringTokenizer puanDizisi = new EnhancedStringTokenizer(ex,",");
    /*method içerisinden dosyadan yeni satır okumak için Scanner'a ihtiyaç 
    duyacağımız için count sistemi koyarak main metodunda bu metodun çalışmasını
    saydırdık. Method her çalışmasında count satrını doldurup çıkış yapıyor 
    böylece method içerisine bir de scanner'ı karıştırmadan listeyi hatasız
    doldurmayı başardık*/
        for (int x=count; x<ratingsArray.length;x++) {
            for (int y = 0; y < ratingsArray[x].length; y++) {
                
                String token = puanDizisi.nextToken();
                int puan=puanAl(token);
                if (ratingsArray[x][y]== 0){
                ratingsArray[x][y] = puan;
                
                }
            }
            break;
        }
    
        return ratingsArray;
    }
    public static int ortalamaDerecelendirmePuaniBul(int [][] dizi,int urunNumarasi){
        /*
        her bir ürün için tek fonksiyon kullanmak adına kaçıncı ürünü istediğimizi
        de parametre olarak aldık
        */
        int urunSayisi=0,toplam=0,sonOrtalamaPuan;
        
        for(int[] dizi1:dizi){
            if(dizi1[urunNumarasi]== 0){
            break;
            }
            else{
            toplam +=dizi1[urunNumarasi];
            urunSayisi++;
                    }
            
        }
        double ortalamaPuan = (double) toplam / (double) urunSayisi;
        sonOrtalamaPuan = sayiyiYuvarla(ortalamaPuan);
        return sonOrtalamaPuan;
    } 
  public static int sayiyiYuvarla(double sayi){
  int yuvarlanmisSayi;
  /*Basit bir şekilde sayıyı yuvarlamak için kurulmuş algoritma
  eğer sayının ondalık kısmı 0.5'den küçük ise bir altına
  büyük veya eşitse bir üstüne yuvarlıyor*/
  if ((int) sayi - sayi == 0){
  yuvarlanmisSayi = (int) sayi;
  }
  else if((int) sayi +1 - sayi > 0.5){
            yuvarlanmisSayi = (int)sayi;
        }
        else{
        yuvarlanmisSayi = (int) sayi+1;
        }
  return yuvarlanmisSayi;
  }
  
  public static void urunPuanlariniYazdir(int[][] dizi,int toplamUrunSayisi){
  
      for(int i=0; i<toplamUrunSayisi;i++){
          System.out.println((i+1)+". ürün için ortalama derecelendirme puanı: "+
                  ortalamaDerecelendirmePuaniBul(dizi,i));   
      }
  
  }
  
  public static int[][] nationalCustomerPuanlari(Customer[] customerArray,
    int[][] ratingsArray,int toplamUrunSayisi){
    int [][] nationalCustomerRatings = new int [200][toplamUrunSayisi];
    int customerCounter=0;
    int nationalCustomerCounter=0;
        for (Customer dizi : customerArray) {
            if(dizi==null) break;
            else if (ulusalMusteriMi(dizi)) {
           
            nationalCustomerRatings[nationalCustomerCounter] = ratingsArray[customerCounter];
              
                nationalCustomerCounter++;
                customerCounter++;
            }
            else customerCounter++; 

            
            
        }
        return nationalCustomerRatings;
  }
  
  public static int[][] interNationalCustomerPuanlari(Customer[] customerArray,
    int[][] ratingsArray,int toplamUrunSayisi){
    int [][] interNationalCustomerRatings = new int [200][toplamUrunSayisi];
    int customerCounter=0;
    int interNationalCustomerCounter=0;
        for (Customer dizi : customerArray) {
            if(dizi==null) break;
            else if (uluslararasiMusteriMi(dizi)) {
           
            interNationalCustomerRatings[interNationalCustomerCounter] = ratingsArray[customerCounter];
              
                interNationalCustomerCounter++;
                customerCounter++;
            }
            else customerCounter++; 

            
            
        }
        return interNationalCustomerRatings;
  }
  
  public static int[][] doctorCustomerPuanlari(Customer[] customerArray,
    int[][] ratingsArray,int toplamUrunSayisi){
    int [][] nationalCustomerRatings = new int [200][toplamUrunSayisi];
    int customerCounter=0;
    int nationalCustomerCounter=0;
    NationalCustomer musteri = new NationalCustomer();
        for (Customer dizi : customerArray) {
            if(ulusalMusteriMi(dizi)){
            musteri = (NationalCustomer) dizi;}
            if (dizi == null) {
                break;
            } else if (dizi instanceof NationalCustomer && musteri.getOccupation().equalsIgnoreCase("doktor")) {
                nationalCustomerRatings[nationalCustomerCounter] = ratingsArray[customerCounter];
                
                nationalCustomerCounter++;
                customerCounter++;
            } else {
                customerCounter++;
            }
        }
        return nationalCustomerRatings;
  }
  public static void ortalamanınAltindakiUlusalMusterilerinPuanlari(Customer[] customerDizi,
          int[][] ratingDizi,int urunNumarasi)
          
  {
      int i = 0;
      int urununOrtalamaPuani = ortalamaDerecelendirmePuaniBul(ratingDizi,urunNumarasi);
  for (Customer c: customerDizi){
      if(ulusalMusteriMi(c)&& 
        ratingDizi[i][urunNumarasi]<urununOrtalamaPuani){
          System.out.println(c.getName()+" "+c.getSurname()+" "+(urunNumarasi+1)+
                  " Numaralı ürüne ortalamanın altında puan vermiştir." +"\n"
                        +"Puanı:"+ratingDizi [i][urunNumarasi]+
                        "\n"+"Urunun ortalama puanı: "+ urununOrtalamaPuani );
      }
  
  }
  }
  
  public static void ortalamanınAltindakiUluslararasiMusterilerinPuanlari(Customer[] customerDizi,
          int[][] ratingDizi,int urunNumarasi)
          
  {
      int i = 0;
      int urununOrtalamaPuani = ortalamaDerecelendirmePuaniBul(ratingDizi,urunNumarasi);
  for (Customer c: customerDizi){
      if(uluslararasiMusteriMi(c)&& 
        ratingDizi[i][urunNumarasi]<urununOrtalamaPuani){
          System.out.println(c.getName()+" "+c.getSurname()+" "+(urunNumarasi+1)+
                  " Numaralı ürüne ortalamanın altında puan vermiştir." +"\n"
                        +"Puanı:"+ratingDizi [i][urunNumarasi]+
                        "\n"+"Urunun ortalama puanı: "+ urununOrtalamaPuani );
      }
  
  }
  }
  
 
  
  public static boolean ulusalMusteriMi(Customer c){
  if(c instanceof NationalCustomer) return true;
  else return false;
  }
  public static boolean uluslararasiMusteriMi(Customer c){
  if(c instanceof InternationalCustomer) return true;
  else return false;
  }
  
 /*Tahmin algoritması için yazılan methodlar*/
  
  public static int[] yakinlikDereceleriniBul(int[][] ratingsArray,
          int[] musteriPuanlari,int musteriSayisi){
 
  int[] yakinlikDizisi = new int[musteriSayisi];
  for(int satir = 0; satir<musteriSayisi;satir++){
      int toplamYakinlik=0;
      for(int sutun = 0; sutun<ratingsArray[satir].length;sutun++){
          int yakinlik = musteriPuanlari[sutun]-ratingsArray[satir][sutun];
          yakinlik = Math.abs(yakinlik);
          toplamYakinlik += yakinlik;
      }
      yakinlikDizisi[satir] = toplamYakinlik;
  }
  return yakinlikDizisi;
  }
  public static int dizininEnkucugunuBul(int[] dizi){
  int min = 99;
  for(int i: dizi){
  if(i<=min) min = i;
  }
  return min;
  }
  
public static int[] enYakinMusteriyiBul(int min,int[] yakinlikDizisi,int musteriSayisi){
int[] musteriIndex = new int[musteriSayisi+1];
int k = 0;
for (int i = 0 ; i< yakinlikDizisi.length;i++){
if(yakinlikDizisi[i] == min)
{
    musteriIndex[k]=i;
    k++;           
}
}
musteriIndex[musteriSayisi] = k;
return musteriIndex;
}

public static int sonPuanHesapla(int[] musteriIndex,int[][] ratingsArray,
        int urunSayisi){
double sonPuan;
int yuvarlanmisSonPuan;
int araToplam= 0;
for(int i = 0; i<musteriIndex[musteriIndex.length-1];i++){
araToplam += ratingsArray[musteriIndex[i]][urunSayisi-1];
}
sonPuan = (double) araToplam / (double) musteriIndex[musteriIndex.length-1];
yuvarlanmisSonPuan = sayiyiYuvarla(sonPuan);

return yuvarlanmisSonPuan;
}

public static int[][] klavyedenGirilenleriArrayeAt(int[][] ratingsArray,
                                                    int[] klavye,int dosya)
{
    
    for(int k = 0; k<ratingsArray[k].length;k++)
        ratingsArray[dosya][k]=klavye[k];
return ratingsArray;
}

/*Klavyeden girilen müşterilerin ortalama puanları*/


public static int  klavyedenGirilenPuanOrtalaması(int [][] dizi,int urunNumarasi
                                             ,int dosyadanOkunan){
        
        int urunSayisi=0,toplam=0,sonOrtalamaPuan;
        
        for(int i = dosyadanOkunan ; i<dizi.length;i++ ){
            if(dizi[i][urunNumarasi]== 0){
            break;
            }
            else{
            toplam +=dizi[i][urunNumarasi];
            urunSayisi++;
                    }
            
        }
        double ortalamaPuan = (double) toplam / (double) urunSayisi;
        sonOrtalamaPuan = sayiyiYuvarla(ortalamaPuan);
        return sonOrtalamaPuan;
    } 
  public static void klavyedenGirilenPuanlariYazdir(int[][] dizi,int dosya
                                                    ,int toplamUrunSayisi){
  
      for(int i=0; i<toplamUrunSayisi;i++){
          System.out.println((i+1)+". ürün için ortalama derecelendirme puanı: "+
                  klavyedenGirilenPuanOrtalaması(dizi,i,dosya));   
      }
  
  }
}
