package school;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author dengzhe
 * @date 2022/6/4
 */
@Configuration
@ConditionalOnClass(SchoolService.class)
@EnableConfigurationProperties(SchoolProperties.class)
public class SchoolAutoConfigurationProperties {
    /**
     * 注入属性配置类
     */
    @Resource
    private SchoolProperties msgProperties;

    @Bean
    @ConditionalOnMissingBean(SchoolService.class)
    @ConditionalOnProperty(prefix = "school", value = "enabled", havingValue = "true")
    public SchoolService schoolService() {
        SchoolService schoolService = new SchoolService(msgProperties.getName());
        return schoolService;
    }
}
