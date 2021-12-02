package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modal.entities.Produto;
//crie um arquivo txt e coloque o caminho dele na String path
public class Program {
	public static void main(String[] args) {

		String path = "C:\\Users\\micro\\Desktop\\text\\int.txt";
		String path2 = "C:\\Users\\micro\\Desktop\\text\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Produto> liste = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] filds = line.split(",");
				liste.add(new Produto(filds[0], Double.parseDouble(filds[1]), Integer.parseInt(filds[2])));
				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
				for(Produto pd: liste) {
					bw.write(pd.getName()+","+String.valueOf(pd.calc_total()+"\n"));
				}
			} catch (IOException  e) {
				System.out.println("Error: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
