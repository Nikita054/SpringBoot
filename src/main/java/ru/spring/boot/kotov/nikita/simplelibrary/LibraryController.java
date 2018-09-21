package ru.spring.boot.kotov.nikita.simplelibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.Message;
import ru.spring.boot.kotov.nikita.simplelibrary.entities.Text;
import ru.spring.boot.kotov.nikita.simplelibrary.repos.MessageRepo;
import ru.spring.boot.kotov.nikita.simplelibrary.repos.TextRepo;

import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

@Controller
public class LibraryController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private TextRepo textRepo;

    @GetMapping("/main")
    public String main(Map<String,Object> model){
        Iterable<Message> messages=messageRepo.findAll();
        model.put("messages",messages);
        return "main";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name,@RequestParam String email,@RequestParam String text,Model model){
        Message message=new Message();
        message.setEmail(email);
        message.setName(name);
        Text text1=new Text();
        text1.setText(text);
        textRepo.save(text1);
        message.setIdText(text1.getIdText());
        messageRepo.save(message);

        model.addAttribute("messages",messageRepo.findAll());
        model.addAttribute("text",textRepo.findAll());
        return "index";
    }
    @PostMapping("/filter")
    public String filter(@RequestParam String filter,Model model){
        Iterable<Message> messages;
        if(filter!=null && !filter.isEmpty()) {
             messages = messageRepo.findByName(filter);
        }
        else {
            messages=messageRepo.findAll();
        }
        model.addAttribute("messages",messages);
        return "main";
    }
}
