package ar.edu.teclab.prueba.dto;

import java.util.List;

public class CarreraDto {

    private Integer id;

    private List<MateriaDto> materiaDtoList;

    private String name;

    private String code;

    private String status;

    public CarreraDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<MateriaDto> getMateriaDtoList() {
        return materiaDtoList;
    }

    public void setMateriaDtoList(List<MateriaDto> materiaDtoList) {
        this.materiaDtoList = materiaDtoList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
