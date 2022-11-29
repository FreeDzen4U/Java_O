package Labs_O.Lab_2;

import nl.jqno.equalsverifier.EqualsVerifier;

class Test {

    @org.junit.jupiter.api.Test
    public void equalsContract() {
        EqualsVerifier.simple().forClass(Person.class).verify();
    }
}