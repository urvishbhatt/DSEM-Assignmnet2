package com.example.appengine.java8;

import com.example.appengine.java8.Services.UploadEmailService;
import com.opencsv.CSVReader;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@WebServlet("/backend/email_import_data")
public class EmailImportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/email_import.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            UploadEmailService uploaddata = new UploadEmailService();
            try {
                List<FileItem> multiparts = upload.parseRequest(req);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        new File(item.getName()).getName();
                        CSVReader csvReader = new CSVReader(new InputStreamReader(item.getInputStream()));
                        String[] nextRecord;
                        while ((nextRecord = csvReader.readNext()) != null) {
                            uploaddata.uploadFile(nextRecord);
                        }
                    }
                }
            } catch (Exception e) {}
            req.getRequestDispatcher("/").forward(req,resp);
        }
    }
}
