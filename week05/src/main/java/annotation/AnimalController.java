package annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author dengzhe
 * @date 2022/6/3
 */
@Controller("animalController")
public class AnimalController {

    @Resource(name = "animalService")
    private AnimalService animalService;

    public void speak() {
        this.animalService.speak();
        System.out.println("animal controller .. speak");
    }

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

}
