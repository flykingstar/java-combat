import annotation.AnimalController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dengzhe
 * @date 2022/6/3
 */
public class BeanTest {
    public static void main(String[] args) {
        // xml方式实现装配bean：输出：this car name is 别克,color is 黑色
       xmlMethod();
        //annotation方式装配bean ： 输出：wang！ wang！ wang！
  //      annotationMethod();
    }

    public static void xmlMethod(){
        // 定义配置文件路径
        String xmlPath = "car1.xml";
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 构造方式输出结果
        System.out.println(applicationContext.getBean("car"));
    }

    public static void annotationMethod(){
        String xmlPath = "car2.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AnimalController animalController = (AnimalController) applicationContext.getBean("animalController");
        animalController.speak();
    }
}
