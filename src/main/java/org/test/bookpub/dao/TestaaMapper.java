package org.test.bookpub.dao;

import org.test.bookpub.annotation.MapperType;
import org.test.bookpub.entity.Testaa;

/**
 * Created by zhangxingxing on 16/9/12.
 */
@MapperType
public interface TestaaMapper {

   Testaa findById(Long id);

}
