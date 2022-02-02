package com.knockknock.yoo.springboot;

import com.knockknock.yoo.springboot.config.auth.LoginUser;
import com.knockknock.yoo.springboot.config.auth.SessionUser;
import com.knockknock.yoo.springboot.domain.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;
    // private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postService.findAllDesc());
        // User Annotation Remove Session Codes
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user !=null) model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }


}
