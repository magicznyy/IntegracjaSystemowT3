import java.util.ArrayList;
import java.util.HashMap;

public class Printer {

    public void printTable(ArrayList<Laptop> laptops){
        int i =0;
        String leftAlignFormat = "| %-4s | %-10s | %-10s | %-14s | %-12s | %-12s | %-10s | %-14s | %-10s | %-10s | %-10s | %-10s | %-30s | %10s | %-30s | %-10s |%n";


        System.out.format(leftAlignFormat,"L.p.","Marka","Przekątna","Rozdzielczość","Typ matrycy", "Czy dotykowa", "Procesor", "Liczba rdzeni", "Taktowanie", "ROM", "Typ dysku","RAM", "Karta graficzna", "Pamięć GPU", "System", "Napęd");

        for (Laptop l: laptops
             ) {
            i++;
            System.out.format(leftAlignFormat,i, l.getBrand(), l.getScreen().getDiagonal(),l.getScreen().getResolution(),l.getScreen().getType(),l.getScreen().isTouchScreen(),l.getProcessor().getName(),l.getProcessor().getCoresNumber(),l.getProcessor().getClocking(),l.getDisc().getCapacity(),l.getDisc().getType(),l.getRamMemory(),l.getGraphicCard().getName(),l.getGraphicCard().getMemory(),l.getOperatingSystem(),l.getDriveName());

        }
    }

    public void printQuantity(ArrayList<Laptop> laptops){

        HashMap<String,Integer> quantity = new HashMap<>();
        ArrayList<String> brands = getBrands(laptops);

        for (String brand: brands
             ) {
                quantity.put(brand,0);
        }

        for (Laptop l : laptops
             ) {
            int number = quantity.get(l.getBrand());
            number++;
            quantity.put(l.getBrand(),number);
        }

        for (String brand: brands
             ) {
            System.out.println(brand + " " + quantity.get(brand) );
        }
    }
    public ArrayList<String> getBrands(ArrayList<Laptop> laptops){
        ArrayList <String> brands = new ArrayList<>();
        for (Laptop l : laptops
             ) {
            if(!(brands.contains(l.getBrand())))
            brands.add(l.getBrand());
        }
        return brands;
    }



}
