package annotation;

import org.springframework.stereotype.Repository;

/**
 * @author dengzhe
 * @date 2022/6/3
 */
@Repository("animalDao")
public class AnimalDaoImpl implements AnimalDao{

    @Override
    public void speak() {
        System.out.println("wang！ wang！ wang！");
    }
}
