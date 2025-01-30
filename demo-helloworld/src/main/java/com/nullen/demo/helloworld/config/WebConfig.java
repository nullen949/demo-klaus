package com.nullen.demo.helloworld.config;

import com.nullen.demo.helloworld.entity.DtoList;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Nullen
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String DTO_ARRAY_LIST = DtoList.class.getCanonicalName();


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
    }


    // @Bean
    // public HttpMessageConverter<Object> httpMessageConverter() {
    //     HttpMessageConverter<Object> httpMessageConverter = new MappingJackson2HttpMessageConverter() {
    //         @Override
    //         protected JavaType getJavaType(Type type, @Nullable Class<?> contextClass) {
    //             JavaType javaType;
    //             if (type != null && DTO_ARRAY_LIST.equals(type.getTypeName())) {
    //                 ObjectMapper objectMapper = new ObjectMapper();
    //                 TypeFactory typeFactory = objectMapper.getTypeFactory();
    //                 CollectionType collectionType = typeFactory.constructCollectionType(ArrayList.class, Pojo.class);
    //                 javaType = collectionType;
    //             } else {
    //                 javaType = super.getJavaType(type, contextClass);
    //             }
    //             return javaType;
    //         }
    //     };
    //     return httpMessageConverter;
    // }
}
