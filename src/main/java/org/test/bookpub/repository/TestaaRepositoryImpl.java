package org.test.bookpub.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.test.bookpub.dao.TestaaMapper;
import org.test.bookpub.entity.Testaa;

/**
 * Created by zhangxingxing on 16/9/12.
 */
@Repository
public class TestaaRepositoryImpl implements TestaaRepository {

    @Autowired
    private TestaaMapper testaaMapper;


    @Override
    public Testaa findById(Long id) {
        return testaaMapper.findById(id);
    }
}
