# Tests for mysql

# A local version of AC_CHECK_SIZEOF that includes sys/types.h
dnl MYSQL_CHECK_SIZEOF(TYPE [, CROSS-SIZE])
AC_DEFUN([MYSQL_CHECK_SIZEOF],
[changequote(<<, >>)dnl
dnl The name to #define.
define(<<AC_TYPE_NAME>>, translit(sizeof_$1, [a-z *], [A-Z_P]))dnl
dnl The cache variable name.
define(<<AC_CV_NAME>>, translit(ac_cv_sizeof_$1, [ *], [_p]))dnl
changequote([, ])dnl
AC_MSG_CHECKING(size of $1)
AC_CACHE_VAL(AC_CV_NAME,
[AC_TRY_RUN([#include <stdio.h>
#include <sys/types.h>
#if STDC_HEADERS
#include <stdlib.h>
#include <stddef.h>
#endif
main()
{
  FILE *f=fopen("conftestval", "w");
  if (!f) exit(1);
  fprintf(f, "%d\n", sizeof($1));
  exit(0);
}], AC_CV_NAME=`cat conftestval`, AC_CV_NAME=0, ifelse([$2], , , AC_CV_NAME=$2))])dnl
AC_MSG_RESULT($AC_CV_NAME)
AC_DEFINE_UNQUOTED(AC_TYPE_NAME, $AC_CV_NAME, [ ])
undefine([AC_TYPE_NAME])dnl
undefine([AC_CV_NAME])dnl
])


dnl Checks for typedefs, structures, and compiler characteristics.
AC_C_CONST
AC_C_INLINE
AC_TYPE_OFF_T
AC_TYPE_SIZE_T
AC_STRUCT_ST_RDEV
AC_HEADER_TIME
AC_STRUCT_TM

AC_CHECK_TYPES([sigset_t, off_t], [], [], [#include <sys/types.h>])
AC_CHECK_TYPES([size_t], [], [], [#include <stdio.h>])
AC_CHECK_TYPES([u_int32_t])

dnl Checks for header files.
AC_CHECK_HEADERS(malloc.h sys/cdefs.h)

dnl Checks for library functions.
AC_FUNC_ALLOCA
AC_PROG_GCC_TRADITIONAL
AC_TYPE_SIGNAL

AC_CHECK_FUNCS(re_comp regcomp strdup)
AC_CHECK_FUNCS(strlcat strlcpy)
AC_CHECK_FUNCS(issetugid)
AC_CHECK_FUNCS(fgetln)
AC_CHECK_FUNCS(getline flockfile)
AC_CHECK_FUNCS(lstat putenv select setenv setlocale strcoll tcgetattr)

AC_FUNC_MMAP
AC_TYPE_SIGNAL
AC_FUNC_UTIME_NULL
AC_FUNC_VPRINTF

# AC_CHECK_SIZEOF return 0 when it does not find the size of a
# type. We want a error instead.
AC_CHECK_SIZEOF(char, 1)
if test "$ac_cv_sizeof_char" -eq 0
then
  AC_MSG_ERROR([No size for char type.
A likely cause for this could be that there isn't any
static libraries installed. You can verify this by checking if you have libm.a
in /lib, /usr/lib or some other standard place.  If this is the problem,
install the static libraries and try again.  If this isn't the problem,
examine config.log for possible errors.  If you want to report this, use
'scripts/mysqlbug' and include at least the last 20 rows from config.log!])
fi
AC_CHECK_SIZEOF(char*, 4)
AC_CHECK_SIZEOF(int, 4)
if test "$ac_cv_sizeof_int" -eq 0
then
  AC_MSG_ERROR("No size for int type.")
fi
AC_CHECK_SIZEOF(long, 4)
if test "$ac_cv_sizeof_long" -eq 0
then
  AC_MSG_ERROR("No size for long type.")
fi
AC_CHECK_SIZEOF(long long, 8)
if test "$ac_cv_sizeof_long_long" -eq 0
then
  AC_MSG_ERROR("MySQL needs a long long type.")
fi
# off_t is not a builtin type
MYSQL_CHECK_SIZEOF(off_t, 4)
if test "$ac_cv_sizeof_off_t" -eq 0
then
  AC_MSG_ERROR("MySQL needs a off_t type.")
fi
