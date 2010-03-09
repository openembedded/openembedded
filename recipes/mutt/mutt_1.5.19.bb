SECTION = "console/network"
DEPENDS = "ncurses gnutls gpgme"
DESCRIPTION = "Mutt is a small but very powerful text-based \
MIME mail client. It is highly configurable, and is well-suited \
to the mail power user with advanced features like key \
bindings, keyboard macros, mail threading, regular expression \
searches, and a powerful pattern matching language for selecting \
groups of messages."
LICENSE = "GPL"
PR = "r1"
SRC_URI = "ftp://ftp.mutt.org/mutt/devel/mutt-${PV}.tar.gz \
           file://patch-1.5.19.sidebar.20090522.txt;patch=1 \
	   file://529838-gnutls-autoconf.patch;patch=1 \
           file://makedoc.patch;patch=1" 

S = "${WORKDIR}/mutt-1.5.19"

inherit autotools

EXTRA_OECONF = "--enable-gpgme --with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-gnutls --enable-nntp"

do_compile_prepend () {
        ${BUILD_CC} doc/makedoc.c -o doc/makedoc
}

