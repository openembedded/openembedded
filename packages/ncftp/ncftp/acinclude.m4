AC_DEFUN([wi_ARG_WITH_SOCKS5], [
	AC_ARG_WITH(socks5,[  --with-socks5           try to find and use the SOCKS5 library],wi_want_socks5=$withval,wi_want_socks5=no)
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([SOCKS], [define if using the socks library])
AC_DEFUN([wi_LIB_SOCKS5], [
	if test "$wi_want_socks5" != yes ; then
		ac_cv_lib_socks5_SOCKSinit=no
	else
		# Look for the "SOCKS" library for use with Firewalls/Gateways.
		SOCKS_LIBS=''

		# First check for extra libraries that may be needed to
		# link against socks.  If we already checked for one or
		# more of these libraries, we don't want to count them
		# in the socks-only list.
		#
		if test "x$ac_cv_lib_db_main" = "x" ; then
			AC_CHECK_LIB(db,main,[SOCKS_LIBS="$SOCKS_LIBS -ldb"])
		fi
		if test "x$ac_cv_lib_isode_main" = "x" ; then
			AC_CHECK_LIB(isode,main,[SOCKS_LIBS="$SOCKS_LIBS -lisode"])
		fi
		if test "x$ac_cv_lib_com_err_main" = "x" ; then
			AC_CHECK_LIB(com_err,main,[SOCKS_LIBS="$SOCKS_LIBS -lcom_err"])
		fi
		if test "x$ac_cv_lib_crypto_main" = "x" ; then
			AC_CHECK_LIB(crypto,main,[SOCKS_LIBS="$SOCKS_LIBS -lcrypto"])
		fi
		if test "x$ac_cv_lib_krb5_main" = "x" ; then
			AC_CHECK_LIB(krb5,main,[SOCKS_LIBS="$SOCKS_LIBS -lkrb5"])
		fi
		if test "x$ac_cv_lib_gssapi_krb5_main" = "x" ; then
			AC_CHECK_LIB(gssapi_krb5,main,[SOCKS_LIBS="$SOCKS_LIBS -lgssapi_krb5"])
		fi

		AC_CHECK_LIB(socks5,SOCKSinit,[SOCKS_LIBS="$SOCKS_LIBS -lsocks5"])
		AC_CHECK_HEADERS(socks.h socks5p.h)

		if test "$ac_cv_lib_socks5_SOCKSinit" != yes ; then
			ac_cv_lib_socks5_SOCKSinit=no
			unset SOCKS_LIBS
		else
			AC_SUBST(SOCKS_LIBS)
			AC_DEFINE(SOCKS,5)
		fi
	fi
	AC_MSG_CHECKING([if SOCKS5 will be used])
	AC_MSG_RESULT([$ac_cv_lib_socks5_SOCKSinit])
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_ARG_ENABLE_DEBUG], [
# if DEBUGBUILD is yes, other macros try to set up a compilation environment
# with debugging symbols enabled.  Example macros which are affected are
# wi_CFLAGS and wi_SFLAG.
#
AC_ARG_ENABLE(debug,
[  --enable-debug          enable debugging symbols],
[
	DEBUGBUILD=no
	DEBUGCONFIGUREFLAG=""
	if test "$enableval" != "no" ; then
		DEBUGBUILD=yes
		DEBUGCONFIGUREFLAG="--enable-debug"
	fi
],[
dnl	# Argument not specified; default is disabled.
	DEBUGBUILD=no
	DEBUGCONFIGUREFLAG=""
])
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_ARG_DISABLE_CCDV], [
AC_ARG_ENABLE(ccdv,[  --disable-ccdv          disable use of ccdv program in Makefiles],use_ccdv="$enableval",use_ccdv=yes)
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_ARG_DISABLE_PRECOMP], [
AC_ARG_ENABLE(ccdv,[  --disable-precomp       disable use of precompiled header files],use_precomp="$enableval",use_precomp=yes)
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([PRAGMA_HDRSTOP], [])
AC_DEFUN([wi_CC_PRECOMP], [
AC_CACHE_CHECK([if the C compiler can use precompiled headers], [wi_cv_cc_precomp], [
	result="no"
	if test "${use_precomp-yes}" != no ; then
		wi_cv_cc_precomp_type="unknown"
		/bin/rm -f pchtest.h pchtest.p pchtest.c pchtest.o pchtest csetc.pch pchtest.pch pchtest.h.gch
		cat <<EOF > pchtest.h
/* pchtest.h */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define FOOBAR 33	/* Make sure it can compile custom headers too */
EOF
		cat <<EOF > pchtest.c
/* pchtest.c */
#include "pchtest.h"

main()
{
	if (FOOBAR == 33)
		exit(0);
	exit(1);
}
EOF
		if test "$GCC" = yes ; then
			#
			# Try gcc 3.4's built-in implementation first
			#
			echo ${CC-cc} $CPPFLAGS pchtest.h -c >&5
			${CC-cc} $CPPFLAGS pchtest.h -c >&5 2>&5
			if test -f pchtest.h.gch ; then
				#
				# Good, the .gch file was created.
				# Odds are we're good to go.
				#
				echo "Successfully compiled pchtest.h into the precompiled header file pchtest.h.gch." >&5
				AC_TRY_COMPILE([#include "pchtest.h"],[if (FOOBAR == 33) exit(0)],[result="yes" ; wi_cv_cc_precomp_type="gcc_gch_files"],[result="no"])
			else
				echo "This version of GCC did not compile pchtest.h into the precompiled header file pchtest.h.gch." >&5
				#
				# See if Apple's implementation works.
				#
				echo ${CC-cc} $CPPFLAGS -precomp pchtest.h -o pchtest.p >&5 
				${CC-cc} $CPPFLAGS -precomp pchtest.h -o pchtest.p >&5 2>&5
				if test -s pchtest.p ; then
					AC_TRY_COMPILE([#include "pchtest.h"],[if (FOOBAR == 33) exit(0)],[result="yes" ; wi_cv_cc_precomp_type="gcc_dash_precomp"],[result="no"])
				fi
			fi
		elif test "${result}_${SYS-aix}_${GCC}" = "no_aix_no" ; then
			#
			# AIX xlc
			#
			echo ${CC-cc} $CPPFLAGS -qusepcomp -qgenpcomp pchtest.c -o pchtest >&5
			${CC-cc} $CPPFLAGS -qusepcomp -qgenpcomp pchtest.c -o pchtest >&5 2>&5
			if test -s pchtest ; then
				result="yes"
				wi_cv_cc_precomp_type="xlc"
				wi_CFLAGS_TO_ADD_LATER="$wi_CFLAGS_TO_ADD_LATER -qusepcomp -qgenpcomp"
			fi
		else
			#
			# IRIX, Compaq C
			#
			cat <<EOF > pchtest.c
#include "pchtest.h"
#pragma hdrstop
#include <stdarg.h>

main() { exit(0); }
EOF
			for pchflags in "-pch -no_pch_messages" "-pch" "-LANG:pch"
			do
				/bin/rm -f pchtest.pch
				echo ${CC-cc} $CPPFLAGS $pchflags pchtest.c -o pchtest >&5
				${CC-cc} $CPPFLAGS $pchflags pchtest.c -o pchtest >&5 2>&5
				if test -f pchtest.pch ; then
					result="yes"
					wi_cv_cc_precomp_type="ccc"
					wi_CFLAGS_TO_ADD_LATER="$wi_CFLAGS_TO_ADD_LATER $pchflags"
					AC_DEFINE(PRAGMA_HDRSTOP)
					break
				fi
			done
			unset pchflags
		fi
		/bin/rm -f pchtest.h pchtest.p pchtest.c pchtest.o pchtest csetc.pch pchtest.pch pchtest.h.gch
	fi
	wi_cv_cc_precomp="$result"
])
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_TEST_DASH_L], [
AC_CACHE_CHECK([if shell can test for symlinks], [wi_cv_shell_test_symlinks], [
wi_cv_shell_test_symlinks="no"
wi_cv_test_L="false"
wi_cv_test_not_L=":"
/bin/rm -f config.lnk
if test ! -f "config.lnk" ; then
	/bin/ln -s /bin/ln config.lnk
	if test -f "config.lnk" ; then
		( if test -L config.lnk ; then /bin/rm -f config.lnk ; fi ) 2>/dev/null
		if test ! -f "config.lnk" ; then
			wi_cv_shell_test_symlinks="yes"
			wi_cv_test_L='test -L'
			wi_cv_test_not_L='test ! -L'
		else
			( if test -h config.lnk ; then /bin/rm -f config.lnk ; fi ) 2>/dev/null
			if test ! -f "config.lnk" ; then
				wi_cv_shell_test_symlinks="yes"
				wi_cv_test_L='test -h'
				wi_cv_test_not_L='test ! -h'
			fi
		fi
	fi
	/bin/rm -f config.lnk
fi
])
test_L="$wi_cv_test_L"
test_not_L="$wi_cv_test_not_L"
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_EXTRA_IDIR], [
incdir="$1"
if test -r $incdir ; then
	case "$CPPFLAGS" in
		*${incdir}*)
			# echo "   + already had $incdir" 1>&6
			;;
		*)
			if test "$CPPFLAGS" = "" ; then
				CPPFLAGS="-I$incdir"
			else
				CPPFLAGS="$CPPFLAGS -I$incdir"
			fi
			echo "   + found $incdir" 1>&6
			;;
	esac
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_EXTRA_LDIR], [
libdir="$1"
if test -r $libdir ; then
	case "$LDFLAGS" in
		*${libdir}*)
			# echo "   + already had $libdir" 1>&6
			;;
		*)
			if test "$LDFLAGS" = "" ; then
				LDFLAGS="-L$libdir"
			else
				LDFLAGS="$LDFLAGS -L$libdir"
			fi
			echo "   + found $libdir" 1>&6
			;;
	esac
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_GNU_LD], [
AC_MSG_CHECKING([for GNU ld])
wi_cv_prog_ld="ld"
result="no"
x=`ld --version 2>/dev/null | fgrep GNU`
if test "$x" != "" ; then
	wi_cv_prog_ld="gld"
	result="yes"
fi
AC_MSG_RESULT($result)
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_LD_READONLY_TEXT], [
if test "$SYS$wi_cv_prog_ld" = "linuxgld" ; then
	LDFLAGS="$LDFLAGS -Xlinker -n"
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_FUNC_STRSIGNAL], [
	case "$OS" in
		aix4.3*)
			# It didn't appear until several ML packs
			# into 4.3.3
			#
			;;
		*)
			AC_CHECK_FUNCS(strsignal)
			;;
	esac
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_FUNC_GETCWD], [
if test "${SYS}" = sunos ; then
	# Use getwd on SunOS -- getcwd does a "popen("/bin/pwd")" -- aaaccck.
	#
	AC_CHECK_FUNCS(getwd)
else
	AC_CHECK_FUNCS(getcwd getwd)
fi
if test "$ac_cv_func_getcwd" = no && test "$ac_cv_func_getwd" = no ; then
AC_WARN(This system does not have either getwd or getcwd?)
AC_WARN(I find that a little hard to believe.)
AC_WARN(You may want to try -DHAVE_GETWD anyway.)
AC_WARN([
This could also mean that your compiler isn't working])
AC_WARN(with this configure script.  Check the ./config.log)
AC_WARN(and look for anomalies.)
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_EXTRA_SYSV_SUNOS_DIRS], [
if test "${SYS-sunos}" = sunos ; then
	AC_MSG_CHECKING([for System V compatibility directories])
	AC_MSG_RESULT([])
	wi_EXTRA_IDIR("/usr/5include")
	wi_EXTRA_LDIR("/usr/5lib")
fi
])
dnl
dnl
dnl If you want to also look for include and lib subdirectories in the
dnl $HOME tree, you supply "yes" as the first argument to this macro.
dnl
dnl If you want to look for subdirectories in include/lib directories,
dnl you pass the names in argument 3, otherwise pass a dash.
dnl
AC_DEFUN([wi_EXTRA_DIRS], [
AC_MSG_CHECKING([for extra include and lib directories])
AC_MSG_RESULT([])
ifelse([$1], yes, [dnl
b1=`cd .. ; pwd`
b2=`cd ../.. ; pwd`
exdirs="$HOME $j $b1 $b2 $prefix $2"
if test -x "$HOME/bin/OS" ; then
	b3=`$HOME/bin/OS`
	b3="$HOME/$b3"
	if test -d "$b3" ; then
		exdirs="$b3 $exdirs"
	fi
fi
],[dnl
exdirs="$prefix $2"
])
subexdirs="$3"
if test "$subexdirs" = "" ; then
	subexdirs="-"
fi
for subexdir in $subexdirs ; do
if test "$subexdir" = "-" ; then
	subexdir=""
else
	subexdir="/$subexdir"
fi
for exdir in $exdirs ; do
	case "$exdir" in
		"/usr"|"/"|"//")
			if test "$exdir" = "//" ; then exdir="/" ; fi
			if test "$subexdir" != ""; then
				incdir="${exdir}/include${subexdir}"
				wi_EXTRA_IDIR($incdir)

				libdir="${exdir}/lib${subexdir}"
				wi_EXTRA_LDIR($libdir)
			fi
			;;
		*)
			if test "$subexdir" = ""; then
				incdir="${exdir}/include${subexdir}"
				wi_EXTRA_IDIR($incdir)

				libdir="${exdir}/lib${subexdir}"
				wi_EXTRA_LDIR($libdir)
			fi
			;;
	esac
done
done
])
dnl
dnl
dnl
AC_DEFUN([wi_HPUX_CFLAGS],
[AC_MSG_CHECKING(if HP-UX ansi C compiler flags are needed)
AC_REQUIRE([AC_PROG_CC])
AC_REQUIRE([wi_OS_VAR])
ac_cv_hpux_flags=no
if test "$os" = hp-ux ; then
	if test "$GCC" = yes ; then
		if test "$CFLAGS" != "" ; then
			# Shouldn't be in there.
changequote(<<, >>)dnl
			CFLAGS=`echo "$CFLAGS" | sed 's/-A[ae]//g'`
changequote([, ])dnl
			case "$CFLAGS" in
				*_HPUX_SOURCE*)
					;;
				*)
					# This is required for the extended
					# namespace.
					#
					CFLAGS="-D_HPUX_SOURCE $CFLAGS"
					;;
			esac
		fi
	else
		# If you're not using gcc, then you better have a cc/c89
		# that is usable.  If you have the barebones compiler, it
		# won't work.  The good compiler uses -Aa for the ANSI
		# compatible stuff.
changequote(<<, >>)dnl
		x=`echo "$CFLAGS" | grep 'A[ae]' 2>/dev/null`
changequote([, ])dnl
		if test "$x" = "" ; then
			CFLAGS="$CFLAGS -Ae"
		fi
	fi
	ac_cv_hpux_flags=yes
fi
AC_MSG_RESULT($ac_cv_hpux_flags)
])
dnl
dnl
dnl
AC_DEFUN([wi_OS_DEFAULT_CFLAGS], [
AC_MSG_CHECKING(if we should customize your CFLAGS environment variable)
wi_replace_O_with_g="no"
case "$wi_orig_CFLAGS" in
	"")
		wi_replace_O_with_g="no"
		;;
	"-g -O2")
		wi_replace_O_with_g="no"
		;;
	"-g -O")
		wi_replace_O_with_g="no"
		;;
	"-O2 -g")
		wi_replace_O_with_g="no"
		;;
	"-O -g")
		wi_replace_O_with_g="no"
		;;
	-g)
		wi_replace_O_with_g="yes"
		;;
esac

#
# See if your CFLAGS environment variable wasn't set or exported,
# or if you are using a conservative default.  If so, we will
# add some additional flags for better performance, warning reporting,
# etc.
#
# Note we are now checking the current value of CFLAGS, which may have
# been changed by configure.
#
wi_os_default_cflags="no"
case "$CFLAGS" in
	"")
		wi_os_default_cflags="yes"
		;;
	"-g -O2")
		wi_os_default_cflags="yes"
		;;
	"-g -O")
		wi_os_default_cflags="yes"
		;;
	"-O2 -g")
		wi_os_default_cflags="yes"
		;;
	"-O -g")
		wi_os_default_cflags="yes"
		;;
	-g)
		wi_os_default_cflags="yes"
		;;
	-O)
		wi_os_default_cflags="yes"
		;;
	-O2)
		wi_os_default_cflags="yes"
		;;
esac

