package ar.edu.teclab.prueba.dto;

public class MateriaDto {

    private Integer id;

    private String name;

    private String Code;

    private ProfesorDto profesorDto;

    private String carreraName;

    private Integer carreraId;

    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public ProfesorDto getProfesorDto() {
        return profesorDto;
    }

    public void setProfesorDto(ProfesorDto profesorDto) {
        this.profesorDto = profesorDto;
    }

    public String getCarreraName() {
        return carreraName;
    }

    public void setCarreraName(String carreraName) {
        this.carreraName = carreraName;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }
}
