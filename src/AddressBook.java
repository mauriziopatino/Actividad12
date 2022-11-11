import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    HashMap<String, String> contactos = new HashMap<>();

    public AddressBook() {

    }

    public AddressBook(HashMap<String, String> contactos) {
        this.contactos = contactos;
    }

    public void Load(String path) throws IOException {
        String inputFilename = path;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader =  new BufferedReader(new FileReader(inputFilename));

            String reader;
            while ((reader = bufferedReader.readLine()) != null) {

                String phoneNumber = reader.substring(0, reader.indexOf("-"));
                String contactName = reader.substring(reader.lastIndexOf("-") + 1);

                contactos.put(phoneNumber, contactName);


                System.out.println(contactos);

            }

        }catch(Exception ex){
            throw ex;
        }finally {
            if(bufferedReader  != null){
                bufferedReader.close();
            }
        }
    }

    public void list(String path) throws IOException {
        String inputFilename = path;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader =  new BufferedReader(new FileReader(inputFilename));

            String reader;
            while ((reader = bufferedReader.readLine()) != null) {

                String phoneNumber = reader.substring(0, reader.indexOf(","));
                String contactName = reader.substring(reader.lastIndexOf(",") + 1);

                contactos.put(phoneNumber, contactName);
                System.out.println(contactos);

            }
        }catch(Exception ex){
            throw ex;
        }
    }

    public void create(String path, String phoneNumber, String contactName) throws IOException {
        String outputFilename = path;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedWriter =  new BufferedWriter(new FileWriter(outputFilename));
            bufferedReader =  new BufferedReader(new FileReader(outputFilename));

            String reader;
            while ((reader = bufferedReader.readLine()) != null) {
                System.out.println(reader);
                bufferedWriter.write(reader + "\n" + phoneNumber + "," + contactName);
                System.out.println(reader);

                System.out.println(contactos);

            }
        }catch(Exception ex){
            throw ex;
        }
    }

    public void delete(String path, String phoneNumber, String contactName) throws IOException {
        String inputFilename = path;
        String outputFilename = path;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader =  new BufferedReader(new FileReader(inputFilename));
            bufferedWriter =  new BufferedWriter(new FileWriter(outputFilename));

            String reader;
            while ((reader = bufferedReader.readLine()) != null) {

                if(reader.equals(phoneNumber)){
                    if(reader.equals(contactName)){
                        bufferedWriter.write(reader + System.getProperty("line.separator"));
                    }
                }

                contactos.put(phoneNumber, contactName);
                System.out.println(contactos);

            }
        }catch(Exception ex){
            throw ex;
        }
    }

    public HashMap<String, String> getContactos() {
        return contactos;
    }

    public void setContactos(HashMap<String, String> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contactos=" + contactos +
                '}';
    }
}