if test "$wi_os_default_cflags" = yes ; then
	if test "$GCC" = yes ; then
		#
		# gcc
		#
		wi_gcc_optimizer_flags=''
		case "$wi_cv_gcc_version" in
			2.7.*|2.8.*|2.9*)
				wi_os_default_cflags="-W -Wall -Wstrict-prototypes -Wmissing-prototypes -Wshadow -Wbad-function-cast -Wpointer-arith -Wcast-qual -Wcast-align -Wwrite-strings -Wmissing-declarations -Winline"
				;;
			3.*)
				wi_os_default_cflags="-W -Wall -Wstrict-prototypes -Wmissing-prototypes -Wshadow -Wbad-function-cast -Wpointer-arith -Wcast-qual -Wcast-align -Wwrite-strings -Wmissing-declarations -Winline -Wmissing-format-attribute -Wformat-security"
				wi_gcc_optimizer_flags='-Wdisabled-optimization'
				;;
			*)
				wi_os_default_cflags="-W -Wall"
				;;
		esac
		if test "$wi_replace_O_with_g" = yes ; then
			wi_os_default_cflags="-g $wi_os_default_cflags"
		else
			wi_os_default_cflags="-O2 $wi_os_default_cflags"
			if test "$wi_gcc_optimizer_flags" != "" ; then
				wi_os_default_cflags="$wi_os_default_cflags $wi_gcc_optimizer_flags"
			fi
		fi
		case "$OS" in
			hpux*)
				wi_os_default_cflags="-D_HPUX_SOURCE $wi_os_default_cflags"
				;;
			bsdos*)
				wi_os_default_cflags=`echo "$wi_os_default_cflags" | sed 's/\ -Wcast-qual//g'`		# avoid va_start() problem
				wi_os_default_cflags=`echo "$wi_os_default_cflags" | sed 's/\ -Wredundant-decls//g'`
				;;
			openbsd*|unixware*|openunix*)
				wi_os_default_cflags=`echo "$wi_os_default_cflags" | sed 's/\ -Wredundant-decls//g'`
				;;
		esac
	else
		#
		# regular cc
		#
		case "${wi_replace_O_with_g}_${OS}" in
			no_aix*)
				wi_os_default_cflags="-O -qinfo=cmp:cnd:dcl:eff:gen:ini:par:pro:rea:use -qlonglong -qro -qroconst -qlanglvl=extended -qsrcmsg -qmaxmem=20480 -qsuppress=1506-469:1506-409"
				;;
			yes_aix*)
				wi_os_default_cflags="-g -qinfo=cmp:cnd:dcl:eff:gen:ini:par:pro:rea:use -qlonglong -qro -qroconst -qlanglvl=extended -qsrcmsg -qmaxmem=20480 -qsuppress=1506-469:1506-409"
				;;
			no_irix[2345]*|no_irix6.[01234]*)
				wi_os_default_cflags="-O2 -xansi -fullwarn -use_readonly_const -G0 -rdata_shared"
				;;
			yes_irix[2345]*|yes_irix6.[01234]*)
				wi_os_default_cflags="-g -xansi -fullwarn -use_readonly_const -G0 -rdata_shared"
				;;
			no_irix*)
				wi_os_default_cflags="-O2 -IPA -xansi -fullwarn -use_readonly_const -G0 -rdata_shared -woff 1174"
				;;
			yes_irix*)
				wi_os_default_cflags="-g -xansi -fullwarn -use_readonly_const -G0 -rdata_shared -woff 1174"
				;;
			no_digitalunix*)
				wi_os_default_cflags="-O4 -std1 -portable -readonly_strings"
				;;
			yes_digitalunix*)
				wi_os_default_cflags="-g -std1 -portable -readonly_strings"
				;;
			no_hpux*)
				wi_os_default_cflags="-Ae +O2 +Ovolatile +Olibcalls +ESlit +w1 +DAportable"
				;;
			yes_hpux*)
				wi_os_default_cflags="-Ae -g +w1 +DAportable"
				;;
			no_solaris*)
				if test "$wi_cv_sunwspro_cc_version2" -ge 530 ; then
					wi_os_default_cflags="-xipo -xO5 -xc99 -xbuiltin -xstrconst -dalign -Qn -errtags=yes -erroff=E_END_OF_LOOP_CODE_NOT_REACHED -mc"
				else
					wi_os_default_cflags="-xO4 -xstrconst -dalign -Qn"
				fi
				;;
			yes_solaris*)
				if test "$wi_cv_sunwspro_cc_version2" -ge 530 ; then
					wi_os_default_cflags="-g -xc99 -xstrconst -dalign -Qn -errtags=yes -erroff=E_END_OF_LOOP_CODE_NOT_REACHED"
				else
					wi_os_default_cflags="-g -xstrconst -dalign -Qn"
				fi
				;;
			no_tru64*)
				wi_os_default_cflags="-O4 -tune host -std1 -readonly_strings -portable -warnprotos -msg_enable level6 -msg_disable longlongtype,hexoctunsign,unusedincl,unnecincl,nestincl,unusedtop,unknownmacro,ignorecallval,strctpadding,truncintasn,truncintcast,trunclongcast,ansialiascast,conststocls,unrefsdecl,subscrbounds2"
				;;
			yes_tru64*)
				wi_os_default_cflags="-g -std1 -readonly_strings -portable -warnprotos -msg_enable level6 -msg_disable longlongtype,hexoctunsign,unusedincl,unnecincl,nestincl,unusedtop,unknownmacro,ignorecallval,strctpadding,truncintasn,truncintcast,trunclongcast,ansialiascast,conststocls,unrefsdecl,subscrbounds2"
				;;
			no_unixware*|no_openunix*)
				wi_os_default_cflags='-O -K inline -K host -Q n'
				;;
			yes_unixware*|yes_openunix*)
				wi_os_default_cflags='-g -K host -Q n'
				;;
			*)
				wi_os_default_cflags="no"
				;;
		esac
	fi
fi
if test "$wi_os_default_cflags" != "no" ; then
	CFLAGS="$wi_os_default_cflags"
fi
AC_MSG_RESULT($wi_os_default_cflags)
])
dnl
dnl
dnl
AC_DEFUN([wi_SFLAG], [AC_REQUIRE([AC_PROG_CC])
STRIP="strip"
if test "$SFLAG" = "" ; then
	SFLAG="-s"
	case "$OS" in
		macosx*)
			SFLAG='-Wl,-x'
			;;
	esac
fi
#
# Was it ./configure --enable-debug ?
#
if test "$DEBUGBUILD" = yes ; then
	SFLAG=""
	STRIP=":"
fi
case "$CFLAGS" in
	"-g"|"-g "*|*" -g"|*" -g "*|*"-g"[0-9]*)
		# SFLAG="# $SFLAG"
		SFLAG=""
		STRIP=":"
		;;
esac
STRIPFLAG="$SFLAG"
])
dnl
dnl
dnl
AC_DEFUN([wi_PROG_SUN_WORKSHOP_CC_VERSION], [
AC_REQUIRE([AC_PROG_CC])
if test "${SYS}_${GCC}" != solaris_no ; then
	wi_cv_cc_is_sunwspro_cc="no"
	wi_cv_sunwspro_cc_version="0"
	wi_cv_sunwspro_cc_version2="0"
else
	AC_CACHE_CHECK([if the C compiler is Sun WorkShop C],[wi_cv_cc_is_sunwspro_cc], [
changequote(<<, >>)dnl
#
# cc: Sun WorkShop 6 update 2 C 5.3 2001/05/15
# usage: cc [ options] files.  Use 'cc -flags' for details
#
# cc: WorkShop Compilers 4.2 30 Oct 1996 C 4.2
# usage: cc [ options] files.  Use 'cc -flags' for details
#
		wi_cv_sunwspro_cc_version=`$CC -V 2>&1 | sed -n '/WorkShop.*C\ [1-9]/{s/^.*C/C/;s/^C\ \([^\ ]*\).*/\1/;p;q;}'`
		case "$wi_cv_sunwspro_cc_version" in
			[1-9]*)
				wi_cv_cc_is_sunwspro_cc="yes"
				ver1=`echo "$wi_cv_sunwspro_cc_version" | cut -d. -f1`
				ver2=`echo "$wi_cv_sunwspro_cc_version" | cut -d. -f2`
				ver3=0
				wi_cv_sunwspro_cc_version2=`expr "$ver1" '*' 100 + "$ver2" "*" 10 + "$ver3"`
				unset ver1 ver2 ver3
				;;
			*)
				wi_cv_cc_is_sunwspro_cc="no"
				wi_cv_sunwspro_cc_version="0"
				wi_cv_sunwspro_cc_version2="0"
				;;
		esac
changequote([, ])dnl
	])
	if test "$wi_cv_cc_is_sunwspro_cc" = yes ; then
		AC_MSG_CHECKING([output of "cc -V" to determine version of Sun WorkShop C])
		AC_MSG_RESULT("version $wi_cv_sunwspro_cc_version")
	fi
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_PROG_GCC_VERSION], [
AC_REQUIRE([AC_PROG_CC])
if test "$GCC" = yes ; then
	AC_CACHE_CHECK([the version of GCC],[wi_cv_gcc_version], [
changequote(<<, >>)dnl
	wi_cv_gcc_version=`$CC -v 2>&1 | sed -n '/gcc version/{s/^.*gcc version//;s/^[^1-9]*//;s/\ .*//;p;q;}'`
changequote([, ])dnl
])
else
	wi_cv_gcc_version="0"
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_REQUEST_NO_Y2K_WARNINGS], [
	wi_request_no_y2k_warnings=yes
])
dnl
dnl
dnl
AC_DEFUN([wi_CFLAGS_NO_Y2K_WARNINGS], [
AC_REQUIRE([AC_PROG_CC])
if test "x$wi_request_no_y2k_warnings" = xyes ; then
case "${wi_cv_gcc_version-0}" in
changequote(<<, >>)dnl
	0|1.*|2.[012345678].*)
changequote([, ])dnl
		;;
	*)
		case "$CFLAGS" in
			*-Wno-format-y2k*)
				;;
			*)
				oldCFLAGS="$CFLAGS"
				CFLAGS="$CFLAGS -Wno-format-y2k"
				#
				# Now check if this version of GCC
				# accepts this flag...
				#
				AC_TRY_COMPILE([],[int junk;],[],[CFLAGS="$oldCFLAGS"])
				unset oldCFLAGS
				;;
		esac
		;;
esac
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_CFLAGS], [AC_REQUIRE([AC_PROG_CC])
	wi_PROG_GCC_VERSION
	AC_REQUIRE_CPP()
	wi_PROG_SUN_WORKSHOP_CC_VERSION
	wi_OS_DEFAULT_CFLAGS
	wi_CFLAGS_NO_Y2K_WARNINGS
changequote(<<, >>)dnl
	add_O0="no"
	if [ "$NOOPTCFLAGS" = "" ] ; then
		NOOPTCFLAGS=`echo "$CFLAGS" | sed 's/[-+]O[0-9A-Za-z]*//g;s/-xO[0-9]//g;s/-Wc,-O3//g;s/-IPA//g;s/-xipo//g;s/\ \ */ /g;s/^\ *//;s/\ *$//;'`
		if [ "$GCC" = "yes" ] ; then
			add_O0="yes"
		else
			case "$CC" in
				ccc|*/ccc)
					# Compaq CC
					add_O0="yes"
					;;
			esac
		fi
	fi
	if [ "$DEBUGCFLAGS" = "" ] ; then
		DEBUGCFLAGS="-g $NOOPTCFLAGS"
	fi
	if [ "$add_O0" = yes ] ; then
		NOOPTCFLAGS="-O0 $NOOPTCFLAGS"
	fi
changequote([, ])dnl
	#
	# Was it ./configure --enable-debug ?
	#
	AC_MSG_CHECKING([if this is a debug build])
	if test "$DEBUGBUILD" = yes ; then
		AC_MSG_RESULT(yes)
		CFLAGS="$DEBUGCFLAGS"
	else
		AC_MSG_RESULT(no)
	fi
	AC_MSG_CHECKING([NOOPTCFLAGS])
	AC_MSG_RESULT($NOOPTCFLAGS)
	AC_MSG_CHECKING([DEBUGCFLAGS])
	AC_MSG_RESULT($DEBUGCFLAGS)
	AC_MSG_CHECKING([CFLAGS])
	AC_MSG_RESULT($CFLAGS)
])
dnl
dnl
dnl
AC_DEFUN([wi_HPUX_GCC___STDC_EXT__], [
AC_MSG_CHECKING([if -D__STDC_EXT__ is needed with GCC on HP-UX])
AC_TRY_RUN([
#include <stdio.h>
 
main()
{
#ifdef __STDC_EXT__
	if (__STDC_EXT__ == 0)
		exit(1);		/* have __STDC_EXT__=0 */
	exit(0);			/* have __STDC_EXT__=1 */
#else
	exit(1);			/* do not have __STDC_EXT__ */
#endif
}],[
	# action if true
	#
	# Already have it defined.
	#
	AC_MSG_RESULT(no)
],[
	# action if false
	#
	# Not defined -- we need to define it then.
	# This is required for the extended
	# namespace symbols for Large Files.
	#
	CFLAGS="-D__STDC_EXT__ $CFLAGS"
	AC_MSG_RESULT(yes)
],[
	# action if cross-compiling, guess
	CFLAGS="-D__STDC_EXT__ $CFLAGS"
	AC_MSG_RESULT(yes)
])
])
dnl
dnl
dnl
AC_DEFUN([wi_ENV_VAR_MESSAGES], [
AC_MSG_CHECKING([if you set and exported the environment variable CC])
if test "x$CC" = x ; then
	AC_MSG_RESULT([no (you may want to do that since configure scripts look for gcc first)])
else
	AC_MSG_RESULT($CC)
fi
AC_MSG_CHECKING([for environment variable CFLAGS])
if test "x$CFLAGS" = x ; then
	AC_MSG_RESULT([no (we will choose a default set for you)])
else
	AC_MSG_RESULT($CFLAGS)
fi
AC_MSG_CHECKING([for environment variable CPPFLAGS])
AC_MSG_RESULT(${CPPFLAGS-no})
AC_MSG_CHECKING([for environment variable LDFLAGS])
AC_MSG_RESULT(${LDFLAGS-no})
AC_MSG_CHECKING([for environment variable LIBS])
AC_MSG_RESULT(${LIBS-no})
])
dnl
dnl
dnl
AC_DEFUN([wi_CFLAGS_LFS64], [AC_REQUIRE([AC_PROG_CC])
AC_REQUIRE([wi_OS_VAR])
wi_CFLAGS
if test "os_${os}_gcc_${GCC}" = os_hp-ux_gcc_yes ; then
	wi_HPUX_GCC___STDC_EXT__
fi
case "$CFLAGS" in
	*-D_LARGEFILE64_SOURCE*)
		;;
	*)
		CFLAGS="-D_LARGEFILE64_SOURCE $CFLAGS"
		DEBUGCFLAGS="-D_LARGEFILE64_SOURCE $DEBUGCFLAGS"
		NOOPTCFLAGS="-D_LARGEFILE64_SOURCE $NOOPTCFLAGS"
		;;
esac
AC_MSG_CHECKING([if we should add to CFLAGS for LFS64 support])
AC_MSG_RESULT($CFLAGS)
])
dnl
dnl
dnl
AC_DEFUN([wi_CFLAGS_REENTRANT], [AC_REQUIRE([AC_PROG_CC])
case "$CFLAGS" in
	*-D_REENTRANT*)
		;;
	*)
		CFLAGS="-D_REENTRANT $CFLAGS"
		;;
esac
AC_MSG_CHECKING([if we should add -D_REENTRANT to CFLAGS])
AC_MSG_RESULT($CFLAGS)
])
dnl
dnl
dnl
AC_DEFUN([wi_PROTOTYPES], [
AC_MSG_CHECKING(if the compiler supports function prototypes)
AC_TRY_COMPILE(,[extern void exit(int status);],[wi_cv_prototypes=yes
AC_DEFINE(PROTOTYPES)],wi_cv_prototypes=no)
AC_MSG_RESULT($wi_cv_prototypes)
])
dnl
dnl
dnl

AH_TEMPLATE([tv_sec_t], [type of the tv_sec field of struct timeval])
AH_TEMPLATE([tv_usec_t], [type of the tv_usec field of struct timeval])
AC_DEFUN([wi_STRUCT_TIMEVAL_FIELD_TYPES], [
wi_struct_timeval_field_checks="cached"
AC_CACHE_CHECK([what type the tv_sec field of struct timeval is],[wi_cv_struct_timeval_tv_sec], [
wi_struct_timeval_field_checks="uncached"
wi_PREREQ_UNISTD_H([$0])
AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static void
neg(void *dst0, size_t siz)
{
	unsigned char *dst = (unsigned char *) dst0;
	unsigned char *dlim;

	dlim = dst + siz;
	while (dst < dlim)
		*dst++ = (unsigned char) 0xEE;
}

int
main(int argc, char **argv)
{
	FILE *fp;
	const char *typ;
	struct timeval tv;
#define x tv.tv_sec

	memset(&tv, 0, sizeof(tv));
	fp = stdout;
	if (argc == 1) {
		fp = fopen("conftest.out", "w");
		if (fp == NULL) {
			perror("could not write to ./conftest.out");
			exit(1);
		}
	}

	neg(&x, sizeof(x));
#ifdef HAVE_LONG_LONG
	if (sizeof(x) == sizeof(long long)) {
		typ = "long long";
	} else
#endif
	if (sizeof(x) == sizeof(long)) {
		typ = "long";
	} else {
		typ = "int";
	}
	(void) fprintf(fp, "%s%s\n", (x > 0) ? "unsigned " : "", typ);
#undef x

#define x tv.tv_usec
	neg(&x, sizeof(x));
#ifdef HAVE_LONG_LONG
	if (sizeof(x) == sizeof(long long)) {
		typ = "long long";
	} else
#endif
	if (sizeof(x) == sizeof(long)) {
		typ = "long";
	} else {
		typ = "int";
	}
	(void) fprintf(fp, "%s%s\n", (x > 0) ? "unsigned " : "", typ);
#undef x

	if (fp != stdout)
		(void) fclose(fp);
	exit(0);
}
],[
	# action if true
	if test -f conftest.out ; then
		wi_cv_struct_timeval_tv_sec="`sed -n '1,1p' conftest.out`"
		wi_cv_struct_timeval_tv_usec="`sed -n '2,2p' conftest.out`"
	fi
],[
	# action if false
	wi_cv_struct_timeval_tv_sec="long"
	wi_cv_struct_timeval_tv_usec="long"
],[
	# action if cross compiling
	wi_cv_struct_timeval_tv_sec="long"
	wi_cv_struct_timeval_tv_usec="long"
])
	/bin/rm -f conftest.out
])
if test "$wi_struct_timeval_field_checks" = "uncached" ; then
	AC_MSG_CHECKING([what type the tv_usec field of struct timeval is])
	AC_MSG_RESULT([$wi_cv_struct_timeval_tv_usec])
else
	AC_CACHE_CHECK([what type the tv_usec field of struct timeval is],[wi_cv_struct_timeval_tv_usec], [:])
fi
AC_DEFINE_UNQUOTED(tv_sec_t, $wi_cv_struct_timeval_tv_sec)
AC_DEFINE_UNQUOTED(tv_usec_t, $wi_cv_struct_timeval_tv_usec)
])
dnl
dnl
dnl
AH_TEMPLATE([main_void_return_t], [type that main() should return])
AC_DEFUN([wi_VOID_MAIN_RETURN_TYPE], [
AC_CACHE_CHECK([what type main() should return],[wi_cv_main_void_return_t], [
wi_cv_main_void_return_t="int"
case "${GCC}_${SYS}" in
	no_irix*|no_hpux)
		wi_cv_main_void_return_t="void"
		;;
esac
])
AC_DEFINE_UNQUOTED(main_void_return_t, $wi_cv_main_void_return_t)
])
dnl
dnl
dnl
AH_TEMPLATE([INSECURE_CHOWN], [define if chown can be used to subvert security])
AC_DEFUN([wi_INSECURE_CHOWN], [
wi_PREREQ_UNISTD_H([$0])
AC_MSG_CHECKING(if chown can be used to subvert security)
AC_TRY_RUN([
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
 
main()
{
	int result;
	char fn[64];
	FILE *fp;
	struct stat st;

	setuid(1);	/* if you're root, try set to someone else. */
	sprintf(fn, "/tmp/fu%06ld", (long) getpid());
	unlink(fn);
	fp = fopen(fn, "w");
	if (fp == NULL)
		exit(1);	/* assume the worst */
	fprintf(fp, "%s\n", "hello world");
	fclose(fp);

	result = chown(fn, 0, 0);
	if (stat(fn, &st) < 0) {
		unlink(fn);
		exit((result == 0) ? 0 : 1);
	}
	unlink(fn);

	/* exit(0) if the insecure chown to uid 0 succeeded. */
	exit((st.st_uid == 0) ? 0 : 1);
}],[
	# action if true
	wi_cv_insecure_chown=yes
	AC_DEFINE(INSECURE_CHOWN)
],[
	# action if false
	wi_cv_insecure_chown=no
],[
	# action if cross-compiling, guess
	wi_cv_insecure_chown=no
])

AC_MSG_RESULT($wi_cv_insecure_chown)
])
dnl
dnl
dnl
AC_DEFUN([wi_PREREQ_UNISTD_H], [
	if test "x$ac_cv_header_unistd_h" = x ; then
		AC_MSG_ERROR([Script needs to check for <unistd.h> before calling [$1].])
	fi
])

