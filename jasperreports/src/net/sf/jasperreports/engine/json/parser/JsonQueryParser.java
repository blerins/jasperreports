// $ANTLR 2.7.5 (20050128): "json_grammar.g" -> "JsonQueryParser.java"$

/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2016 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.json.parser;

import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.NoViableAltException;
import antlr.ParserSharedInputState;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenBuffer;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.AST;
import antlr.collections.impl.ASTArray;
import antlr.collections.impl.BitSet;

/**
 * @author Narcis Marcu (narcism@users.sourceforge.net)
 */
public class JsonQueryParser extends antlr.LLkParser       implements JsonQueryParserTokenTypes
 {

protected JsonQueryParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public JsonQueryParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected JsonQueryParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public JsonQueryParser(TokenStream lexer) {
  this(lexer,2);
}

public JsonQueryParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void pathExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST pathExpr_AST = null;
		
		{
		_loop3:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
				memberExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop3;
			}
			
		} while (true);
		}
		match(Token.EOF_TYPE);
		if ( inputState.guessing==0 ) {
			pathExpr_AST = (AST)currentAST.root;
			pathExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PATH,"Path Expr:")).add(pathExpr_AST));
			currentAST.root = pathExpr_AST;
			currentAST.child = pathExpr_AST!=null &&pathExpr_AST.getFirstChild()!=null ?
				pathExpr_AST.getFirstChild() : pathExpr_AST;
			currentAST.advanceChildToEnd();
		}
		pathExpr_AST = (AST)currentAST.root;
		returnAST = pathExpr_AST;
	}
	
	public final void memberExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST memberExpr_AST = null;
		
		pathNaviExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			filterExprMain();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case DOT:
		case DOTDOT:
		case ID:
		case WILDCARD:
		case LBRACKET:
		case BACKSP:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			memberExpr_AST = (AST)currentAST.root;
			memberExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MEMBER,"Member expression:")).add(memberExpr_AST));
			currentAST.root = memberExpr_AST;
			currentAST.child = memberExpr_AST!=null &&memberExpr_AST.getFirstChild()!=null ?
				memberExpr_AST.getFirstChild() : memberExpr_AST;
			currentAST.advanceChildToEnd();
		}
		memberExpr_AST = (AST)currentAST.root;
		returnAST = memberExpr_AST;
	}
	
	public final void pathNaviExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST pathNaviExpr_AST = null;
		
		boolean synPredMatched10 = false;
		if ((((LA(1) >= DOT && LA(1) <= WILDCARD)) && (_tokenSet_1.member(LA(2))))) {
			int _m10 = mark();
			synPredMatched10 = true;
			inputState.guessing++;
			try {
				{
				{
				switch ( LA(1)) {
				case DOT:
				{
					match(DOT);
					break;
				}
				case DOTDOT:
				{
					match(DOTDOT);
					break;
				}
				case ID:
				case WILDCARD:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case ID:
				{
					match(ID);
					break;
				}
				case WILDCARD:
				{
					match(WILDCARD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				}
			}
			catch (RecognitionException pe) {
				synPredMatched10 = false;
			}
			rewind(_m10);
			inputState.guessing--;
		}
		if ( synPredMatched10 ) {
			simpleKeyExpr();
			astFactory.addASTChild(currentAST, returnAST);
			pathNaviExpr_AST = (AST)currentAST.root;
		}
		else {
			boolean synPredMatched13 = false;
			if (((LA(1)==DOTDOT||LA(1)==LBRACKET) && (LA(2)==LBRACKET||LA(2)==STRING))) {
				int _m13 = mark();
				synPredMatched13 = true;
				inputState.guessing++;
				try {
					{
					{
					switch ( LA(1)) {
					case DOTDOT:
					{
						match(DOTDOT);
						break;
					}
					case LBRACKET:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(LBRACKET);
					match(STRING);
					match(RBRACKET);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched13 = false;
				}
				rewind(_m13);
				inputState.guessing--;
			}
			if ( synPredMatched13 ) {
				complexKeyExpr();
				astFactory.addASTChild(currentAST, returnAST);
				pathNaviExpr_AST = (AST)currentAST.root;
			}
			else {
				boolean synPredMatched18 = false;
				if (((LA(1)==DOTDOT||LA(1)==LBRACKET) && (LA(2)==ID||LA(2)==LBRACKET||LA(2)==STRING))) {
					int _m18 = mark();
					synPredMatched18 = true;
					inputState.guessing++;
					try {
						{
						{
						switch ( LA(1)) {
						case DOTDOT:
						{
							match(DOTDOT);
							break;
						}
						case LBRACKET:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						match(LBRACKET);
						{
						switch ( LA(1)) {
						case STRING:
						{
							match(STRING);
							break;
						}
						case ID:
						{
							match(ID);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						match(COMMA);
						{
						switch ( LA(1)) {
						case STRING:
						{
							match(STRING);
							break;
						}
						case ID:
						{
							match(ID);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						}
					}
					catch (RecognitionException pe) {
						synPredMatched18 = false;
					}
					rewind(_m18);
					inputState.guessing--;
				}
				if ( synPredMatched18 ) {
					objectConstructionExpr();
					astFactory.addASTChild(currentAST, returnAST);
					pathNaviExpr_AST = (AST)currentAST.root;
				}
				else {
					boolean synPredMatched21 = false;
					if (((LA(1)==DOTDOT||LA(1)==LBRACKET) && (LA(2)==LBRACKET||LA(2)==INT))) {
						int _m21 = mark();
						synPredMatched21 = true;
						inputState.guessing++;
						try {
							{
							{
							switch ( LA(1)) {
							case DOTDOT:
							{
								match(DOTDOT);
								break;
							}
							case LBRACKET:
							{
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
							match(LBRACKET);
							match(INT);
							match(RBRACKET);
							}
						}
						catch (RecognitionException pe) {
							synPredMatched21 = false;
						}
						rewind(_m21);
						inputState.guessing--;
					}
					if ( synPredMatched21 ) {
						arrayExpr();
						astFactory.addASTChild(currentAST, returnAST);
						pathNaviExpr_AST = (AST)currentAST.root;
					}
					else {
						boolean synPredMatched24 = false;
						if (((LA(1)==DOTDOT||LA(1)==LBRACKET) && (LA(2)==LBRACKET||LA(2)==INT))) {
							int _m24 = mark();
							synPredMatched24 = true;
							inputState.guessing++;
							try {
								{
								{
								switch ( LA(1)) {
								case DOTDOT:
								{
									match(DOTDOT);
									break;
								}
								case LBRACKET:
								{
									break;
								}
								default:
								{
									throw new NoViableAltException(LT(1), getFilename());
								}
								}
								}
								match(LBRACKET);
								match(INT);
								match(COMMA);
								match(INT);
								}
							}
							catch (RecognitionException pe) {
								synPredMatched24 = false;
							}
							rewind(_m24);
							inputState.guessing--;
						}
						if ( synPredMatched24 ) {
							arrayConstructionExpr();
							astFactory.addASTChild(currentAST, returnAST);
							pathNaviExpr_AST = (AST)currentAST.root;
						}
						else if ((LA(1)==DOTDOT||LA(1)==LBRACKET) && (LA(2)==LBRACKET||LA(2)==INT||LA(2)==SEMI)) {
							arraySliceExpr();
							astFactory.addASTChild(currentAST, returnAST);
							pathNaviExpr_AST = (AST)currentAST.root;
						}
						else if ((LA(1)==BACKSP)) {
							multiLevelUpExpr();
							astFactory.addASTChild(currentAST, returnAST);
							pathNaviExpr_AST = (AST)currentAST.root;
						}
						else {
							throw new NoViableAltException(LT(1), getFilename());
						}
						}}}}
						returnAST = pathNaviExpr_AST;
					}
					
	public final void filterExprMain() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST filterExprMain_AST = null;
		
		match(LPAREN);
		filterExpr();
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			filterExprMain_AST = (AST)currentAST.root;
			filterExprMain_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FILTER,"Filter expression main:")).add(filterExprMain_AST));
			currentAST.root = filterExprMain_AST;
			currentAST.child = filterExprMain_AST!=null &&filterExprMain_AST.getFirstChild()!=null ?
				filterExprMain_AST.getFirstChild() : filterExprMain_AST;
			currentAST.advanceChildToEnd();
		}
		filterExprMain_AST = (AST)currentAST.root;
		returnAST = filterExprMain_AST;
	}
	
	public final void simpleKeyExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST simpleKeyExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case DOT:
		{
			AST tmp31_AST = null;
			tmp31_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp31_AST);
			match(DOT);
			break;
		}
		case DOTDOT:
		{
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(DOTDOT);
			break;
		}
		case ID:
		case WILDCARD:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case ID:
		{
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(ID);
			break;
		}
		case WILDCARD:
		{
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp34_AST);
			match(WILDCARD);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			simpleKeyExpr_AST = (AST)currentAST.root;
			simpleKeyExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SIMPLE_KEY,"Simple expression:")).add(simpleKeyExpr_AST));
			currentAST.root = simpleKeyExpr_AST;
			currentAST.child = simpleKeyExpr_AST!=null &&simpleKeyExpr_AST.getFirstChild()!=null ?
				simpleKeyExpr_AST.getFirstChild() : simpleKeyExpr_AST;
			currentAST.advanceChildToEnd();
		}
		simpleKeyExpr_AST = (AST)currentAST.root;
		returnAST = simpleKeyExpr_AST;
	}
	
	public final void complexKeyExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST complexKeyExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
			match(DOTDOT);
			break;
		}
		case LBRACKET:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LBRACKET);
		AST tmp37_AST = null;
		tmp37_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp37_AST);
		match(STRING);
		match(RBRACKET);
		if ( inputState.guessing==0 ) {
			complexKeyExpr_AST = (AST)currentAST.root;
			complexKeyExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPLEX_KEY,"Complex expression:")).add(complexKeyExpr_AST));
			currentAST.root = complexKeyExpr_AST;
			currentAST.child = complexKeyExpr_AST!=null &&complexKeyExpr_AST.getFirstChild()!=null ?
				complexKeyExpr_AST.getFirstChild() : complexKeyExpr_AST;
			currentAST.advanceChildToEnd();
		}
		complexKeyExpr_AST = (AST)currentAST.root;
		returnAST = complexKeyExpr_AST;
	}
	
	public final void objectConstructionExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST objectConstructionExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(DOTDOT);
			break;
		}
		case LBRACKET:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LBRACKET);
		{
		switch ( LA(1)) {
		case STRING:
		{
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(STRING);
			break;
		}
		case ID:
		{
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
			match(ID);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		int _cnt35=0;
		_loop35:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				{
				switch ( LA(1)) {
				case STRING:
				{
					AST tmp44_AST = null;
					tmp44_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp44_AST);
					match(STRING);
					break;
				}
				case ID:
				{
					AST tmp45_AST = null;
					tmp45_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp45_AST);
					match(ID);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			else {
				if ( _cnt35>=1 ) { break _loop35; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt35++;
		} while (true);
		}
		match(RBRACKET);
		if ( inputState.guessing==0 ) {
			objectConstructionExpr_AST = (AST)currentAST.root;
			objectConstructionExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJECT_CONSTRUCTION,"Object construction expression:")).add(objectConstructionExpr_AST));
			currentAST.root = objectConstructionExpr_AST;
			currentAST.child = objectConstructionExpr_AST!=null &&objectConstructionExpr_AST.getFirstChild()!=null ?
				objectConstructionExpr_AST.getFirstChild() : objectConstructionExpr_AST;
			currentAST.advanceChildToEnd();
		}
		objectConstructionExpr_AST = (AST)currentAST.root;
		returnAST = objectConstructionExpr_AST;
	}
	
	public final void arrayExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arrayExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			AST tmp47_AST = null;
			tmp47_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp47_AST);
			match(DOTDOT);
			break;
		}
		case LBRACKET:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LBRACKET);
		AST tmp49_AST = null;
		tmp49_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp49_AST);
		match(INT);
		match(RBRACKET);
		if ( inputState.guessing==0 ) {
			arrayExpr_AST = (AST)currentAST.root;
			arrayExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY_INDEX,"Array expression:")).add(arrayExpr_AST));
			currentAST.root = arrayExpr_AST;
			currentAST.child = arrayExpr_AST!=null &&arrayExpr_AST.getFirstChild()!=null ?
				arrayExpr_AST.getFirstChild() : arrayExpr_AST;
			currentAST.advanceChildToEnd();
		}
		arrayExpr_AST = (AST)currentAST.root;
		returnAST = arrayExpr_AST;
	}
	
	public final void arrayConstructionExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arrayConstructionExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			AST tmp51_AST = null;
			tmp51_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp51_AST);
			match(DOTDOT);
			break;
		}
		case LBRACKET:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LBRACKET);
		AST tmp53_AST = null;
		tmp53_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp53_AST);
		match(INT);
		{
		int _cnt41=0;
		_loop41:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				AST tmp55_AST = null;
				tmp55_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp55_AST);
				match(INT);
			}
			else {
				if ( _cnt41>=1 ) { break _loop41; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt41++;
		} while (true);
		}
		match(RBRACKET);
		if ( inputState.guessing==0 ) {
			arrayConstructionExpr_AST = (AST)currentAST.root;
			arrayConstructionExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY_CONSTRUCTION,"Array construction expression:")).add(arrayConstructionExpr_AST));
			currentAST.root = arrayConstructionExpr_AST;
			currentAST.child = arrayConstructionExpr_AST!=null &&arrayConstructionExpr_AST.getFirstChild()!=null ?
				arrayConstructionExpr_AST.getFirstChild() : arrayConstructionExpr_AST;
			currentAST.advanceChildToEnd();
		}
		arrayConstructionExpr_AST = (AST)currentAST.root;
		returnAST = arrayConstructionExpr_AST;
	}
	
	public final void arraySliceExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arraySliceExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case DOTDOT:
		{
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp57_AST);
			match(DOTDOT);
			break;
		}
		case LBRACKET:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(LBRACKET);
		{
		switch ( LA(1)) {
		case INT:
		{
			{
			AST tmp59_AST = null;
			tmp59_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp59_AST);
			match(INT);
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
			match(SEMI);
			{
			switch ( LA(1)) {
			case INT:
			{
				AST tmp61_AST = null;
				tmp61_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp61_AST);
				match(INT);
				break;
			}
			case RBRACKET:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			}
			break;
		}
		case SEMI:
		{
			{
			AST tmp62_AST = null;
			tmp62_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp62_AST);
			match(SEMI);
			AST tmp63_AST = null;
			tmp63_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp63_AST);
			match(INT);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RBRACKET);
		if ( inputState.guessing==0 ) {
			arraySliceExpr_AST = (AST)currentAST.root;
			arraySliceExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARRAY_SLICE,"Array slice expression:")).add(arraySliceExpr_AST));
			currentAST.root = arraySliceExpr_AST;
			currentAST.child = arraySliceExpr_AST!=null &&arraySliceExpr_AST.getFirstChild()!=null ?
				arraySliceExpr_AST.getFirstChild() : arraySliceExpr_AST;
			currentAST.advanceChildToEnd();
		}
		arraySliceExpr_AST = (AST)currentAST.root;
		returnAST = arraySliceExpr_AST;
	}
	
	public final void multiLevelUpExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiLevelUpExpr_AST = null;
		
		AST tmp65_AST = null;
		tmp65_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp65_AST);
		match(BACKSP);
		{
		switch ( LA(1)) {
		case LCURLY:
		{
			match(LCURLY);
			AST tmp67_AST = null;
			tmp67_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp67_AST);
			match(INT);
			match(RCURLY);
			break;
		}
		case EOF:
		case DOT:
		case DOTDOT:
		case ID:
		case WILDCARD:
		case LBRACKET:
		case BACKSP:
		case LPAREN:
		case AT_SIZE:
		case EQ:
		case NE:
		case LT:
		case LE:
		case GT:
		case GE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			multiLevelUpExpr_AST = (AST)currentAST.root;
			multiLevelUpExpr_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MULTI_LEVEL_UP,"Multi level up:")).add(multiLevelUpExpr_AST));
			currentAST.root = multiLevelUpExpr_AST;
			currentAST.child = multiLevelUpExpr_AST!=null &&multiLevelUpExpr_AST.getFirstChild()!=null ?
				multiLevelUpExpr_AST.getFirstChild() : multiLevelUpExpr_AST;
			currentAST.advanceChildToEnd();
		}
		multiLevelUpExpr_AST = (AST)currentAST.root;
		returnAST = multiLevelUpExpr_AST;
	}
	
	public final void filterExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST filterExpr_AST = null;
		
		andExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop53:
		do {
			if ((LA(1)==OR)) {
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp69_AST);
				match(OR);
				andExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop53;
			}
			
		} while (true);
		}
		filterExpr_AST = (AST)currentAST.root;
		returnAST = filterExpr_AST;
	}
	
	public final void andExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST andExpr_AST = null;
		
		notExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop56:
		do {
			if ((LA(1)==AND)) {
				AST tmp70_AST = null;
				tmp70_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp70_AST);
				match(AND);
				notExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop56;
			}
			
		} while (true);
		}
		andExpr_AST = (AST)currentAST.root;
		returnAST = andExpr_AST;
	}
	
	public final void notExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST notExpr_AST = null;
		
		{
		switch ( LA(1)) {
		case NOT:
		{
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp71_AST);
			match(NOT);
			break;
		}
		case DOT:
		case DOTDOT:
		case ID:
		case WILDCARD:
		case LBRACKET:
		case BACKSP:
		case LPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		basicExpr();
		astFactory.addASTChild(currentAST, returnAST);
		notExpr_AST = (AST)currentAST.root;
		returnAST = notExpr_AST;
	}
	
	public final void basicExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST basicExpr_AST = null;
		
		switch ( LA(1)) {
		case DOT:
		case DOTDOT:
		case ID:
		case WILDCARD:
		case LBRACKET:
		case BACKSP:
		{
			filterNaviExpr();
			astFactory.addASTChild(currentAST, returnAST);
			basicExpr_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			match(LPAREN);
			filterExpr();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			basicExpr_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = basicExpr_AST;
	}
	
	public final void filterNaviExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST filterNaviExpr_AST = null;
		
		{
		int _cnt62=0;
		_loop62:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
				pathNaviExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				if ( _cnt62>=1 ) { break _loop62; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt62++;
		} while (true);
		}
		{
		switch ( LA(1)) {
		case AT_SIZE:
		{
			sizeFnExpr();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EQ:
		case NE:
		case LT:
		case LE:
		case GT:
		case GE:
		{
			operator_to_value();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		filterNaviExpr_AST = (AST)currentAST.root;
		returnAST = filterNaviExpr_AST;
	}
	
	public final void sizeFnExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sizeFnExpr_AST = null;
		
		AST tmp74_AST = null;
		tmp74_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp74_AST);
		match(AT_SIZE);
		{
		switch ( LA(1)) {
		case EQ:
		{
			AST tmp75_AST = null;
			tmp75_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp75_AST);
			match(EQ);
			break;
		}
		case NE:
		{
			AST tmp76_AST = null;
			tmp76_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp76_AST);
			match(NE);
			break;
		}
		case LT:
		{
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(LT);
			break;
		}
		case LE:
		{
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(LE);
			break;
		}
		case GT:
		{
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(GT);
			break;
		}
		case GE:
		{
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp80_AST);
			match(GE);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		AST tmp81_AST = null;
		tmp81_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp81_AST);
		match(INT);
		sizeFnExpr_AST = (AST)currentAST.root;
		returnAST = sizeFnExpr_AST;
	}
	
	public final void operator_to_value() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST operator_to_value_AST = null;
		
		switch ( LA(1)) {
		case EQ:
		case NE:
		{
			{
			switch ( LA(1)) {
			case EQ:
			{
				AST tmp82_AST = null;
				tmp82_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp82_AST);
				match(EQ);
				break;
			}
			case NE:
			{
				AST tmp83_AST = null;
				tmp83_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp83_AST);
				match(NE);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			value();
			astFactory.addASTChild(currentAST, returnAST);
			operator_to_value_AST = (AST)currentAST.root;
			break;
		}
		case LT:
		case LE:
		case GT:
		case GE:
		{
			{
			switch ( LA(1)) {
			case LT:
			{
				AST tmp84_AST = null;
				tmp84_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp84_AST);
				match(LT);
				break;
			}
			case LE:
			{
				AST tmp85_AST = null;
				tmp85_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp85_AST);
				match(LE);
				break;
			}
			case GT:
			{
				AST tmp86_AST = null;
				tmp86_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp86_AST);
				match(GT);
				break;
			}
			case GE:
			{
				AST tmp87_AST = null;
				tmp87_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp87_AST);
				match(GE);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case INT:
			{
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(INT);
				break;
			}
			case REAL:
			{
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp89_AST);
				match(REAL);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			operator_to_value_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = operator_to_value_AST;
	}
	
	public final void value() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST value_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_null:
		{
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(LITERAL_null);
			value_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_true:
		{
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(LITERAL_true);
			value_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_false:
		{
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
			match(LITERAL_false);
			value_AST = (AST)currentAST.root;
			break;
		}
		case STRING:
		{
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp93_AST);
			match(STRING);
			value_AST = (AST)currentAST.root;
			break;
		}
		case INT:
		{
			AST tmp94_AST = null;
			tmp94_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp94_AST);
			match(INT);
			value_AST = (AST)currentAST.root;
			break;
		}
		case REAL:
		{
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
			match(REAL);
			value_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = value_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"PATH",
		"MEMBER",
		"SIMPLE_KEY",
		"COMPLEX_KEY",
		"OBJECT_CONSTRUCTION",
		"ARRAY_INDEX",
		"ARRAY_CONSTRUCTION",
		"ARRAY_SLICE",
		"MULTI_LEVEL_UP",
		"FILTER",
		"DOT",
		"DOTDOT",
		"ID",
		"WILDCARD",
		"LBRACKET",
		"STRING",
		"RBRACKET",
		"COMMA",
		"INT",
		"SEMI",
		"BACKSP",
		"LCURLY",
		"RCURLY",
		"LPAREN",
		"RPAREN",
		"OR",
		"AND",
		"NOT",
		"AT_SIZE",
		"EQ",
		"NE",
		"LT",
		"LE",
		"GT",
		"GE",
		"REAL",
		"\"null\"",
		"\"true\"",
		"\"false\"",
		"INT_OR_REAL_OR_DOTS",
		"NEWLINE",
		"WS",
		"DIGIT",
		"FRAC",
		"EXP",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 17285120L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 545612349442L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
