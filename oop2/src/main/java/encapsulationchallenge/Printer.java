package encapsulationchallenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 100 || tonerAmount < 1) {
            return -1;
        }

        int tempAmount = tonerLevel + tonerAmount;
        if (tempAmount > 100 || tempAmount < 0) {
            return -1;
        }

        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public int printPages(int pages) {
        int sheetsRequired = duplex ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += pages;

        if (duplex) {
            System.out.println("It's a duplex printer");
        }

        return sheetsRequired;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
