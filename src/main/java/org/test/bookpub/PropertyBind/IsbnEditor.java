package org.test.bookpub.PropertyBind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * Created by zhangxingxing on 16/9/12.
 */
public class IsbnEditor extends PropertyEditorSupport {

    private final Logger logger = LoggerFactory.getLogger(IsbnEditor.class);

    @Override
    public void setValue(Object value) {
        logger.info("pp"+value.toString());
        super.setValue(value);
    }

    @Override
    public Object getValue() {
        Object result = super.getValue();
        logger.info(result.toString());
        return super.getValue();
    }
}
