/*
 * #%L
 * BroadleafCommerce Profile
 * %%
 * Copyright (C) 2009 - 2013 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.broadleafcommerce.profile.core.service;

import org.broadleafcommerce.common.util.TransactionUtils;
import org.broadleafcommerce.profile.core.dao.PhoneDao;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("blPhoneService")
public class PhoneServiceImpl implements PhoneService {

    @Resource(name="blPhoneDao")
    protected PhoneDao phoneDao;

    @Override
    @Transactional(TransactionUtils.DEFAULT_TRANSACTION_MANAGER)
    public Phone savePhone(Phone phone) {
        return phoneDao.save(phone);
    }

    @Override
    public Phone readPhoneById(Long phoneId) {
        return phoneDao.readPhoneById(phoneId);
    }

    @Override
    public Phone create() {
        return phoneDao.create();
    }

    @Override
    public Phone copyPhone(Phone orig) {
        return copyPhone(null, orig);
    }

    @Override
    public Phone copyPhone(Phone dest, Phone orig) {
        if (dest == null) {
            dest = create();
        }

        if (orig != null) {
            dest.setPhoneNumber(orig.getPhoneNumber());
            dest.setCountryCode(orig.getCountryCode());
            dest.setExtension(orig.getExtension());
            return dest;
        }

        return null;
    }

}