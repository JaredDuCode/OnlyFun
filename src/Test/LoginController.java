package Test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController{

    @RequestMapping(method=RequestMethod.GET,value="/login.do")
    public String transValue(HttpServletRequest request){
        System.out.println("hello");
        return "/second";
    }

}