AH_TEMPLATE([NEED_GETOPT_H], [define if we need to include <getopt.h> for the getopt() global variables])
AH_TEMPLATE([NEED_GETOPT_EXTERN_DECLS], [define if we need extern declarations for the getopt() global variables])
AC_DEFUN([wi_GETOPT], [
AC_CACHE_CHECK([how to access getopt() global variables], [wi_cv_getopt_decl], [
wi_PREREQ_UNISTD_H([$0])
AC_TRY_COMPILE([
/* includes */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <stdio.h>
#include <stdlib.h>
],[
	optind = (optarg == 0) ? 66 : 99;
],[wi_cv_getopt_decl="automatic"],[wi_cv_getopt_decl="unknown"])
if test "$wi_cv_getopt_decl" = unknown ; then
AC_TRY_COMPILE([
/* includes */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
],[
	optind = (optarg == 0) ? 66 : 99;
],[wi_cv_getopt_decl="getopt.h"],[wi_cv_getopt_decl="manual"])
fi
])
if test "$wi_cv_getopt_decl" = "getopt.h" ; then
	AC_DEFINE(NEED_GETOPT_H)
elif test "$wi_cv_getopt_decl" = "manual" ; then
	AC_DEFINE(NEED_GETOPT_EXTERN_DECLS)
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_SNPRINTF], [
if test "$ac_cv_func_snprintf" = "no" ; then
	AC_CHECK_LIB(snprintf,snprintf)
	if test "$ac_cv_lib_snprintf_snprintf" = yes ; then
		unset ac_cv_func_snprintf ac_cv_func_vsnprintf
		AC_CHECK_HEADERS(snprintf.h)
		AC_CHECK_FUNCS(snprintf vsnprintf)
	fi
fi
])
dnl
dnl
dnl
AH_TEMPLATE([SNPRINTF_TERMINATES], [define if snprintf works correctly])
AC_DEFUN([wi_SNPRINTF_TERMINATES], [
if test "$ac_cv_func_snprintf" != "no" ; then
AC_MSG_CHECKING(if snprintf works correctly)
	if test "$ac_cv_func_snprintf" = "no" ; then
		AC_CHECK_LIB(snprintf,snprintf)
	fi
wi_PREREQ_UNISTD_H([$0])
AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <stdio.h>
#include <string.h>
#ifdef HAVE_STRINGS_H
#include <strings.h>
#endif
#include <stdlib.h>
 
main()
{
	char s[16];
	int i, result;

	for (i=0; i<(int)(sizeof(s)/sizeof(char)); i++)
		s[i] = 'x';
	result = (int) snprintf(s + 1, 10, "%s %s!", "hello", "world");
	if (s[10] != '\0')
		exit(1);	/* did not force termination! */
	if (s[11] != 'x')
		exit(2);	/* overflow! */
	if (s[0] != 'x')
		exit(3);	/* underflow! */
	exit(0);
}
],[
	# action if true
	wi_cv_snprintf_terminates=yes
	AC_DEFINE(SNPRINTF_TERMINATES)
	x="yes";
],[
	# action if false
  	wi_cv_snprintf_terminates=no
	x="no";
],[
	# action if cross compiling
	wi_cv_snprintf_terminates=no
	x="unknown";
])
AC_MSG_RESULT($x)
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_SNPRINTF], [
wi_SPRINTF_RETVAL
dnl Uncache these -- config.cache doesn't cache it right for this case.
unset ac_cv_func_snprintf
unset ac_cv_func_vsnprintf

AC_CHECK_FUNCS(snprintf vsnprintf)
wi_SNPRINTF_TERMINATES
wi_LIB_SNPRINTF
])
dnl
dnl
dnl

AH_TEMPLATE([HAVE_HPSECURITY_H], [define if we have hpsecurity.h])
AC_DEFUN([wi_HEADER_HPSECURITY_H], [
AC_MSG_CHECKING(for hpsecurity.h)
wi_cv_header_hpsecurity_h=no
if test -f /usr/include/hpsecurity.h ; then
	wi_cv_header_hpsecurity_h=yes
	AC_DEFINE(HAVE_HPSECURITY_H)
fi
AC_MSG_RESULT($wi_cv_header_hpsecurity_h)
])
dnl
dnl
dnl
AH_TEMPLATE([CAN_USE_SYS_SELECT_H], [define if we can use sys/select.h])
AC_DEFUN([wi_HEADER_SYS_SELECT_H], [
wi_PREREQ_UNISTD_H([$0])
# See if <sys/select.h> is includable after <sys/time.h>
if test "$ac_cv_header_sys_time_h" = no ; then
	wi_chk_headers="sys/time.h sys/select.h"
else
	wi_chk_headers="sys/time.h"
fi
AC_CHECK_HEADERS($wi_chk_headers)
if test "$ac_cv_header_sys_select_h" = yes ; then
	AC_MSG_CHECKING([if <sys/select.h> is compatible with <sys/time.h>])
	selecth=yes
	if test "$ac_cv_header_sys_time_h" = yes ; then
		AC_TRY_COMPILE([
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/time.h>
#include <sys/select.h>],[
		fd_set a;
		struct timeval tmval;

		tmval.tv_sec = 0;],selecth=yes,selecth=no)
	fi
	if test "$selecth" = yes ; then
		AC_DEFINE(CAN_USE_SYS_SELECT_H)
	fi
	AC_MSG_RESULT($selecth)
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_44BSD], [
AC_CHECK_FUNC(strerror,[a=yes],[a=no])
if test "$a" = no ; then
	# Not in libc, try lib44bsd.
	AC_CHECK_LIB(44bsd,strerror)
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_UNIX_DOMAIN_SOCKETS], [define if UNIX domain sockets are available])
AC_DEFUN([wi_UNIX_DOMAIN_SOCKETS], [
if test "x$want_unix_domain_sockets" != xno ; then
	wi_PREREQ_UNISTD_H([$0])
	AC_CHECK_HEADERS(sys/un.h)
	AC_CACHE_CHECK([for UNIX domain sockets], [wi_cv_unix_domain_sockets], [
	AC_TRY_RUN([
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/socket.h>
#ifdef HAVE_SYS_UN_H
#include <sys/un.h>
#endif
 
main()
{
	int sfd;

	sfd = socket(AF_UNIX, SOCK_STREAM, 0);
	if (sfd < 0)
		exit(1);		/* do not have UNIX domain sockets */
	close(sfd);
	exit(0);			/* do have UNIX domain sockets */
}],[
	# action if true
	wi_cv_unix_domain_sockets=yes
],[
	# action if false
	wi_cv_unix_domain_sockets=no
],[
	# action if cross-compiling, guess
	wi_cv_unix_domain_sockets=yes
])
])
	if test "x$wi_cv_unix_domain_sockets" = xyes ; then
		AC_DEFINE(HAVE_UNIX_DOMAIN_SOCKETS)
	fi
	wi_SOCKADDR_UN_SUN_LEN
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_NSL], [
dnl Note: Check for socket lib first, then nsl.

case "$OS" in
	hpux1[123456789]*)
		# HP-UX 11 uses NSL for YP services
		AC_CHECK_LIB(nsl,getpwent)
		;;

	*)
		AC_CHECK_FUNC(gethostbyname,[a=yes],[a=no])
		if test "$a" = no ; then
			# Not in libc, try libnsl.
			AC_CHECK_LIB(nsl,gethostbyname)
		fi
		;;
esac

])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_SOCKET], [
AC_CHECK_FUNC(socket,[a=yes],[a=no])
if test "$a" = no ; then
	# Not in libc, try libsocket.
	AC_CHECK_LIB(socket,socket)
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_RESOLV], [
# See if we could access two well-known sites without help of any special
# libraries, like resolv.
dnl
dnl AC_MSG_WARN([the following check may take several minutes if networking is not up.  You may want to bring it up now and restart configure, otherwise please be patient.])
dnl
AC_CACHE_CHECK([if we need to look for -lresolv], [wi_cv_look_for_resolv], [
wi_PREREQ_UNISTD_H([$0])
AC_TRY_RUN([
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
 
main()
{
	struct hostent *hp1, *hp2;

	hp1 = gethostbyname("ftp.ncftp.com");
	if (hp1 == (struct hostent *) 0) {
		hp2 = gethostbyname("www.ibm.com");
		if (hp2 == (struct hostent *) 0)
			exit(1);
	}
	exit(0);
}],wi_cv_look_for_resolv=no,wi_cv_look_for_resolv=yes,wi_cv_look_for_resolv=yes)
])

if test "$wi_cv_look_for_resolv" = yes ; then
AC_CHECK_LIB(resolv,main)
else
	ac_cv_lib_resolv=no
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_TCP_WRAPPERS], [
wi_PREREQ_UNISTD_H([$0])
AC_MSG_CHECKING([for tcp wrappers library (libwrap)])

AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>

/* These are needed if libwrap.a was compiled with
 * PROCESS_OPTIONS defined.
 */
int allow_severity = 1;	/* arbitrary for this test */
int deny_severity = 2;	/* arbitrary for this test */

],[
	/* function-body */
	exit((allow_severity == deny_severity) ? 1 : 0);
],[
dnl	...Don't bother defining this symbol...
dnl	...Check for tcpd.h instead...
dnl	AC_DEFINE(HAVE_LIBWRAP)
dnl
dnl	...Don't modify LIBS, instead set WRAPLIB...
dnl	LIBS="-lwrap  $LIBS"
dnl
	WRAPLIB="-lwrap"
	wi_cv_lib_wrap_hosts_access=yes
],[
	WRAPLIB=""
	wi_cv_lib_wrap_hosts_access=no
])
AC_MSG_RESULT($wi_cv_lib_wrap_hosts_access)
])
dnl
dnl
dnl
AC_DEFUN([wi_NET_LIBS], [
# Mostly for SunOS 4 -- needs to come first because other libs depend on it
wi_LIB_44BSD

wi_LIB_SOCKET

if test "$SYS" = unixware ; then
	case "$OS" in
		unixware2*)
			# So far, only UnixWare needs this.
			AC_CHECK_LIB(gen,syslog)

			if test -f /usr/ucblib/libucb.a ; then
				LDFLAGS="$LDFLAGS -L/usr/ucblib"
				LIBS="$LIBS -lucb"
			fi
			if test -f /usr/include/unistd.h ; then
				ac_cv_header_unistd_h=yes
			fi

			# UnixWare 2 needs both lsocket and lnsl, and configure
			# script won't detect this condition properly because 
			# the libraries are interdependent.
			#
			LIBS="$LIBS -lsocket -lnsl"

			# Now look for socket()
			#
			# AC_CHECK_FUNC(socket,[a=yes],[a=no])
			#
			AC_CHECK_FUNC(socket,[a=yes],[a=no])
			;;
		*)
			;;
	esac
fi

dnl AC_CHECK_LIB(inet,main)

wi_LIB_NSL
wi_LIB_RESOLV

if test "$SYS" = dynixptx ; then
	LIBS="$LIBS -lsocket -lnsl"
fi

])
dnl
dnl
dnl
dnl
AH_TEMPLATE([UNAME], [uname -a output])
AC_DEFUN([wi_DEFINE_UNAME], [
# Get first 127 chars of all uname information.  Some folks have
# way too much stuff there, so grab only the first 127.
unam=`uname -a 2>/dev/null | cut -c1-127 | sed 's-"-\\"-g'`
if test "$unam" != "" ; then
	AC_DEFINE_UNQUOTED(UNAME, "$unam")
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_SIGSETJMP], [define if we have sigsetjmp and siglongjmp])
AC_DEFUN([wi_FUNC_SIGSETJMP], [
wi_PREREQ_UNISTD_H([$0])
AC_CACHE_CHECK([for sigsetjmp and siglongjmp], [wi_cv_func_sigsetjmp], [

AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <signal.h>
#include <setjmp.h>
],[
	/* function-body */
	sigjmp_buf sjb;

	if (sigsetjmp(sjb, 1) != 0)
		siglongjmp(sjb, 1);	/* bogus code, of course. */
	exit(0);
],[
	wi_cv_func_sigsetjmp=yes
],[
	wi_cv_func_sigsetjmp=no
])
])
if test "$wi_cv_func_sigsetjmp" = yes ; then
	AC_DEFINE(HAVE_SIGSETJMP)
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_UTMP_UT_NAME], [define if struct utmp has the ut_name field])
AC_DEFUN([wi_UTMP_UT_NAME], [
AC_MSG_CHECKING([for ut_name field in struct utmp])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <utmp.h>
],[
struct utmp u;

u.ut_name[0] = '\0';
exit(((int) &u.ut_name) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_utmp_ut_name=yes
	AC_DEFINE(HAVE_UTMP_UT_NAME)
],[
	wi_cv_utmp_ut_name=no
])
AC_MSG_RESULT($wi_cv_utmp_ut_name)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_UTMPX_UT_SYSLEN], [define if struct utmpx has the ut_syslen field])
AC_DEFUN([wi_UTMPX_UT_SYSLEN], [
AC_MSG_CHECKING([for ut_syslen field in struct utmpx])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <utmpx.h>
],[
struct utmpx u;

u.ut_syslen = 0;
exit(((int) &u.ut_syslen) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_utmpx_ut_syslen=yes
	AC_DEFINE(HAVE_UTMPX_UT_SYSLEN)
],[
	wi_cv_utmpx_ut_syslen=no
])
AC_MSG_RESULT($wi_cv_utmpx_ut_syslen)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_UTMP_UT_USER], [define if struct utmp has the ut_user field])
AC_DEFUN([wi_UTMP_UT_USER], [
AC_MSG_CHECKING([for ut_user field in struct utmp])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <utmp.h>
],[
struct utmp u;

u.ut_user[0] = '\0';
exit(((int) &u.ut_user) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_utmp_ut_user=yes
	AC_DEFINE(HAVE_UTMP_UT_USER)
],[
	wi_cv_utmp_ut_user=no
])
AC_MSG_RESULT($wi_cv_utmp_ut_user)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_UTMP_UT_PID], [define if struct utmp has the ut_pid field])
AC_DEFUN([wi_UTMP_UT_PID], [
AC_MSG_CHECKING([for ut_pid field in struct utmp])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <utmp.h>
],[
struct utmp u;

u.ut_pid = 1;
exit(((int) &u.ut_pid) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_utmp_ut_pid=yes
	AC_DEFINE(HAVE_UTMP_UT_PID)
],[
	wi_cv_utmp_ut_pid=no
])
AC_MSG_RESULT($wi_cv_utmp_ut_pid)
])

