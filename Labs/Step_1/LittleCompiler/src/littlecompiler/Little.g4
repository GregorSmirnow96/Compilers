grammar Little;

/* Parsing rules */

string_literal: STRING_LITERAL;






/* Lexing */

DIGIT: [0-9];
ALPHANUMERIC: [a-zA-Z0-9];
LETTER: [a-zA-Z];

IDENTIFIER: LETTER ALPHANUMERIC*;
INT_LITERAL: DIGIT+;
FLOAT_LITERAL: DIGIT* '.' DIGIT+;
STRING_LITERAL: '"' ~["]* '"';
COMMENT: '--' ~['']* [\n];
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines



// Keywords

PROGRAM		: 'PROGRAM' ;
BEGIN		: 'BEGIN' ;
END			: 'END' ;
FUNCTION	: 'FUNCTION' ;
READ		: 'READ' ;
WRITE		: 'WRITE' ;

IF			: 'IF' ;
ELSE		: 'ELSE' ;
ENDIF		: 'ENDIF' ;
WHILE		: 'WHILE' ;
ENDWHILE	: 'ENDWHILE' ;
CONTINUE	: 'CONTINUE' ;
BREAK		: 'BREAK' ;

RETURN		: 'RETURN' ;
INT			: 'INT' ;
VOID		: 'VOID' ;
STRING		: 'STRING' ;
FLOAT		: 'FLOAT' ;



// Operators

SET_TO						: ':=' ;
PLUS						: '+' ;
MINUS						: '-' ;
MULTIPLY					: '*' ;
DIVIDE						: '/' ;
EQUALS						: '=' ;
NOT_EQUALS					: '!=' ;
LESS_THAN					: '<' ;
GREATER_THAN				: '>' ;
OPEN_PARENTHESES			: '(' ;
CLOSE_PARENTHESES			: ')' ;
END_STATEMENT				: ';' ;
COMMA						: ',' ;
LESS_THAN_OR_EQUAL_TO		: '<=' ;
GREATER_THAN_OR_EQUAL_TO	: '>=' ;