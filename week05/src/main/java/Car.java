import lombok.Data;

/**
 * @author dengzhe
 * @date 2022/6/3
 */
@Data
public class Car {
    private String name;
    private String color;

    @Override
    public String toString() {
        return String.format("this car name is %s,color is %s", name, color);
    }
}
