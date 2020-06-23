package com.second.checkeyword;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class JSoupSampleController {

    @GetMapping("/sample")
    public String sample(Model model)throws IOException{
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
        log(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        Elements ewsHeadliness = doc.select("#mp-itn b a");
        String bodyString="";
        for (Element headline : newsHeadlines) {
            bodyString+="<h2>"+headline.attr("title")+"</h2> <p>"+headline.absUrl("href")+"</p>";


            log("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
        return bodyString;
    }
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

    @GetMapping("/coocha")
    public String coocha() throws IOException{
        String bodyString="<h1>CooCha<h1>";
        Document doc = Jsoup.connect("http://www.coocha.co.kr/").get();
        log(doc.title());
        Elements hotItems = doc.select("#dealListDiv .deal .title");
        for(Element item : hotItems){
            bodyString+="<p>"+item.toString()+"<p>";
            log("%s\n",item.toString());
        }
        return bodyString;
    }
}
