package com.bhhan.eventsample.web;

import com.bhhan.eventsample.app.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hbh5274@gmail.com on 2020-10-09
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequestMapping("/event-sample")
@RequiredArgsConstructor
public class TestController {
    private final SampleService sampleService;

    @GetMapping
    public String raiseEvent(){
        sampleService.doSome();
        return "hello world!!!";
    }
}
