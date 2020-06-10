package com.second.checkeyword;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JSoupSampleController {

    @GetMapping("/sample")
    public String sample()throws Exception{
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        log(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
        return "/sample.html";
    }
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
    @GetMapping("/sample2")
    public void sample2(){}

}
