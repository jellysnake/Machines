/*
 * Copyright 2014 MovingBlocks
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
package org.terasology.itemRendering.components;

import org.terasology.entitySystem.Component;
import org.terasology.math.Pitch;
import org.terasology.math.Roll;
import org.terasology.math.Yaw;

import javax.vecmath.Vector3f;

/**
 * Add this to a block that will display an item and it will be copied to each item that is displayed
 */
public class RenderItemComponent implements Component {
    public Vector3f translate = new Vector3f(0, 0, 0);
    public float size = 0.3f;
    public Yaw yaw = Yaw.NONE;
    public Pitch pitch = Pitch.NONE;
    public Roll roll = Roll.NONE;
}