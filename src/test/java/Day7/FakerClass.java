package Day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerClass {
    @Test
    public void fakerData(){
        Faker fakerobj = new Faker();
        String fullname = fakerobj.name().fullName();
        String firstname = fakerobj.name().firstName();

        System.out.println(fullname);
        System.out.println(firstname);
        System.out.println(fakerobj.name().lastName());
        System.out.println(fakerobj.name().username());
    }
}
