grammar TokenDefinitions;

rule: TOKEN*;

TOKEN: COMMENT | KEYWORD | IDENTIFIER | INTLITERAL | FLOATLITERAL | STRINGLITERAL | OPERATOR;

IDENTIFIER: LETTER ALPHANUMERIC*;
INTLITERAL: DIGIT+;
FLOATLITERAL: DIGIT* '.' DIGIT+;
STRINGLITERAL: '"' ~["]* '"';
COMMENT: '--' ~['\n']* [\n] -> skip;

KEYWORD: 'PROGRAM' | 'BEGIN' | 'END'| 'FUCNTION'| 'READ'| 'WRITE'| 'ELSE'| 'FI'|
         'FOR'| 'ROF'| 'RETURN'| 'INT'| 'VOID'| 'STRING'| 'FLOAT'| 'WHILE'| 'ENDIF'| 'ENDWHILE';

OPERATOR: ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' | ';' | ',' | '<=' | '>=';

DIGIT: [0-9];
ALPHANUMERIC: [a-zA-Z0-9];
LETTER: [a-zA-Z];

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

