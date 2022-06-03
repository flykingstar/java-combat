import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dengzhe
 * @date 2022/6/3
 */
public class BeanTest {
    public static void main(String[] args) {
        // 定义配置文件路径
        String xmlPath = "car.xml";
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 构造方式输出结果
        System.out.println(applicationContext.getBean("car"));
    }
}
