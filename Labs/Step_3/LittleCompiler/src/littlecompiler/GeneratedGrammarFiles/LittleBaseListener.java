package littlecompiler.GeneratedGrammarFiles;

// Generated from Little.g4 by ANTLR 4.7.1

import java.util.ArrayList;
import littlecompiler.IterableStackAdapter;
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
    public final IterableStackAdapter<SymbolTable> symbolTables =
        new IterableStackAdapter<>(new ArrayList<>());
    private int currentBlockCount = 0;
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterProgram(LittleParser.ProgramContext ctx)
    {
        this.symbolTables.push(new SymbolTable("GLOBAL"));
    }
        
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(LittleParser.ProgramContext ctx)
    {
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
        SymbolTable currentScopeTable = this.symbolTables.peek();
        
        ParseTree stringNameNode = ctx.children.get(1);
        String stringName = stringNameNode.getText();
        currentScopeTable.addSymbol(
            new Symbol(
                stringName,
                ESymbolType.VAR,
                ESymbolAttribute.STRING));
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitString_decl(LittleParser.String_declContext ctx)
    {
        
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
        SymbolTable currentScopeTable = this.symbolTables.peek();
        
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
            currentScopeTable.addSymbol(
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
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_decl_list(LittleParser.Param_decl_listContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParam_decl(LittleParser.Param_declContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParam_decl(LittleParser.Param_declContext ctx)
    {
        
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
        String functionName = ctx.children.get(0).getChild(2).getText();
        String returnTypeString = ctx
            .children
            .get(0)
            .getChild(1)
            .getText();
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
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunc_decl(LittleParser.Func_declContext ctx)
    {
        
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFunc_body(LittleParser.Func_bodyContext ctx)
    {
        
    }
    
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFunc_body(LittleParser.Func_bodyContext ctx)
    {
        this.symbolTables.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStmt_list(LittleParser.Stmt_listContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStmt_list(LittleParser.Stmt_listContext ctx)
    {
        
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
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAssign_expr(LittleParser.Assign_exprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterRead_stmt(LittleParser.Read_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitRead_stmt(LittleParser.Read_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterWrite_stmt(LittleParser.Write_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWrite_stmt(LittleParser.Write_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterReturn_stmt(LittleParser.Return_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitReturn_stmt(LittleParser.Return_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr(LittleParser.ExprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr(LittleParser.ExprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_prefix(LittleParser.Expr_prefixContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_prefix(LittleParser.Expr_prefixContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFactor(LittleParser.FactorContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFactor(LittleParser.FactorContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterFactor_prefix(LittleParser.Factor_prefixContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitFactor_prefix(LittleParser.Factor_prefixContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterPostfix_expr(LittleParser.Postfix_exprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPostfix_expr(LittleParser.Postfix_exprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCall_expr(LittleParser.Call_exprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCall_expr(LittleParser.Call_exprContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr_list(LittleParser.Expr_listContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr_list(LittleParser.Expr_listContext ctx)
    {
        
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
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitPrimary(LittleParser.PrimaryContext ctx)
    {
        
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
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitIf_stmt(LittleParser.If_stmtContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterElse_part(LittleParser.Else_partContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitElse_part(LittleParser.Else_partContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterCond(LittleParser.CondContext ctx)
    {
        
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitCond(LittleParser.CondContext ctx)
    {
        
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
        /* Create this block's symbol table */
        currentBlockCount++;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitWhile_stmt(LittleParser.While_stmtContext ctx)
    {
        
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
}