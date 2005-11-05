SECTION = "console/network"
DEPENDS = "ncurses gnutls gpgme"
DESCRIPTION = "Mutt is a small but very powerful text-based \
MIME mail client. It is highly configurable, and is well-suited \
to the mail power user with advanced features like key \
bindings, keyboard macros, mail threading, regular expression \
searches, and a powerful pattern matching language for selecting \
groups of messages."
LICENSE = "GPL"
SRC_URI = "ftp://ftp.mutt.org/mutt/devel/mutt-${PV}.tar.gz \
	   http://mutt.kiev.ua/download/mutt-1.5.9/patch-1.5.9.rr.compressed.gz;patch=1 \
	   http://mutt.kiev.ua/download/mutt-1.5.9/patch-1.5.9.vvv.nntp.gz;patch=1 \
	   http://mutt.kiev.ua/download/mutt-1.5.9/patch-1.5.9.vvv.initials.gz;patch=1 \
	   http://mutt.kiev.ua/download/mutt-1.5.9/patch-1.5.9.vvv.quote.gz;patch=1 \
	   file://patch-1.5.9i.sidebar.20050628.txt.hackedfornntp;patch=1 \
	   file://sidebar-nntp-clash.patch;patch=1 \
	   file://cppflags.patch;patch=1 \
	   file://posix1_lim.patch;patch=1 \
	   file://makedoc.patch;patch=1 "
#	   file://configure.patch;patch=1"
S = "${WORKDIR}/mutt-1.5.9"

DEFAULT_PREFERENCE = -1

inherit autotools

EXTRA_OECONF = "--enable-gpgme --with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-gnutls --enable-compressed --enable-nntp"

do_compile_prepend () {
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} makedoc.c -o makedoc
}
