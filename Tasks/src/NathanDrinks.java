import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NathanDrinks {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double time = Double.parseDouble(bf.readLine());
        int  litres = (int) time/2;
        System.out.println("time = " + time + "----> litres = " + litres);
    }
}
