## RACE-ML

The purpose of this project is to bring machine learning capabilities to [RACE](http://nasarace.github.io/race/).

## Installing RACE-ML

### RACE 

The RACE project is on GitHub, and can be downloaded by running the following command.

`git clone https://github.com/NASARace/race.git`

Then, to build RACE, run the `sbt` command from the RACE root directory as follows. 

`cd race`

`sbt`

After building RACE, execute the `publishLocal` command from within 
the SBT console as follows to publish RACE to `/.ivy2/local/`, 
accessible by RACE-ML.

`sbt:race-ml> publishLocal`

More details on how to build RACE can be found at http://nasarace.github.io/race/installation/build.html.

### RACE-ML

The RACE project is also on GitHub, and can be downloaded by the following command.

`git clone https://github.com/NASARace/race-ml.git`

To build RACE-ML, run the `sbt` command from within the RACE-ML directory as follows.

`cd race-ml`

`sbt`

Then, execute the `compile` command from within the SBT console to compile
the code.

`sbt:race-ml> compile`

## Running HelloTensorFlow

To run the `HelloTensorFlow` example, run the following from within the RACE-ML
directory.

`cd race-ml`

`sbt`

`sbt:race-ml> runMain gov.nasa.race.ml.HelloTensorFlow`