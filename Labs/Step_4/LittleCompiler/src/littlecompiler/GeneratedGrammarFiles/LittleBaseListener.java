package littlecompiler.GeneratedGrammarFiles;

// Generated from Little.g4 by ANTLR 4.7.1

import AbstractSyntaxTree.AST;
import AbstractSyntaxTree.Nodes.AssignNode;
import AbstractSyntaxTree.Nodes.BeginFunctionNode;
import AbstractSyntaxTree.Nodes.ConditionNode;
import AbstractSyntaxTree.Nodes.DeclarationNode;
import AbstractSyntaxTree.Nodes.ElseNode;
import AbstractSyntaxTree.Nodes.EndFunctionNode;
import AbstractSyntaxTree.Nodes.FloatLiteralNode;
import AbstractSyntaxTree.Nodes.FunctionCallNode;
import AbstractSyntaxTree.Nodes.Operators.DivideNode;
import AbstractSyntaxTree.Nodes.FunctionNode;
import AbstractSyntaxTree.Nodes.IfNode;
import AbstractSyntaxTree.Nodes.InputParameterListNode;
import AbstractSyntaxTree.Nodes.InputParameterNode;
import AbstractSyntaxTree.Nodes.IntLiteralNode;
import AbstractSyntaxTree.Nodes.Operators.EqualNode;
import AbstractSyntaxTree.Nodes.Operators.GreaterThanNode;
import AbstractSyntaxTree.Nodes.Operators.GreaterThanOrEqualToNode;
import AbstractSyntaxTree.Nodes.Operators.LessThanNode;
import AbstractSyntaxTree.Nodes.Operators.LessThanOrEqualToNode;
import AbstractSyntaxTree.Nodes.Operators.MinusNode;
import AbstractSyntaxTree.Nodes.Operators.MultiplyNode;
import AbstractSyntaxTree.Nodes.Operators.NotEqualNode;
import AbstractSyntaxTree.Nodes.Operators.PlusNode;
import AbstractSyntaxTree.Nodes.ParameterListNode;
import AbstractSyntaxTree.Nodes.ProgramNode;
import AbstractSyntaxTree.Nodes.ReadNode;
import AbstractSyntaxTree.Nodes.ReturnNode;
import AbstractSyntaxTree.Nodes.StatementListNode;
import AbstractSyntaxTree.Nodes.VariableNode;
import AbstractSyntaxTree.Nodes.WhileNode;
import AbstractSyntaxTree.Nodes.WriteNode;
import AbstractSyntaxTree.TACLine;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import littlecompiler.SymbolTableContainer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import symboltables.Symbol;
import symboltables.SymbolTable;
import symboltables.enums.ESymbolAttribute;
import symboltables.enums.ESymbolType;

