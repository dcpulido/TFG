/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.visitor;

import javacc.parser.ast.CompilationUnit;
import javacc.parser.ast.ImportDeclaration;
import javacc.parser.ast.Node;
import javacc.parser.ast.TypeParameter;
import javacc.parser.ast.body.AnnotationDeclaration;
import javacc.parser.ast.body.AnnotationMemberDeclaration;
import javacc.parser.ast.body.ClassOrInterfaceDeclaration;
import javacc.parser.ast.body.ConstructorDeclaration;
import javacc.parser.ast.body.EmptyMemberDeclaration;
import javacc.parser.ast.body.EmptyTypeDeclaration;
import javacc.parser.ast.body.EnumConstantDeclaration;
import javacc.parser.ast.body.EnumDeclaration;
import javacc.parser.ast.body.FieldDeclaration;
import javacc.parser.ast.body.InitializerDeclaration;
import javacc.parser.ast.body.MethodDeclaration;
import javacc.parser.ast.body.Parameter;
import javacc.parser.ast.body.VariableDeclarator;
import javacc.parser.ast.body.VariableDeclaratorId;
import javacc.parser.ast.expr.ArrayAccessExpr;
import javacc.parser.ast.expr.ArrayCreationExpr;
import javacc.parser.ast.expr.ArrayInitializerExpr;
import javacc.parser.ast.expr.AssignExpr;
import javacc.parser.ast.expr.BinaryExpr;
import javacc.parser.ast.expr.CastExpr;
import javacc.parser.ast.expr.ClassExpr;
import javacc.parser.ast.expr.ConditionalExpr;
import javacc.parser.ast.expr.EnclosedExpr;
import javacc.parser.ast.expr.FieldAccessExpr;
import javacc.parser.ast.expr.InstanceOfExpr;
import javacc.parser.ast.expr.LiteralExpr;
import javacc.parser.ast.expr.MarkerAnnotationExpr;
import javacc.parser.ast.expr.MemberValuePair;
import javacc.parser.ast.expr.MethodCallExpr;
import javacc.parser.ast.expr.NameExpr;
import javacc.parser.ast.expr.NormalAnnotationExpr;
import javacc.parser.ast.expr.ObjectCreationExpr;
import javacc.parser.ast.expr.QualifiedNameExpr;
import javacc.parser.ast.expr.SingleMemberAnnotationExpr;
import javacc.parser.ast.expr.SuperExpr;
import javacc.parser.ast.expr.SuperMemberAccessExpr;
import javacc.parser.ast.expr.ThisExpr;
import javacc.parser.ast.expr.UnaryExpr;
import javacc.parser.ast.expr.VariableDeclarationExpr;
import javacc.parser.ast.stmt.AssertStmt;
import javacc.parser.ast.stmt.BlockStmt;
import javacc.parser.ast.stmt.BreakStmt;
import javacc.parser.ast.stmt.CatchClause;
import javacc.parser.ast.stmt.ContinueStmt;
import javacc.parser.ast.stmt.DoStmt;
import javacc.parser.ast.stmt.EmptyStmt;
import javacc.parser.ast.stmt.ExplicitConstructorInvocationStmt;
import javacc.parser.ast.stmt.ExpressionStmt;
import javacc.parser.ast.stmt.ForStmt;
import javacc.parser.ast.stmt.ForeachStmt;
import javacc.parser.ast.stmt.IfStmt;
import javacc.parser.ast.stmt.LabeledStmt;
import javacc.parser.ast.stmt.ReturnStmt;
import javacc.parser.ast.stmt.SwitchEntryStmt;
import javacc.parser.ast.stmt.SwitchStmt;
import javacc.parser.ast.stmt.SynchronizedStmt;
import javacc.parser.ast.stmt.ThrowStmt;
import javacc.parser.ast.stmt.TryStmt;
import javacc.parser.ast.stmt.TypeDeclarationStmt;
import javacc.parser.ast.stmt.WhileStmt;
import javacc.parser.ast.type.ClassOrInterfaceType;
import javacc.parser.ast.type.PrimitiveType;
import javacc.parser.ast.type.ReferenceType;
import javacc.parser.ast.type.VoidType;
import javacc.parser.ast.type.WildcardType;

