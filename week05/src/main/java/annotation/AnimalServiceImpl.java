package annotation;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dengzhe
 * @date 2022/6/3
 */
@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    @Resource(name = "animalDao")
    private AnimalDao animalDao;

    @Override
    public void speak() {
        this.animalDao.speak();
        System.out.println("animal service speak");
    }

    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }
}
