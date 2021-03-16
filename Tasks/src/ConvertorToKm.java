import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ConvertorToKm {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double aMile = 1.609344;
        double aGallon = 4.54609188;
        double howMuchMilesPerGallon = Double.parseDouble(bf.readLine());
        double kilometresPerLitres = (aMile / aGallon) * howMuchMilesPerGallon;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String secondStr = decimalFormat.format(kilometresPerLitres);
        System.out.println((secondStr));
    }
}