/**
 * @author Julio Vilmar Gesser
 */
public interface GenericVisitor<R, A> {

    public R visit(Node n, A arg);

    //- Compilation Unit ----------------------------------

    public R visit(CompilationUnit n, A arg);

    public R visit(ImportDeclaration n, A arg);

    public R visit(TypeParameter n, A arg);

    //- Body ----------------------------------------------

    public R visit(ClassOrInterfaceDeclaration n, A arg);

    public R visit(EnumDeclaration n, A arg);

    public R visit(EmptyTypeDeclaration n, A arg);

    public R visit(EnumConstantDeclaration n, A arg);

    public R visit(AnnotationDeclaration n, A arg);

    public R visit(AnnotationMemberDeclaration n, A arg);

    public R visit(FieldDeclaration n, A arg);

    public R visit(VariableDeclarator n, A arg);

    public R visit(VariableDeclaratorId n, A arg);

    public R visit(ConstructorDeclaration n, A arg);

    public R visit(MethodDeclaration n, A arg);

    public R visit(Parameter n, A arg);

    public R visit(EmptyMemberDeclaration n, A arg);

    public R visit(InitializerDeclaration n, A arg);

    //- Type ----------------------------------------------

    public R visit(ClassOrInterfaceType n, A arg);

    public R visit(PrimitiveType n, A arg);

    public R visit(ReferenceType n, A arg);

    public R visit(VoidType n, A arg);

    public R visit(WildcardType n, A arg);

    //- Expression ----------------------------------------

    public R visit(ArrayAccessExpr n, A arg);

    public R visit(ArrayCreationExpr n, A arg);

    public R visit(ArrayInitializerExpr n, A arg);

    public R visit(AssignExpr n, A arg);

    public R visit(BinaryExpr n, A arg);

    public R visit(CastExpr n, A arg);

    public R visit(ClassExpr n, A arg);

    public R visit(ConditionalExpr n, A arg);

    public R visit(EnclosedExpr n, A arg);

    public R visit(FieldAccessExpr n, A arg);

    public R visit(InstanceOfExpr n, A arg);

    public R visit(LiteralExpr n, A arg);

    public R visit(MethodCallExpr n, A arg);

    public R visit(NameExpr n, A arg);

    public R visit(ObjectCreationExpr n, A arg);

    public R visit(QualifiedNameExpr n, A arg);

    public R visit(SuperMemberAccessExpr n, A arg);

    public R visit(ThisExpr n, A arg);

    public R visit(SuperExpr n, A arg);

    public R visit(UnaryExpr n, A arg);

    public R visit(VariableDeclarationExpr n, A arg);

    public R visit(MarkerAnnotationExpr n, A arg);

    public R visit(SingleMemberAnnotationExpr n, A arg);

    public R visit(NormalAnnotationExpr n, A arg);

    public R visit(MemberValuePair n, A arg);

    //- Statements ----------------------------------------

    public R visit(ExplicitConstructorInvocationStmt n, A arg);

    public R visit(TypeDeclarationStmt n, A arg);

    public R visit(AssertStmt n, A arg);

    public R visit(BlockStmt n, A arg);

    public R visit(LabeledStmt n, A arg);

    public R visit(EmptyStmt n, A arg);

    public R visit(ExpressionStmt n, A arg);

    public R visit(SwitchStmt n, A arg);

    public R visit(SwitchEntryStmt n, A arg);

    public R visit(BreakStmt n, A arg);

    public R visit(ReturnStmt n, A arg);

    public R visit(IfStmt n, A arg);

    public R visit(WhileStmt n, A arg);

    public R visit(ContinueStmt n, A arg);

    public R visit(DoStmt n, A arg);

    public R visit(ForeachStmt n, A arg);

    public R visit(ForStmt n, A arg);

    public R visit(ThrowStmt n, A arg);

    public R visit(SynchronizedStmt n, A arg);

    public R visit(TryStmt n, A arg);

    public R visit(CatchClause n, A arg);

}
