import org.junit.Test;
import school.SchoolService;

import javax.annotation.Resource;

/**
 * @author dengzhe
 * @date 2022/6/4
 */
public class SpringBootStarterTest {

    @Resource
    private SchoolService schoolService;

    @Test
    public void should_ok() {
        schoolService.ding();
    }
}
