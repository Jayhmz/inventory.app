package com.plantacion.inventory.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class AssetComponentDTO {
    @JsonProperty("component_id")
    @Size(min = 12, max = 12, message = "Confirm the component id")
    private String component_Id;

    @JsonProperty("component_name")
    @NotNull(message = "component name cannot be empty")
    @Size(min = 3, message = "Invalid component name")
    private String component_Name;

    @JsonProperty("component_category")
    @Size(min = 1, message = "Invalid category name")
    private String component_Category;

    @JsonProperty("component_location")
    @NotNull(message = "Specify the location of the component")
    private String component_Location;

    @JsonProperty("component_user")
    @Size(min = 5, message = "Invalid component user/office")
    @NotNull(message = "component user/office cannot be empty")
    private String component_User;

    @JsonProperty("serial_no")
    private String component_Serial_No;

    @JsonProperty("new_component_id")
    @Size(min = 1, max = 12, message = "Ensure to input valid QR code")
    @NotNull(message = "Ensure to input the new id on the QR code")
    private String new_componentId;

    @JsonProperty("status")
    @NotNull(message = "What is the status of the component?")
    private String status;

    @JsonProperty("movement_details")
    private String movement_Details;

    @JsonProperty("availability_details")
    @NotNull(message = "What is the availability state of the component?")
    private String availability_Details;
}
