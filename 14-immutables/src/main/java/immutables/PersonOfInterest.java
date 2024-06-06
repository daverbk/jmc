package immutables;

public class PersonOfInterest extends PersonImmutable {
    protected PersonOfInterest(PersonImmutable person) {
        super(person);
    }

    @Override
    public PersonImmutable[] getKids() {
        return super.kids;
    }
}
