package school;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author dengzhe
 * @date 2022/6/4
 */
@ConfigurationProperties(prefix = "school")
@Data
public class SchoolProperties {
    /**
     * 学校名称
     */
    public String name;
}
