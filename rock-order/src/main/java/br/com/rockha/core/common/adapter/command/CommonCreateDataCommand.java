package br.com.rockha.core.common.adapter.command;


import java.util.Set;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class CommonCreateDataCommand {
    // Método genérico de validação usando Bean Validation
    public void validate() {
       var validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<CommonCreateDataCommand>> violations = validator.validate(this);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<CommonCreateDataCommand> violation : violations) {
                sb.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new IllegalArgumentException("Erro de validação: \n" + sb.toString());
        }
    }
}