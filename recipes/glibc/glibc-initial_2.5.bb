require glibc_${PV}.bb
require glibc-initial.inc

do_configure () {
	sed -ie 's,{ (exit 1); exit 1; }; },{ (exit 0); }; },g' ${S}/configure
	chmod +x ${S}/configure
	unset CFLAGS
	${S}/configure --host=${TARGET_SYS} --build=${BUILD_SYS} \
		--without-cvs --disable-sanity-checks \
		--with-headers=${STAGING_INCDIR} \
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

SRC_URI[md5sum] = "1fb29764a6a650a4d5b409dda227ac9f"
SRC_URI[sha256sum] = "9b2e12bb1eafb55ab2e5a868532b8e6ec39216c66c25b8998d7474bc4d4eb529"
SRC_URI[md5sum] = "183f6d46e8fa5e4b2aff240ab1586c2e"
SRC_URI[sha256sum] = "80c38a005325e7539012bd665fb8e06af9ee9bfc74efb236ebff121265bfd463"
SRC_URI[md5sum] = "8787868ba8962d9b125997ec2f25ac01"
SRC_URI[sha256sum] = "de77e49e0beee6061d4c6e480f322566ba25d4e5e018c456a18ea4a8da5c0ede"
