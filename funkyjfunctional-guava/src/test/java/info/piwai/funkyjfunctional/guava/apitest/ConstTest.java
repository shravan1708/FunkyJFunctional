/**
 * Copyright (C) 2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.piwai.funkyjfunctional.guava.apitest;

import static info.piwai.funkyjfunctional.guava.FunkyGuava.withConst;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import info.piwai.funkyjfunctional.guava.Const;

import org.junit.Test;

import com.google.common.collect.Constraint;

/**
 * @author Pierre-Yves Ricau (py.ricau at gmail.com)
 */
public class ConstTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidInput() {
        // @off
        class NotFortyTwo extends Const<String> {{ if("42".equals(in)) invalid("Should not be 42!"); }}
        // @on
        
        Constraint<String> constraint = withConst(NotFortyTwo.class);
        
        constraint.checkElement("42");
    }

    @Test
    public void validInput() {
        // @off
        class NotFortyTwo extends Const<String> {{ if("42".equals(in)) invalid("Should not be 42!"); }}
        // @on
        
        Constraint<String> constraint = withConst(NotFortyTwo.class);
        
        constraint.checkElement("43");
    }
    
    @Test
    public void defaultReturnsSame() {
        // @off
        class Void extends Const<String> {{}}
        // @on
        
        String input = "43";
        String returned = withConst(Void.class).checkElement(input);
        assertSame(input, returned);
    }
    
    @Test
    public void mayChangeReturned() {
        // @off
        class ChangeReturn extends Const<String> {{ out = "43"; }}
        // @on
        
        String input = "42";
        String returned = withConst(ChangeReturn.class).checkElement(input);
        assertNotSame(input, returned);
    }
    
    @Test
    public void printsCorrectString() {
        // @off
        class SomeName extends Const<String> {{}}
        // @on
        
        String toStringValue = withConst(SomeName.class).toString();
        
        assertEquals("SomeName constraint", toStringValue);
    }
    
}