dnl
dnl
dnl
AH_TEMPLATE([HAVE_UTMP_UT_TIME], [define if struct utmp has the ut_time field])
AC_DEFUN([wi_UTMP_UT_TIME], [
AC_MSG_CHECKING([for ut_time field in struct utmp])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <utmp.h>
],[
struct utmp u;

u.ut_time = 1;
exit(((int) &u.ut_time) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_utmp_ut_time=yes
	AC_DEFINE(HAVE_UTMP_UT_TIME)
],[
	wi_cv_utmp_ut_time=no
])
AC_MSG_RESULT($wi_cv_utmp_ut_time)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_UTMP_UT_HOST], [define if struct utmp has the ut_host field])
AC_DEFUN([wi_UTMP_UT_HOST], [
AC_MSG_CHECKING([for ut_host field in struct utmp])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <utmp.h>
],[
struct utmp u;

u.ut_host[0] = '\0';
exit(((int) &u.ut_host) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_utmp_ut_host=yes
	AC_DEFINE(HAVE_UTMP_UT_HOST)
],[
	wi_cv_utmp_ut_host=no
])
AC_MSG_RESULT($wi_cv_utmp_ut_host)
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([HAVE_STRUCT_STAT64], [define if we have struct stat64])
AC_DEFUN([wi_STRUCT_STAT64], [
AC_MSG_CHECKING([for struct stat64])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
],[
struct stat64 st;

st.st_size = 0;
exit(((int) &st.st_size) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_struct_stat64=yes
	AC_DEFINE(HAVE_STRUCT_STAT64)
],[
	wi_cv_struct_stat64=no
])
AC_MSG_RESULT($wi_cv_struct_stat64)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_STRUCT_CMSGDHR], [define if we have struct cmsghdr])
AC_DEFUN([wi_STRUCT_CMSGHDR], [
AC_CACHE_CHECK([for struct cmsghdr],[wi_cv_struct_cmsghdr], [
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <sys/socket.h>
#include <sys/un.h>
],[
struct cmsghdr cm;

cm.cmsg_len = 0;
cm.cmsg_level = 0;
cm.cmsg_type = 0;
exit(((int) &cm.cmsg_type) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_struct_cmsghdr=yes
],[
	wi_cv_struct_cmsghdr=no
])
])
if test "$wi_cv_struct_cmsghdr" = yes ; then
	AC_DEFINE(HAVE_STRUCT_CMSGDHR)
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_MSGHDR_CONTROL], [define if struct msghdr has the msg_control field])
AC_DEFUN([wi_MSGHDR_CONTROL], [
AC_CACHE_CHECK([for msg_control field in struct msghdr],[wi_cv_msghdr_control], [
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <sys/socket.h>
#include <sys/un.h>
],[
struct msghdr m;

m.msg_control = &m;
m.msg_controllen = sizeof(m);
exit(((int) &m.msg_control) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_msghdr_control=yes
],[
	wi_cv_msghdr_control=no
])
])
if test "$wi_cv_msghdr_control" = yes ; then
	AC_DEFINE(HAVE_MSGHDR_CONTROL)
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_MSGHDR_ACCRIGHTS], [define if struct msghdr has the msg_accrights field])
AC_DEFUN([wi_MSGHDR_ACCRIGHTS], [
AC_CACHE_CHECK([for msg_accrights field in struct msghdr], [wi_cv_msghdr_accrights], [
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <sys/socket.h>
#include <sys/un.h>
],[
struct msghdr m;

m.msg_accrights = &m;
m.msg_accrightslen = sizeof(m);
exit(((int) &m.msg_accrights) & 0xff);	/* bogus code, of course. */
],[
	wi_cv_msghdr_accrights=yes
],[
	wi_cv_msghdr_accrights=no
])
])
if test "$wi_cv_msghdr_accrights" = yes ; then
	AC_DEFINE(HAVE_MSGHDR_ACCRIGHTS)
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_PR_PASSWD_FG_OLDCRYPT], [define if struct pr_passwd has the fg_oldcrypt field])
AC_DEFUN([wi_PR_PASSWD_FG_OLDCRYPT], [
AC_MSG_CHECKING([for fg_oldcrypt field in struct pr_passwd])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <pwd.h>
#include <grp.h>
#include <errno.h>

#if defined(HAVE_USERPW_H) && defined(HAVE_GETUSERPW)	/* AIX */
#	include <userpw.h>
#elif defined(HAVE_PWDADJ_H) && defined(HAVE_GETPWANAM)	/* SunOS */
#	include <sys/label.h>
#	ifdef HAVE_SYS_AUDIT_H
#		include <sys/audit.h>
#	endif
#	include <pwdadj.h>
#elif defined(HAVE_GETESPWNAM) /* Digital UNIX 4 */
#	ifdef HAVE_SYS_SECDEFINES_H
#		include <sys/secdefines.h>
#	endif
#	ifdef HAVE_SYS_SECURITY_H
#		include <sys/security.h>
#	endif
#	ifdef HAVE_SYS_AUDIT_H
#		include <sys/audit.h>
#	endif
#	ifdef HAVE_KRB_H
#		include <krb.h>
#	endif
#	ifdef HAVE_PROT_H
#		include <prot.h>
#	endif
#elif defined(HAVE_GETPRPWNAM) /* SCO Open Server V, Digital UNIX 3, HP-UX 10 */
#	ifdef HAVE_SYS_SECDEFINES_H
#		include <sys/secdefines.h>
#	endif
#	ifdef HAVE_SYS_SECURITY_H
#		include <sys/security.h>
#	endif
#	ifdef HAVE_SYS_AUDIT_H
#		include <sys/audit.h>
#	endif
#	ifdef HAVE_HPSECURITY_H
#		include <hpsecurity.h>
#	endif
#	ifdef HAVE_KRB_H
#		include <krb.h>
#	endif
#	ifdef HAVE_PROT_H
#		include <prot.h>
#	endif
#endif
],[
	struct pr_passwd xu;
	memset(&xu, 0, sizeof(xu));
	if (xu.uflg.fg_oldcrypt != 0)
		xu.uflg.fg_oldcrypt++;	/* bogus code, of course */
	exit(0);
],[
	wi_cv_pr_passwd_fg_oldcrypt=yes
	AC_DEFINE(HAVE_PR_PASSWD_FG_OLDCRYPT)
],[
	wi_cv_pr_passwd_fg_oldcrypt=no
])
AC_MSG_RESULT($wi_cv_pr_passwd_fg_oldcrypt)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_SOCKADDR_UN_SUN_LEN], [define if struct sockaddr_un has the sun_len field])
AC_DEFUN([wi_SOCKADDR_UN_SUN_LEN], [
AC_CACHE_CHECK([for sun_len field in struct sockaddr_un], [wi_cv_sockaddr_un_sun_len], [
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <sys/socket.h>
#include <sys/un.h>
],[
struct sockaddr_un uaddr;

uaddr.sun_len = strlen("/tmp/test.sock");
exit(((int) uaddr.sun_len);	/* bogus code, of course. */
],[
	wi_cv_sockaddr_un_sun_len=yes
],[
	wi_cv_sockaddr_un_sun_len=no
])
])
if test "$wi_cv_sockaddr_un_sun_len" = yes ; then
	AC_DEFINE(HAVE_SOCKADDR_UN_SUN_LEN)
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_STATFS_F_BAVAIL], [define if struct statfs has the f_bavail field])
AC_DEFUN([wi_STATFS_F_BAVAIL], [
AC_MSG_CHECKING([for f_bavail field in struct statfs])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#ifdef HAVE_SYS_STATFS_H
#	include <sys/statfs.h>
#elif defined(HAVE_SYS_VFS_H)
#	include <sys/vfs.h>
#endif
],[
struct statfs st;

st.f_bavail = 1;
exit((int) st.f_bavail);	/* bogus code, of course. */
],[
	wi_cv_statfs_f_bavail=yes
	AC_DEFINE(HAVE_STATFS_F_BAVAIL)
],[
	wi_cv_statfs_f_bavail=no
])
AC_MSG_RESULT($wi_cv_statfs_f_bavail)
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_STATVFS_F_FRSIZE], [define if struct statvfs has the f_frsize field])
AC_DEFUN([wi_STATVFS_F_FRSIZE], [
AC_MSG_CHECKING([for f_frsize field in struct statvfs])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/statvfs.h>
],[
struct statvfs st;

st.f_frsize = 1;
exit((int) st.f_frsize);	/* bogus code, of course. */
],[
	wi_cv_statfs_f_frsize=yes
	AC_DEFINE(HAVE_STATVFS_F_FRSIZE)
],[
	wi_cv_statfs_f_frsize=no
])
AC_MSG_RESULT($wi_cv_statfs_f_frsize)
])
dnl
dnl
dnl
AH_TEMPLATE([SPRINTF_RETURNS_PTR], [define if sprintf returns a pointer to the data])
AC_DEFUN([wi_SPRINTF_RETVAL], [
AC_MSG_CHECKING([what sprintf() returns])
AC_TRY_RUN([
	/* program */
#include <stdio.h>
#include <string.h>
 
main()
{
	int result;
	char s[8];

	result = (int) sprintf(s, "%d", 22);
	if (result == 2)
		exit(0);
	exit(1);

}
],[
	# action if true
	wi_cv_sprintf_returns_ptr=no
	x="length of data written";
],[
	# action if false
  	wi_cv_sprintf_returns_ptr=yes
	AC_DEFINE(SPRINTF_RETURNS_PTR)
	x="pointer to data";
],[
	# action if cross compiling
	wi_cv_sprintf_returns_ptr=no
	x="unknown";
])
AC_MSG_RESULT($x)
])
dnl
dnl
dnl
AC_DEFUN([wi_LIB_CRYPT], [
AC_MSG_CHECKING([which library has usable crypt() function])
ac_save_LIBS="$LIBS"
crypt_lib=NONE

for lib in "c" "crypt" "descrypt" "des"
do

if test "$lib" = "c" ; then
	LIBS="$ac_save_LIBS"
else
	LIBS="$ac_save_LIBS -l${lib}"
fi

wi_PREREQ_UNISTD_H([$0])
AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <stdio.h>
#include <string.h>

extern char *crypt(const char *key, const char *salt);

main()
{
	char cleartext[256];
	char *cp;

	memset(cleartext, 0, sizeof(cleartext));
	strcpy(cleartext, "password");

	cp = crypt(cleartext, "xx");
	if ((cp != NULL) && (strcmp(cp, "xxj31ZMTZzkVA") == 0)) {
		/* printf("PASS\n"); */
		exit(0);
	}
	/* printf("FAIL\n"); */
	exit(1);
}
],[
	# action if true
	crypt_lib="$lib"
],[
	# action if false
	:
],[
	# action if cross compiling
	:
])


if test "$crypt_lib" != NONE ; then
	break
fi

done


LIBS="$ac_save_LIBS"

if test "$crypt_lib" = NONE ; then
	crypt_lib=c
	AC_MSG_RESULT([none?])
else
	AC_MSG_RESULT([lib${crypt_lib}])
fi
if test "$crypt_lib" != c ; then
	AC_CHECK_LIB(${lib},crypt)
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_TEST], [
changequote(<^, ^>)dnl
changequote([, ])dnl
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE__RES_DEFDNAME], [define if _res global variable is usable])
AC_DEFUN([wi__RES_DEFDNAME], [
AC_MSG_CHECKING([for useable _res global variable])
AC_TRY_LINK([
	/* includes */
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#ifdef HAVE_ARPA_NAMESER_H
#	include <arpa/nameser.h>
#endif
#ifdef HAVE_RESOLV_H
#	include <resolv.h>
#endif
],[
	/* function-body */
	int len;

	res_init();
	len = (int) strlen(_res.defdname);
],[
	wi_cv__res_defdname=yes
	AC_DEFINE(HAVE__RES_DEFDNAME)
],[
	wi_cv__res_defdname=no
])
AC_MSG_RESULT($wi_cv__res_defdname)
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([sig_atomic_t], [type to use for sig_atomic_t])
AC_DEFUN([wi_TYPE_SIG_ATOMIC_T], [
wi_PREREQ_UNISTD_H([$0])
AC_MSG_CHECKING([for sig_atomic_t])
AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/signal.h>
#include <signal.h>	/* MG: for IRIX */
#if STDC_HEADERS
#include <stdlib.h>
#include <stddef.h>
#endif
],[
	/* function-body */
	sig_atomic_t sample;

	sample = (sig_atomic_t) getpid();	/* bogus code, of course */
	exit((sample > 0) ? 0 : 1);
],[
	ac_cv_type_sig_atomic_t=yes
],[
	ac_cv_type_sig_atomic_t=no
])
AC_MSG_RESULT($ac_cv_type_sig_atomic_t)
if test $ac_cv_type_sig_atomic_t = no ; then
	AC_DEFINE(sig_atomic_t, int)
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_LIB_READLINE], [
AC_MSG_CHECKING([for GNU Readline library, version 2.0 or newer])

wi_cv_lib_readline=no
wi_cv_lib_readline_result=no
ac_save_LIBS="$LIBS"
# Note: $LIBCURSES is permitted to be empty.
for LIBREADLINE in "-lreadline" "-lreadline $LIBCURSES" "-lreadline -ltermcap" "-lreadline -lncurses" "-lreadline -lcurses"
do
	LIBS="$ac_save_LIBS $LIBREADLINE"
	AC_TRY_RUN([
	/* program */
#include <stdio.h>
#include <stdlib.h>
 
main(int argc, char **argv)
{
	/* Note:  don't actually call readline, since it may block;
	 * We just want to see if it (dynamic) linked in okay.
	 */
	if (argc == 0)	/* never true */
		readline(0);
	exit(0);
}
],[
	# action if true
	wi_cv_lib_readline=yes
],[
	# action if false
	wi_cv_lib_readline=no
],[
	# action if cross compiling
	wi_cv_lib_readline=no
])

	if test "$wi_cv_lib_readline" = yes ; then break ; fi
done

# Now try it again, to be sure it is recent enough.
# rl_function_of_keyseq appeared in version 2.0
#
dnl AC_CHECK_FUNC(rl_function_of_keyseq, [wi_cv_lib_readline=yes],[
dnl 	wi_cv_lib_readline=no;wi_cv_lib_readline_result="no (it is present but too old to use)"
dnl ])
	AC_TRY_LINK([
		/* includes */
	],[
		/* function-body */
		readline(0);
		rl_function_of_keyseq(0);
	],[
		wi_cv_lib_readline=yes
	],[
		wi_cv_lib_readline=no
		wi_cv_lib_readline_result="no (it is present but too old to use)"
	])

if test "$wi_cv_lib_readline" = no ; then
	LIBREADLINE=""
	# restore LIBS
	LIBS="$ac_save_LIBS"
else
	/bin/rm -f readline.ver
	touch readline.ver

	AC_TRY_RUN([
	/* program */
#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>

extern char *rl_library_version;

main()
{
	FILE *fp;
	double d;

	sscanf(rl_library_version, "%lf", &d);
	fp = fopen("readline.ver", "w");
	if (fp == NULL) exit(1);
	if (fprintf(fp, "%s\n", rl_library_version) < 0) exit(1);
	if (fprintf(fp, "%03d\n", (int) (d * 100.0)) < 0) exit(1);
	if (fclose(fp) < 0) exit(1);
	exit(0);
}
	],[
		# action if true
		rl_library_version=`sed -n 1,1p readline.ver 2>/dev/null`
		rlver=`sed -n 2,2p readline.ver 2>/dev/null`
		/bin/rm -f readline.ver
	],[
		# action if false
		rl_library_version=''
		rlver=''
		/bin/rm -f readline.ver
	],[
		# action if cross compiling
		rl_library_version=''
		rlver=''
		/bin/rm -f readline.ver
	])

	case "$rlver" in
		???)
			wi_cv_lib_readline_result="yes, installed version is $rl_library_version"
			;;
		*)
			# Test using current LIBS.
			AC_TRY_LINK([
				/* includes */
				extern int rl_completion_append_character;
			],[
				/* function-body */
				readline(0);
				rl_completion_append_character = 0;
			],[
				rlver="210"
			],[
				rlver="200"
			])

			if test "$rlver" = "210" ; then
				wi_cv_lib_readline_result="yes, version 2.1 or higher"
			else
				wi_cv_lib_readline_result="yes, version 2.0"
			fi
			;;
	esac

	wi_cv_lib_readline=yes
	# restore LIBS
	LIBS="$ac_save_LIBS"
fi
AC_MSG_RESULT($wi_cv_lib_readline_result)
AC_SUBST(LIBREADLINE)

if test "$wi_cv_lib_readline" = yes ; then
	# Now verify that all the headers are installed.
	#
	AC_REQUIRE_CPP()
	unset ac_cv_header_readline_chardefs_h
	unset ac_cv_header_readline_history_h
	unset ac_cv_header_readline_keymaps_h
	unset ac_cv_header_readline_readline_h
	unset ac_cv_header_readline_tilde_h
	AC_CHECK_HEADERS([readline/chardefs.h readline/history.h readline/keymaps.h readline/readline.h readline/tilde.h])

	for xxwi in \
		"$ac_cv_header_readline_chardefs_h" \
		"$ac_cv_header_readline_history_h" \
		"$ac_cv_header_readline_keymaps_h" \
		"$ac_cv_header_readline_readline_h" \
		"$ac_cv_header_readline_tilde_h" 
	do
		if test "$xxwi" = no ; then
			break
		fi
	done

	if test "$xxwi" = no ; then
		AC_MSG_WARN([GNU Readline headers are not installed or could not be found -- GNU Readline will not be used.])
		wi_cv_lib_readline=no
		wi_cv_lib_readline_result="no (headers not installed)"
	else
		AC_DEFINE_UNQUOTED(HAVE_LIBREADLINE, $rlver)
	fi
fi
])
dnl
dnl
dnl
AH_TEMPLATE([HAVE_LONG_LONG], [define if we have the long long type])
AH_TEMPLATE([PRINTF_LONG_LONG], [define if printf supports long long])
AH_TEMPLATE([SCANF_LONG_LONG], [define if scanf supports long long])
AH_TEMPLATE([PRINTF_ULONG_LONG], [define if printf supports unsigned long long])
AH_TEMPLATE([SCANF_ULONG_LONG], [define if scanf supports unsigned long long])
AH_TEMPLATE([PRINTF_LONG_LONG_QD], [define if using %qd for long long in printf])
AH_TEMPLATE([SCANF_LONG_LONG_QD], [define if using %qd for long long in scanf])
AH_TEMPLATE([PRINTF_LONG_LONG_LLD], [define if using %lld for long long in printf])
AH_TEMPLATE([SCANF_LONG_LONG_LLD], [define if using %lld for long long in scanf])
AC_DEFUN([wi_USE_LONG_LONG], [
wi_PREREQ_UNISTD_H([$0])
AC_MSG_CHECKING([for 64-bit integral type: long long])
LONGEST_INT="long"
AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>

long long hugeNumvar = 1;

main()
{
	long long hugeNumtoo = 2;

	if (hugeNumtoo > hugeNumvar)
		hugeNumvar++;
	if (sizeof(hugeNumvar) < 8)
		exit(1);
	exit(0);
}

],[
	# action if true
	wi_cv_type_long_long=yes
	LONGEST_INT="long long"
],[
	# action if false
  	wi_cv_type_long_long=no
],[
	# action if cross compiling
	wi_cv_type_long_long=no
])
AC_MSG_RESULT($wi_cv_type_long_long)

if test "$wi_cv_type_long_long" = yes ; then
	
AC_MSG_CHECKING([how to print a 64-bit integral type])
wi_cv_printf_long_long=fail

AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

main()
{
	char s[80];
	long long hugeNum;

	hugeNum = (long long) 1000000000;
	hugeNum = hugeNum * (long long) 99;
	hugeNum = hugeNum + (long long) 1;

	(void) sprintf(s, "%lld", hugeNum);
	exit((strcmp(s, "99000000001") == 0) ? 0 : 1);
}
],[
	# action if true
	wi_cv_printf_long_long="%lld"
],[
	# action if false
	:
],[
	# action if cross compiling
	:
])


if test "$wi_cv_printf_long_long" = fail ; then

AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

main()
{
	char s[80];
	long long hugeNum;

	hugeNum = (long long) 1000000000;
	hugeNum = hugeNum * (long long) 99;
	hugeNum = hugeNum + (long long) 1;

	(void) sprintf(s, "%qd", hugeNum);
	exit((strcmp(s, "99000000001") == 0) ? 0 : 1);
}
],[
	# action if true
	wi_cv_printf_long_long="%qd"
],[
	# action if false
	:
],[
	# action if cross compiling
	:
])
fi

if test "$wi_cv_printf_long_long" = fail ; then
	wi_cv_printf_long_long_msg_result='cannot print'
else
	wi_cv_printf_long_long_msg_result="$wi_cv_printf_long_long"
fi

AC_MSG_RESULT($wi_cv_printf_long_long_msg_result)

	
AC_MSG_CHECKING([how to scan a 64-bit integral type])
wi_cv_scanf_long_long=fail

AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

main()
{
	long long hugeNum, justAsHugeNum;

	hugeNum = (long long) 1000000000;
	hugeNum = hugeNum * (long long) 99;
	hugeNum = hugeNum + (long long) 1;

	justAsHugeNum = (long long) 0;
	--justAsHugeNum;
	sscanf("99000000001", "%lld", &justAsHugeNum);
	if (memcmp(&hugeNum, &justAsHugeNum, sizeof(hugeNum)) == 0)
		exit(0);
	exit(1);
}
],[
	# action if true
	wi_cv_scanf_long_long="%lld"
],[
	# action if false
	:
],[
	# action if cross compiling
	:
])


if test "$wi_cv_scanf_long_long" = fail ; then

AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

main()
{
	long long hugeNum, justAsHugeNum;

	hugeNum = (long long) 1000000000;
	hugeNum = hugeNum * (long long) 99;
	hugeNum = hugeNum + (long long) 1;

	justAsHugeNum = (long long) 0;
	--justAsHugeNum;
	sscanf("99000000001", "%qd", &justAsHugeNum);
	if (memcmp(&hugeNum, &justAsHugeNum, sizeof(hugeNum)) == 0)
		exit(0);
	exit(1);
}
],[
	# action if true
	wi_cv_scanf_long_long="%qd"
],[
	# action if false
	:
],[
	# action if cross compiling
	:
])
fi

if test "$wi_cv_scanf_long_long" = fail ; then
	wi_cv_scanf_long_long_msg_result='cannot scan'
else
	wi_cv_scanf_long_long_msg_result="$wi_cv_scanf_long_long"
fi

AC_MSG_RESULT($wi_cv_scanf_long_long_msg_result)

fi

AC_MSG_CHECKING([if everything was available to use the 64-bit integral type])

if test "$wi_cv_type_long_long" = no ; then
	wi_cv_use_long_long_msg_result="no (long long type not available)"
	wi_cv_use_long_long="no"
	wi_cv_scanf_long_long="fail"
	wi_cv_prihtf_long_long="fail"
	LONGEST_INT="long"
elif test "$wi_cv_printf_long_long" = fail ; then
	wi_cv_use_long_long_msg_result="no (libc printf() does not support them)"
	wi_cv_use_long_long="no"
	wi_cv_scanf_long_long="fail"
	wi_cv_prihtf_long_long="fail"
	LONGEST_INT="long"
elif test "$wi_cv_scanf_long_long" = fail ; then
	wi_cv_use_long_long_msg_result="no (libc scanf() does not support them)"
	wi_cv_use_long_long="no"
	wi_cv_scanf_long_long="fail"
	wi_cv_prihtf_long_long="fail"
	LONGEST_INT="long"
