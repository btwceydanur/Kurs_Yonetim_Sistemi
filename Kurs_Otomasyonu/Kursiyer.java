package FinalOdevi_22100011932;

//22100011932
//Ceydanur Gezer

import java.util.ArrayList;

public class Kursiyer implements Hesaplama{
	private int kursiyerId;
	private String kursiyerAdSoyad;
	private int kursiyerYas;
	public ArrayList<Kurs> alinanKurslar;
	
	public static final String RESET = "\033[0m";
	public static final String LIGHT_PURPLE = "\u001B[1;38;2;186;85;211m";
	public static final String RIVER_GREEN = "\u001B[1;38;2;0;250;154m";
	
	public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas, ArrayList<Kurs> alinanKurslar) {
		super();
		this.kursiyerId = kursiyerId;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.kursiyerYas = kursiyerYas;
		this.alinanKurslar = alinanKurslar;
	}


	@Override
	public void BorcHesapla() 
	{
		int kurs_ucret,haftalik_ucret=500,aylikucret=0,indirim;
		kurs_ucret=haftalik_ucret*4;
		if(alinanKurslar.size()==2)
		{
			for(int i=0;i<2;i++)
			{
				if(i==1)
				{
					indirim=(int) (kurs_ucret*0.20);
					kurs_ucret=kurs_ucret-indirim;
				}
				aylikucret+=kurs_ucret;
			}
			System.out.println(RIVER_GREEN+kursiyerAdSoyad.toUpperCase()+" isimli kursiyere ait Aylik Ucret: "+aylikucret+RESET);
			System.out.println("-".repeat(50));
			System.out.println(LIGHT_PURPLE+"1.Kampanya'dan yararlandiniz!(2.Ders %20 indirimli)"+RESET);
		}
		else if(alinanKurslar.size()==3)
		{
			for(int i=0;i<3;i++)
			{
				if(i==2)
				{
					indirim=(int)(kurs_ucret*0.25);
					kurs_ucret=kurs_ucret-indirim;
				}
				aylikucret+=kurs_ucret;
			}
			System.out.println(RIVER_GREEN+kursiyerAdSoyad.toUpperCase()+" isimli kursiyere ait Aylik Ucret: "+aylikucret+RESET);
			System.out.println("-".repeat(50));
			System.out.println(LIGHT_PURPLE+"2.Kampanya'dan yararlandiniz!(3.Ders %25 indirimli)"+RESET);
		}
		else if(alinanKurslar.size()>3)
		{
			kurs_ucret=kurs_ucret*alinanKurslar.size();
			indirim=(int) (kurs_ucret*0.10);
			aylikucret=kurs_ucret-indirim;
			System.out.println(RIVER_GREEN+kursiyerAdSoyad.toUpperCase()+" isimli kursiyere ait Aylik Ucret: "+aylikucret+RESET);
			System.out.println("-".repeat(50));
			System.out.println(LIGHT_PURPLE+"3.Kampanya'dan yararlandiniz!(Her ders %10 indirimli)"+RESET);
		}
		else
		{
			aylikucret=kurs_ucret;
			System.out.println(RIVER_GREEN+kursiyerAdSoyad.toUpperCase()+" isimli kursiyere ait Aylik Ucret: "+aylikucret+RESET);
			System.out.println("-".repeat(50));
			System.out.println("1 tane Ders alan Kursiyerler için Kampanya bulunmamaktadır!!");
		}
		
	}


	public int getKursiyerId() {
		return kursiyerId;
	}


	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}


	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}


	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}


	public int getKursiyerYas() {
		return kursiyerYas;
	}


	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}

	
	
}
