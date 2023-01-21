package com.plantacion.inventory.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AssetDTO {

    @JsonProperty("asset_id")
    @Size(min = 11, max = 11, message = "maximum length exceeded")
    private String asset_Id;

    @JsonProperty("asset_name")
    @NotNull(message = "Asset name cannot be empty")
    @Size(min = 3, message = "Invalid asset name")
    private String asset_Name;

    @JsonProperty("asset_category")
    @Size(min = 1, message = "Invalid category name")
    private String asset_Category;

    @JsonProperty("asset_user")
    @Size(min = 1, message = "Invalid asset user/office")
    @NotNull(message = "Asset user/office cannot be empty")
    private String asset_User;

    @JsonProperty("new_asset_id")
    @Size(min = 1, max = 12, message = "Ensure to input valid QR code")
    @NotNull(message = "Ensure to input the new id on the QR code")
    private String new_AssetId;


}
