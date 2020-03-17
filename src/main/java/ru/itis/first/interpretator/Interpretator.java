package ru.itis.first.interpretator;

import org.springframework.context.ApplicationContext;
import ru.itis.first.repository.MyClass;
import ru.itis.first.repository.MyClassRepository;

import java.util.ArrayList;
import java.util.List;


public class Interpretator {
    public String interpretate(ApplicationContext context, String string){
        MyClassRepository myClassRepository = context.getBean(MyClassRepository.class);
        if (string.startsWith("add")){
            return add(myClassRepository, string);
        } else if (string.startsWith("out")){
            return out(myClassRepository);
        } else if (string.startsWith("stop")){
            return "stop";
        } else return "Wrong action";
    }


    private String out(MyClassRepository repository) {
        List<MyClass> list = new ArrayList<>();
        StringBuilder names = new StringBuilder();
        repository.findAll().forEach(list::add);
        for (MyClass x: list){
            names.append(x.getName());
        }
        return names.toString();
    }

    private String add(MyClassRepository repository, String string) {
        repository.save(MyClass.builder()
                .name(string.substring(string.indexOf(' '), string.lastIndexOf(' ')))
                .age(Integer.parseInt(string.substring(string.lastIndexOf(' ')+1)))
                .build());
        return "Success";
    }
}
