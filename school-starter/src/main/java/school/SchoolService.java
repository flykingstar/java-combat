package school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dengzhe
 * @date 2022/6/4
 */
@Service
public class SchoolService implements ISchoolService {

    private String schoolName;

    public SchoolService(String name) {
        schoolName = name;
    }

    // Resource
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {
        System.out.println("school name " + schoolName + "Class1 have " + this.class1.getStudents().size() + "students and one is" + this.student100);
    }
}
