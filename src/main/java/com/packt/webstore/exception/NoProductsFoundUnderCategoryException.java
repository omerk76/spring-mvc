package com.packt.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by okeynan on 4/26/15.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found under this category")
public class NoProductsFoundUnderCategoryException extends Exception {

}