else
	AC_DEFINE(HAVE_LONG_LONG)
	if test "$wi_cv_printf_long_long$wi_cv_scanf_long_long" = "%lld%qd" ; then
		# FreeBSD 3.2 has %lld and %qd, but we want to
		# run on 3.1 and 3.0.
		#
		wi_cv_printf_long_long="%qd"
	fi
	wi_cv_printf_ulong_long=`echo "$wi_cv_printf_long_long" | sed 's/d$/u/;'`
	wi_cv_scanf_ulong_long=`echo "$wi_cv_scanf_long_long" | sed 's/d$/u/;'`
	AC_DEFINE_UNQUOTED(PRINTF_LONG_LONG, "$wi_cv_printf_long_long")
	AC_DEFINE_UNQUOTED(SCANF_LONG_LONG , "$wi_cv_scanf_long_long")
	AC_DEFINE_UNQUOTED(PRINTF_ULONG_LONG, "$wi_cv_printf_ulong_long")
	AC_DEFINE_UNQUOTED(SCANF_ULONG_LONG , "$wi_cv_scanf_ulong_long")
	if test "$wi_cv_printf_long_long" = "%qd" ; then
		AC_DEFINE(PRINTF_LONG_LONG_QD)
	else
		AC_DEFINE(PRINTF_LONG_LONG_LLD)
	fi
	if test "$wi_cv_scanf_long_long" = "%qd" ; then
		AC_DEFINE(SCANF_LONG_LONG_QD)
	else
		AC_DEFINE(SCANF_LONG_LONG_LLD)
	fi
	wi_cv_use_long_long="yes"
	wi_cv_use_long_long_msg_result="yes"
