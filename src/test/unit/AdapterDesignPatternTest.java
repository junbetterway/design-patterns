/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.structural.adapter.Ferrari;
import design.pattern.structural.adapter.SpeedAdapter;
import design.pattern.structural.adapter.SpeedAdapterImpl;

/**
 * 
 * @author JunMinon
 *
 */
public class AdapterDesignPatternTest {

	@Test
	public void convertMPHtoKPH() {
		
		Ferrari ferrari = new Ferrari();
		assertEquals(270.50, ferrari.getSpeed());
		
		SpeedAdapter speedAdapter = new SpeedAdapterImpl(ferrari);
		assertEquals(270.50 * 1.60934, speedAdapter.getSpeed());
		
	}
	
}
