package Revison.demo;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class Beans {
    public List<Todo> getData(){
        return new ArrayList<>();
    }
}
