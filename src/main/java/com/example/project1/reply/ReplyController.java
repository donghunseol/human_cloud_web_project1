package com.example.project1.reply;

import com.example.project1.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ReplyController {
    private final HttpSession session;
    private final ReplyRepository replyRepository;


    @PostMapping("/reply/save")
    public String write(ReplyRequest.WriteDTO requestDTO) {
        System.out.println(requestDTO);
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (sessionUser == null) {
            return "redirect:/loginForm";
        }

        replyRepository.save(requestDTO, sessionUser.getId());
        return "redirect:/board/" + requestDTO.getBoardId();

    }

    @PostMapping("/reply/{id}/delete")
    public String delete(@PathVariable Integer id) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            return "redirect:/loginForm";
        }
        Reply reply = replyRepository.findById(id);

//        if (reply == null) {
//            return "error/404";
//        }
//
//        if (reply.getUserId() != sessionUser.getId()) {
//            return "error/403";
//        }

        replyRepository.deleteById(id);

        return "redirect:/board/" + reply.getBoardId();

    }
}