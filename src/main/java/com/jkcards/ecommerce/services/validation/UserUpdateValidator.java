package com.jkcards.ecommerce.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.jkcards.ecommerce.DTO.UserUpdateDTO;
import com.jkcards.ecommerce.entities.User;
import com.jkcards.ecommerce.exceptions.FieldMessage;
import com.jkcards.ecommerce.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

    // através do http eu consigo pegar as informações da requisição, ou seja o numero
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        // usei essa anotação pra tira o warning
        @SuppressWarnings("unchecked")
        //pegar as informações da uri
        var uriVars = (Map<String,String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        //pegando o id passado na minha uri
        long userId = Long.parseLong(uriVars.get("/{id}"));

        List<FieldMessage> list = new ArrayList<>();

        User user = repository.findByEmail(dto.getEmail());

        if(user != null && userId != user.getId()) {
            list.add(new FieldMessage("Email", "Email ja existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
