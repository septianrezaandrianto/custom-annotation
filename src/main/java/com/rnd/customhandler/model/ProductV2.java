package com.rnd.customhandler.model;

import com.rnd.customhandler.validator.NameValidation;
import com.rnd.customhandler.validator.QuantityValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductV2 {

    @NameValidation
    private String name;
    @QuantityValidation
    private String quantity;

}
