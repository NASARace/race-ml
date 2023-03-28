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

package gov.nasa.race.ml;

import java.util.Arrays;

import org.tensorflow.TensorFlow;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.ndarray.IntNdArray;
import org.tensorflow.ndarray.NdArrays;
import org.tensorflow.types.TInt32;

public class HelloJavaTensorFlow {

    public static void main(String[] args) {
        System.out.println("Hello TensorFlow " + TensorFlow.version());

        IntNdArray matrix = NdArrays.ofInts(Shape.of(3, 2, 4));

        matrix.elements(0).forEach(m -> {
            m.set(NdArrays.vectorOf(1, 2, 3, 4), 0)
                    .set(NdArrays.vectorOf(5, 6, 7, 8), 1);
        });

        TInt32 tensor = TInt32.tensorOf(matrix);

        System.out.println("--- Matrix tensor ---");
        System.out.println("Data Type: " + tensor.dataType().name());
        System.out.println("Rank: " + tensor.shape().size());
        System.out.println("Shape: " + Arrays.toString(tensor.shape().asArray()));
        System.out.println("the (2,1,3) element: " + tensor.getInt(2, 1, 3));
    }
}
