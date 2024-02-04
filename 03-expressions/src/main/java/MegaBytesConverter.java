public class MegaBytesConverter {

    public static void main(String[] args) {

        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(-1024);
        printMegaBytesAndKiloBytes(5000);
        printMegaBytesAndKiloBytes(0);
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int kbInMb = 1024;

        String conversionResult = kiloBytes >= 0
                ? (kiloBytes  + " KB = " + (kiloBytes / kbInMb) + " MB and " + (kiloBytes % kbInMb) + " KB")
                : "Invalid Value";

        System.out.println(conversionResult);
    }
}
