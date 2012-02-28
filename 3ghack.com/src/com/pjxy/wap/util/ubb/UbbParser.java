/* Generated By:JavaCC: Do not edit this line. UbbParser.java */
package com.pjxy.wap.util.ubb;
@ SuppressWarnings("all") public class UbbParser implements UbbParserConstants {
  private UbbTree root = new UbbTree(UbbType.ROOT);

  final public UbbTree Exp() throws ParseException {
    FlowExp(root);
    jj_consume_token(0);
    {if (true) return root;}
    throw new Error("Missing return statement in function");
  }

  final public void DynExp(UbbTree parent) throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIME:
      t = jj_consume_token(TIME);
      break;
    case DATE:
      t = jj_consume_token(DATE);
      break;
    case WEEK:
      t = jj_consume_token(WEEK);
      break;
    case IP:
      t = jj_consume_token(IP);
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    if (t.kind == TIME) parent.addChild(new UbbTree(UbbType.TIME));
    if (t.kind == DATE) parent.addChild(new UbbTree(UbbType.DATE));
    if (t.kind == WEEK) parent.addChild(new UbbTree(UbbType.WEEK));
    if (t.kind == IP) parent.addChild(new UbbTree(UbbType.IP));
  }

  final public void OnExp(UbbTree parent) throws ParseException {
  UbbTree tree = null;
  String text = "";
  Token t;
    jj_consume_token(ON_BEGIN);
    tree = new UbbTree(UbbType.ON);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
        t = jj_consume_token(SIMPLE_TEXT);
        break;
      case RIGHT_BRACKET:
        t = jj_consume_token(RIGHT_BRACKET);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      text += t.image;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
      case RIGHT_BRACKET:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(ON_END);
    tree.addChild(new UbbTree(UbbType.TEXT, text));
  }

  final public void FlowExp(UbbTree parent) throws ParseException {
  String text = "";
  Token t;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case I_BEGIN:
      case B_BEGIN:
      case U_BEGIN:
      case IMG_BEGIN:
      case CALL_BEGIN:
      case URL_BEGIN:
      case ON_BEGIN:
      case BR:
      case TIME:
      case DATE:
      case WEEK:
      case IP:
      if (!text.isEmpty())
      {
        parent.addChild(new UbbTree(UbbType.TEXT, text));
        text = "";
      }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case I_BEGIN:
        case B_BEGIN:
        case U_BEGIN:
        case CALL_BEGIN:
        case BR:
        case TIME:
        case DATE:
        case WEEK:
        case IP:
          LayoutExp(parent);
          break;
        case IMG_BEGIN:
          ImgExp(parent);
          break;
        case URL_BEGIN:
          UrlExp(parent);
          break;
        case ON_BEGIN:
          OnExp(parent);
          break;
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      case SIMPLE_TEXT:
        t = jj_consume_token(SIMPLE_TEXT);
      text += t.image;
        break;
      case RIGHT_BRACKET:
        t = jj_consume_token(RIGHT_BRACKET);
      text += t.image;
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
      case RIGHT_BRACKET:
      case I_BEGIN:
      case B_BEGIN:
      case U_BEGIN:
      case IMG_BEGIN:
      case CALL_BEGIN:
      case URL_BEGIN:
      case ON_BEGIN:
      case BR:
      case TIME:
      case DATE:
      case WEEK:
      case IP:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
    }
    if (!text.isEmpty())
    {
      parent.addChild(new UbbTree(UbbType.TEXT, text));
      text = "";
    }
  }

  final public void ImgExp(UbbTree parent) throws ParseException {
  String text = "";
  Token t;
  UbbTree tree = null;
    jj_consume_token(IMG_BEGIN);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
        t = jj_consume_token(SIMPLE_TEXT);
        break;
      case RIGHT_BRACKET:
        t = jj_consume_token(RIGHT_BRACKET);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      text += t.image;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
      case RIGHT_BRACKET:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
    }
    tree = new UbbTree(UbbType.IMG);
    tree.addChild(new UbbTree(UbbType.TEXT, text));
    jj_consume_token(IMG_END);
    parent.addChild(tree);
  }

  final public void UrlExp(UbbTree parent) throws ParseException {
  String text = "";
  Token t;
  UbbTree tree = null;
    jj_consume_token(URL_BEGIN);
    label_4:
    while (true) {
      t = jj_consume_token(SIMPLE_TEXT);
    text += t.image;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
    }
    jj_consume_token(RIGHT_BRACKET);
    tree = new UbbTree(UbbType.URL, text);
    text = "";
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
      case RIGHT_BRACKET:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SIMPLE_TEXT:
          t = jj_consume_token(SIMPLE_TEXT);
          break;
        case RIGHT_BRACKET:
          t = jj_consume_token(RIGHT_BRACKET);
          break;
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      text += t.image;
        break;
      case IMG_BEGIN:
      if (!text.isEmpty())
      {
        tree.addChild(new UbbTree(UbbType.TEXT, text));
        text = "";
      }
        ImgExp(tree);
        break;
      case TIME:
      case DATE:
      case WEEK:
      case IP:
        DynExp(parent);
        break;
      case BR:
        BrExp(parent);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
      case RIGHT_BRACKET:
      case IMG_BEGIN:
      case BR:
      case TIME:
      case DATE:
      case WEEK:
      case IP:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_5;
      }
    }
    jj_consume_token(URL_END);
    if (!text.isEmpty())
    {
      tree.addChild(new UbbTree(UbbType.TEXT, text));
      text = "";
    }
    parent.addChild(tree);
  }

  final public void CallExp(UbbTree parent) throws ParseException {
  UbbTree tree = null;
  String text = "";
  Token t;
    jj_consume_token(CALL_BEGIN);
    tree = new UbbTree(UbbType.CALL);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
        t = jj_consume_token(SIMPLE_TEXT);
        break;
      case RIGHT_BRACKET:
        t = jj_consume_token(RIGHT_BRACKET);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      text += t.image;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SIMPLE_TEXT:
      case RIGHT_BRACKET:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(CALL_END);
    tree.addChild(new UbbTree(UbbType.TEXT, text));
    parent.addChild(tree);
  }

  final public void LayoutExp(UbbTree parent) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case I_BEGIN:
      IExp(parent);
      break;
    case B_BEGIN:
      BExp(parent);
      break;
    case U_BEGIN:
      UExp(parent);
      break;
    case BR:
      BrExp(parent);
      break;
    case TIME:
    case DATE:
    case WEEK:
    case IP:
      DynExp(parent);
      break;
    case CALL_BEGIN:
      CallExp(parent);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void BrExp(UbbTree parent) throws ParseException {
    jj_consume_token(BR);
    parent.addChild(new UbbTree(UbbType.BR));
  }

  final public void IExp(UbbTree parent) throws ParseException {
  UbbTree tree = null;
    jj_consume_token(I_BEGIN);
    tree = new UbbTree(UbbType.I);
    FlowExp(tree);
    jj_consume_token(I_END);
    parent.addChild(tree);
  }

  final public void BExp(UbbTree parent) throws ParseException {
  UbbTree tree = null;
    jj_consume_token(B_BEGIN);
    tree = new UbbTree(UbbType.B);
    FlowExp(tree);
    jj_consume_token(B_END);
    parent.addChild(tree);
  }

  final public void UExp(UbbTree parent) throws ParseException {
  UbbTree tree = null;
    jj_consume_token(U_BEGIN);
    tree = new UbbTree(UbbType.U);
    FlowExp(tree);
    jj_consume_token(U_END);
    parent.addChild(tree);
  }

  /** Generated Token Manager. */
  public UbbParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3c0000,0x6,0x6,0x3eaaa8,0x3eaaae,0x3eaaae,0x6,0x6,0x2,0x6,0x3e0206,0x3e0206,0x6,0x6,0x3e08a8,};
   }

  /** Constructor with InputStream. */
  public UbbParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public UbbParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new UbbParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public UbbParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new UbbParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public UbbParser(UbbParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(UbbParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[22];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 22; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}