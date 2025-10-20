package FinalOdevi_22100011932;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class yazma_deneme {

	public static void main(String[] args) throws IOException {
		File kurs_dosya= new File("kurs1.txt");
		if(!kurs_dosya.exists())
		{
			kurs_dosya.createNewFile();
		}
		FileWriter fw=new FileWriter(kurs_dosya);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("*"+100+"%"+"Ceydanur Gezer"+"%"+21);
		bw.flush();
		bw.close();
	}

}
