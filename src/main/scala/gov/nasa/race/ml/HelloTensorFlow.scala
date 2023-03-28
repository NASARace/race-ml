/*
 * Copyright (c) 2023, United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 *
 * The RACE - Runtime for Airspace Concept Evaluation platform is licensed
 * under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gov.nasa.race.ml

import org.tensorflow.ConcreteFunction
import org.tensorflow.Signature
import org.tensorflow.TensorFlow
import org.tensorflow.op.Ops
import org.tensorflow.types.TInt32
import scala.util.Using

/**
 * This is the Scala version of the Java example in https://www.tensorflow.org/jvm/install
 */
object HelloTensorFlow {
  def main(args: Array[String]): Unit = {
    println(s"Hello TensorFlow: ${TensorFlow.version}")

    Using(ConcreteFunction.create(HelloTensorFlow.dbl)){
      db => {
        val x = TInt32.scalarOf(10)
        val dblX = db.call(x)
        println(s"{x.getInt()} doubled is ${(dblX.asInstanceOf[TInt32]).getInt()}")
      }
    }
  }

  private def dbl(tf: Ops): Signature = {
    val x = tf.placeholder(classOf[TInt32])
    val dblX = tf.math.add(x, x)
    Signature.builder.input("x", x).output("dbl", dblX).build
  }
}

