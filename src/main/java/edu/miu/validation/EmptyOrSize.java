package edu.miu.validation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@NotEmpty()
@Size
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface EmptyOrSize {
    String message() default "Must be a value and the right size";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
    @OverridesAttribute(constraint=Size.class, name="min")
    int min() default 2;
    @OverridesAttribute(constraint=Size.class, name="max")
    int max() default 20;

}
