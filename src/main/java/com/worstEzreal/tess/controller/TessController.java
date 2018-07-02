package com.worstEzreal.tess.controller;

import com.worstEzreal.tess.Result;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Desc
 *
 * @date 2018/7/2
 */
@RestController
public class TessController {

    @Value("${tesseract.data-path}")
    private String dataPath;

    @RequestMapping("/tess")
    public Result tess(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String filePath = request.getSession().getServletContext().getRealPath("upload/");

        File image = new File(filePath+".png");
        FileUtils.writeByteArrayToFile(image, file.getBytes());
        ITesseract tesseract = new Tesseract();

        tesseract.setDatapath(dataPath);
        tesseract.setLanguage("chi_sim");
        String s = null;
        try {
            s = tesseract.doOCR(image);
        } catch (TesseractException e) {
        }
        return new Result<>(s);
    }
}
