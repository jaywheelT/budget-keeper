package com.coastory.budgetKeeper.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    //自定义配置...
    //FastJsonConfig config = new FastJsonConfig();
    //config.set ...
    //converter.setFastJsonConfig(config);
    FastJsonConfig config = new FastJsonConfig();
    config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
    config.setCharset(Charset.forName("UTF-8"));
    converter.setFastJsonConfig(config);
    converters.add(converter);
  }
}