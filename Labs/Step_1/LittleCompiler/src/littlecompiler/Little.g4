grammar Little;

/* Parsing rules */

string_literal: STRING_LITERAL;






/* Lexing */

KEYWORD		: 'PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'READ' | 'WRITE' |
              'IF' | 'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' |
              'BREAK' | 'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT' ;

OPERATOR	: ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' |
              ')' | ';' | ',' | '<=' | '>=' ;
              
IDENTIFIER: LETTER ALPHANUMERIC*;
INTLITERAL: DIGIT+;
FLOATLITERAL: DIGIT* '.' DIGIT+;
STRINGLITERAL: '"' ~["]* '"';
COMMENT: '--' ~['\n']* '\n' -> skip ; // skips comments
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

DIGIT: [0-9];
ALPHANUMERIC: [a-zA-Z0-9];
LETTER: [a-zA-Z];