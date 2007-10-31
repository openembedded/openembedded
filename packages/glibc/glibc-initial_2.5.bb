require glibc_${PV}.bb
require glibc-initial.inc

do_configure () {
	sed -ie 's,{ (exit 1); exit 1; }; },{ (exit 0); }; },g' ${S}/configure
	chmod +x ${S}/configure
	unset CFLAGS
	CC="${BUILD_CC}" CPP="${BUILD_CPP}" LD="${BUILD_LD}" ${S}/configure --host=${TARGET_SYS} --build=${BUILD_SYS} \
		--without-cvs --disable-sanity-checks \
		--with-headers=${CROSS_DIR}/${TARGET_SYS}/include \
		--enable-hacker-mode
	if grep -q GLIBC_2.5 ${S}/ChangeLog; then
		# glibc-2.3.x passes cross options to $(CC) when generating errlist-compat.c, which fails without a real cross-compiler.
		# Fortunately, we don't need errlist-compat.c, since we just need .h files,
		# so work around this by creating a fake errlist-compat.c and satisfying its dependencies.
		# Another workaround might be to tell configure to not use any cross options to $(CC).
		# The real fix would be to get install-headers to not generate errlist-compat.c.
		make sysdeps/gnu/errlist.c
		mkdir -p stdio-common
		touch stdio-common/errlist-compat.c
	fi
}
