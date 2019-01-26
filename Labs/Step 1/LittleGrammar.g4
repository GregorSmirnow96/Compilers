grammar LittleGrammar;

rule: COMMENT;

DIGIT: [0-9];
ALPHANUMERIC: [a-zA-Z0-9];
LETTER: [a-zA-Z];

IDENTIFIER: LETTER ALPHANUMERIC*;
INT_LITERAL: DIGIT+;
FLOAT_LITERAL: DIGIT* '.' DIGIT+;
STRING_LITERAL: '"' ~["]* '"';
COMMENT: '--' ~['']* [\n];

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines