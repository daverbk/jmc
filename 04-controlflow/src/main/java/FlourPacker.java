public class FlourPacker {

    public static void main(String[] args) {

        System.out.println(canPack(0, 5, 5));
        System.out.println(canPack(2, 10, 20));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        int bigWeight = 5;

        int goalLastDigit = goal % 10;

        if (goalLastDigit % bigWeight == 0) {

            while (bigCount > 0) {
                goal -= bigWeight;
                bigCount--;

                if (goal <= 0 || goal - smallCount <= 0) {
                    return true;
                }
            }

        }

        while (smallCount > 0) {
            goal--;
            smallCount--;

            if ((goal % bigWeight == 0) && (goal / bigWeight <= bigCount)) {
                return true;
            }
        }

        return false;
    }
}
