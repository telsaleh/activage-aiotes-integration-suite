/*
 * Copyright (C) 2018 te0003
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.activage.leeds.producer.client.ngsi;


import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

public class AccessResourceFilesTest {

  @Test
  public void testHello() {

	  String result = getFile("model/ngsi_v2/example/create_entity.json");
	  System.out.println(result);

  }
	
  String getFile(String fileName){
		
	  String result = "";
		
	  ClassLoader classLoader = getClass().getClassLoader();
	  try {
          //noinspection deprecation
          result = IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream(fileName)));
	  } catch (IOException e) {
		e.printStackTrace();
	  }
		
	  return result;
		
  }
}
