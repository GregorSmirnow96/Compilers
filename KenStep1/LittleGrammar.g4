// Define a grammar called Little
grammar LittleGrammar;



r: STRINGLIT;

D:          [0-9];              // digit
AN:         [a-zA-Z0-9];        // alphanumeric
ID:         [a-zA-Z]AN*;        // identifier
INTLIT:     D+;                 // integer literal
FLOATLIT:   D*.D+;              // float literal
STRINGLIT:  '"' ~['']* '"';     // string literal
COMMENT:    '--'~['']* '\n';    // comment
WS:         [ \t\r\n]+ -> skip; // skip spaces, tabs, newlines


// Keywords

PROGRAM:    'program';
BEGIN:      'begin';
END:        'end';
FUNCTION:   'function';
READ:       'read';
WRITE:      'write';
IF:         'if';
ELSE:       'else';
ENDIF:      'endif';
WHILE:      'while';
ENDWHILE:   'endwhile';
CONTINUE:   'continue';
BREAK:      'break';
RETURN:     'return';
INT:        'int';
VOID:       'void';
STRING:     'string';
FLOAT:      'float';


// Operators

ASSIGNMENT:     ':=';
ADD:            '+';
SUBTRACT:       '-';


MULTIPLY:       '*';
DEVIDE:         '/';
EQUALS:         '=';
NOTEQUAL:       '!=';
LESSTHAN:       '<';
GREATERTHAN:    '>';
OPENPAREN:      '(';
CLOSEPAREN:     ')';
SEMICOLON:      ';';
COLON:          ',';
LESSEQUAL:      '<=';
GREATEREQUAL:   '>=';