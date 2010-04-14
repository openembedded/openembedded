SECTION = "x11/utils"
DEPENDS = "virtual/libx11 libxt libxft"
DESCRIPTION = "rxvt-unicode is a clone of the well known \
terminal emulator rxvt, modified to store text in Unicode \
(either UCS-2 or UCS-4) and to use locale-correct input and \
output. It also supports mixing multiple fonts at the \
same time, including Xft fonts."
LICENSE = "GPL"
SRC_URI = "http://dist.schmorp.de/rxvt-unicode/rxvt-unicode-${PV}.tar.bz2 \
	   file://signedchar.patch;patch=1"

SRC_URI[md5sum] = "52664198e7c6a500dd9728b1a2c97e8a"
SRC_URI[sha256sum] = "6ce00673bb9be8ed172c41c9246689916e358d331eb24aa05f5d89db4dd23c82"

inherit autotools update-alternatives

PROVIDES = "virtual/x-terminal-emulator"
ALTERNATIVE_NAME = "x-terminal-emulator"
ALTERNATIVE_PATH = "${bindir}/rxvt"

CFLAGS_append = " -fpermissive"

EXTRA_OECONF = "--enable-menubar --enable-xim \
		--enable-utmp --enable-wtmp --enable-lastlog \
		--disable-strings --with-term=rxvt --enable-keepscrolling \
		--enable-xft --with-name=rxvt --enable-frills \
		--enable-swapscreen --enable-transparency \
		--with-codesets=eu \
		--enable-cursor-blink --enable-pointer-blank \
		--enable-text-blink --enable-plain-scroll \
		--enable-combining --enable-shared \
		--enable-xgetdefault \
		--with-x=${STAGING_LIBDIR}/.."
EXTRA_OEMAKE = "'XINC=-I${STAGING_INCDIR}' \
		'XLIB=-L${STAGING_LIBDIR} -lX11'"

do_configure () {
	mv autoconf/configure.in . || true
	rm autoconf/libtool.m4
	libtoolize --force
	autotools_do_configure
	echo '#define RXVT_UTMP_FILE "${localstatedir}/run/utmp"' >> config.h
	echo '#define RXVT_WTMP_FILE "${localstatedir}/log/wtmp"' >> config.h
	echo '#define RXVT_LASTLOG_FILE "${localstatedir}/log/lastlog"' >> config.h
	echo '#define HAVE_XLOCALE 1' >> config.h
}

do_compile () {
	if test -e ${S}/${HOST_SYS}-libtool; then
		LIBTOOL=${S}/${HOST_SYS}-libtool
	else
		LIBTOOL=${S}/libtool
	fi
	# docs need "yodl" and I have no idea what that is
	oe_runmake -C src "LIBTOOL=$LIBTOOL"
}