fi
AC_MSG_RESULT($wi_cv_use_long_long_msg_result)
])
dnl
dnl
dnl
AC_DEFUN([wi_REMOVE_UNKNOWN_PREPROCESSING_DIRECTIVES_FROM_FILE], [
AC_REQUIRE([wi_TEST_DASH_L])
h_file="$1"
if test -f "$h_file" && $test_not_L "$h_file" ; then
	h_tmp=`echo "$h_file" | sed 's/\.h/.tmp/;'`

changequote(<<, >>)dnl
	remove_cpp_warning=yes
	if [ "$SYS" = linux ] ; then
		#
		# We need to retain #warning on Linux
		#
		remove_cpp_warning=no
	fi
	if [ "$GCC" = yes ] ; then
		#
		# GCC accepts #warning
		#
		remove_cpp_warning=no
	fi

	if [ "$remove_cpp_warning" = yes ] ; then
		#
		# Remove "#warning", since compiler will complain about it
		# not being recognized.
		#
		sed 's/^\([\ \	]*#[\ \	]*warning.*\)/\/* \1 *\//;' "$h_file" > "$h_tmp"
		cmp -s "$h_file" "$h_tmp"
		if test $? -ne 0 ; then 
			mv "$h_tmp" "$h_file"
			chmod a+r "$h_file"
		fi
		/bin/rm -f "$h_tmp"
		unset h_tmp longest_int_subst
	fi
changequote([, ])dnl
fi
unset h_file remove_cpp_warning
])
dnl
dnl
dnl
AC_DEFUN([wi_SUBST_LONGEST_INT_HEADER], [
AC_REQUIRE([wi_TEST_DASH_L])
h_file="$1"
if test -f "$h_file" && $test_not_L "$h_file" ; then
	h_tmp=`echo "$h_file" | sed 's/\.h/.tmp/;'`
dnl
dnl LONGEST_INT should most often be "long long" if wi_USE_LONG_LONG has been run
dnl
	longest_int_subst="${LONGEST_INT-long}"
dnl
	if sed 's/^#define longest_int.*/#define longest_int '"$longest_int_subst"'/;s/^#define longest_uint.*/#define longest_uint unsigned '"$longest_int_subst"'/;' "$h_file" > "$h_tmp" ; then
		cmp -s "$h_file" "$h_tmp"
		if test $? -ne 0 ; then 
			mv "$h_tmp" "$h_file"
			chmod a+r "$h_file"
		fi
	fi
	/bin/rm -f "$h_tmp"
	unset h_tmp longest_int_subst
fi
unset h_file
])
dnl
dnl
dnl
AC_DEFUN([wi_SUBST_STAT_HEADER], [
AC_REQUIRE([wi_TEST_DASH_L])
h_file="$1"
if test -f "$h_file" && $test_not_L "$h_file" ; then
	h_tmp=`echo "$h_file" | sed 's/\.h/.tmp/;'`
dnl
dnl wi_cv_struct_stat64=yes
dnl
	if test "x$wi_cv_struct_stat64" = xyes ; then
		if sed 's/^#define Stat .*/#define Stat stat64/;s/^#define Lstat .*/#define Lstat lstat64/;s/^#define Fstat .*/#define Fstat fstat64/;' "$h_file" > "$h_tmp" ; then
			cmp -s "$h_file" "$h_tmp"
			if test $? -ne 0 ; then 
				mv "$h_tmp" "$h_file"
				chmod a+r "$h_file"
			fi
		fi
	else
		if sed 's/^#define Stat .*/#define Stat stat/;s/^#define Lstat .*/#define Lstat lstat/;s/^#define Fstat .*/#define Fstat fstat/;' "$h_file" > "$h_tmp" ; then
			cmp -s "$h_file" "$h_tmp"
			if test $? -ne 0 ; then 
				mv "$h_tmp" "$h_file"
				chmod a+r "$h_file"
			fi
		fi
	fi
	/bin/rm -f "$h_tmp"
	unset h_tmp longest_int_subst
fi
unset h_file
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_MANDIR], [
if test "x$mandir" = 'x${prefix}/man' ; then
	# Mandir is at default value -- try to see
	# if $prefix/share/man would be better.
	#

	# $prefix is probably set to NONE.
	#
	p=`cd / ; cd $prefix 2>/dev/null ; pwd`
	if test "x$p" = "x/" ; then
		p="/usr/local"
	fi
	if test -d "$p/share/man" ; then
		mandir="$p/share/man"
	fi
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_BEAUTIFY_ENVIRONMENT_VARIABLES], [
changequote(<<, >>)dnl
LIBS=`echo "$LIBS" | sed 's/^ *//;s/ *$//;s/  */ /g'`
LDFLAGS=`echo "$LDFLAGS" | sed 's/^ *//;s/ *$//;s/  */ /g'`
CPPFLAGS=`echo "$CPPFLAGS" | sed 's/^ *//;s/ *$//;s/  */ /g'`
CFLAGS=`echo "$CFLAGS $wi_CFLAGS_TO_ADD_LATER" | sed 's/^ *//;s/ *$//;s/  */ /g'`
DEFS=`echo "$DEFS" | sed 's/^ *//;s/ *$//;s/  */ /g'`
changequote([, ])dnl
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PATH_PWD], [
AC_PATH_PROG(wi_PWD, "pwd", "pwd")
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_BASENAME], [
$1=`echo "[$]$1" | sed -n '
s-//*-/-g
s-/*$--
s-^/$--
s-^.*/--
p
q'`dnl
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_DIRNAME], [
changequote({{, }})dnl
$1=`echo "{{$}}$1" | sed -n '
s-//*-/-g
s-/*$--
/^\/\/*[^/]*$/{
	c\\
/
	p
	q
}
/^[^/]*$/{
	c\\
.
	p
	q
}
/./{
	s-/[^/]*$--
	p
	q
}'`dnl
changequote([, ])dnl
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_RESOLVE_PATH], [
AC_REQUIRE([wi_PATH_PWD])
wi_path="$1"
if test -d "$wi_path" ; then
	wi_resolved_path=`cd "$wi_path" ; $wi_PWD 2>/dev/null`
elif test ! -f "$wi_path" ; then
	wi_resolved_path="$wi_path"
else
	wi_parent_dir="$wi_path"
	wi_file_name="$wi_path"
	wi_DIRNAME(wi_parent_dir)
	wi_BASENAME(wi_file_name)
	wi_resolved_path=`cd "$wi_parent_dir" ; $wi_PWD 2>/dev/null`
	if test "x$wi_resolved_path" != x ; then
		wi_resolved_path="$wi_resolved_path/$wi_file_name"
	fi
	unset wi_parent_dir wi_file_name
fi
if test "x$wi_resolved_path" = x ; then
	$2="[$]$1"
else
	$2="$wi_resolved_path"
fi
unset wi_resolved_path wi_path
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PATH_MKTEMP], [
AC_PATH_PROG(MKTEMP, "mktemp", "")
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PATH_PERL], [
AC_PATH_PROG(PERL, "perl", "perl")
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PROG_PERL], [
AC_REQUIRE([wi_PATH_PERL])
if test "x$PERL" != "x" ; then
	AC_DEFINE_UNQUOTED(PERL, "$PERL")
fi
AC_SUBST(PERL)
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_CREATE_AC_TMPDIR], [
AC_REQUIRE([wi_PATH_MKTEMP])
changequote({{, }})dnl
wi_tmpdir=""
if [ "x$MKTEMP" != "x" ] ; then
	# Ignore error from mktemp, since some old versions of Linux
	# print an error about not supporting -d.
	#
	wi_tmpdir=`"$MKTEMP" -d /tmp/configure.XXXXXXXXXX 2>/dev/null`
	if [ $? -ne 0 ] ; then
		wi_tmpdir=""
	fi
fi
if [ "x$wi_tmpdir" = "x" ] ; then
	for wi_tmpdir in . $TMPDIR $TEMPDIR /tmp ABORT
	do
		if [ "$wi_tmpdir" = ABORT ] ; then
			echo "Cannot create temporary directory."
			exit 1
		fi
		wi_tmpdir="$wi_tmpdir/config_tmp.$$"
		if [ -d "$wi_tmpdir" ] || [ -f "$wi_tmpdir" ] ; then
			echo "Will not create temporary directory."
			exit 1
		fi
		mkdir "$wi_tmpdir"
		if [ $? -eq 0 ] && [ -d "$wi_tmpdir" ] ; then break ;  fi
	done
fi
changequote([, ])dnl

# Use the temporary directory here...
$1
# Done using the temporary directory here.

/bin/rm -r "$wi_tmpdir"
unset wi_tmpdir
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([SELECT_TYPE_ARG1], [define this to the type of the first parameter to select()])
AH_TEMPLATE([SELECT_TYPE_ARG234], [define this to the type of parameters 2, 3, and 4 to select()])
AH_TEMPLATE([SELECT_TYPE_ARG5], [define this to the type of the fifth parameter to select()])
AC_DEFUN([wi_FUNC_SELECT_ARGTYPES],
[
wi_PREREQ_UNISTD_H([$0])
AC_MSG_CHECKING([types of arguments for select()])
 AC_CACHE_VAL(ac_cv_func_select_arg234,dnl
 [AC_CACHE_VAL(ac_cv_func_select_arg1,dnl
  [AC_CACHE_VAL(ac_cv_func_select_arg5,dnl
   [for ac_cv_func_select_arg234 in 'fd_set *' 'int *' 'void *'; do
     for ac_cv_func_select_arg1 in 'int' 'size_t' 'unsigned long' 'unsigned'; do
      for ac_cv_func_select_arg5 in 'struct timeval *' 'const struct timeval *'; do
       AC_TRY_COMPILE(dnl
[#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)	/* MG */
#	define _ALL_SOURCE 1	/* MG */
#endif
#ifdef HAVE_UNISTD_H	/* MG */
#include <unistd.h>
#endif			/* MG */
#include <sys/types.h>	/* MG: always incl */
#include <sys/time.h>	/* MG: always incl */
#ifdef HAVE_SYS_SELECT_H
#include <sys/select.h>
#endif
#include <sys/socket.h>	/* MG: always incl */
extern select ($ac_cv_func_select_arg1,$ac_cv_func_select_arg234,$ac_cv_func_select_arg234,$ac_cv_func_select_arg234,$ac_cv_func_select_arg5);],,dnl
        [ac_not_found=no ; break 3],ac_not_found=yes)
      done
     done
    done
   ])dnl AC_CACHE_VAL
  ])dnl AC_CACHE_VAL
 ])dnl AC_CACHE_VAL
 if test "$ac_not_found" = yes; then
  ac_cv_func_select_arg1=int 
  ac_cv_func_select_arg234='int *' 
  ac_cv_func_select_arg5='struct timeval *'
 fi
 AC_MSG_RESULT([$ac_cv_func_select_arg1,$ac_cv_func_select_arg234,$ac_cv_func_select_arg5])
 AC_DEFINE_UNQUOTED(SELECT_TYPE_ARG1,$ac_cv_func_select_arg1)
 AC_DEFINE_UNQUOTED(SELECT_TYPE_ARG234,($ac_cv_func_select_arg234))
 AC_DEFINE_UNQUOTED(SELECT_TYPE_ARG5,($ac_cv_func_select_arg5))
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_CREATE_PRPP_SCRIPT], [
changequote({{, }})dnl
cat << 'EOF' > "{{$1}}"
#!/usr/bin/perl -w
#
# prpp.pl
#
# Feed the output of your CPP to this to print a list of function prototypes.
# 
#use strict;

my ($c) = "";
my ($unputc) = "";
my ($line) = "";
my ($lines) = "";
my ($cline) = "";
my ($skipping) = 0;
my ($numclines) = 0;

MAINLOOP: while (1) {
	if ($unputc ne "") {
		$c = $unputc;
		$unputc = "";
	} else {
		last unless (read(STDIN, $c, 1) == 1);
	}
	if ($c eq "{") {
		$skipping++;
	} elsif ($c eq "}") {
		--$skipping;
		$unputc = ";";
	} elsif ($skipping) {
		next MAINLOOP;
	} elsif ($c eq ";") {
		if ($line =~ m/^\s*(\S.*\S)\s*$/s) {
			$lines .= {{$}}1;
			$line = "";
		}
		if ($lines =~ m/^\s*(extern\s*)?(\S.*\S)\s*$/s) {
			$cline = {{$}}2;
			$cline =~ s/\s+/\ /g;
			if ($cline =~ /^typedef/) {
				$cline = "";
			} elsif ($cline =~ /\(.*\)$/) {
				# found a proto
				print $cline, ";\n";
				$numclines++;
			} else {
				$cline = "";
			}
		}
		$lines = "";
		$line = "";
	} elsif ($c eq "\n") {
		if ($line =~ m/^\s*(\S.*\S)\s*$/s) {
			$lines .= {{$}}1 . " ";
			$line = "";
		}
	} elsif (($c eq "#") && ($line eq "")) {
		# Looks like a preprocessor line, kill it
		{
			last MAINLOOP if (read(STDIN, $c, 1) != 1);
			last if ($c eq "\n");
			redo;
		}
	} elsif ($c =~ /^\s$/) {
		$line .= " " if ($line ne "");
	} elsif (! $skipping) {
		$line .= $c;
	}
}
exit(($numclines == 0) ? 1 : 0);
EOF
chmod 755 "{{$1}}"
changequote([, ])dnl
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([write_return_t], [return type from write])
AH_TEMPLATE([write_size_t], [size parameter to write])
AH_TEMPLATE([read_return_t], [return type from read])
AH_TEMPLATE([read_size_t], [size parameter to read])
AH_TEMPLATE([send_return_t], [return type from send])
AH_TEMPLATE([send_size_t], [size parameter to send])
AH_TEMPLATE([recv_return_t], [return type from recv])
AH_TEMPLATE([recv_size_t], [size parameter to recv])
AH_TEMPLATE([sockaddr_size_t], [size parameter to connect])
AH_TEMPLATE([sockopt_size_t], [size parameter to setsockopt])
AH_TEMPLATE([listen_backlog_t], [backlog parameter to write])
AH_TEMPLATE([alarm_time_t], [seconds parameter to alarm])
AH_TEMPLATE([gethost_addrptr_t], [address parameter to gethostbyaddr])
AH_TEMPLATE([gethostname_size_t], [size parameter to gethostname])
AC_DEFUN([wi_UNISTD_FUNC_PARAM_TYPES], [
AC_REQUIRE([AC_PROG_CPP])
AC_REQUIRE([wi_PATH_PERL])
AC_REQUIRE([AC_TYPE_SIZE_T])
AC_REQUIRE([wi_PATH_MKTEMP])
wi_PREREQ_UNISTD_H([$0])
AC_CACHE_CHECK([for return type from write], [wi_cv_write_return_t], [
used_cache_for_wi_unistd_fpt="no"
wi_CREATE_AC_TMPDIR([
wi_CREATE_PRPP_SCRIPT([$wi_tmpdir/prpp.pl])

changequote({{, }})dnl
cat << 'EOF' > "$wi_tmpdir/unistd.c"
#include <confdefs.h>

#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

main()
{
	exit(0);
}
EOF

cat << 'EOF' > "$wi_tmpdir/sed.sh"
#!/bin/sh

if [ {{$}}# -eq 0 ] ; then exit 1 ; fi
x="{{$}}1"

sed -n 's/extern//;s/static//;
		/[\ \*]'"$x"'\ *(/{
			s/^.*'"$x"'\ *(/(/
			s/)\ *[;,].*$/)/
			/ssize_t/{
				c\
ssize_t
			}
			/size_t/{
				c\
size_t
			}
			/socklen_t/{
				c\
socklen_t
			}
			/unsigned int/{
				c\
unsigned int
			}
			/unsigned long/{
				c\
unsigned long
			}
			/long/{
				c\
long
			}
			q
}' | sed 's/int int/int/g'
EOF
chmod 755 "$wi_tmpdir/sed.sh"


cat << 'EOF' > "$wi_tmpdir/sed2.sh"
#!/bin/sh

if [ {{$}}# -eq 0 ] ; then exit 1 ; fi
x="{{$}}1"

sed -n 's/extern//;s/static//;
		/[\ \*]'"$x"'\ *(/{
			s/^.*'"$x"'\ *(/(/
			s/)\ *[;,].*$/)/
			/const char/{
				c\
const char *
			}
			/char/{
				c\
char *
			}
			/const/{
				c\
const void
			}
			q
}'
EOF
chmod 755 "$wi_tmpdir/sed2.sh"

$CPP "-I${srcdir-.}" "$wi_tmpdir/unistd.c" > "$wi_tmpdir/unistd.i"
if [ -s "$wi_tmpdir/unistd.i" ] ; then
	"$PERL" "$wi_tmpdir/prpp.pl" < "$wi_tmpdir/unistd.i" > "$wi_tmpdir/protos.h"
fi
if [ -f "$wi_tmpdir/protos.h" ] ; then
	#
	# Check the return type of write()
	#
	x="write"
	wi_cv_write_return_t=`sed -n 's/extern//;s/static//;
		s/__attribute__((__cdecl__))//;
		/[\ \*]'"$x"'\ *(/{
			s/'"$x"'\ *(.*//
			s/^\ *//
			s/\ *$//
			p;q
		}' "$wi_tmpdir/protos.h"`
	#
	# Check what type write() expects for the size parameter
	#
	x="write"
	wi_cv_write_size_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check the return type of send()
	#
	x="send"
	wi_cv_send_return_t=`sed -n 's/extern//;s/static//;
		s/__attribute__((__cdecl__))//;
		/[\ \*]'"$x"'\ *(/{
			s/'"$x"'\ *(.*//
			s/^\ *//
			s/\ *$//
			p;q
		}' "$wi_tmpdir/protos.h"`
	#
	# Check what type send() expects for the size parameter
	# Tru64 is one example where send() differs from write()  :-(
	#
	x="send"
	wi_cv_send_size_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check what type connect() expects for the size parameter
	#
	x="connect"
	wi_cv_sockaddr_size_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check what type setsockopt() expects for the size parameter
	#
	x="setsockopt"
	wi_cv_sockopt_size_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check what type listen() expects for the backlog parameter
	#
	x="listen"
	wi_cv_listen_backlog_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check what type alarm() expects for the seconds parameter
	#
	x="alarm"
	wi_cv_alarm_time_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check what type gethostbyaddr() expects for the addr parameter
	#
	x="gethostbyaddr"
	wi_cv_gethost_addrptr_t=`/bin/sh "$wi_tmpdir/sed2.sh" "$x" < "$wi_tmpdir/protos.h"`
	#
	# Check what type gethostname() expects for the size parameter
	#
	x="gethostname"
	wi_cv_gethostname_size_t=`/bin/sh "$wi_tmpdir/sed.sh" "$x" < "$wi_tmpdir/protos.h"`
fi
if [ "x$wi_cv_write_return_t" = "x" ] ; then
	wi_cv_write_return_t="int"
fi
if [ "x$wi_cv_write_size_t" = "x" ] ; then
	wi_cv_write_size_t="int"
fi
if [ "x$wi_cv_send_return_t" = "x" ] ; then
	wi_cv_send_return_t="int"
fi
if [ "x$wi_cv_send_size_t" = "x" ] ; then
	wi_cv_send_size_t="int"
fi
if [ "x$wi_cv_sockaddr_size_t" = "x" ] ; then
	wi_cv_sockaddr_size_t="int"
fi
if [ "x$wi_cv_sockopt_size_t" = "x" ] ; then
	wi_cv_sockopt_size_t="int"
fi
if [ "x$wi_cv_listen_backlog_t" = "x" ] ; then
	wi_cv_listen_backlog_t="int"
fi
if [ "x$wi_cv_alarm_time_t" = "x" ] ; then
	wi_cv_alarm_time_t="int"
fi
if [ "x$wi_cv_gethost_addrptr_t" = "x" ] ; then
	wi_cv_gethost_addrptr_t="struct in_addr *"
fi
if [ "$wi_cv_gethost_addrptr_t" = "const void" ] ; then
	wi_cv_gethost_addrptr_t="const struct in_addr *"
fi
if [ "x$wi_cv_gethostname_size_t" = "x" ] ; then
	wi_cv_gethostname_size_t="int"
fi
changequote([, ])dnl
])
])
if test "x$used_cache_for_wi_unistd_fpt" = "xno" ; then
	AC_MSG_CHECKING([for size parameter to write])
	AC_MSG_RESULT([$wi_cv_write_size_t])
	AC_MSG_CHECKING([for return type from send])
	AC_MSG_RESULT([$wi_cv_send_return_t])
	AC_MSG_CHECKING([for size parameter to send])
	AC_MSG_RESULT([$wi_cv_send_size_t])
	AC_MSG_CHECKING([for size parameter to connect])
	AC_MSG_RESULT([$wi_cv_sockaddr_size_t])
	AC_MSG_CHECKING([for size parameter to setsockopt])
	AC_MSG_RESULT([$wi_cv_sockopt_size_t])
	AC_MSG_CHECKING([for backlog parameter to listen])
	AC_MSG_RESULT([$wi_cv_listen_backlog_t])
	AC_MSG_CHECKING([for seconds parameter to alarm])
	AC_MSG_RESULT([$wi_cv_alarm_time_t])
	AC_MSG_CHECKING([for address parameter to gethostbyaddr])
	AC_MSG_RESULT([$wi_cv_gethost_addrptr_t])
	AC_MSG_CHECKING([for size parameter to gethostname])
	AC_MSG_RESULT([$wi_cv_gethostname_size_t])
else
	AC_CACHE_CHECK([for size parameter to write],[wi_cv_write_size_t],[:])
	AC_CACHE_CHECK([for return type from send],[wi_cv_send_return_t],[:])
	AC_CACHE_CHECK([for size parameter to send],[wi_cv_send_size_t],[:])
	AC_CACHE_CHECK([for size parameter to connect],[wi_cv_sockaddr_size_t],[:])
	AC_CACHE_CHECK([for size parameter to setsockopt],[wi_cv_sockopt_size_t],[:])
	AC_CACHE_CHECK([for backlog parameter to listen],[wi_cv_listen_backlog_t],[:])
	AC_CACHE_CHECK([for seconds parameter to alarm],[wi_cv_alarm_time_t],[:])
	AC_CACHE_CHECK([for address parameter to gethostbyaddr],[wi_cv_gethost_addrptr_t],[:])
	AC_CACHE_CHECK([for size parameter to gethostname],[wi_cv_gethostname_size_t],[:])
fi
unset used_cache_for_wi_unistd_fpt
AC_DEFINE_UNQUOTED(write_return_t, $wi_cv_write_return_t)
AC_DEFINE_UNQUOTED(write_size_t, $wi_cv_write_size_t)
AC_DEFINE_UNQUOTED(read_return_t, $wi_cv_write_return_t)
AC_DEFINE_UNQUOTED(read_size_t, $wi_cv_write_size_t)
AC_DEFINE_UNQUOTED(send_return_t, $wi_cv_send_return_t)
AC_DEFINE_UNQUOTED(send_size_t, $wi_cv_send_size_t)
AC_DEFINE_UNQUOTED(recv_return_t, $wi_cv_send_return_t)
AC_DEFINE_UNQUOTED(recv_size_t, $wi_cv_send_size_t)
AC_DEFINE_UNQUOTED(sockaddr_size_t, $wi_cv_sockaddr_size_t)
AC_DEFINE_UNQUOTED(sockopt_size_t, $wi_cv_sockopt_size_t)
AC_DEFINE_UNQUOTED(listen_backlog_t, $wi_cv_listen_backlog_t)
AC_DEFINE_UNQUOTED(alarm_time_t, $wi_cv_alarm_time_t)
AC_DEFINE_UNQUOTED(gethost_addrptr_t, $wi_cv_gethost_addrptr_t)
AC_DEFINE_UNQUOTED(gethostname_size_t, $wi_cv_gethostname_size_t)
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PATH_GNU_TAR_OR_TAR], [
AC_PATH_PROG(TAR, "gtar", "")
if test "x$TAR" = "x" ; then
	unset TAR
	unset ac_cv_path_TAR
	AC_PATH_PROG(TAR, "tar", "")
fi
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([TAR], [define to the tar command being used])
AC_DEFUN([wi_PROG_TAR], [
AC_REQUIRE([wi_PATH_GNU_TAR_OR_TAR])
if test "x$TAR" != "x" ; then
	AC_DEFINE_UNQUOTED(TAR, "$TAR")
fi
AC_SUBST(TAR)
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_CREATE_TAR_FILES], [
AC_REQUIRE([wi_PATH_GNU_TAR_OR_TAR])
AC_MSG_CHECKING([how to create TAR files])
changequote(<<, >>)dnl
x=""
if [ -x /usr/bin/what ] ; then
	x=`/usr/bin/what "$TAR" 2>&1 | sed -n 's/.*pax.*/pax/g;/pax/p'`
elif [ -x /bin/what ] ; then
	x=`/bin/what "$TAR" 2>&1 | sed -n 's/.*pax.*/pax/g;/pax/p'`
fi
if [ "x$x" != "xpax" ] ; then
	# The junk above is because Mac OS X Server's tar freaks out
	# and does not exit if you do "tar --help".
	#
	x=`"$TAR" --help 2>&1 | sed -n 's/.*owner=NAME.*/owner=NAME/g;/owner=NAME/p'`
fi
case "$x" in
	*owner=NAME*)
		TARFLAGS="-c --owner=root --group=bin --verbose -f"
		;;
	*)
		TARFLAGS="cvf"
		;;
esac
changequote([, ])dnl
AC_SUBST(TARFLAGS)
AC_MSG_RESULT([$TAR $TARFLAGS])
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PROG_CCDV_NO_CREATE], [
if test "x$use_ccdv" = "xno" ; then
	AC_MSG_CHECKING([for ccdv])
	AC_MSG_RESULT([(disabled)])
else
	AC_PATH_PROG(CCDV, "CCDV", "")
	CCDV="$wi_cv_path_ccdv"
	if test "x$CCDV" != x ; then
		CCDV="@$CCDV "	# trailing space needed
	fi
AC_SUBST(CCDV)
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_PROG_CCDV], [
if test "x$use_ccdv" = "xno" ; then
	AC_MSG_CHECKING([for ccdv])
	AC_MSG_RESULT([(disabled)])
else
unset wi_cv_path_ccdv	# can't use cache if it was a temp prog last time
wi_used_cache_path_ccdv="yes"
AC_CACHE_CHECK([for ccdv], [wi_cv_path_ccdv], [
wi_used_cache_path_ccdv="no"
for CCDV in /usr/bin/ccdv /usr/local/bin/ccdv /usr/ccs/bin/ccdv NONE
do
	if test "$CCDV" = NONE ; then CCDV="" ; break ; fi
	$CCDV >/dev/null 2>&1
	if test $? -eq 96 ; then
		break
	fi
done
if test "x$CCDV" = "x" ; then
	changequote({{, }})dnl
	cat > ccdv.c << 'EOF'
/* ccdv.c
 *
 * Copyright (C) 2002-2003, by Mike Gleason, NcFTP Software.
 * All Rights Reserved.
 *
 * Licensed under the GNU Public License.
 */
#include <unistd.h>
#include <sys/types.h>
#include <sys/time.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <errno.h>

#define SETCOLOR_SUCCESS	(gANSIEscapes ? "\033\1331;32m" : "")
#define SETCOLOR_FAILURE	(gANSIEscapes ? "\033\1331;31m" : "")
#define SETCOLOR_WARNING	(gANSIEscapes ? "\033\1331;33m" : "")
#define SETCOLOR_NORMAL		(gANSIEscapes ? "\033\1330;39m" : "")

#define TEXT_BLOCK_SIZE 8192
#define INDENT 2

#define TERMS "vt100:vt102:vt220:vt320:xterm:xterm-color:ansi:linux:scoterm:scoansi:dtterm:cons25:cygwin:screen"

size_t gNBufUsed = 0, gNBufAllocated = 0;
char *gBuf = NULL;
int gCCPID;
char gAction[64] = "";
char gTarget[64] = "";
char gAr[32] = "";
char gArLibraryTarget[64] = "";
int gDumpCmdArgs = 0;
char gArgsStr[800];
int gColumns = 80;
int gANSIEscapes = 0;
int gExitStatus = 95;

static void
DumpFormattedOutput(void)
{
	char *cp;
	char spaces[8 + 1] = "        ";
	char *saved;
	int curcol;
	int i;

	curcol = 0;
	saved = NULL;
	for (cp = gBuf + ((gDumpCmdArgs == 0) ? strlen(gArgsStr) : 0); ; cp++) {
		if (*cp == '\0') {
			if (saved != NULL) {
				cp = saved;
				saved = NULL;
			} else break;
		}
		if (*cp == '\r')
			continue;
		if (*cp == '\t') {
			saved = cp + 1;
			cp = spaces + 8 - (8 - ((curcol - INDENT - 1) % 8));
		}
		if (curcol == 0) {
			for (i = INDENT; --i >= 0; )
				putchar(' ');
			curcol = INDENT;
		}
		putchar(*cp);
		if (++curcol == (gColumns - 1)) {
			putchar('\n');
			curcol = 0;
		} else if (*cp == '\n')
			curcol = 0;
	}
	free(gBuf);
}	/* DumpFormattedOutput */



/* Difftime(), only for timeval structures.  */
static void TimeValSubtract(struct timeval *tdiff, struct timeval *t1, struct timeval *t0)
{
	tdiff->tv_sec = t1->tv_sec - t0->tv_sec;
	tdiff->tv_usec = t1->tv_usec - t0->tv_usec;
	if (tdiff->tv_usec < 0) {
		tdiff->tv_sec--;
		tdiff->tv_usec += 1000000;
	}
}	/* TimeValSubtract */



static void
Wait(void)
{
	int pid2, status;

	do {
		status = 0;
		pid2 = (int) waitpid(gCCPID, &status, 0);
	} while (((pid2 >= 0) && (! WIFEXITED(status))) || ((pid2 < 0) && (errno == EINTR)));
	if (WIFEXITED(status))
		gExitStatus = WEXITSTATUS(status);
}	/* Wait */



static int
SlurpProgress(int fd)
{
	char s1[71];
	char *newbuf;
	int nready;
	size_t ntoread;
	ssize_t nread;
	struct timeval now, tnext, tleft;
	fd_set ss;
	fd_set ss2;
	const char *trail = "/-\\|", *trailcp;

	trailcp = trail;
	snprintf(s1, sizeof(s1), "%s%s%s... ", gAction, gTarget[0] ? " " : "", gTarget);
	printf("\r%-70s%-9s", s1, "");
	fflush(stdout);

	gettimeofday(&now, NULL);
	tnext = now;
	tnext.tv_sec++;
	tleft.tv_sec = 1;
	tleft.tv_usec = 0;
	FD_ZERO(&ss2);
	FD_SET(fd, &ss2);
	for(;;) {
		if (gNBufUsed == (gNBufAllocated - 1)) {
			if ((newbuf = (char *) realloc(gBuf, gNBufAllocated + TEXT_BLOCK_SIZE)) == NULL) {
				perror("ccdv: realloc");
				return (-1);
			}
			gNBufAllocated += TEXT_BLOCK_SIZE;
			gBuf = newbuf;
		}
		for (;;) {
			ss = ss2;
			nready = select(fd + 1, &ss, NULL, NULL, &tleft);
			if (nready == 1)
				break;
			if (nready < 0) {
				if (errno != EINTR) {
					perror("ccdv: select");
					return (-1);
				}
				continue;
			}
			gettimeofday(&now, NULL);
			if ((now.tv_sec > tnext.tv_sec) || ((now.tv_sec == tnext.tv_sec) && (now.tv_usec >= tnext.tv_usec))) {
				tnext = now;
				tnext.tv_sec++;
				tleft.tv_sec = 1;
				tleft.tv_usec = 0;
				printf("\r%-71s%c%-7s", s1, *trailcp, "");
				fflush(stdout);
				if (*++trailcp == '\0')
					trailcp = trail;
			} else {
				TimeValSubtract(&tleft, &tnext, &now);
			}
		}
		ntoread = (gNBufAllocated - gNBufUsed - 1);
		nread = read(fd, gBuf + gNBufUsed, ntoread);
		if (nread < 0) {
			if (errno == EINTR)
				continue;
			perror("ccdv: read");
			return (-1);
		} else if (nread == 0) {
			break;
		}
		gNBufUsed += nread;
		gBuf[gNBufUsed] = '\0';
	}
	snprintf(s1, sizeof(s1), "%s%s%s: ", gAction, gTarget[0] ? " " : "", gTarget);
	Wait();
	if (gExitStatus == 0) {
		printf("\r%-70s", s1);
		printf("[%s%s%s]", ((gNBufUsed - strlen(gArgsStr)) < 4) ? SETCOLOR_SUCCESS : SETCOLOR_WARNING, "OK", SETCOLOR_NORMAL);
		printf("%-5s\n", " ");
	} else {
		printf("\r%-70s", s1);
		printf("[%s%s%s]", SETCOLOR_FAILURE, "ERROR", SETCOLOR_NORMAL);
		printf("%-2s\n", " ");
		gDumpCmdArgs = 1;	/* print cmd when there are errors */
	}
	fflush(stdout);
	return (0);
}	/* SlurpProgress */



static int
SlurpAll(int fd)
{
	char *newbuf;
	size_t ntoread;
	ssize_t nread;

	printf("%s%s%s.\n", gAction, gTarget[0] ? " " : "", gTarget);
	fflush(stdout);

	for(;;) {
		if (gNBufUsed == (gNBufAllocated - 1)) {
			if ((newbuf = (char *) realloc(gBuf, gNBufAllocated + TEXT_BLOCK_SIZE)) == NULL) {
				perror("ccdv: realloc");
				return (-1);
			}
			gNBufAllocated += TEXT_BLOCK_SIZE;
			gBuf = newbuf;
		}
		ntoread = (gNBufAllocated - gNBufUsed - 1);
		nread = read(fd, gBuf + gNBufUsed, ntoread);
		if (nread < 0) {
			if (errno == EINTR)
				continue;
			perror("ccdv: read");
			return (-1);
		} else if (nread == 0) {
			break;
		}
		gNBufUsed += nread;
		gBuf[gNBufUsed] = '\0';
	}
	Wait();
	gDumpCmdArgs = (gExitStatus != 0);	/* print cmd when there are errors */
	return (0);
}	/* SlurpAll */



static const char *
Basename(const char *path)
{
	const char *cp;
	cp = strrchr(path, '/');
	if (cp == NULL)
		return (path);
	return (cp + 1);
}	/* Basename */



static const char *
Extension(const char *path)
{
	const char *cp = path;
	cp = strrchr(path, '.');
	if (cp == NULL)
		return ("");
	return (cp);
}	/* Extension */



static void
Usage(void)
{
	fprintf(stderr, "Usage: ccdv /path/to/cc CFLAGS...\n\n");
	fprintf(stderr, "I wrote this to reduce the deluge Make output to make finding actual problems\n");
	fprintf(stderr, "easier.  It is intended to be invoked from Makefiles, like this.  Instead of:\n\n");
	fprintf(stderr, "\t.c.o:\n");
	fprintf(stderr, "\t\t$(CC) $(CFLAGS) $(DEFS) $(CPPFLAGS) $< -c\n");
	fprintf(stderr, "\nRewrite your rule so it looks like:\n\n");
	fprintf(stderr, "\t.c.o:\n");
	fprintf(stderr, "\t\t@ccdv $(CC) $(CFLAGS) $(DEFS) $(CPPFLAGS) $< -c\n\n");
	fprintf(stderr, "ccdv 1.1.0 is Free under the GNU Public License.  Enjoy!\n");
	fprintf(stderr, "  -- Mike Gleason, NcFTP Software <http://www.ncftp.com>\n");
	exit(96);
}	/* Usage */



int
main(int argc, char **argv)
{
	int pipe1[2];
	int devnull;
	char emerg[256];
	int fd;
	int nread;
	int i;
	int cc = 0, pch = 0;
	const char *quote;

	if (argc < 2)
		Usage();

	snprintf(gAction, sizeof(gAction), "Running %s", Basename(argv[1]));
	memset(gArgsStr, 0, sizeof(gArgsStr));
	for (i = 1; i < argc; i++) {
		quote = (strchr(argv[i], ' ') != NULL) ? "\"" : "";
		snprintf(gArgsStr + strlen(gArgsStr), sizeof(gArgsStr) - strlen(gArgsStr), "%s%s%s%s%s", (i == 1) ? "" : " ", quote, argv[i], quote, (i == (argc - 1)) ? "\n" : "");
		if ((strcmp(argv[i], "-o") == 0) && ((i + 1) < argc)) {
			if (strcasecmp(Extension(argv[i + 1]), ".o") != 0) {
				strcpy(gAction, "Linking");
				snprintf(gTarget, sizeof(gTarget), "%s", Basename(argv[i + 1]));
			}
		} else if (strchr("-+/", (int) argv[i][0]) != NULL) {
			continue;
		} else if (strncasecmp(Extension(argv[i]), ".c", 2) == 0) {
			cc++;
			snprintf(gTarget, sizeof(gTarget), "%s", Basename(argv[i]));
		} else if ((strncasecmp(Extension(argv[i]), ".h", 2) == 0) && (cc == 0)) {
			pch++;
			snprintf(gTarget, sizeof(gTarget), "%s", Basename(argv[i]));
		} else if ((i == 1) && (strcmp(Basename(argv[i]), "ar") == 0)) {
			snprintf(gAr, sizeof(gAr), "%s", Basename(argv[i]));
		} else if ((gArLibraryTarget[0] == '\0') && (strcasecmp(Extension(argv[i]), ".a") == 0)) {
			snprintf(gArLibraryTarget, sizeof(gArLibraryTarget), "%s", Basename(argv[i]));
		}
	}
	if ((gAr[0] != '\0') && (gArLibraryTarget[0] != '\0')) {
		strcpy(gAction, "Creating library");
		snprintf(gTarget, sizeof(gTarget), "%s", gArLibraryTarget);
	} else if (pch > 0) {
		strcpy(gAction, "Precompiling");
	} else if (cc > 0) {
		strcpy(gAction, "Compiling");
	}

	if (pipe(pipe1) < 0) {
		perror("ccdv: pipe");
		exit(97);
	}

	(void) close(0);
	devnull = open("/dev/null", O_RDWR, 00666);
	if ((devnull != 0) && (dup2(devnull, 0) == 0))
		close(devnull);

	gCCPID = (int) fork();
	if (gCCPID < 0) {
		(void) close(pipe1[0]);
		(void) close(pipe1[1]);
		perror("ccdv: fork");
		exit(98);
	} else if (gCCPID == 0) {
		/* Child */
		(void) close(pipe1[0]);		/* close read end */
		if (pipe1[1] != 1) {		/* use write end on stdout */
			(void) dup2(pipe1[1], 1);
			(void) close(pipe1[1]);
		}
		(void) dup2(1, 2);		/* use write end on stderr */
		execvp(argv[1], argv + 1);
		perror(argv[1]);
		exit(99);
	}

	/* parent */
	(void) close(pipe1[1]);		/* close write end */
	fd = pipe1[0];			/* use read end */

	gColumns = (getenv("COLUMNS") != NULL) ? atoi(getenv("COLUMNS")) : 80;
	gANSIEscapes = (getenv("TERM") != NULL) && (strstr(TERMS, getenv("TERM")) != NULL);
	gBuf = (char *) malloc(TEXT_BLOCK_SIZE);
	if (gBuf == NULL) 
		goto panic;
	gNBufUsed = 0;
	gNBufAllocated = TEXT_BLOCK_SIZE;
	if (strlen(gArgsStr) < (gNBufAllocated - 1)) {
		strcpy(gBuf, gArgsStr);
		gNBufUsed = strlen(gArgsStr);
	}

	if (isatty(1)) {
		if (SlurpProgress(fd) < 0)
			goto panic;
	} else {
		if (SlurpAll(fd) < 0)
			goto panic;
	}
	DumpFormattedOutput();
	exit(gExitStatus);

panic:
	gDumpCmdArgs = 1;	/* print cmd when there are errors */
	DumpFormattedOutput();
	while ((nread = read(fd, emerg, (size_t) sizeof(emerg))) > 0)
		(void) write(2, emerg, (size_t) nread);
	Wait();
	exit(gExitStatus);
}	/* main */
/* eof ccdv.c */
EOF
	changequote([, ])dnl
	${CC-cc} $DEFS $CPPFLAGS $CFLAGS "ccdv.c" -o "ccdv" >/dev/null 2>&1
	/bin/rm -f ccdv.c ccdv.o ccdv.c.gz.uu ccdv.c.gz
	strip ./ccdv >/dev/null 2>&1
	./ccdv >/dev/null 2>&1
	if test $? -eq 96 ; then
		CCDV="./ccdv"
	else
		/bin/rm -f ccdv
	fi
fi
if test "x$CCDV" != x ; then
	wi_RESOLVE_PATH([$CCDV], [CCDV])
	wi_cv_path_ccdv="$CCDV"
	CCDV="@$CCDV "	# trailing space needed
else
	wi_cv_path_ccdv=""
fi
])
if test "$wi_used_cache_path_ccdv" = yes ; then
	CCDV="$wi_cv_path_ccdv"
	if test "x$CCDV" != x ; then
		CCDV="@$CCDV "	# trailing space needed
	fi
fi
AC_SUBST(CCDV)
fi
])
dnl
dnl
dnl
dnl
AC_DEFUN([wi_HEADER_CURSES], [
AC_MSG_CHECKING([for curses library headers])
if test "$wi_cv_ncurses" != "no" ; then
	AC_CHECK_HEADERS(ncurses.h curses.h termios.h termio.h sgtty.h sys/ioctl.h)
else
	AC_CHECK_HEADERS(curses.h termios.h termio.h sgtty.h sys/ioctl.h)
fi
dnl needed for Solaris 7
if test "$ac_cv_header_curses_h" = no ; then
	if test -f /usr/include/curses.h ; then
		AC_DEFINE(HAVE_CURSES_H)
		ac_cv_header_curses_h=yes
	fi
fi
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([HAVE_LIBCURSES], [define if linking against libcurses])
AH_TEMPLATE([HAVE_LIBNCURSES], [define if linking against libncurses])
AC_DEFUN([wi_LIB_CURSES], [
wi_HEADER_CURSES
AC_MSG_CHECKING([for curses library])

wi_cv_lib_curses=no
wi_cv_lib_curses_result=no
ac_save_LIBS="$LIBS"
for LIBCURSES in "-lncurses" "-lcurses" "-lcurses -ltermcap" "-ltermcap -lcurses"
do
	if test "x$LIBCURSES-$wi_cv_ncurses" = "x-lncurses-no" ; then
		# This should never work
		LIBCURSES="-lkdfjkdjfs"
	fi
	LIBS="$ac_save_LIBS $LIBCURSES"
	AC_TRY_RUN([
	/* program */
#include <stdio.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif

 
main(int argc, char **argv)
{
	/* Note:  don't actually call curses, since it may block;
	 * We just want to see if it (dynamic) linked in okay.
	 */
	if (argc == 4)
		initscr();
	exit(0);
}
],[
	# action if true
	wi_cv_lib_curses=yes
	wi_cv_lib_curses_result="yes"
],[
	# action if false
	wi_cv_lib_curses=no
],[
	# action if cross compiling
	wi_cv_lib_curses=no
])

	if test "$wi_cv_lib_curses" = yes ; then break ; fi
done

# restore LIBS
LIBS="$ac_save_LIBS"

if test "$wi_cv_lib_curses_result" != "no" ; then
	case "$LIBCURSES" in
		"-lncurses")
			AC_DEFINE(HAVE_LIBNCURSES)
			;;
		"-lcurses")
			AC_DEFINE(HAVE_LIBCURSES)
			;;
		"-lcurses -ltermcap")
			AC_DEFINE(HAVE_LIBCURSES)
			;;
		"-ltermcap -lcurses")
			AC_DEFINE(HAVE_LIBCURSES)
			;;
	esac
else
	LIBCURSES=''
fi

AC_SUBST(LIBCURSES)
AC_MSG_RESULT([$wi_cv_lib_curses_result])
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([waddstr_str_t], [string parameter to waddstr])
AH_TEMPLATE([WADDSTR_TYPE_ARG1_CONST], [define if first parameter to waddstr is const char *])
AC_DEFUN([wi_CURSES_FUNC_PARAM_TYPES], [
AC_REQUIRE([AC_PROG_CPP])
AC_REQUIRE([wi_PATH_PERL])
AC_REQUIRE([wi_PATH_MKTEMP])
wi_PREREQ_UNISTD_H([$0])
AC_CACHE_CHECK([string parameter to waddstr], [wi_cv_waddstr_str_t], [
used_cache_for_wi_curses_fpt="no"
wi_CREATE_AC_TMPDIR([
wi_CREATE_PRPP_SCRIPT([$wi_tmpdir/prpp.pl])

changequote({{, }})dnl
cat << 'EOF' > "$wi_tmpdir/curses.c"
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#include <confdefs.h>
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif

main()
{
	exit(0);
}
EOF

cat << 'EOF' > "$wi_tmpdir/sed2.sh"
#!/bin/sh

if [ {{$}}# -eq 0 ] ; then exit 1 ; fi
x="{{$}}1"

sed -n 's/extern//;s/static//;
		/[\ \*]'"$x"'\ *(/{
			s/^.*'"$x"'\ *(/(/
			s/)\ *[;,].*$/)/
			/const char/{
				c\
const char *
			}
			/char/{
				c\
char *
			}
			/const/{
				c\
const void
			}
			q
}'
EOF
chmod 755 "$wi_tmpdir/sed2.sh"

$CPP "-I${srcdir-.}" "$wi_tmpdir/curses.c" > "$wi_tmpdir/curses.i"
if [ -s "$wi_tmpdir/curses.i" ] ; then
	"$PERL" "$wi_tmpdir/prpp.pl" < "$wi_tmpdir/curses.i" > "$wi_tmpdir/protos.h"
fi
if [ -f "$wi_tmpdir/protos.h" ] ; then
	#
	# Check what type waddstr() expects for the string parameter
	#
	x="waddstr"
	wi_cv_waddstr_str_t=`/bin/sh "$wi_tmpdir/sed2.sh" "$x" < "$wi_tmpdir/protos.h"`
fi
if [ "x$wi_cv_waddstr_str_t" = "x" ] ; then
	wi_cv_waddstr_str_t="const char *"
fi
changequote([, ])dnl
])
])
dnl if test "x$used_cache_for_wi_curses_fpt" = "xno" ; then
dnl 	AC_MSG_CHECKING([string parameter to waddstr])
dnl 	AC_MSG_RESULT([$wi_cv_waddstr_str_t])
dnl else
dnl 	AC_CACHE_CHECK([string parameter to waddstr],[wi_cv_waddstr_str_t],[:])
dnl fi
unset used_cache_for_wi_curses_fpt
AC_DEFINE_UNQUOTED(waddstr_str_t, $wi_cv_waddstr_str_t)
if test "$wi_cv_waddstr_str_t" = "const char *" ; then
	AC_DEFINE(WADDSTR_TYPE_ARG1_CONST)
fi
])
dnl
dnl
dnl
dnl
AH_TEMPLATE([HAVE_BEEP], [define if curses library has beep() functionality])
AH_TEMPLATE([HAVE__MAXX], [define if curses structure has maxx or _maxx field])
AH_TEMPLATE([HAVE_GETCURX], [define if curses library has getcurx() functionality])
AH_TEMPLATE([HAVE_GETYX], [define if curses library has getyx() functionality])
AH_TEMPLATE([HAVE_GETMAXX], [define if curses library has getmaxx() functionality])
AH_TEMPLATE([HAVE_GETMAXYX], [define if curses library has getmaxyx() functionality])
AH_TEMPLATE([HAVE_GETBEGX], [define if curses library has getbegx() functionality])
AH_TEMPLATE([HAVE_GETBEGYX], [define if curses library has getbegyx() functionality])
AH_TEMPLATE([HAVE_TOUCHWIN], [define if curses library has touchwin() functionality])
AC_DEFUN([wi_CURSES_FEATURES], [
if test "$wi_cv_lib_curses" = "yes" ; then
wi_PREREQ_UNISTD_H([$0])
	# Then $LIBCURSES is a list of curses and support libraries.
	ac_save_LIBS="$LIBS";
	LIBS="$LIBS $LIBCURSES";

wi_CURSES_FUNC_PARAM_TYPES

	# maxx or _maxx
	AC_MSG_CHECKING([whether curses structure has maxx or _maxx field])
	AC_TRY_COMPILE([
	/* includes */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif
],[
		WINDOW *w;
	
		w = newwin(10, 10, 1, 1);
		w->maxx = 0;
],[
AC_MSG_RESULT([maxx])
],[
AC_DEFINE(HAVE__MAXX)
AC_MSG_RESULT([_maxx])
])

	if test "${SYS-hpux}" = hpux ; then
	AC_CHECK_FUNCS(__getcurx __getcury __getmaxx __getmaxy __getbegx __getbegy)
	fi

	# getcurx
	AC_MSG_CHECKING([for getcurx() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif

],[
	/* function-body */
	WINDOW *junk = 0;
	int mx = 0;

	mx = getcurx(junk);
	exit(0);
],[
	AC_DEFINE(HAVE_GETCURX)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# getyx
	AC_MSG_CHECKING([for getyx() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif

],[
	/* function-body */
	WINDOW *junk = 0;
	int mx = 0, my = 0;

	getyx(junk, my, mx);
	exit(0);
],[
	AC_DEFINE(HAVE_GETYX)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# getmaxx
	AC_MSG_CHECKING([for getmaxx() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif
],[
	/* function-body */
	WINDOW *junk = 0;
	int mx = 0;

	mx = getmaxx(junk);
	exit(0);
],[
	AC_DEFINE(HAVE_GETMAXX)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# getmaxyx
	AC_MSG_CHECKING([for getmaxyx() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif
],[
	/* function-body */
	WINDOW *junk = 0;
	int mx = 0, my = 0;

	getmaxyx(junk, my, mx);
	exit(my < 0 ? my : 0);
],[
	AC_DEFINE(HAVE_GETMAXYX)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# getbegx
	AC_MSG_CHECKING([for getbegx() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif

],[
	/* function-body */
	WINDOW *junk = 0;
	int mx = 0;

	mx = getbegx(junk);
	exit(0);
],[
	AC_DEFINE(HAVE_GETBEGX)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# getbegyx
	AC_MSG_CHECKING([for getbegyx() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif
],[
	/* function-body */
	WINDOW *junk = 0;
	int mx = 0, my = 0;

	getbegyx(junk, my, mx);
	exit(my < 0 ? my : 0);
],[
	AC_DEFINE(HAVE_GETBEGYX)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# touchwin
	AC_MSG_CHECKING([for touchwin() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif
],[
	/* function-body */
	WINDOW *junk = 0;
	touchwin(junk);
	exit(0);
],[
	AC_DEFINE(HAVE_TOUCHWIN)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	# beep
	AC_MSG_CHECKING([for beep() functionality in curses library])
	AC_TRY_LINK([
	/* includes */
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef HAVE_NCURSES_H
#	include <ncurses.h>
#else
#	include <curses.h>
#endif
],[
	/* function-body */
	beep();
	exit(getpid() & 1);
],[
	AC_DEFINE(HAVE_BEEP)
	AC_MSG_RESULT([yes])
],[
	AC_MSG_RESULT([no])
])

	AC_CHECK_FUNCS(keypad nodelay curs_set doupdate wnoutrefresh)

	LIBS="$ac_save_LIBS";
fi
])
dnl
dnl
dnl
AC_DEFUN([wi_SHADOW_FUNCS], [
AC_CHECK_FUNCS(md5_crypt md5crypt bcrypt getspnam crypt_set_format)

if test "$ac_cv_func_getspnam" = no ; then
	unset ac_cv_func_getspnam
	AC_CHECK_LIB(gen,getspnam)
	if test "$ac_cv_lib_gen_getspnam" = yes ; then
		AC_CHECK_FUNCS(getspnam)
	fi
elif test "$ac_cv_func_getspnam" = yes ; then
	# Special hack to be sure UnixWare 7.1 uses -lgen for getspnam.
	# The reason we do this is so that the binary can be used on
	# SCO 5.0.6 with the UDK compatibility libraries installed,
	# For some reason, on UW7.1 getspnam is in the standard library and
	# libgen, but on SCO/UDK it is only in libgen.
	#
	case "$OS" in
		unixware2*)
			;;
		unixware*)
			AC_CHECK_LIB(gen,getspnam)
			;;
	esac
fi

# AIX
#
case "$SYS" in
	"aix"|"")
		AC_CHECK_FUNCS(getuserpw)
		;;
	*)
		;;
esac

# C2: SCO Open Server 5; Digital UNIX
AC_CHECK_FUNCS(set_auth_parameters bigcrypt)

# C2: Digital UNIX 3.2, 4.0; SCO Open Server 5; HP-UX 11
AC_CHECK_FUNCS(getprpwnam)

# Digital UNIX 4.0
AC_CHECK_FUNCS(getespwnam get_num_crypts get_crypt_name)

# Digital Unix 4.0
AC_CHECK_FUNCS(dispcrypt)

# SunOS
AC_CHECK_FUNCS(getpwanam)
])
dnl
dnl
dnl
AC_DEFUN([wi_SHADOW_HEADERS], [
AC_CHECK_HEADERS(shadow.h crypt.h)

# AIX
AC_CHECK_HEADERS(userpw.h)

# SunOS
AC_CHECK_HEADERS(pwdadj.h)

# HP-UX
#
# Bug in header on these version 10 which cause is it not
# to get detected.
#
wi_HEADER_HPSECURITY_H

# SCO Open Server, Digital UNIX
AC_CHECK_HEADERS(sys/security.h sys/audit.h krb.h prot.h)

# Digital UNIX
AC_CHECK_HEADERS(sys/secdefines.h)

# Digital UNIX
wi_PR_PASSWD_FG_OLDCRYPT
])
dnl
dnl
dnl
AC_DEFUN([wi_SHADOW_LIBS], [
check_for_libcrypt=yes

# AIX security library is libs.a
AC_CHECK_LIB(s,getuserpw)
if test "$ac_cv_lib_s" = yes ; then
	check_for_libcrypt=no
elif test "$ac_cv_lib_s_getuserpw" = yes ; then
	check_for_libcrypt=no
fi

# SCO OpenServer 5 stuff for shadow password
AC_CHECK_LIB(x,nap)
AC_CHECK_LIB(prot,getprpwnam)

# Digital UNIX
AC_CHECK_LIB(security,endprpwent)

# HP-UX
AC_CHECK_LIB(sec,getprpwnam)

if test "$ac_cv_lib_sec_getprpwnam" = no ; then
	# DYNIX/ptx
	AC_CHECK_LIB(sec,getspnam)
fi

if test "$check_for_libcrypt" = yes ; then
	wi_LIB_CRYPT
fi
AC_CHECK_FUNCS(crypt)
])
dnl
dnl
dnl
AC_DEFUN([wi_OS_VAR], [
#
# Take note if the user is or is not exporting a CFLAGS env var.
#
wi_orig_CFLAGS="$CFLAGS"
wi_CFLAGS_TO_ADD_LATER=""
changequote(!@, @!)dnl
if [ -x "$HOME/bin/OS" ] ; then
	HOME_OS=`$HOME/bin/OS`
	HOME_OS="$HOME/$HOME_OS"
fi
host=`uname -n 2>/dev/null | tr '[A-Z]' '[a-z]'`
os=`uname -s 2>/dev/null | tr '[A-Z]' '[a-z]'`
if [ "$os" = "TvoPT" ] ; then os="sunos" ; fi
dnl work around inability to use $1
os_v=`uname -v 2>/dev/null | sed 's/^[^0-9.]*//;s/[^0-9.].*$//;' | awk '-F[-/: ]' '{n = 1; print $n; }'`
os_r=`uname -r 2>/dev/null | sed 's/^[^0-9.]*//;s/[^0-9.].*$//;' | awk '-F[-/: ]' '{n = 1; print $n; }'`
os_r1=`echo "${os_r}" | cut -c1`
arch=`uname -m 2>/dev/null | tr '[A-Z]' '[a-z]'`
archp=`uname -p 2>/dev/null | tr '[A-Z]' '[a-z]'`
OS=''
SYS=''
NDEFS=''

# Special case a few systems where if your CFLAGS appear
# to want to generate for 32 bit, use that mode rather
# than 64 bit.
#
case "$os,$CFLAGS" in
	irix64,*-n32*)
		os=irix
		# then go to regular "irix" instead of "irix64" below.
		;;
esac

case "$os" in
	osf1)
		case "$os_r" in
			3*|4*)
				OS="digitalunix${os_r}-$arch"
				SYS=digitalunix
				NDEFS="$NDEFS -DDIGITAL_UNIX=$os_r1"
				;;
			*)
				OS="tru64unix${os_r}-$arch"
				SYS=tru64unix
				NDEFS="$NDEFS -DTRU64UNIX=$os_r1"
				;;
		esac
		;;
	aix)
		os_lev=`/usr/bin/oslevel 2>/dev/null`
		if [ "$os_lev" = "" ] ; then
			if [ "$os_r" = "" ] ; then os_r=0 ; fi
			OS="aix${os_v}.${os_r}"
			os_int=`expr $os_v$os_r '*' 10`
		else
			os_v=`echo "$os_lev" | cut -d. -f1-3`
			os_v1=`echo "$os_v" | cut -d. -f1`
			os_v2=`echo "$os_v" | cut -d. -f2`
			if [ "$os_v2" = "" ] ; then os_v2=0 ; fi
			os_v3=`echo "$os_v" | cut -d. -f3`
			if [ "$os_v3" = "" ] ; then os_v3=0 ; fi
			os_int=`expr "$os_v1" '*' 100 + "$os_v2" '*' 10 + "$os_v3"`
			OS="aix${os_v}"
		fi
		SYS=aix
		NDEFS="$NDEFS -DAIX=${os_int}"
		;;
	irix)
		OS="irix${os_r}"
		SYS=irix
		NDEFS="$NDEFS -DIRIX=$os_r1"
		;;
	irix64)
		OS="irix64_${os_r}"
		SYS=irix64
		NDEFS="$NDEFS -DIRIX=$os_r1 -DIRIX64=$os_r1"
		;;
	hp-ux)
		os_r=`echo "${os_r}" | cut -d. -f2-`
		os_r1=`echo "$os_r" | cut -d. -f1`
		os_r2=`echo "${os_r}" | cut -d. -f2`
		os_int=`expr "$os_r1" '*' 100 + "$os_r2"`
		OS="hpux${os_r}"
		SYS=hpux
		NDEFS="$NDEFS -DHPUX=$os_int"
		;;
	freebsd)
		OS="freebsd${os_r}-$arch"
		os_r1=`echo "$os_r" | cut -d. -f1`
		os_r2=`echo "$os_r" | cut -d. -f2`
		if [ "$os_r2" = "" ] ; then os_r2=0 ; fi
		os_r3=`echo "$os_r" | cut -d. -f3`
		if [ "$os_r3" = "" ] ; then os_r3=0 ; fi
		os_int=`expr "$os_r1" '*' 100 + "$os_r2" '*' 10 + "$os_r3"`
		SYS=freebsd
		NDEFS="$NDEFS -DFREEBSD=$os_int"
		;;
	netbsd)
		OS="netbsd${os_r}-$arch"
		os_r1=`echo "$os_r" | cut -d. -f1`
		os_r2=`echo "$os_r" | cut -d. -f2`
		if [ "$os_r2" = "" ] ; then os_r2=0 ; fi
		os_r3=`echo "$os_r" | cut -d. -f3`
		if [ "$os_r3" = "" ] ; then os_r3=0 ; fi
		os_int=`expr "$os_r1" '*' 100 + "$os_r2" '*' 10 + "$os_r3"`
		NDEFS="$NDEFS -DNETBSD=$os_int"
		SYS=netbsd
		;;
	openbsd)
		OS="openbsd${os_r}-$arch"
		os_r1=`echo "$os_r" | cut -d. -f1`
		os_r2=`echo "$os_r" | cut -d. -f2`
		if [ "$os_r2" = "" ] ; then os_r2=0 ; fi
		os_r3=`echo "$os_r" | cut -d. -f3`
		if [ "$os_r3" = "" ] ; then os_r3=0 ; fi
		os_int=`expr "$os_r1" '*' 100 + "$os_r2" '*' 10 + "$os_r3"`
		SYS=openbsd
		NDEFS="$NDEFS -DOPENBSD=$os_int"
		;;
	sco*)
		OS=scosv
		SYS=sco
		os_v1=`echo "$os_v" | cut -d. -f1`
		case "$os_v1" in
			[1-9])
				os_v2=`echo "$os_v" | cut -d. -f2`
				if [ "$os_v2" = "" ] ; then os_v2=0 ; fi
				os_v3=`echo "$os_v" | cut -d. -f3`
				if [ "$os_v3" = "" ] ; then os_v3=0 ; fi
				os_int=`expr "$os_v1" '*' 100 + "$os_v2" '*' 10 + "$os_v3"`
				NDEFS="$NDEFS -DSCO=$os_int"
				;;
			*)
				NDEFS="$NDEFS -DSCO=1"
				;;
		esac
		;;
	dynix*)
		OS="dynixptx${os_v}"
		SYS=dynixptx
		os_v1=`echo "$os_v" | cut -d. -f1`
		os_v2=`echo "$os_v" | cut -d. -f2`
		os_v3=`echo "$os_v" | cut -d. -f3`
		if [ "$os_v3" = "" ] ; then os_v3=0 ; fi
		os_int=`expr "$os_v1" '*' 100 + "$os_v2" '*' 10 + "$os_v3"`
		NDEFS="$NDEFS -DDYNIX=$os_int"
		;;
	linux)
		case "$arch" in
			*86)
				arch=x86
				;;
		esac

		libc=""
		os_r1=`echo "$os_r" | cut -d. -f1`
		os_r2=`echo "$os_r" | cut -d. -f2`
		os_r3=`echo "$os_r" | cut -d- -f1 | cut -d. -f3`
		os_int=`expr "$os_r1" '*' 10000 + "$os_r2" '*' 1000 + "$os_r3"`
		NDEFS="$NDEFS -DLINUX=$os_int"

		vertest="./vertest.$$"
		/bin/rm -f "$vertest" "$vertest.c"
		cat <<EOF > "$vertest.c"
#include <stdio.h>
#include <gnu/libc-version.h>

main()
{
	const char *ver = gnu_get_libc_version();
	const char *rel = gnu_get_libc_release();

	fprintf(stdout, "glibc%s\n", ver);
	exit(0);
}
EOF
		echo $ac_n "checking version of C library""... $ac_c" 1>&6
		echo "configure:: checking version of C library" >&5
		${CC-cc} $DEFS $CPPFLAGS $CFLAGS "$vertest.c" -o "$vertest" >/dev/null 2>&1
		if [ -x "$vertest" ] ; then libc=`$vertest` ; fi
		/bin/rm -f "$vertest" "$vertest.c"

		case "$libc" in
			glibc*)
				echo "$libc" 1>&6
				glibc_r=`echo "$libc" | sed 's/glibc//'`
				glibc_r1=`echo "$glibc_r" | cut -d. -f1`
				glibc_r2=`echo "$glibc_r" | cut -d. -f2`
				glibc_r3=`echo "$glibc_r" | cut -d- -f1 | cut -d. -f3`
				glibc_int=`expr "$glibc_r1" '*' 10000 + "$glibc_r2" '*' 1000 + "$glibc_r3"`
				NDEFS="$NDEFS -DLINUX_GLIBC=$glibc_int"
				libc="glibc${glibc_r1}.${glibc_r2}"
				OS="linux-$arch"
				;;
			*)
				if test -f /lib/libc-2.2.2.so ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=22002"
					libc="glibc2.2"
					OS="linux-$arch"
				elif test -f /lib/libc-2.2.1.so ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=22001"
					libc="glibc2.2"
					OS="linux-$arch"
				elif test -f /lib/libc-2.2.0.so ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=22000"
					libc="glibc2.1"
					OS="linux-$arch"
				elif test -f /lib/libc-2.1.3.so ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=21003"
					libc="glibc2.1"
					OS="linux-$arch"
				elif test -f /lib/libc-2.1.2.so ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=21002"
					libc="glibc2.1"
					OS="linux-$arch"
				elif test -f /lib/libc-2.1.1.so ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=21001"
					libc="glibc2.1"
					OS="linux-$arch"
				elif test -f /lib/libc.so.6 ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=20000"
					libc="glibc2.0"
					OS="linux-$arch"
				elif test -f /lib/libc.so.6.1 ; then
					NDEFS="$NDEFS -DLINUX_GLIBC=20001"
					libc="glibc2.0"
					OS="linux-$arch"
				else
					NDEFS="$NDEFS -DLINUX_LIBC=5"
					libc="libc5"
					OS="linux-$arch"
				fi
				echo "$libc" 1>&6
				;;
		esac
		SYS=linux
		;;
	bsd/os)
		OS="bsdos${os_r}"
		SYS=bsdos
		NDEFS="$NDEFS -DBSDOS=$os_r1"
		;;
	ultrix)
		OS="ultrix-$arch"
		SYS=ultrix
		NDEFS="$NDEFS -DULTRIX"
		;;
	unixware)
		OS="unixware${os_v}"
		SYS=unixware
		os_v1=`echo "$os_v" | cut -d. -f1`
		case "$os_v1" in
			[1-9])
				os_v2=`echo "$os_v" | cut -d. -f2`
				os_v3=`echo "$os_v" | cut -d. -f3`
				if [ "$os_v3" = "" ] ; then os_v3=0 ; fi
				os_int=`expr "$os_v1" '*' 100 + "$os_v2" '*' 10 + "$os_v3"`
				NDEFS="$NDEFS -DUNIXWARE=$os_int"
				;;
			*)
				NDEFS="$NDEFS -DUNIXWARE=1"
				;;
		esac
		;;
	openunix)
		OS="openunix${os_v}"
		SYS=openunix
		os_v1=`echo "$os_v" | cut -d. -f1`
		os_v2=`echo "$os_v" | cut -d. -f2`
		os_v3=`echo "$os_v" | cut -d. -f3`
		if [ "$os_v3" = "" ] ; then os_v3=0 ; fi
		os_int=`expr "$os_v1" '*' 100 + "$os_v2" '*' 10 + "$os_v3"`
		NDEFS="$NDEFS -DOPENUNIX=$os_int -DUNIXWARE=$os_int"
		;;
	macos*|darwin|rhapsody)
		OS="macosx"
		SYS="macosx"
		os_v=`perl -e '{open(F, "< /System/Library/CoreServices/SystemVersion.plist") or exit(2); my ($doc) = ""; my ($line); while (defined($line = <F>)) { $doc .= $line; } close(F); $doc =~ s/\s+//gs; if ($doc =~ /<key>ProductVersion<\/key><string>([^<]+)<\/string>/) { print $1, "\n"; exit(0); } exit(1); }' 2>/dev/null`
		if [ "$os_v" = "" ] && [ -x "$HOME/bin/macosver" ] ; then
			os_v=`"$HOME/bin/macosver" 2>/dev/null`
		fi
		if [ "$os_v" = "" ] ; then
			cat > "$HOME/macosver.c" <<EOF
