package pl.gruchh.maintenanceworkcrud.Controller.DTO;

public class WorksDto {
    private String name;
    private Long workDuration;

    public WorksDto(String name, Long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(Long workDuration) {
        this.workDuration = workDuration;
    }

    @Override
    public String toString() {
        return "WorksDto{" +
                "name='" + name + '\'' +
                ", workDuration=" + workDuration +
                '}';
    }
}


