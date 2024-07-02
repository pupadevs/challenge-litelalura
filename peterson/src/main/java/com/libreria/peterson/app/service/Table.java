package com.libreria.peterson.app.service;

import com.libreria.peterson.domain.entity.Book;

public class Table {
    public  static String toTableString( Book bk) {
        StringBuilder sb = new StringBuilder();
        String line = "+---------------------+-------------------------+\n";
        sb.append(line);
        sb.append("|       Book ID       |           " + bk.getId() + "           |\n");
        sb.append(line);
        sb.append("|       Title         |        " + bk.getTitle() + "        |\n");
        sb.append(line);
        sb.append("|       Author        |        " + bk.getAuthor().getName() + "        |\n");
        sb.append(line);
        sb.append("|      Languages      |        " + bk.getLanguages() + "        |\n");
        sb.append(line);
        sb.append("|     Downloads       |          " + bk.getNumDownload() + "          |\n");
        sb.append(line);

        return sb.toString();
    }

}
