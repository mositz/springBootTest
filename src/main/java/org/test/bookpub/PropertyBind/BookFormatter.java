package org.test.bookpub.PropertyBind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.test.bookpub.entity.Testaa;
import org.test.bookpub.repository.TestaaRepository;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by zhangxingxing on 16/9/12.
 */
public class BookFormatter implements Formatter<Testaa> {

    private TestaaRepository testaaRepository;

    @Override
    public Testaa parse(String text, Locale locale) throws ParseException {
        return testaaRepository.findById(Long.valueOf(text));
    }

    @Override
    public String print(Testaa object, Locale locale) {
        return object.getId().toString();
    }

    public void setTestaaRepository(TestaaRepository testaaRepository) {
        this.testaaRepository = testaaRepository;
    }
}
