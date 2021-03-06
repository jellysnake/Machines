/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.fluidTransport.world;


import org.terasology.fluidTransport.systems.FluidTransportAuthoritySystem;
import org.terasology.machines.world.SameNetworkByBlockBlockFamily;
import org.terasology.math.Side;
import org.terasology.math.geom.Vector3i;
import org.terasology.registry.In;
import org.terasology.world.WorldProvider;
import org.terasology.world.block.BlockBuilderHelper;
import org.terasology.world.block.family.RegisterBlockFamily;
import org.terasology.world.block.loader.BlockFamilyDefinition;

@RegisterBlockFamily("FluidTransport:FluidPumpBlock")
public class FluidPumpBlockBlockFamily extends SameNetworkByBlockBlockFamily {
    @In
    WorldProvider worldProvider;

    public FluidPumpBlockBlockFamily(BlockFamilyDefinition family, BlockBuilderHelper builderHelper) {
        super(family, builderHelper, x -> x.getNetworkId().equals(FluidTransportAuthoritySystem.NETWORK_ID));
    }

    @Override
    protected boolean connectionCondition(Vector3i blockLocation, Side connectSide) {
        boolean result = super.connectionCondition(blockLocation, connectSide);
        if( !result) {
            Vector3i targetLocation = new Vector3i(blockLocation);
            targetLocation.add(connectSide.getVector3i());
            result = worldProvider.getLiquid(targetLocation).getDepth() > 0;
        }
        return result;
    }
}
