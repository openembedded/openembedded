# Tests from squeak
AC_DEFUN([AC_C_DOUBLE_ALIGNMENT],
[AC_CACHE_CHECK([whether unaligned access to doubles is ok], ac_cv_double_align,
  AC_TRY_RUN([f(int i){*(double *)i=*(double *)(i+4);}
              int main(){char b[[12]];f(b);return 0;}],
    ac_cv_double_align="yes", ac_cv_double_align="no"))
test "$ac_cv_double_align" = "no" && AC_DEFINE(DOUBLE_WORD_ALIGNMENT)])

AC_DEFUN([AC_C_DOUBLE_ORDER],
[AC_CACHE_CHECK([whether doubles are stored in Squeak order], ac_cv_double_order,
  AC_TRY_RUN([union { double d; int i[[2]]; } d;
              int main(void) { d.d= 1.0;  return d.i[[0]] == 0; }],
    ac_cv_double_order="yes", ac_cv_double_order="no"))
test "$ac_cv_double_order" = "no" && AC_DEFINE(DOUBLE_WORD_ORDER)])