/**
 * This class provides an empty implementation of {@link LittleListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class LittleBaseListener implements LittleListener
{
    public final Stack<SymbolTable> symbolTables = new Stack<>();
    private int currentBlockCount = 1;
    private AST ast;
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterProgram(LittleParser.ProgramContext ctx)
    {
        SymbolTable globalSymbolTable = new SymbolTable("GLOBAL");
        this.symbolTables.push(globalSymbolTable);
        SymbolTableContainer.getInstance().setGlobalTable(globalSymbolTable);
        this.ast = new AST(new ProgramNode());
    }
        
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(LittleParser.ProgramContext ctx)
    {
        this.ast.pop();
        List<TACLine> linesOfCode = this.ast.generate3AC();
        linesOfCode.forEach(line -> System.out.println(line.getLineText()));
    }
        
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterId(LittleParser.IdContext ctx)
    {
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitId(LittleParser.IdContext ctx)
    {
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPgm_body(LittleParser.Pgm_bodyContext ctx)
    {
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPgm_body(LittleParser.Pgm_bodyContext ctx)
    {
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterDecl(LittleParser.DeclContext ctx)
    {
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitDecl(LittleParser.DeclContext ctx)
    {
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterString_decl(LittleParser.String_declContext ctx)
    {
        /* */
        this.ast.push(new DeclarationNode());
        /* */
        
        SymbolTable currentScopeTable = this.symbolTables.peek();
        
        ParseTree stringNameNode = ctx.children.get(1);
        String stringName = stringNameNode.getText();
        Symbol stringSymbol = new Symbol(
            stringName,
            ESymbolType.VAR,
            ESymbolAttribute.STRING);
        
        ParseTree stringValueNode = ctx.children.get(3);
        String stringValue = stringValueNode.getText().replace("\"", "");
        stringSymbol.setValue(stringValue);
        
        currentScopeTable.addSymbol(stringSymbol);
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitString_decl(LittleParser.String_declContext ctx)
    {
        this.ast.pop();
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStr(LittleParser.StrContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStr(LittleParser.StrContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVar_decl(LittleParser.Var_declContext ctx)
    {
        this.ast.push(new DeclarationNode());
        
        SymbolTable currentScope = this.symbolTables.peek();
        
        ParseTree varTypeNode = ctx.children.get(0);
        String varType = varTypeNode.getText();
        ParseTree varNamesNode = ctx.children.get(1);
        String[] varNames = varNamesNode.getText().split(",");
        ESymbolAttribute symbolAttribute = varType
            .equals(ESymbolAttribute.INT.toString())
                ? ESymbolAttribute.INT
                : ESymbolAttribute.FLOAT;
        
        for (String varName : varNames)
        {
            
            if (currentScope.getSymbolByName(varName) != null)
            {
                System.out.println("DECLARATION ERROR " + varName);
                System.exit(0);
            }
            
            currentScope.addSymbol(
                new Symbol(
                    varName,
                    ESymbolType.VAR,
                    symbolAttribute));
        }
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVar_decl(LittleParser.Var_declContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVar_type(LittleParser.Var_typeContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVar_type(LittleParser.Var_typeContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAny_type(LittleParser.Any_typeContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAny_type(LittleParser.Any_typeContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterId_list(LittleParser.Id_listContext ctx)
    {
        ParseTree firstVariableTree = ctx.children.get(0);
        String firstVariableName = firstVariableTree.getText();
        this.ast.push(new VariableNode(firstVariableName));
        this.ast.pop();
        
        ParseTree followingVariablesTree = ctx.children.get(1);
        int childCount = followingVariablesTree.getChildCount();
        while (childCount > 1)
        {
            String nextVariableName = followingVariablesTree
                .getChild(1)
                .getText();
            this.ast.push(new VariableNode(nextVariableName));
            this.ast.pop();
            followingVariablesTree = followingVariablesTree.getChild(2);
            childCount = followingVariablesTree.getChildCount();
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitId_list(LittleParser.Id_listContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterId_tail(LittleParser.Id_tailContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitId_tail(LittleParser.Id_tailContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam_decl_list(LittleParser.Param_decl_listContext ctx)
    {
        this.ast.push(new InputParameterListNode());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_decl_list(LittleParser.Param_decl_listContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam_decl(LittleParser.Param_declContext ctx)
    {
        String parameterType = ctx.children.get(0).getText();
        String parameterName = ctx.children.get(1).getText();
        this.ast.push(new InputParameterNode(parameterName));
        
        SymbolTable currentScope = this.symbolTables.peek();
        
        
        currentScope.addSymbol(
            new Symbol(
                parameterName,
                ESymbolType.VAR,
                ESymbolAttribute.valueOf(parameterType)));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_decl(LittleParser.Param_declContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam_decl_tail(LittleParser.Param_decl_tailContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_decl_tail(LittleParser.Param_decl_tailContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunc_declarations(LittleParser.Func_declarationsContext ctx)
    {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunc_declarations(LittleParser.Func_declarationsContext ctx)
    {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunc_decl(LittleParser.Func_declContext ctx)
    {
        String functionName = ctx.getChild(2).getText();
        this.ast.push(new FunctionNode(functionName));
        
        String returnTypeString = ctx.getChild(1).getText();
        ESymbolAttribute returnType = ESymbolAttribute
            .valueOf(returnTypeString);
        
        SymbolTable currentScopeTable = this.symbolTables.peek();
        
        currentScopeTable.addSymbol(
            new Symbol(
                functionName,
                ESymbolType.PROCEDURE,
                returnType));
        
        SymbolTable childTable = currentScopeTable
            .getChildTableByName(functionName);
        this.symbolTables.push(childTable);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunc_decl(LittleParser.Func_declContext ctx)
    {
        this.ast.pop();
        
        this.symbolTables.pop();
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunc_body(LittleParser.Func_bodyContext ctx)
    {
        this.ast.push(new BeginFunctionNode());
        this.ast.pop();
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunc_body(LittleParser.Func_bodyContext ctx)
    {
        this.ast.push(new EndFunctionNode());
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStmt_list(LittleParser.Stmt_listContext ctx)
    {
        this.ast.push(new StatementListNode());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt_list(LittleParser.Stmt_listContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStmt(LittleParser.StmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt(LittleParser.StmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterBase_stmt(LittleParser.Base_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitBase_stmt(LittleParser.Base_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssign_stmt(LittleParser.Assign_stmtContext ctx)
    {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssign_stmt(LittleParser.Assign_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAssign_expr(LittleParser.Assign_exprContext ctx)
    {
        this.ast.push(new AssignNode());
        this.ast.push(new VariableNode(ctx.getChild(0).getText()));
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssign_expr(LittleParser.Assign_exprContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterRead_stmt(LittleParser.Read_stmtContext ctx)
    {
        this.ast.push(new ReadNode());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRead_stmt(LittleParser.Read_stmtContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWrite_stmt(LittleParser.Write_stmtContext ctx)
    {
        this.ast.push(new WriteNode());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWrite_stmt(LittleParser.Write_stmtContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterReturn_stmt(LittleParser.Return_stmtContext ctx)
    {
        String containingMethodName = this.symbolTables.peek().getName();
        this.ast.push(new ReturnNode(containingMethodName));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitReturn_stmt(LittleParser.Return_stmtContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr(LittleParser.ExprContext ctx)
    {
        boolean expressionIsAnOperation = ctx.getChildCount() == 3;
        if (expressionIsAnOperation)
        {
            String operator = ctx.children.get(1).getText();
            switch (operator)
            {
                case "+":
                    this.ast.push(new PlusNode());
                    break;
                case "-":
                    this.ast.push(new MinusNode());
                    break;
                case "*":
                    this.ast.push(new MultiplyNode());
                    break;
                case "/":
                    this.ast.push(new DivideNode());
                    break;
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr(LittleParser.ExprContext ctx)
    {
        boolean expressionIsAnOperation = ctx.getChildCount() == 3;
        if (expressionIsAnOperation)
        {
            this.ast.pop();
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCall_expr(LittleParser.Call_exprContext ctx)
    {
        this.ast.push(new FunctionCallNode(ctx.getText().replace("()", "")));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCall_expr(LittleParser.Call_exprContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_list(LittleParser.Expr_listContext ctx)
    {
        this.ast.push(new ParameterListNode());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_list(LittleParser.Expr_listContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_list_tail(LittleParser.Expr_list_tailContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_list_tail(LittleParser.Expr_list_tailContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPrimary(LittleParser.PrimaryContext ctx)
    {
        Pattern pattern = Pattern.compile("[0-9]");
        String primaryText = ctx.getText();
        Matcher matcher = pattern.matcher(ctx.getText());
        if (matcher.matches())
        {
            this.ast.push(new IntLiteralNode(Integer.parseInt(ctx.getText())));
            return;
        }
        
        pattern = Pattern.compile("[0-9][.][0-9]");
        matcher = pattern.matcher(ctx.getText());
        if (matcher.matches())
            this.ast.push(
                new FloatLiteralNode(
                    Float.parseFloat(ctx.getText())));
        else
            this.ast.push(new VariableNode(ctx.getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPrimary(LittleParser.PrimaryContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAddop(LittleParser.AddopContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAddop(LittleParser.AddopContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterMulop(LittleParser.MulopContext ctx)
    {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitMulop(LittleParser.MulopContext ctx)
    {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterIf_stmt(LittleParser.If_stmtContext ctx)
    {
        this.ast.push(new IfNode());
        
        String blockScopeName = "BLOCK " + currentBlockCount++;
        
        SymbolTable currentScope = this.symbolTables.peek();
        SymbolTable newScope = new SymbolTable(blockScopeName);
        currentScope.addChildTable(newScope);
        this.symbolTables.push(newScope);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIf_stmt(LittleParser.If_stmtContext ctx)
    {
        this.ast.pop();
        this.symbolTables.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterElse_part(LittleParser.Else_partContext ctx)
    {
        this.ast.push(new ElseNode());
        
        String blockScopeName = "BLOCK " + currentBlockCount++;
        
        SymbolTable currentScope = this.symbolTables.peek();
        SymbolTable newScope = new SymbolTable(blockScopeName);
        currentScope.addChildTable(newScope);
        this.symbolTables.push(newScope);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitElse_part(LittleParser.Else_partContext ctx)
    {
        this.ast.pop();
        this.symbolTables.pop();        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCond(LittleParser.CondContext ctx)
    {
        this.ast.push(new ConditionNode());
        String operator = ctx.children.get(1).getText();
        
        switch (operator)
        {
            case ">":
                this.ast.push(new GreaterThanNode());
                break;
            case ">=":
                this.ast.push(new GreaterThanOrEqualToNode());
                break;
            case "<":
                this.ast.push(new LessThanNode());
                break;
            case "<=":
                this.ast.push(new LessThanOrEqualToNode());
                break;
            case "=":
                this.ast.push(new EqualNode());
                break;
            case "!=":
                this.ast.push(new NotEqualNode());
                break;
            default:
                break;
        }
        
        /* Get ctx.children.get(1) and ast.push the corresponding node.
         * 
         * Implement while loops.
         * 
         * Verify StatementListNode is instantiated for functions,
         * if blocks, and while loops.
         */
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCond(LittleParser.CondContext ctx)
    {
        this.ast.pop();
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCompop(LittleParser.CompopContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCompop(LittleParser.CompopContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWhile_stmt(LittleParser.While_stmtContext ctx)
    {
        this.ast.push(new WhileNode());
        
        String blockScopeName = "BLOCK " + currentBlockCount++;
        
        SymbolTable currentScope = this.symbolTables.peek();
        SymbolTable newScope = new SymbolTable(blockScopeName);
        currentScope.addChildTable(newScope);
        this.symbolTables.push(newScope);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWhile_stmt(LittleParser.While_stmtContext ctx)
    {
        this.ast.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node)
    {
        
    }

    @Override
    public void enterAdd_minus_expression(LittleParser.Add_minus_expressionContext ctx)
    {
        boolean nodeIsAddop = ctx.getChildCount() == 3;
        if (nodeIsAddop)
        {
            String operator = ctx.children.get(1).getText();
            this.ast.push(
                operator.equals("+")
                    ? new PlusNode()
                    : new MinusNode());
        }
    }

    @Override
    public void exitAdd_minus_expression(LittleParser.Add_minus_expressionContext ctx)
    {
        boolean nodeIsAddop = ctx.getChildCount() == 3;
        if (nodeIsAddop)
            this.ast.pop();
    }

    @Override
    public void enterMultiply_divide_expression(LittleParser.Multiply_divide_expressionContext ctx)
    {
        boolean nodeIsMulop = ctx.getChildCount() == 3;
        if (nodeIsMulop)
        {
            String operator = ctx.children.get(1).getText();
            this.ast.push(
                operator.equals("*")
                    ? new MultiplyNode()
                    : new DivideNode());
        }
    }

    @Override
    public void exitMultiply_divide_expression(LittleParser.Multiply_divide_expressionContext ctx)
    {
        boolean nodeIsMulop = ctx.getChildCount() == 3;
        if (nodeIsMulop)
            this.ast.pop();
    }

    @Override
    public void enterExpression_component(LittleParser.Expression_componentContext ctx)
    {
    }

    @Override
    public void exitExpression_component(LittleParser.Expression_componentContext ctx)
    {
    }

    @Override
    public void enterStmt_list_tail(LittleParser.Stmt_list_tailContext ctx)
    {
    }

    @Override
    public void exitStmt_list_tail(LittleParser.Stmt_list_tailContext ctx)
    {
    }
}