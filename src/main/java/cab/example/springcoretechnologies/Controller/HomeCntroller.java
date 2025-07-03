package cab.example.springcoretechnologies.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class HomeCntroller {
    @GetMapping
    public String speak(){
        return "Hello";
    }
    @GetMapping("/user")
    public  String users(){
        return "Hi user Vattey!";
    }
    @GetMapping("/admin")
    public String admin(){
        return "I am an Admin.";
    }
    @GetMapping("/default")
    public String default1(){
        return "I am defaulf.";
    }
    @GetMapping("/Customer")
    public String customer(){
        return  "Hello dear customer!";
    }
}
