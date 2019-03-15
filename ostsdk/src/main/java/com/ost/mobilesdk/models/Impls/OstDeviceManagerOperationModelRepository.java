/*
 * Copyright 2019 OST.com Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package com.ost.mobilesdk.models.Impls;

import com.ost.mobilesdk.database.OstSdkDatabase;
import com.ost.mobilesdk.database.daos.OstBaseDao;
import com.ost.mobilesdk.database.daos.OstDeviceOperationDao;
import com.ost.mobilesdk.models.OstDeviceManagerOperationModel;
import com.ost.mobilesdk.models.entities.OstDeviceManagerOperation;

class OstDeviceManagerOperationModelRepository extends OstBaseModelCacheRepository implements OstDeviceManagerOperationModel {

    private static final int LRU_CACHE_SIZE = 5;
    private OstDeviceOperationDao mMultiSigOperation;

    OstDeviceManagerOperationModelRepository() {
        super(LRU_CACHE_SIZE);
        OstSdkDatabase db = OstSdkDatabase.getDatabase();
        mMultiSigOperation = db.multiSigOperationDao();
    }


    @Override
    OstBaseDao getModel() {
        return mMultiSigOperation;
    }


    @Override
    public OstDeviceManagerOperation getEntityById(String id) {
        return (OstDeviceManagerOperation)super.getById(id);
    }

    @Override
    public OstDeviceManagerOperation[] getEntitiesByParentId(String id) {
        return (OstDeviceManagerOperation[]) super.getByParentId(id);
    }
}
