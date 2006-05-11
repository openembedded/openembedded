SECTION = "x11/utils"
DEPENDS = "libx11 libxt libxft libxpm"
DESCRIPTION = "rxvt-unicode is a clone of the well known \
terminal emulator rxvt, modified to store text in Unicode \
(either UCS-2 or UCS-4) and to use locale-correct input and \
output. It also supports mixing multiple fonts at the \
same time, including Xft fonts."
LICENSE = "GPL"
PACKAGES =+ "${PN}-daemon ${PN}-control"
FILES_${PN}-daemon = "${bindir}/rxvtd"
FILES_${PN}-control = "${bindir}/rxvtc"

SRC_URI = "http://dist.schmorp.de/rxvt-unicode/rxvt-unicode-${PV}.tar.bz2 \
           file://xwc.patch;patch=1 \
           file://signedchar.patch;patch=1" 
PR = "r0"

DEFAULT_PREFERENCE = "-1"

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
		--enable-text-blink --enable-rxvt-scroll \
		--enable-combining --enable-shared \
		--enable-xgetdefault \
		--with-x=${STAGING_LIBDIR}/.. \
		--enable-xpm-background \
		--disable-perl \
		--with-xpm-includes=${STAGING_INCDIR} \
		--with-xpm-libs=${STAGING_LIBDIR}"

do_configure_prepend () {
	cp aclocal.m4 acinclude.m4
}

do_compile_prepend () {
	echo '#define UTMP_FILE "${localstatedir}/run/utmp"' >> config.h
	echo '#define WTMP_FILE "${localstatedir}/log/wtmp"' >> config.h
	echo '#define LASTLOG_FILE "${localstatedir}/log/lastlog"' >> config.h
	echo '#define HAVE_XLOCALE 1' >> config.h
}

