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

package info.piwai.funkyjfunctional.functionaljava;

import fj.F2;
import info.piwai.funkyjfunctional.Funky;

/**
 * A Funky {@link F2}
 * 
 * @see FunkyFunctionalJava FunkyFunctionalJava documentation
 * 
 * @author Pierre-Yves Ricau (py.ricau at gmail.com)
 */
public abstract class FF2<A, B, C> {

    protected final A inA;
    protected final B inB;

    protected C out;

    public FF2() {
        FF2Input<A, B> compared = Funky.getInput();
        inA = compared.a;
        inB = compared.b;
    }
}
