package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentScanTest {

    @Configuration
    @ComponentScan(basePackages = {
            "com.example.september.domain.member.api"
    })
    static class TestAppContextWithoutDataSourceBean { }

    @Configuration
    @ComponentScan()
    static class DefaultComponentScanScopeApplicationConext { }

    @Test
    @DisplayName("dataSource Bean이 없는 ApplicationContext")
    void componentScanExcludeDataSource() {
        // given
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(TestAppContextWithoutDataSourceBean.class);
        // when
        String[] names = appContext.getBeanDefinitionNames();
        // then
        assertThat(names).doesNotContain("dataSource");
    }

    @Test
    @DisplayName("기본 ComponentScan 범위 확인")
    void componentScanDefaultScope() {
        // given
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(DefaultComponentScanScopeApplicationConext.class);
        // when
        String[] names = appContext.getBeanDefinitionNames();
        // then
        assertThat(names).contains("defaultComponent");
        Arrays.stream(names).forEach(System.out::println);
    }

}
