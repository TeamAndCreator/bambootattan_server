package com.ahau.entity.file;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Files implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;

    /* 文件名称 */
    private String name;
    /* 文件原名 */
    private String origin_name;
    /* 文件上传路径 */
    private String path;
    /* 文件上传日期(年月日时分秒） */
    private String date;
    /* 文件类型（video/image) */
    private String type;
    /* 文件内容（bamboo/rattan) */
    private String content;

    public Files(String name, String origin_name, String path, String date, String type, String content) {
        this.name = name;
        this.origin_name = origin_name;
        this.path = path;
        this.date = date;
        this.type = type;
        this.content = content;
    }

    public Files(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin_name='" + origin_name + '\'' +
                ", path='" + path + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
