import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CLient {

    public static void main(String[] args) {
        try {
            Interface service1 = (Interface) Naming.lookup("rmi://127.0.0.1:1250/Serveur");
            
              Scanner scanner = new Scanner(System.in);
            
      
            
            System.out.println("Montant a débiter :");
            String str = scanner.nextLine();
            double X = Double.parseDouble(str);
            System.out.println("Le nouveau solde est :"); 
            service1.debiter(X);
            System.out.println(service1.lireSolde());
            
            System.out.println("Montant a créditer :");
            str = scanner.nextLine();
            double Y = Double.parseDouble(str);
            System.out.println("Le nouveau solde est :");  
            service1.crediter(Y);          
            System.out.println(service1.lireSolde());

        } catch (NumberFormatException | MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Erreur de connexion ");
            System.out.println(e.toString());
        }
    }

}
