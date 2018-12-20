/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.artemis.services.powchain;
import tech.pegasys.artemis.factories.EventBusFactory;
import tech.pegasys.artemis.pow.ValidatorRegistrationClient;
import tech.pegasys.artemis.services.ServiceInterface;

import com.google.common.eventbus.EventBus;



public class PowchainService implements ServiceInterface {

    private final EventBus eventBus;
    private final ValidatorRegistrationClient vrc;

    public PowchainService(){
        this.eventBus = EventBusFactory.getInstance();
        this.vrc = new ValidatorRegistrationClient(eventBus);
    }

    @Override
    public void init(){
        this.eventBus.register(this);
    }

    @Override
    public void start(){
        this.vrc.listenToPoWChain();
    }

    @Override
    public void stop(){

    }
}
