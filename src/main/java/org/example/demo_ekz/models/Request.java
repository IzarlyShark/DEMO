package org.example.demo_ekz.models;

import java.util.Date;

public class Request {

    private int requestID;
    private Date startDate;
    private String orgTechType;
    private String orgTechModel;
    private String problemDescription;
    private String requestStatus;
    private Date completionDate;
    private String repairParts;
    private int masterID;
    private int clientID;
    //пустой конструктор
    public Request() {

    }
    // Конструктор для первичного создания заявки
    public Request(String orgTechType, String orgTechModel, String problemDescription, int masterID, int clientID){
        this.startDate = new Date();
        this.orgTechType = orgTechType;
        this.orgTechModel = orgTechModel;
        this.problemDescription = problemDescription;
        this.requestStatus = "Создана";
        this.masterID = masterID;
        this.clientID = clientID;
    }

    public int getRequestID() {
        return requestID; // Возвращает идентификатор заявки
    }

    public Date getStartDate() {
        return startDate; // Возвращает дату начала обработки заявки
    }

    public String getOrgTechType() {
        return orgTechType; // Возвращает тип организационной техники
    }

    public void setOrgTechType(String orgTechType) {
        this.orgTechType = orgTechType; // Устанавливает новый тип организационной техники
    }
    public String getOrgTechModel() {
        return orgTechModel; // Возвращает модель организационной техники
    }

    public void setOrgTechModel(String orgTechModel) {
        this.orgTechModel = orgTechModel; // Устанавливает новую модель организационной техники
    }

    public String getProblemDescription() {
        return problemDescription; // Возвращает описание проблемы
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription; // Устанавливает новое описание проблемы
    }

    public String getRequestStatus() {
        return requestStatus; // Возвращает статус заявки
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus; // Устанавливает новый статус заявки
    }

    public Date getCompletionDate() {
        return completionDate; // Возвращает дату завершения обработки заявки
    }

    public String getRepairParts() {
        return repairParts; // Возвращает информацию о запчастях, использованных для ремонта
    }

    public void setRepairParts(String repairParts) {
        this.repairParts = repairParts; // Устанавливает новую информацию о запчастях, использованных для ремонта
    }
    public int getMasterID() {
        return masterID; // Возвращает идентификатор мастера
    }
    public void setMaterID(int materID) {
        this.masterID = materID; // Устанавливает новый идентификатор мастера
    }


    public int getClientID() {
        return clientID; // Возвращает идентификатор клиента
    }

}
