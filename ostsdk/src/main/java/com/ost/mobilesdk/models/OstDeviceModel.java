/*
 * Copyright 2019 OST.com Inc
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package com.ost.mobilesdk.models;

import com.ost.mobilesdk.models.entities.OstDevice;

public interface OstDeviceModel extends OstBaseModel {
    @Override
    OstDevice getEntityById(String id);

    @Override
    OstDevice[] getEntitiesByParentId(String id);
}