
import java.util.Scanner;
import java.util.Random;

public class Berac {

    //-------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seme = sc.nextInt();
        int milievrovZaFunt = sc.nextInt();
        int milievrovZaDolar = sc.nextInt();
        int maksDarilo = sc.nextInt();
        int ciljniZnesekVMilievrih = sc.nextInt();
		int trenutnoStanje = 0;
		int dar = 0;
		int valutaVInt = 0;
		
		Random random = new Random(seme);
		
		System.out.printf("%10s%16s%n", "Darilo", "Klobuk");
		
		while(trenutnoStanje < ciljniZnesekVMilievrih) {
			valutaVInt = random.nextInt(3);
			dar = random.nextInt(maksDarilo);
			
			
			trenutnoStanje += preracunajVMilievre(dar, valutaVInt, milievrovZaFunt, milievrovZaDolar);
			
			
			System.out.printf("%6d %s%11d mEUR%n", dar, oznakaValute(valutaVInt), trenutnoStanje);
			
			
			
		}
    }

    /*
     * Vrne oznako valute za podano številko valute (0 --> "EUR", 1 --> "GBP",
     * 2 --> "USD").
     */
    private static String oznakaValute(int valuta) {
        switch (valuta) {
			case 0:
				return "EUR";
			case 1:
				return "GBP";
			case 2:
				return "USD";
		}

        return "Napaka";
        // bolje:
        // throw new RuntimeException("Parameter valuta ni v intervalu [0, 2].");
    }

    /* 
     * Vrne znesek v milievrih, ki ustreza podanemu znesku v podani valuti.
     */
    private static int preracunajVMilievre(int znesek, int valuta,
            int milievrovZaFunt, int milievrovZaDolar) {
				
			switch (valuta) {
				case 0:
					return znesek*1000;
				case 1:
					return znesek*milievrovZaFunt;
				case 2:
					return znesek*milievrovZaDolar;
			}

        // ...

        return 0;
        // bolje:
        // throw new RuntimeException("Parameter valuta ni v intervalu [0, 2].");
    }
}
