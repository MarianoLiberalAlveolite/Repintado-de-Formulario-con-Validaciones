package org.marianola.ecoparametros.Validations;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

class DireccionIpValidator implements ConstraintValidator<DireccionIp, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern =
                Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
        Matcher matcher = pattern.matcher(value);
        try {
            if (!matcher.matches()) {
                return false;
            } else {
                for (int i = 1; i <= 4; i++) {
                    int octet = Integer.valueOf(matcher.group(i));
                    if (octet > 255) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}