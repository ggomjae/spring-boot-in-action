package com.github.renuevo.feign.client;


import com.github.renuevo.dto.NaverBlogParamDto;
import com.github.renuevo.dto.NaverResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "sample-feign-client", url = "${naver.url.search}")
public interface SampleFeignClient {

    @GetMapping(value = "blog.json")
    NaverResponse naverBlogSearch(
            @RequestHeader("X-Naver-Client-Id") String id,
            @RequestHeader("X-Naver-Client-Secret") String secret,
            @SpringQueryMap NaverBlogParamDto naverBlogParamDto);

}
