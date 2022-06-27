package org.aposternak35.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


@Controller
public class FileController {
    Fayl fayl=new Fayl();



    @GetMapping(value = "/")
    public String showFayl(Model model)  {
        model.addAttribute("fayl",fayl);
        return "dir";
    }
    @PostMapping(value = "/")
    public String postFayl(@RequestParam(value="param") String path){
        if(path.equals("root")){
            fayl=new Fayl(File.listRoots());
        }else{
            fayl=new Fayl(path);
        }
        return "redirect:/";
    }
}
