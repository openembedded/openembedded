# Tests for mono
# this likely does not work, needs to be packaged.
# the MONO_DL_NEED_USCORE is the macro that needs to be defined in site.conf

dnl dynamic loader support
AC_CHECK_FUNC(dlopen, DL_LIB="",
	AC_CHECK_LIB(dl, dlopen, DL_LIB="-ldl", dl_support=no)
)
if test x$dl_support = xno; then
	AC_MSG_WARN([No dynamic loading support available])
else
	LIBS="$LIBS $DL_LIB"
	AC_DEFINE(HAVE_DL_LOADER,1,[dlopen-based dynamic loader available])
	dnl from glib's configure.in
	AC_CACHE_CHECK([for preceeding underscore in symbols],
		mono_cv_uscore,[
		AC_TRY_RUN([#include <dlfcn.h>
		int mono_underscore_test (void) { return 42; }
		int main() {
		  void *f1 = (void*)0, *f2 = (void*)0, *handle;
		  handle = dlopen ((void*)0, 0);
		  if (handle) {
		    f1 = dlsym (handle, "mono_underscore_test");
		    f2 = dlsym (handle, "_mono_underscore_test");
		  } return (!f2 || f1);
		}],
			[mono_cv_uscore=yes],
			[mono_cv_uscore=no],
		[])
	])
	if test "x$mono_cv_uscore" = "xyes"; then
		MONO_DL_NEED_USCORE=1
	else
		MONO_DL_NEED_USCORE=0
	fi
	AC_SUBST(MONO_DL_NEED_USCORE)
	AC_CHECK_FUNC(dlerror)
fi


