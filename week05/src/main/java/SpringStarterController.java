import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.SchoolService;
import javax.annotation.Resource;

/**
 * @author dengzhe
 * @date 2022/6/4
 * 实现自动配置和 Starter
 */
@RestController
public class SpringStarterController {
    @Resource
    private SchoolService schoolService;

    @RequestMapping("/school")
    public void sendMsg(){
        schoolService.ding();
    }
}
