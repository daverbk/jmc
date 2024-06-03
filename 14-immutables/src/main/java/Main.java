import consumer.specific.ChildClass;
import external.util.Logger;
import finalmodifier.BaseClass;

public class Main {
    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass childClass = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("=====================================");
        childClass.recommendedMethod();
        System.out.println("=====================================");
        childReferredToAsBase.recommendedMethod();
        System.out.println("=====================================");

        parent.recommendedStatic();
        System.out.println("=====================================");
        childClass.recommendedStatic();
        System.out.println("=====================================");
        childReferredToAsBase.recommendedStatic();

        System.out.println("=====================================");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        String xArgument = "This is all I've got to say about section ";
        StringBuilder zArgument = new StringBuilder("only saying this after section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("after method xArgument = " + xArgument);
        System.out.println("after method zArgument = " + zArgument);

        StringBuilder tracker = new StringBuilder("Step 1 is abc");
        Logger.logToConsole(tracker.toString());
        tracker.append("Step 2 is xyz");
        Logger.logToConsole(tracker.toString());
        System.out.println("after logging tracker = " + tracker);
    }

    private static void doXYZ(String x, int y, final StringBuilder z) {

        final String c = x + y;
        System.out.println("c = " + c);
        x = c;
//        z = new StringBuilder("I'm saying this after section " + y);
    }
}
