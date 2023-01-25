package com.plantacion.inventory.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.plantacion.inventory.app.model.domain.Component;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDTO {

    @JsonProperty("asset_id")
    @Size(min = 0, max = 12, message = "Confirm the asset id")
    private String asset_Id;

    @JsonProperty("asset_name")
    @NotNull(message = "Asset name cannot be empty")
    @Size(min = 3, message = "Invalid asset name")
    private String asset_Name;

    @JsonProperty("asset_category")
    @Size(min = 1, message = "Invalid category name")
    private String asset_Category;

    @JsonProperty("asset_location")
    @NotNull(message = "Specify the location of the asset")
    private String asset_Location;

    @JsonProperty("asset_user")
    @Size(min = 5, message = "Invalid asset user/office")
    @NotNull(message = "Asset user/office cannot be empty")
    private String asset_User;

    @JsonProperty("serial_no")
    private String asset_Serial_No;

    @JsonProperty("new_asset_id")
    @Size(min = 1, max = 12, message = "Ensure to input valid QR code")
    @NotNull(message = "Ensure to input the new id on the QR code")
    private String new_AssetId;

    @JsonProperty("status")
    @NotNull(message = "What is the status of the asset?")
    private String status;

    @JsonProperty("movement_details")
    private String movement_Details;

    @JsonProperty("availability_status")
    @NotNull(message = "What is the availability state of the asset?")
    private String availability_Details;

    @JsonProperty("component")
    private AssetComponentDTO component;
}
