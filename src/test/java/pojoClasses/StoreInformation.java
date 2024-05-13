package pojoClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreInformation {

    @JsonProperty
    private int petId;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private String shipDate;

    @JsonProperty
    private String status;

    @JsonProperty
    private Boolean complete;

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
