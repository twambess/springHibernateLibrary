package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.BookDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Book;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private BookDAO bookDAO;

    private final String path = "D:\\Study\\Programming\\3course\\reports";

    @Transactional
    public synchronized void exportReport(String reportFormat) throws JRException, FileNotFoundException {
        List<Book> books = bookDAO.getAllBooks();
        File file = ResourceUtils.getFile("classpath:report.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(books);
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                    path + "\\books.pdf");
        }
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint,
                    path + "\\books.html");
        }
    }

    public String getPath() {
        return "Reports generated in path: " + path;
    }
}
