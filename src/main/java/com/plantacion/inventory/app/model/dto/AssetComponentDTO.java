package com.plantacion.inventory.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetComponentDTO {
    @JsonProperty("asset_id")
    @Size(min = 0, max = 12, message = "Confirm the component id")
    @NotNull(message = "You must provide the main asset id e.g desktop new qrcode id")
    private String asset_Id;

    @JsonProperty("component_id")
    @Size(min = 0, max = 12, message = "Confirm the component id")
    private String component_Id;

    @JsonProperty("component_name")
    @NotNull(message = "component name cannot be empty")
    @Size(min = 3, message = "Invalid component name")
    private String component_Name;

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
