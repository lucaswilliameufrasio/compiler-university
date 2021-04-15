;LLVM version 3.8.0 (http://llvm.org/)
;program teste
declare i32 @printf(i8*, ...) nounwind
declare dso_local i32 @__isoc99_scanf(i8*, ...) #1
@str_print_int = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
@str_print_double = private unnamed_addr constant [7 x i8] c"%.2lf\0A\00", align 1
@str_read_int = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@str_read_double = private unnamed_addr constant [4 x i8] c"%lf\00", align 1
define i32 @main() nounwind {
%a = alloca i32
store i32 0, i32* %a
%b = alloca i32
store i32 0, i32* %b
store i32 10, i32* %a
store i32 0, i32* %b
br label %L1
L1:
%1 = load i32, i32* %a
%2 = load i32, i32* %b
%3 = icmp sgt i32 %1, %2
br i1 %3, label %L2, label %L3
L2:
%4 = load i32, i32* %b
%5 = add i32 %4, 11
store i32 %5, i32* %b
br label %L1
L3:
%6 = load i32, i32* %b
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds([4 x i8], [4 x i8]* @str_print_int, i32 0, i32 0), i32 %6)
%d = alloca double
store double 0.0, double* %d
%8 = alloca double
%9 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds([4 x i8], [4 x i8]* @str_read_double, i32 0, i32 0), double* %8)
%10 = load double, double* %8
store double %10, double* %d
%11 = load double, double* %d
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds([7 x i8], [7 x i8]* @str_print_double, i32 0, i32 0), double %11)
ret i32 0
}
