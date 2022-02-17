package kg.itschool.ideas.ideasproject.controllers;

import kg.itschool.ideas.ideasproject.models.dto.IdeaDTO;
import kg.itschool.ideas.ideasproject.services.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/idea")
public class IdeaController {
    @Autowired
    private IdeaService ideaService;


    @PostMapping("/registration")
    public IdeaDTO save(@RequestBody IdeaDTO ideaDTO){

        return ideaService.save(ideaDTO);

    }
}
