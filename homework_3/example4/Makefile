example4:	example4.l example4.y
	bison -d example4.y
	flex example4.l
	cc -o $@ example4.tab.c lex.yy.c -lfl
.PHONY:	example4