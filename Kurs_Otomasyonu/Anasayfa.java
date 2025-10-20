package FinalOdevi_22100011932;

//22100011932
//Ceydanur Gezer

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Anasayfa {
	
	public static final String RESET = "\033[0m";  // Sıfırlama (Normal metin)
	public static final String RED = "\u001B[1;38;2;255;0;0m";    // Kırmızı
	public static final String MUSTARD_YELLOW = "\u001B[1;38;2;255;219;88m"; // Açık sarı
	public static final String PINK = "\u001B[1;38;2;255;105;180m"; // Pembe
	public static final String ORANGE = "\u001B[1;38;2;255;140;0m";
	public static final String LIGHT_PURPLE = "\u001B[1;38;2;186;85;211m"; // Mor// Açık mor
	public static final String RIVER_GREEN = "\u001B[1;38;2;0;250;154m";
	public static final String SKY_BLUE = "\u001B[1;38;2;135;206;235m";
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		Scanner veri=new Scanner(System.in);
		ArrayList<Kursiyer> kursiyerler= new ArrayList<Kursiyer>();
		ArrayList<Kurs> kurslar= new ArrayList<Kurs>();
		int kontrol=0,secim,kursiyer_id,yas,kurs_id;
		
		File kursiyer_dosya=new File("kursiyer.txt");
		if(!kursiyer_dosya.exists())
		{
			System.out.println("Dosya bulunamadi!!");
		}
		FileReader fr=new FileReader(kursiyer_dosya);
		BufferedReader br= new BufferedReader(fr);
		String satir,kursiyer_adSoyad,kurs_isim;
		String[] kursiyerdizi;
		String[] kurs_dizi;
		
		Kursiyer kursiyer=null;
		while((satir=br.readLine())!=null)
		{
			if(satir.startsWith("*"))
			{
				kursiyerdizi=satir.substring(1).split("%");
				kursiyer_id=Integer.parseInt(kursiyerdizi[0]);
				kursiyer_adSoyad=kursiyerdizi[1];
				yas=Integer.parseInt(kursiyerdizi[2]);
				kursiyer=new Kursiyer(kursiyer_id,kursiyer_adSoyad,yas,new ArrayList<>());
				kursiyerler.add(kursiyer);
			}
			else if(satir.startsWith("+") && kursiyer != null)
			{
				kurs_dizi=satir.substring(1).split("%");
				kurs_id=Integer.parseInt(kurs_dizi[0]);
				kurs_isim=kurs_dizi[1];
				kursiyer.alinanKurslar.add(new Kurs(kurs_id,kurs_isim));
			}
		}
		
		File kurs_dosya= new File("kurs.txt");
		if(!kurs_dosya.exists())
		{
			System.out.println("Dosya bulunamadi!");
		}
		FileReader Fr=new FileReader(kurs_dosya);
		BufferedReader Br=new BufferedReader(Fr);
		String kurs_satir,kurs_ad;
		int kurslar_id;
		String[] kurslar_dizi;
		while((kurs_satir=Br.readLine())!=null)
		{
			kurslar_dizi=kurs_satir.split("%");
			kurslar_id=Integer.parseInt(kurslar_dizi[0]);
			kurs_ad=kurslar_dizi[1];
			kurslar.add(new Kurs(kurslar_id,kurs_ad));
		}
		
		int odeme_id;
		while(kontrol!=1)
		{
			
			System.out.println(SKY_BLUE+"=============================================");
	        System.out.println("|       🏫 KURS YÖNETİM SİSTEMİ             |");
	        System.out.println("=============================================");
	        System.out.println("| 1 ➔ Kurs Ekle                            |");
	        System.out.println("| 2 ➔ Kurs Listele                         |");
	        System.out.println("| 3 ➔ Kurs Ara                             |");
	        System.out.println("| 4 ➔ Kurs Sil                             |");
	        System.out.println("| 5 ➔ Kursiyer Ekle                        |");
	        System.out.println("| 6 ➔ Kursiyer Ara                         |");
	        System.out.println("| 7 ➔ Kursiyer Sil                         |");
	        System.out.println("| 8 ➔ Kursiyerleri Listele                 |");
	        System.out.println("| 9 ➔ Kursiyerleri Ayrıntılı Listele       |");
	        System.out.println("| 10 ➔ Kursiyerin Ödeyeceği Tutarı Hesapla |");
	        System.out.println("| 11 ➔ Çıkış                               |");
	        System.out.println("============================================="+RESET);
	        System.out.print("Lütfen bir seçenek seçin (1-11): \n");
	        if(veri.hasNextInt())
	        {
	        	secim=veri.nextInt();
	        	switch(secim)
		        {
			        case 1:
			        	Kurs_Ekle(kurslar);
			            break;
			        case 2:
			        	kurs_goruntule(kurslar);
			        	break;
			        case 3:
			        	Kurs_Ara(kurslar);
			        	
			        	break;
			        case 4:
			        	Kurs_silme(kurslar,kursiyerler);
			        	break;
			        case 5:
			        	Kursiyer_Ekleme(kursiyerler,kurslar);
			        	break;
			        case 6:
			        	Kursiyer_Arama(kursiyerler);
			        	
			        	break;
			        case 7:
			        	Kursiyer_Silme(kursiyerler);
			        	
			        	break;
			        case 8:
			        	Kursiyer_Listele(kursiyerler);
			        	break;
			        case 9:
			        	Kursiyer_detayli_listele(kursiyerler);
			        	break;
			        case 10:
			        	System.out.println("Ödeme bilgisini öğrenmek istediğiniz kursiyerin Id'sini giriniz: ");
			        	odeme_id=veri.nextInt();
			        	KursiyerinOdeyecegiTutarHesapla(odeme_id,kursiyerler);
			        	break;
			        case 11:
			        	Dosya_okuma(kursiyerler,kurslar);
			        	String mj=LIGHT_PURPLE+"Sistemden çıkışınız yapılıyor";
			        	hareketliSilmeMesaji(mj);
			        	kontrol=1;
			        	break;
		        	default:
		        		System.out.println(RED+"Yanlış secim yaptiniz!!\n"+RESET);
		        }
	        }
	        else
	        {
	        	System.out.println(RED + "Karakter girilemez!!" + RESET);
	            veri.next();
	            continue;
	        }
		}
		
	}
	
	
	
	public static void hareketliSilmeMesaji(String mesaj) throws InterruptedException 
	{
		System.out.print(mesaj); 
        for (int i = 0; i < 3; i++) 
        { 
        	if(mesaj.contains("Silme"))
        	{
        		System.out.print(RIVER_GREEN+"."+RESET);
        	}
        	else if(mesaj.contains("Sistemden"))
        	{
        		System.out.print(LIGHT_PURPLE+"."+RESET);
        	}
            Thread.sleep(500); 
        }
    }
	
	public static void Kurs_Ekle(ArrayList<Kurs> kurslar) throws InterruptedException
	{
		Scanner veri=new Scanner(System.in);
		int yeni_kurs_id;
		String yeni_kurs_isim;
		while(true)
		{
			System.out.println("Eklemek istediginiz Kurs'un Id'sini giriniz: ");
	    	yeni_kurs_id=veri.nextInt();
	    	int kontrol=0;
	    	for(int i=0;i<kurslar.size();i++)
	    	{
	    		if(kurslar.get(i).getKursId()==yeni_kurs_id)
	    		{
	    			System.out.println(RED+"!! Aynı Id'ye ait başka bir kurs var !!"+RESET);
	    			kontrol=1;
	    			break;
	    		}
	    	}
	    	
	    	if(kontrol==0)
	    	{
	    		break;
	    	}
		}
		
    	System.out.println("Eklemek istediginiz Kurs'un Adini giriniz: ");
    	yeni_kurs_isim=veri.next();
    	kurslar.add(new Kurs(yeni_kurs_id,yeni_kurs_isim));
    	
    	String mesaj = "\u2705  "+yeni_kurs_id+" No'lu "+ yeni_kurs_isim.toUpperCase()+" kursunu ekleme işlemi başarıyla tamamlandı!";
    	System.out.println(PINK+"=".repeat(70));
        for (char c : mesaj.toCharArray()) 
        {
            System.out.print(c);
            Thread.sleep(30);
        }
        System.out.println("\n"+"=".repeat(70)+RESET);
        System.out.println();
	}
	
	public static void kurs_goruntule(ArrayList<Kurs> kurslar)
	{
		int sayac = 1;
		System.out.println("=".repeat(40));
		System.out.println(PINK + String.format("%25s", "📚 KURSLAR 📚") + RESET);
		System.out.println("=".repeat(40));

		System.out.printf(MUSTARD_YELLOW + "%-5s %-15s %-30s\n", "No", "Kurs Id", "Kurs Adı" + RESET);
		System.out.println("-".repeat(40));

		for (Kurs k : kurslar) 
		{
		    System.out.printf("%-5d %-15d %-30s\n", sayac, k.getKursId(), k.getKursAd());
		    sayac++;
		}
		System.out.println("=".repeat(40));

	}
	
	public static void Kurs_Ara(ArrayList<Kurs> kurslar) throws InterruptedException
	{
		Scanner veri=new Scanner(System.in);
		String aranan_kurs;
		System.out.println("Lutfen aradiginiz kursun ismini giriniz: ");
    	aranan_kurs=veri.next();
    	int k_kontrol=0;
    	String msj="\u2705 "+" ARADIGINIZ KURS BULUNDU";
    	for(Kurs k:kurslar)
    	{
    		if(aranan_kurs.equalsIgnoreCase(k.getKursAd()))
    		{
    			System.out.println("=".repeat(40));
    			for (char c : msj.toCharArray()) 
		        {
    				System.out.print(PINK+c+RESET);
		            Thread.sleep(30);
		        }
    			System.out.println("\n"+"=".repeat(40));
    			System.out.printf(MUSTARD_YELLOW+"%-15s %-30s\n", "Kurs Id", "Kurs Adı"+RESET);
    			System.out.println("-".repeat(40));
    			System.out.printf("%-15d %-30s\n", k.getKursId(), k.getKursAd());
    			System.out.println("=".repeat(40));
    			k_kontrol=1;
    			break;
    		}
    	}
    	if(k_kontrol==0)
    	{
    		System.out.println(RED+aranan_kurs.toUpperCase()+" isimli aranan kurs bulunamadi!!"+RESET);
    	}
	}
	
	public static void Kurs_silme(ArrayList<Kurs> kurslar,ArrayList<Kursiyer> kursiyerler) throws InterruptedException
	{
		Scanner veri=new Scanner(System.in);
		String kurs_isim;
    	System.out.println("Lutfen silmek istediğiniz Kurs'un ismini giriniz: ");
    	kurs_isim=veri.nextLine();
    	Kurs silinen_kurs=null;
    	for(Kurs k:kurslar)
        {
        	if(kurs_isim.equalsIgnoreCase(k.getKursAd()))
        	{
        		silinen_kurs=k;
        		break;
        	}
        }
    	if(silinen_kurs!=null)
    	{
    		int kurs_alan_var=0;
    		for(Kursiyer kr: kursiyerler)
    		{
    			for(Kurs k:kr.alinanKurslar)
    			{
    				if(k.getKursAd().equalsIgnoreCase(silinen_kurs.getKursAd()))
    				{
    					kurs_alan_var=1;
        				break;
    				}
    			}
    		}
    		
    		if(kurs_alan_var==1)
    		{
    			System.out.println(ORANGE+"=".repeat(70));
    			System.out.println(silinen_kurs.getKursAd()+" isimli kursu alan kursiyer mevcut olduğu için kurs silinemez!!");
    			System.out.println("=".repeat(70)+RESET);
    		}
    		else
    		{
    			String ms=RIVER_GREEN+"Silme işlemi yapılıyor";
    			hareketliSilmeMesaji(ms);
        		kurslar.remove(silinen_kurs);
        		System.out.println(LIGHT_PURPLE+"\n"+"=".repeat(85));
        		System.out.println("\u2705  "+kurs_isim.toUpperCase()+" isimli Kurs'un silme işlemi başarılı bir şekilde gerçekleştirilmiştir");
        		System.out.println("=".repeat(85)+RESET);
    		}
    	}
    	else
    	{
    		System.out.println(RED+"!! "+kurs_isim+" isimli kurs bulunamadi !!"+RESET);
    	}
	}
	
	public static void Kursiyer_Ekleme(ArrayList<Kursiyer> kursiyerler,ArrayList<Kurs> kurslar) throws InterruptedException
	{
		Scanner veri=new Scanner(System.in);
		int yeni_id,yeni_yas,kurs_sayisi,alinankurs,kurs_no;
		String ad_soyad,isim,soyisim,alinankursisim;
		Kursiyer yeni_kursiyer=null;
		while(true)
		{
			System.out.println("Lutfen kaydını yapmak istediginiz kursiyerin Id'sini giriniz: ");
	    	yeni_id=veri.nextInt();
	    	int kontrol=0;
	    	for(Kursiyer kr: kursiyerler)
	    	{
	    		if(yeni_id==kr.getKursiyerId())
	    		{
	    			System.out.println(RED+"!! Aynı id'ye ait başka bir kursiyer var !!"+RESET);
	    			kontrol=1;
		        	break;
	    		}
	    	}
	    	
	    	if(kontrol==0)
	    	{
	    		break;
	    	}
	    	
		}
		veri.nextLine();
    	System.out.println("Lutfen kaydını yapmak istediginiz kursiyerin ismini giriniz: ");
    	isim=veri.nextLine();
    	System.out.println("Lutfen kaydını yapmak istediginiz kursiyerin soyisminizi giriniz: ");
    	soyisim=veri.nextLine();
    	ad_soyad=isim+" "+soyisim;
    	System.out.println("Lutfen kaydını yapmak istediginiz kursiyerin yasini giriniz: ");
    	yeni_yas=veri.nextInt();
    	veri.nextLine();
    	kurs_goruntule(kurslar);
    	System.out.println("Kaç tane kurs almak istiyorsunuz? :");
    	kurs_sayisi=veri.nextInt();
    	while(kurs_sayisi > 11 || kurs_sayisi < 1) 
    	{
    	    System.out.println(RED+"Hatalı bir kurs numarası girdiniz. Lütfen 1 ile " + kurslar.size() + " arasında bir numara seçiniz."+RESET);
    	    System.out.println("Kaç tane kurs almak istiyorsunuz? :");
    	    kurs_sayisi = veri.nextInt();
    	}
    	yeni_kursiyer=new Kursiyer(yeni_id,ad_soyad,yeni_yas,new ArrayList<>());
    	Kurs kurs_ekle=null;
    	for(int i=0;i<kurs_sayisi;i++)
    	{
    		System.out.println("Lutfen almak istediginiz "+(i+1)+". kursun numarasını giriniz: ");
    		kurs_no=veri.nextInt();
    		if (kurs_no >= 1 && kurs_no <= kurslar.size())
    		{
    			kurs_ekle=kurslar.get(kurs_no-1);
    			int kontrol=0;
    			for(Kurs k:yeni_kursiyer.alinanKurslar)
    			{
    				if(k.getKursId()==kurs_ekle.getKursId())
    				{
    					kontrol=1;
    					break;
    				}
    			}
    			
    			if(kontrol==1)
    			{
    				System.out.println(LIGHT_PURPLE + "Bu kursu daha once eklediniz!!" + RESET);
    	            i--;
    			}
    			else
    			{
    				yeni_kursiyer.alinanKurslar.add(new Kurs(kurs_ekle.getKursId(),kurs_ekle.getKursAd()));
    			}
    		}
    		else
    		{
    			System.out.println(RED + "Hatalı bir kurs numarası girdiniz. Lütfen 1 ile " + kurslar.size() + " arasında bir numara seçiniz." + RESET);
                i--;
    		}
    	}
    	kursiyerler.add(yeni_kursiyer);
    	String mes=ad_soyad.toUpperCase()+" isimli yeni kursiyerimizin kaydı tamamlanmıştır.\n";
    	System.out.println(PINK+"=".repeat(65));
		for (char c : mes.toCharArray()) 
		{
			System.out.print(c);
            Thread.sleep(30);
        }
		System.out.println("=".repeat(65)+RESET);
	}
	
	public static void Kursiyer_Arama(ArrayList<Kursiyer> kursiyerler) throws InterruptedException

	{
		Scanner veri=new Scanner(System.in);
		String ad,soyad,ad_soyad;
    	System.out.println("Aramak istediğiniz kursiyerin ismini giriniz: ");
    	ad=veri.nextLine();
    	System.out.println("Aramak istediğiniz kursiyerin soyismini giriniz: ");
    	soyad=veri.nextLine();
    	ad_soyad=ad+" "+soyad;
    	int kr_kont=0;
    	String ms="\u2705"+" ARADIGINIZ KURSİYER BULUNDU";
    	for(Kursiyer kr:kursiyerler)
    	{
    		if(ad_soyad.equalsIgnoreCase(kr.getKursiyerAdSoyad()))
    		{
    			System.out.println("=".repeat(50));
    			 for (char c : ms.toCharArray()) 
		            {
		                System.out.print(PINK+c+RESET);
		                Thread.sleep(30);
		            }
    			System.out.println("\n"+"=".repeat(50));
    			System.out.printf(RIVER_GREEN+"%-15s %-20s %-10s\n", "Kursiyer Id", "Kursiyer Ad Soyad", "Kursiyer Yaşı"+RESET);
    			System.out.println("-".repeat(50));
    			System.out.printf("%-15s %-20s %-10s\n", kr.getKursiyerId(), kr.getKursiyerAdSoyad(), kr.getKursiyerYas());
    			System.out.println("=".repeat(50));
    			kr_kont=1;
    			break;
    		}
    	}
    	if(kr_kont==0)
    	{
    		System.out.println(RED+ad_soyad.toUpperCase()+" isimli aranan kursiyer bulunamadi!!"+RESET);
    	}
	}
	
	public static void Kursiyer_Silme(ArrayList<Kursiyer> kursiyerler) throws InterruptedException
	{
		Scanner veri=new Scanner(System.in);
		int sil_kursiyer;
		Kursiyer silinecek_kursiyer=null;
    	System.out.println("Lutfen silmek istediğiniz kursiyerin Id'sini giriniz: ");
    	sil_kursiyer=veri.nextInt();
    	for(Kursiyer kr:kursiyerler)
    	{
    		if(sil_kursiyer==kr.getKursiyerId())
    		{
    			silinecek_kursiyer=kr;
    			break;
    		}
    	}
    	if(silinecek_kursiyer!=null)
    	{
    		String m=RIVER_GREEN+"Silme işlemi yapılıyor";
    		hareketliSilmeMesaji(m);
    		kursiyerler.remove(silinecek_kursiyer);
    		System.out.println("\n"+"-".repeat(40));
    		System.out.println(PINK+sil_kursiyer+" Id'li kursiyer silinmiştir"+RESET);
    		System.out.println("-".repeat(40));
    	}
    	else 
    	{
    		System.out.println("-".repeat(40));
            System.out.println(RED+"Bu ID'ye sahip bir kursiyer bulunamadı."+RESET);
            System.out.println("-".repeat(40));
        }
	}
	
	public static void Kursiyer_Listele(ArrayList<Kursiyer> kursiyerler)
	{
		System.out.println("=".repeat(50));
    	System.out.printf(ORANGE + "%" + (50 - "TÜM KURSİYERLER".length()) / 2 + "s%s\n" + RESET, "", "TÜM KURSİYERLER");
    	System.out.println("=".repeat(50));
    	System.out.printf(RIVER_GREEN+"%-15s %-20s %-10s\n", "Kursiyer Id", "Kursiyer Ad Soyad", "Kursiyer Yaşı"+RESET);
    	System.out.println("-".repeat(50));
    	for(Kursiyer kr:kursiyerler)
    	{
			System.out.printf("%-15s %-20s %-10s\n", kr.getKursiyerId(), kr.getKursiyerAdSoyad(), kr.getKursiyerYas());
    	}
    	System.out.println("=".repeat(50));
	}
	
	public static void Kursiyer_detayli_listele(ArrayList<Kursiyer> kursiyerler)
	{
		System.out.println(LIGHT_PURPLE+"TÜM KURSİYERLER VE ALDIKLARI KURSLAR"+RESET);
		for(Kursiyer kr:kursiyerler)
		{
			System.out.println(kr.getKursiyerId()+" "+kr.getKursiyerAdSoyad()+" "+kr.getKursiyerYas());
			for(Kurs k:kr.alinanKurslar)
			{
				System.out.println("    "+k.getKursId()+" "+k.getKursAd());
			}		
		}
	}
	
	public static void KursiyerinOdeyecegiTutarHesapla(int kursiyerId,ArrayList<Kursiyer> kursiyerler)
	{
		int kontrol=0;
		for(Kursiyer kr: kursiyerler)
		{
			if(kr.getKursiyerId()==kursiyerId)
			{
				kr.BorcHesapla();
				kontrol=1;
				break;
			}
		}
		if(kontrol==0)
		{
			System.out.println(RED+kursiyerId+" Id'li kursiyer bulunamadi!!"+RESET);
		}
	}
	
	public static void Dosya_okuma(ArrayList<Kursiyer> kursiyerler,ArrayList<Kurs> kurslar) throws IOException
	{
		File kursiyer_dosya= new File("kursiyer.txt");
		if(!kursiyer_dosya.exists())
		{
			kursiyer_dosya.createNewFile();
		}
		FileWriter fw=new FileWriter(kursiyer_dosya);
		BufferedWriter bw=new BufferedWriter(fw);
		for(Kursiyer kr:kursiyerler)
		{
			bw.write("*"+kr.getKursiyerId()+"%"+kr.getKursiyerAdSoyad()+"%"+kr.getKursiyerYas()+"\n");
			for(Kurs k: kr.alinanKurslar)
			{
				bw.write("+"+k.getKursId()+"%"+k.getKursAd()+"\n");
			}
		}
		bw.flush();
		bw.close();
		
		File kurs_dosya=new File("kurs.txt");
		if(!kurs_dosya.exists())
		{
			kurs_dosya.createNewFile();
		}
		FileWriter f=new FileWriter(kurs_dosya);
		BufferedWriter b=new BufferedWriter(f);
		for(Kurs k:kurslar)
		{
			b.write(k.getKursId()+"%"+k.getKursAd()+"\n");
		}
		b.flush();
		b.close();
	}
}