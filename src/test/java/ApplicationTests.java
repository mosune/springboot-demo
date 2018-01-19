import com.example.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * FileName: ApplicationTests
 * Author:   gcg
 * Date:     2017/11/30 13:37
 * Description: Properties Test
 * History:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class ApplicationTests {

    @Autowired
    private Student student;

    @Value("${com.didispace.entity.Student.value}")
    private String value;

    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(student.getName(), "gcg");
        Assert.assertEquals(student.getAge(), 23);
        System.out.println(value);
    }

}
