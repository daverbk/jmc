import consumer.specific.ChildClass;
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
    }
}
