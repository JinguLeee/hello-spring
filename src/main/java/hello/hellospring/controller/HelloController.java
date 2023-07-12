package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // viewResolver view와 템플릿을 연결
    }

    @GetMapping("hello-string")
    @ResponseBody   //( <= HttpMessageConverter로 변환 Http의 Body에 문자 내용을 직접 반환)
    public String helloString(@RequestParam("name") String name) { // => String은 StringConverter를 통해 String으로 변환
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) { // =>  객체는 JsonConverter를 통해 Json으로 변환
        Hello hello = new Hello();
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
