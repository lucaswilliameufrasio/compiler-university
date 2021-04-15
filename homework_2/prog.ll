;LLVM version 3.8.0 (http://llvm.org/)
;program teste
declare i32 @printf(i8*, ...) nounwind
declare dso_local i32 @__isoc99_scanf(i8*, ...) #1
@str_print_int = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
@str_print_double = private unnamed_addr constant [7 x i8] c"%.2lf\0A\00", align 1
@str_read_int = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@str_read_double = private unnamed_addr constant [4 x i8] c"%lf\00", align 1
define i32 @main() nounwind {
%d = alloca i32
store i32 0, i32* %d
%1 = load i32, i32* %d
%2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds([3 x i8], [3 x i8]* @str_read_int, i64 0, i64 0), i32 %1)
%3 = load i32, i32* %d
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds([4 x i8], [4 x i8]* @str_print_int, i32 0, i32 0), i32 %3)
%a = alloca i32
store i32 0, i32* %a
store i32 10, i32* %a
ret i32 0
}
