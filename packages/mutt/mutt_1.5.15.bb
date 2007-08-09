SECTION = "console/network"
DEPENDS = "ncurses gnutls gpgme"
DESCRIPTION = "Mutt is a small but very powerful text-based \
MIME mail client. It is highly configurable, and is well-suited \
to the mail power user with advanced features like key \
bindings, keyboard macros, mail threading, regular expression \
searches, and a powerful pattern matching language for selecting \
groups of messages."
LICENSE = "GPL"
PR = "r0"
SRC_URI = "ftp://ftp.mutt.org/mutt/devel/mutt-${PV}.tar.gz \
           http://mutt.org.ua/download/mutt-1.5.15/patch-1.5.15.vvv.nntp.2.gz;patch=1 \
           http://mutt.org.ua/download/mutt-1.5.15/patch-1.5.15.vvv.initials.gz;patch=1 \
           http://mutt.org.ua/download/mutt-1.5.15/patch-1.5.15.vvv.quote.gz;patch=1 \
           file://patch-1.5.15.sidebar.20070408.txt;patch=1 \
           file://makedoc.patch;patch=1 "

S = "${WORKDIR}/mutt-1.5.15"

inherit autotools

EXTRA_OECONF = "--enable-gpgme --with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-gnutls --enable-nntp"

do_compile_prepend () {
	${BUILD_CC} makedoc.c -o makedoc
}
