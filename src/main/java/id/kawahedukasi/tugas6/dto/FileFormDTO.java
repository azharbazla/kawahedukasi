package id.kawahedukasi.tugas6.dto;

import javax.ws.rs.FormParam;

public class FileFormDTO {
    @FormParam("file")
    public byte[] file;
}
