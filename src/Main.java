import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AddressBook myAddresBook = new AddressBook();
        String path = "C:\\Test\\Agenda.txt";

        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona una opción");
        System.out.println("1) List");
        System.out.println("2) Create");
        System.out.println("3) Delete");
        int response = sc.nextInt();

        switch (response){
            case 1:
                try{
                    myAddresBook.list(path);
                } catch (Exception ex){
                    throw ex;
                }
                break;

            case 2:
                try{
                    System.out.println("Ingresa el nombre del contacto");
                    String contactName = sc.nextLine();
                    System.out.println("Ingresa el número del contacto");
                    String phoneNumber = sc.nextLine();
                    myAddresBook.create(path, phoneNumber, contactName);
                } catch (Exception ex){
                    throw ex;
                }

            case 3:
                try{
                    System.out.println("Ingresa el nombre del contacto a borrar");
                    String contactName = sc.nextLine();
                    System.out.println("Ingresa el número del contacto a borrar");
                    String phoneNumber = sc.nextLine();
                    myAddresBook.delete(path, phoneNumber, contactName);
                } catch (Exception ex){
                    throw ex;
                }

        }

    }
}