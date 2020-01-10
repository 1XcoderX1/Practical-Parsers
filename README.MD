# Practical Parser in JAVA
## This repository is the implementation of a practical parser, done in two parts -
* A Top Down parser
* A Bottom up parser

### Part 1: Top Down Parsers
This unambiguous context-free grammar for a subset of arithmetic expressions was used to create the parser grammar:

E → E + T | T

T → T * F | F

F → (E) | a

A hand coded recursive descent parser was developed for this language.

Then, the grammar was modified into this left factored version using a parsing table to develop a predictive parser:

E →  T E′

E′ →  + T E′ | ε

T →  F T′

T ′ →  ∗ F T′ | ε

F →  ( E ) | a

#### Parsing table

|    | (        | a        | )       | +          |  *         |
|----|----------|----------|---------|------------|------------|
| E  | E -> TE' | E -> TE' |         |            |            |
| E' |          |          | E' -> ε | E' -> +TE' |            |
| T  | T -> FT' | T -> FT' |         |            |            |
| T' |          |          | T' -> ε | T' -> ε    | T' -> *FT' |
| F  | F -> (E) | F -> a   |         |            |            |

For this predictive parser, a tokeniser was coded by hand. The parser recognises valid strings and rejects invalid ones. The parser also prints the parse tree, if the string was valid and evaluates the expressions input.


### Part 2: Bottom-Up Parser
The following grammar was used for the parser:

E → E + T | E - T | T

T → T * F | T / F | F

F → (E) | INT | ID

Where INT and ID are integers and standard programming-language variable names respectively. JCup was used to implement a bottom-up parser for this language.

The lexical analyser developed in the first was used for this parser. It recognises valid and invalid strings and prints a parser tree for the same. It also evaluates expressions.
