# Practical Parsers for a compiler
This repository is the implementation of a practical parser, done in two parts -
* A Top Down parser
* A Bottom up parser

The folder structure of the files is as follows  -

    -practical-parsers-for-a-compiler

    ------.git
    ------.metadata
    ------.recommenders
    ------jflex1.7.0
    ------practicalparsers
      ------.settings
      ------bin
      ------src
            ------partone
                  ------ Files for part one
            ------parttwo
                  ------jflex
                  ------jcup
                  ------Other files for part two
    ------.README.MD


## Part 1 : Top Down Parser

The following unambiguous context-free grammar has been provided -

E → E + T | T

T → T * F | F

F → (E) | a

The code inside the partone folder is for this part. The input is first tokenized using a hand-coded lexer. There should be exactly one space between the input characters,
for example - ( 5 + 8 * 9 ).

The parser is called on the input (tokenized). It parses the input according to the grammar. For the second part, as the input language is left-recursive, the following grammar was used to remove left-recursion to build the parser -

E  →  T E'

E' →  + T E' | e

T  →  F T'

T' →  * F T' | e

F  →  (E) | a

* e  = epsilon and 'a' has been replaced to INT in the code.


The system checks if the input is valid and reports if it is not valid. If the input is valid, the parsed input is used to print put a full parse tree for the expression.  

For example, for input, (6 * 5 + 2). the tree is as follows -



 \--F

    |--(

    |--E

    |    |--T

    |    |    |--F

    |    |    |   \--int

    |    |   \--T'

    |    |       |--*

    |    |       |--F

    |    |       |   \--int

    |    |       \--T'

    |    |           \--e

    |   \--E'

    |       |--+

    |       |--T

    |       |    |--F

    |       |    |   \--int

    |       |   \--T'

    |       |       \--e

    |       \--E'

    |           \--e

    \--)


To test the code, please run the Main.java file in the partone folder and enter the expression to parse with one space between each character. The program will first show if the input is valid, and if it is, the parse tree is printed. Use of the eclipse IDE is recommended.

## Part Two: Bottom Up Parser

The following grammar is given -

E → E + T | E - T | T

T → T * F | T / F | F

F → (E) | INT | ID

Java, JCup and JFlex has been used for this part. A lexer is generated using JFlex. The structure and details of the lexer are stored in the lexer.flex file in the jflex folder in the parttwo folder. This file is used by the JFlex .jar file to generate the java class file which is used to lex the input. The parser is created using JCup. The structure of this parser is defined in the 'parser.cup' file which is used by the JCup .jar file to create the java class file which is used to parse the input.

To create the binary tree for this exercise, token classes are written which are in the parsertokens folder inside the jcup folder. They are used to create a node structure for the input, and then parsed to create a tree from them.

For Example -

For the input ((5 + 2) / (2 * 7) * (8 - 10)), the output tree is as follows -


 \-- E

    \-- T

        \-- F

            |-- (

            |-- E

            |   \-- T

            |       |-- T

            |       |   |-- T

            |       |   |   \-- F

            |       |   |       |-- (

            |       |   |       |-- E

            |       |   |       |   |-- E

            |       |   |       |   |   \-- T


            |       |   |       |   |       \-- F

            |       |   |       |   |           \-- INT

            |       |   |           |-- +

            |       |   |       |   \-- T

            |       |   |       |       \-- F

            |       |   |       |           \-- INT

            |       |   |       \-- )

            |           |-- /

            |       |   \-- F

            |       |       |-- (

            |       |       |-- E

            |       |       |   \-- T

            |       |       |       |-- T

            |       |       |       |   \-- F

            |       |       |       |       \-- INT

            |       |       |       \-- *

            |       |       |       \-- F

            |       |       |           \-- INT

            |       |       \-- )

            |       \-- *

            |       \-- F

            |           |-- (

            |           |-- E

            |           |   |-- E

            |           |   |   \-- T

            |           |   |       \-- F

            |           |   |           \-- INT

            |           |-- -

            |           |   |-- T

            |           |   |   \-- F

            |           |   |       \-- INT

            |           |   \-- T

            |           |       \-- F

            |           |           \-- INT

            |           \-- )

            \-- )




The input should be put in the InputFile.txt file in the parttwo folder. The create.bat files can be used to create the java files from the jar files in each JCup and the JFlex folder. Alternatively, the commands inside the bat files can be executed on the command line to creacte the JAVA files.
After the JAVA files are created, write the input in the text file and then run Main.java, The console will print the corresponding parse tree for the input. Again, use of Eclipse IDE is recommended.