/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist SYSTEM "file://localhost/System/Library/DTDs/PropertyList.dtd">
<plist version="0.9">
<dict>
	<key>ProductBuildVersion</key>
	<string>5S66</string>
	<key>ProductName</key>
	<string>Mac OS X</string>
	<key>ProductVersion</key>
	<string>10.1.5</string>
</dict>
</plist>
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

main()
{
	char line[256], *cp, *cp2; 
	FILE *fp;

	fp = fopen("/System/Library/CoreServices/SystemVersion.plist", "r");

	if (fp != NULL) {
		memset(line, 0, sizeof(line));
		while (fgets(line, sizeof(line) - 1, fp) != NULL) {
			cp = strstr(line, "<key>ProductVersion</key>");
			if (cp != NULL) {
				memset(line, 0, sizeof(line));
				if (fgets(line, sizeof(line) - 2, fp) != NULL) {
					for (cp = line; ((*cp != '\0') && (! isdigit(*cp))); ) cp++;
					for (cp2 = cp; ((*cp2 != '\0') && (! isspace(*cp2)) && (*cp2 != '<') && (*cp2 != '>')); ) cp2++;
					cp2[0] = '\0';
					fclose(fp);
					fprintf(stdout, "%s\n", cp);
					exit(0);
				}
			}
		}
	}
	fclose(fp);
	exit(1);
}
EOF
			${CC-cc} "$HOME/macosver.c" -o "$HOME/macosver" > /dev/null 2>&1
			os_v=`"$HOME/macosver" 2>/dev/null`
			/bin/mv "$HOME/macosver" "$HOME/bin/macosver" 2>/dev/null
			/bin/rm -f "$HOME/macosver.c" "$HOME/macosver"
		fi
		if [ "$os_v" != "" ] ; then
			OS="macosx${os_v}"
			os_v1=`echo "$os_v" | cut -d. -f1`
			os_v2=`echo "$os_v" | cut -d. -f2`
			os_v3=`echo "$os_v" | cut -d. -f3`
			if [ "$os_v3" = "" ] ; then os_v3=0 ; fi
			os_int=`expr "$os_v1" '*' 1000 + "$os_v2" '*' 100 + "$os_v3"`
			NDEFS="$NDEFS -DMACOSX=$os_int"
		else
			NDEFS="$NDEFS -DMACOSX"
		fi
		;;
	sunos)
		if [ "$arch" = "" ] ; then arch="sparc" ; fi
		if [ "$archp" = "" ] ; then archp="$arch" ; fi
		case "$os_r" in
			5.[789]*|5.1[0-9][0-9]*)
				os_r1=`echo "$os_r" | cut -d. -f2`
				os_r2=`echo "$os_r" | cut -d. -f3`
				if [ "$os_r2" = "" ] ; then os_r2=0 ; fi
				os_r3=`echo "$os_r" | cut -d. -f4`
				if [ "$os_r3" = "" ] ; then os_r3=0 ; fi
				os_int=`expr "$os_r1" '*' 100 + "$os_r2" '*' 10 + "$os_r3"`
				os_r=`echo "$os_r" | cut -c3-`
				OS="solaris${os_r}-$archp"
				NDEFS="$NDEFS -DSOLARIS=$os_int"
				SYS=solaris
				;;
			5.[023456]*|5.1)
				os_r=`echo "$os_r" | sed 's/^5/2/;'`
				os_r1=`echo "$os_r" | cut -d. -f1`
				os_r2=`echo "$os_r" | cut -d. -f2`
				if [ "$os_r2" = "" ] ; then os_r2=0 ; fi
				os_r3=`echo "$os_r" | cut -d. -f3`
				if [ "$os_r3" = "" ] ; then os_r3=0 ; fi
				os_int=`expr "$os_r1" '*' 100 + "$os_r2" '*' 10 + "$os_r3"`
				OS="solaris${os_r}-$archp"
				NDEFS="$NDEFS -DSOLARIS=$os_int"
				SYS=solaris
				;;
			4.*)
				OS="sunos${os_r}-sparc"
				NDEFS="$NDEFS -DSUNOS=\\\"$os_r\\\""
				SYS=sunos
				;;
			*)
				os_r1=`echo "$os_r" | cut -d. -f1`
				if [ "$os_r1" = "" ] ; then os_r1=0 ; fi
				os_r2=`echo "$os_r" | cut -d. -f2`
				if [ "$os_r2" = "" ] ; then os_r2=0 ; fi
				os_r3=`echo "$os_r" | cut -d. -f3`
				if [ "$os_r3" = "" ] ; then os_r3=0 ; fi
				os_int=`expr "$os_r1" '*' 100 + "$os_r2" '*' 10 + "$os_r3"`
				OS="solaris${os_r}-$archp"
				NDEFS="$NDEFS -DSOLARIS=$os_int"
				SYS=solaris
				;;
		esac
		;;
	*)
		OS="$os"
		SYS="$os"

		if grep Novell /usr/include/sys/types.h ; then
			OS="unixware${os_v}"
			SYS="unixware"
		fi
		;;
