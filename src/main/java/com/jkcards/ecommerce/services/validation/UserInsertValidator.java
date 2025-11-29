package com.jkcards.ecommerce.services.validation;

import java.util.ArrayList;
import java.util.List;
import com.jkcards.ecommerce.DTO.UserInsertDTO;
import com.jkcards.ecommerce.exceptions.FieldMessage;
import com.jkcards.ecommerce.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.jkcards.ecommerce.entities.User;


public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {
    // UserInsertValid -> tipo da minha anotação, para funcionar eu tenho que colocar essa anotação na minha classe que vai receber a verificação
    // UsertInsertDTO  -> nome da clssae que vai receber essa anotação

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

        // lista que recebe os erros
        List<FieldMessage> list = new ArrayList<>();

        //FindByEmail -> metodo que procura o email no eu banco
        User user = repository.findByEmail(dto.getEmail());

        if(user != null) {
            list.add(new FieldMessage("Email", "Email ja existe"));
        }

        // adiciona o erro na minha lista do bean validation
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
