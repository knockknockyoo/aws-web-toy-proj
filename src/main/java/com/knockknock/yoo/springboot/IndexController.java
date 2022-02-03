package com.knockknock.yoo.springboot;

import com.knockknock.yoo.springboot.config.auth.LoginUser;
import com.knockknock.yoo.springboot.config.auth.dto.SessionUser;
import com.knockknock.yoo.springboot.domain.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postService.findAllDesc());
        if (user !=null) model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }


}
