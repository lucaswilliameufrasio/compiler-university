;LLVM version 3.8.0 (http://llvm.org/)
;program equipe2
declare i32 @printf(i8*, ...) nounwind
declare dso_local double @pow(double, double)
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
%c = alloca i32
store i32 0, i32* %c
%d = alloca double
store double 0.0, double* %d
store i32 5, i32* %a
store i32 3, i32* %b
%1 = load i32, i32* %a
%2 = load i32, i32* %b
%3 = add i32 %1, %2
store i32 %3, i32* %c
br label %L1
L1:
%4 = load i32, i32* %a
%5 = load i32, i32* %b
%6 = icmp sgt i32 %4, %5
br i1 %6, label %L2, label %L3
L2:
%7 = load i32, i32* %b
%8 = add i32 %7, 1
store i32 %8, i32* %b
br label %L1
L3:
%9 = alloca double
%10 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds([4 x i8], [4 x i8]* @str_read_double, i32 0, i32 0), double* %9)
%11 = load double, double* %9
store double %11, double* %d
%12 = mul i32 2, 2
%13 = mul i32 %12, 2
store i32 %13, i32* %a
%14 = sitofp i32 2 to double
%15 = sitofp i32 3 to double
%16 = call double @pow(double %14, double %15)
%17 = sitofp i32 2 to double
%18 = call double @pow(double %16, double %17)
store double %18, double* %d
%19 = load double, double* %d
%20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds([7 x i8], [7 x i8]* @str_print_double, i32 0, i32 0), double %19)
%e = alloca double
store double 0.0, double* %e
store double 1.1E+2, double* %e
ret i32 0
}
