# Collection of binutils, gcc, glibc


AC_DEFUN([BINUTILS_CHECK_UINT64],
[AC_TRY_COMPILE(
[#ifdef HAVE_STDINT_H
#include <stdint.h>
#endif],
[extern uint64_t foo;],
liberty_cv_uint64=uint64_t,
[AC_TRY_COMPILE(
[#ifdef HAVE_LIMITS_H
#include <limits.h>
#endif
#ifndef CHAR_BIT
#define CHAR_BIT 8
#endif],
[extern char foo[sizeof(long) * CHAR_BIT >= 64 ? 1 : -1];],
liberty_cv_uint64="unsigned long",
[AC_TRY_COMPILE(
[#ifdef HAVE_LIMITS_H
#include <limits.h>
#endif
#ifndef CHAR_BIT
#define CHAR_BIT 8
#endif],
[extern char foo[sizeof(long long) * CHAR_BIT >= 64 ? 1 : -1];],
liberty_cv_uint64="unsigned long long", liberty_cv_uint64=none)])])])

AC_DEFUN([OE_CHECK_GNU],
[
AC_CHECK_SIZEOF([int])
AC_CHECK_TYPE(uintptr_t, unsigned long)
BINUTILS_CHECK_UINT64
])
