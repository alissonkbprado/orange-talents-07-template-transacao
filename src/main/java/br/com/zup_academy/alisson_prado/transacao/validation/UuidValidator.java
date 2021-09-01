package br.com.zup_academy.alisson_prado.transacao.validation;



import br.com.zup_academy.alisson_prado.transacao.common.CheckUuid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UuidValidator implements ConstraintValidator<Uuid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return CheckUuid.isUuidValid(value);
    }
}
