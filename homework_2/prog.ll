;LLVM version 3.8.0 (http://llvm.org/)
;program teste
declare i32 @printf(i8*, ...) nounwind
declare dso_local i32 @__isoc99_scanf(i8*, ...) #1
@str_print_int = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
@str_print_double = private unnamed_addr constant [7 x i8] c"%.2lf\0A\00", align 1
@str_read_int = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@str_read_double = private unnamed_addr constant [4 x i8] c"%lf\00", align 1
define i32 @main() nounwind {
%d = alloca double
store double 0.0, double* %d
%1 = alloca double
%2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds([4 x i8], [4 x i8]* @str_read_double, i32 0, i32 0), double* %1)
%3 = load double, double* %1
store double %3, double* %d
%4 = load double, double* %d
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds([7 x i8], [7 x i8]* @str_print_double, i32 0, i32 0), double %4)
ret i32 0
}
