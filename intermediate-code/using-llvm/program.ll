define i32 @main() #0 {
%L = alloca double
store double 10.0, double* %L
%1 = load double, double* %L
%2 = fmul double 6.0, %1
%3 = fmul double %2, %1
%a = alloca double
store double %3, double* %a
ret i32 0
}
