package cherry.hello.boot.spring5boot.controller;

import cherry.hello.boot.spring5boot.model.Checkme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/join")
public class JoinController {

    Logger logger = LogManager.getLogger(JoinController.class);

    @GetMapping("/agree")
    public String agree() {
        logger.info("mybatis/mapper/agree 호출!!");

        return "join/agree";
    }

    @GetMapping("/joinme")
    public String joinme() {
        logger.info("mybatis/mapper/joinme 호출!!");

        return "join/joinme";
    }

    @GetMapping("/checkme")
    public String checkme() {
        logger.info("mybatis/mapper/checkme 호출!!");

        return "join/checkme";
    }

    @PostMapping("/checkme")
    public String checkmeok(Checkme checkme, HttpSession sess) {
        logger.info("mybatis/mapper/checkmeok 호출!!");
        // checkme에 보낸 개인정보를 세션에 저장하고
        // joinme로 이동
        String viewPage = "redirect:/join/checkme";

        if (checkme.getName() != null) {
            sess.setAttribute("checkme", checkme);
            viewPage = "redirect:/join/joinme";
        }

        return viewPage;
    }


    @GetMapping("/joinok")
    public String joinok() {
        logger.info("mybatis/mapper/joinok 호출!!");

        return "join/joinok";
    }
}
