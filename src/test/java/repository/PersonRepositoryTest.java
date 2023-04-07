package repository;

import domain.Address;
import domain.Car;
import domain.Gender;
import domain.Person;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonRepositoryTest {
    private final PersonRepository repository = new PersonRepository();
    private final CarRepoForTest testRepository = new CarRepoForTest();

    //TODO 4d test moet slagen
    @Test
    void shouldReadPerson() throws SQLException {
        Person person = repository.readPerson(1);
        assertThat(person).isNotNull();
        assertThat(person.getFirstName()).isEqualTo("Frank");
        assertThat(person.getLastName()).isEqualTo("Rinkens");
        assertThat(person.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(person.getGender()).isEqualTo(Gender.MALE);

        Address address = person.getAddress();
        assertThat(address.getStreetName()).isEqualTo("Dolphijnstraat");
        assertThat(address.getHouseNumber()).isEqualTo("10");
        assertThat(address.getZipCode()).isEqualTo("5632CZ");
        assertThat(address.getCity()).isEqualTo("Eindhoven");
        assertThat(address.getCountry()).isEqualTo("Nederland");

        Car car = person.getCar();
        assertThat(car).isNotNull();
        assertThat(car.getId()).isEqualTo(1);
        assertThat(car.getType()).isEqualTo("Seat");
        assertThat(car.getColor()).isEqualTo("Blauw");
        assertThat(car.getRegistrationPlate()).isEqualTo("P-468-LJ");
    }

    @Test
    void shouldCreatePerson() throws SQLException {
        Address address = new Address("Dorpstraat", "1a", "5504HK", "Veldhoven", "Nederland");
        Person person = new Person(3, "Gerda", "Janssen", LocalDate.parse("1974-08-29"), Gender.FEMALE, address);
        repository.createPerson(person);
        Person createdPerson = repository.readPerson(3);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Gerda");
        assertThat(createdPerson.getLastName()).isEqualTo("Janssen");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1974-08-29"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.FEMALE);

        Address createdAddress = person.getAddress();
        assertThat(createdAddress).isNotNull();
        assertThat(createdAddress.getStreetName()).isEqualTo("Dorpstraat");
        assertThat(createdAddress.getHouseNumber()).isEqualTo("1a");
        assertThat(createdAddress.getZipCode()).isEqualTo("5504HK");
        assertThat(createdAddress.getCity()).isEqualTo("Veldhoven");
        assertThat(createdAddress.getCountry()).isEqualTo("Nederland");
    }

    @Test
    void shouldUpdateAddress() throws SQLException {
        Address address = new Address("Keizerstraat", "11", "5751MR", "Deurne", "Nederland");
        repository.updateAddress(address, 3);
        Person person = repository.readPerson(3);

        Address updatedAddress = person.getAddress();
        assertThat(updatedAddress).isNotNull();
        assertThat(updatedAddress.getStreetName()).isEqualTo("Keizerstraat");
        assertThat(updatedAddress.getHouseNumber()).isEqualTo("11");
        assertThat(updatedAddress.getZipCode()).isEqualTo("5751MR");
        assertThat(updatedAddress.getCity()).isEqualTo("Deurne");
        assertThat(updatedAddress.getCountry()).isEqualTo("Nederland");
    }

    @Test
    void shouldUpdate() throws SQLException {
        String firstName = "Willy";
        repository.updateFirstName(firstName, 2);
        Person updatedPerson = repository.readPerson(2);
        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getFirstName()).isEqualTo("Willy");
        assertThat(updatedPerson.getLastName()).isEqualTo("Roelofsen");
        assertThat(updatedPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1986-03-15"));
        assertThat(updatedPerson.getGender()).isEqualTo(Gender.MALE);
    }

    //TODO 4f test moet slagen. Mocht de test falen, voer dan deletePersonCar.sql uit. Deze verwijdert de person en car van deze test.
    @Test
    void shouldCreatePersonWithCar() throws SQLException {
        Car car = new Car(2, "Ferrari", "Rood", "HH-DF-33");
        Address address = new Address("Voorterweg", "172", "5611TT", "Eindhoven", "Nederland");
        Person person = new Person(4, "Carlos", "Sainz", LocalDate.parse("1990-08-29"), Gender.MALE, address);
        person.setCar(car);

        repository.createPerson(person);
        Person createdPerson = repository.readPerson(4);
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getFirstName()).isEqualTo("Carlos");
        assertThat(createdPerson.getLastName()).isEqualTo("Sainz");
        assertThat(createdPerson.getDateOfBirth()).isEqualTo(LocalDate.parse("1990-08-29"));
        assertThat(createdPerson.getGender()).isEqualTo(Gender.MALE);

        Address createdAddress = person.getAddress();
        assertThat(createdAddress).isNotNull();
        assertThat(createdAddress.getStreetName()).isEqualTo("Voorterweg");
        assertThat(createdAddress.getHouseNumber()).isEqualTo("172");
        assertThat(createdAddress.getZipCode()).isEqualTo("5611TT");
        assertThat(createdAddress.getCity()).isEqualTo("Eindhoven");
        assertThat(createdAddress.getCountry()).isEqualTo("Nederland");

        Car createdCar = createdPerson.getCar();
        assertThat(createdCar).isNotNull();
        assertThat(createdCar.getId()).isEqualTo(2);
        assertThat(createdCar.getType()).isEqualTo("Ferrari");
        assertThat(createdCar.getColor()).isEqualTo("Rood");
        assertThat(createdCar.getRegistrationPlate()).isEqualTo("HH-DF-33");
    }

    //TODO 4h test moet slagen. Mocht de test falen, voer dan deletePersonCar.sql uit en voer shouldCreatePersonWithCar eerst uit
    @Test
    void shouldDelete() throws SQLException {
        Person person = repository.readPerson(4);
        repository.deletePerson(person);
        Person deletedPerson = repository.readPerson(person.getId());
        assertThat(deletedPerson).isNull();

        Car deletedCar = testRepository.getCar(person.getCar().getId());
        assertThat(deletedCar).isNull();
    }
}