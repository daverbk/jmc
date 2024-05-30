package consumer.specific;

import finalmodifier.BaseClass;

public class ChildClass extends BaseClass {
    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod]: Extra stuff here!");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[Child:recommendedMethod]: Ill do thing my way");
//        optionalMethod();
//    }

    public static void recommendedStatic() {
        System.out.println("[Child:recommendedStatic]: Best way to do it");
        optionalStatic();
//        mandatoryStatic();
    }
}
