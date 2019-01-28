package com.worstEzreal.tess.controller;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Desc
 *
 * @date 2018/7/2
 */
@Slf4j
@Controller
public class TessController {

    @Value("${tesseract.data-path}")
    private String dataPath;

    @RequestMapping("/tess")
    public ModelAndView tess(@RequestParam("file") MultipartFile file, ModelAndView modelAndView) throws IOException {

        ByteArrayInputStream in = new ByteArrayInputStream(file.getBytes());
        BufferedImage bufferedImage = ImageIO.read(in);
        ITesseract tesseract = new Tesseract();

        tesseract.setDatapath(dataPath);
        tesseract.setLanguage("chi_sim");
        String s = null;
        try {
            log.info("OCR begin...");
            s = tesseract.doOCR(bufferedImage);
        } catch (TesseractException e) {
            log.error("OCR ERROR!", e);
        }
        log.info("tess result = " + s);

        modelAndView.setViewName("home");
        modelAndView.addObject("tessResult", s);
        return modelAndView;
    }

    @RequestMapping("/index")
    public String index() {
        return "home";
    }
}
