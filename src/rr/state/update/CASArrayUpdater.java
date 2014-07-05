/******************************************************************************

Copyright (c) 2010, Cormac Flanagan (University of California, Santa Cruz)
                    and Stephen Freund (Williams College) 

All rights reserved.  

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.

    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the following
      disclaimer in the documentation and/or other materials provided
      with the distribution.

    * Neither the names of the University of California, Santa Cruz
      and Williams College nor the names of its contributors may be
      used to endorse or promote products derived from this software
      without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

******************************************************************************/

package rr.state.update;

import java.lang.reflect.Field;

import rr.state.AbstractArrayState;
import rr.state.ShadowVar;
import sun.misc.Unsafe;
import acme.util.Assert;
import acme.util.Util;
import acme.util.Yikes;

public class CASArrayUpdater extends AbstractArrayUpdater {

	public CASArrayUpdater() {
	}

	public ShadowVar getState(AbstractArrayState o, int index) {
		return o.getState(index);
		
	}
	public boolean putState(AbstractArrayState o, int index, ShadowVar expectedGS, ShadowVar newGS) {
		if (expectedGS == newGS) return true;
		return o.putState(index, expectedGS, newGS);
	}

//	
//	public final ShadowVar getState(Object o) {
//		return (ShadowVar) unsafe.getObject(o,  offset);
//	}
//
//	public boolean putState(Object o, ShadowVar expectedGS, ShadowVar newGS) {
//		try {
//			if (expectedGS == newGS) return true;
//			return (cas(o, expectedGS, newGS)); 
//			//{
////				Yikes.yikes("Concurrent update"); // Yikes.yikes("Concurrent update on %s: %s.  current=%s  expected=%s  new=%s", getClass(), Util.objectToIdentityString(o), getState(o), expectedGS, newGS);
////			}
////			return true;
//		} catch (ClassCastException e) {
//			Util.log(this.getClass() + " " + o.getClass());
//			Assert.fail(e);
//			return true;
//		}
//	}
}
