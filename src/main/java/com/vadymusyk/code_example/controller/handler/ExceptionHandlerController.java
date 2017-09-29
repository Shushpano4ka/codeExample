package com.vadymusyk.code_example.controller.handler;

import com.vadymusyk.code_example.dto.exception.ExceptionDTO;
import com.vadymusyk.code_example.exception.functional.CategoryAppropriationException;
import com.vadymusyk.code_example.exception.functional.NotFullDepartmentInfoException;
import com.vadymusyk.code_example.exception.functional.comment.DepartmentCommentingException;
import com.vadymusyk.code_example.exception.functional.rating.UsersVoteForDepartmentException;
import com.vadymusyk.code_example.exception.measurements.PhoneNumberException;
import com.vadymusyk.code_example.exception.security.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({EntityNotFoundException.class, EntityExistsException.class})
    public ResponseEntity<ExceptionDTO> EntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> SQLException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> EmptyResultDataAccessException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<String> TransactionSystemException(Exception ex) {
        return new ResponseEntity<>(ex.getCause().getCause().getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordRecoveryException.class)
    public ResponseEntity<ExceptionDTO> PasswordRecoveryException(Exception e) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(HttpStatus.FAILED_DEPENDENCY)
                .message(e.getMessage())
                .build()
                , HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler({TokenExpiredException.class, AccessToDepartmentDenied.class, AccessDeniedException.class,
            UserAlreadyExistsException.class})
    public ResponseEntity<ExceptionDTO> ForbiddenException(Exception e) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(HttpStatus.FORBIDDEN)
                .message(e.getMessage())
                .build()
                , HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({PhoneNumberException.class, CategoryAppropriationException.class, DataIntegrityViolationException.class,
            DifferentPasswordException.class, UserRegistrationException.class, ModeratorActivationException.class})
    public ResponseEntity<ExceptionDTO> ConflictException(Exception e) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(HttpStatus.CONFLICT)
                .message(e.getMessage())
                .build()
                , HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFullDepartmentInfoException.class)
    public ResponseEntity<ExceptionDTO> NotFullDepartmentInfoException(NotFullDepartmentInfoException e) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(HttpStatus.CONFLICT)
                .message(e.getMessage())
                .reason(e.getReason())
                .build()
                , HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DepartmentCommentingException.class)
    public ResponseEntity<ExceptionDTO> DepartmentCommentingException(DepartmentCommentingException e) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(HttpStatus.CONFLICT)
                .message(e.getMessage())
                .reason(e.getReason())
                .build()
                , HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsersVoteForDepartmentException.class)
    public ResponseEntity<ExceptionDTO> DepartmentCommentingException(UsersVoteForDepartmentException e) {
        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(HttpStatus.CONFLICT)
                .message(e.getMessage())
                .build()
                , HttpStatus.CONFLICT);
    }

}