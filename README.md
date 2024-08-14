# Swing playground
This repo purpose is to train and test my swing code.


# Pipe Wall Thickness Calculator

Going to re-create calculator already done by using python and Kivy framework. 
See repo [here](https://github.com/h4sski-programming/pipe_wall_thickness_calculator).

## Concept and conditions:

- user provide inputs and by button force calculations, 
which is going to be displayed on the window along with the inputs.
- App going to be done with using of Swing framework.


### User Inputs:

Name                    | Unit             | Comment
----                    |------------------| -------
Material                | dropdown[string] | -
DN                      | dropdown[string] | -
Wall thickness          | dropdown[int]    | -
Design temperature      | int              | -
Design pressure         | float            | -
Corrosion allowance c0  | float            | -
Thining allowance c2    | float            | -
Joint coefficient z     | dropdown[int]    | -


### Window design map:

`PipeWallThicknessCalculator.java`

Main window is `JFrame frame`.
Order of the JPanels and some classes used in this project:

```mermaid
graph TD;
A[frame] --> B[menu];
B --> C[mainPanel];
C --> D[footer];
C --> E[calcInput];
E --> F[calculatePanel];
F --> G[calculateBtn];
F --> H[calcOutput];
```


## DataBase explanation

### strengthAtTempHM

It is a nested HashMap like that: `HashMap<String, HashMap<Integer, Integer>> strengthAtTempHM`.
Explanation: HashMap<material, HashMap<tempFromTable, strengthAtTempFromTable>>.

This uses supporting values: `Integer[] temps` and `HashMap<Integer, Integer> hmAtTemp`. 
Later those values are used at for loop to combine and create the `strengthAtTempHM`.

I might go even further and create another for loop and combine `strengthAtTempHM` together with `String[] materials`.
But this would require to create a list of `strengthAtTempHM`'s.
Dong this there is a risk of combining material with incorrect strength values.