esac

if [ "x$wi_cv_OS" != "x" ] && [ "$wi_cv_OS" != "$OS" ] ; then
changequote([, ])
	AC_MSG_ERROR([Your config.cache file is invalid.  It was created on $wi_cv_OS, but this machine is running $OS.  Remove the config.cache file if you wish to continue.])
fi
wi_cv_OS="$OS"

AC_SUBST(NDEFS)
AC_SUBST(OS)
AC_SUBST(host)
AC_SUBST(SYS)
AC_SUBST(HOME_OS)
])
dnl
dnl
dnl
AC_DEFUN([wi_SIZEOF_STRUCT_STAT], [
AC_MSG_CHECKING(size of struct stat)
wi_PREREQ_UNISTD_H([$0])
AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
 
main()
{
	struct stat x;
	FILE *fp;

	fp = fopen("conftest.out", "w");
	if (fp != NULL) {
		fprintf(fp, "%u\n", (unsigned int) sizeof(x));
		fclose(fp);
		exit(0);	/* OK */
	}
	exit(1);		/* Not OK */
}
],[
	# action if true
	x=`cat conftest.out`
	case "$x" in
changequote(<<, >>)dnl
		[0-9]*)
changequote([, ])dnl
			AC_DEFINE_UNQUOTED(SIZEOF_STRUCT_STAT, $x)
			ac_cv_sizeof_struct_stat="$x"
			;;
		*)
			x="failed"
			;;
	esac
	/bin/rm -f conftest.out
],[
	# action if false
	x="failed";
	/bin/rm -f conftest.out
],[
	# action if cross compiling
	x="unknown";
	/bin/rm -f conftest.out
])
AC_MSG_RESULT($x)
])
dnl
dnl
dnl
AC_DEFUN([wi_SIZEOF_STRUCT_STAT64], [
AC_MSG_CHECKING(size of struct stat64)
wi_PREREQ_UNISTD_H([$0])
AC_TRY_RUN([
	/* program */
#if defined(AIX) || defined(_AIX) || defined(__HOS_AIX__)
#	define _ALL_SOURCE 1
#endif
#ifdef HAVE_UNISTD_H
#	include <unistd.h>
#endif
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
 
main()
{
	struct stat64 x;
	FILE *fp;

	fp = fopen("conftest.out", "w");
	if (fp != NULL) {
		fprintf(fp, "%u\n", (unsigned int) sizeof(x));
		fclose(fp);
		exit(0);	/* OK */
	}
	exit(1);		/* Not OK */
}
],[
	# action if true
	x=`cat conftest.out`
	case "$x" in
changequote(<<, >>)dnl
		[0-9]*)
changequote([, ])dnl
			AC_DEFINE_UNQUOTED(SIZEOF_STRUCT_STAT64, $x)
			ac_cv_sizeof_struct_stat64="$x"
			;;
		*)
			x="failed"
			;;
	esac
	/bin/rm -f conftest.out
],[
	# action if false
	x="failed";
	/bin/rm -f conftest.out
],[
	# action if cross compiling
	x="unknown";
	/bin/rm -f conftest.out
])
AC_MSG_RESULT($x)
])
