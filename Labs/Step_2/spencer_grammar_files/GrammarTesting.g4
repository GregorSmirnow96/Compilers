grammar GrammarTesting;

test: IDENTIFIER;


IDENTIFIER: LETTER ALPHANUMERIC*;
INTLITERAL: DIGIT+;
FLOATLITERAL: DIGIT* '.' DIGIT+;
STRINGLITERAL: '"' ~["]* '"';
COMMENT: '--' ~['']* [\n];

DIGIT: [0-9];
ALPHANUMERIC: [a-zA-Z0-9];
LETTER: [a-zA-Z];

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines