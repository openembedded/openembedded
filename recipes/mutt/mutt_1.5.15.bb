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
SRC_URI = "ftp://ftp.mutt.org/mutt/devel/mutt-${PV}.tar.gz;name=archive \
           http://mutt.org.ua/download/mutt-1.5.15/patch-1.5.15.vvv.nntp.2.gz;patch=1;name=patch1 \
           http://mutt.org.ua/download/mutt-1.5.15/patch-1.5.15.vvv.initials.gz;patch=1;name=patch2 \
           http://mutt.org.ua/download/mutt-1.5.15/patch-1.5.15.vvv.quote.gz;patch=1;name=patch3 \
           file://patch-1.5.15.sidebar.20070408.txt;patch=1 \
           file://makedoc.patch;patch=1 "

S = "${WORKDIR}/mutt-1.5.15"

inherit autotools

EXTRA_OECONF = "--enable-gpgme --with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-gnutls --enable-nntp"

do_compile_prepend () {
	${BUILD_CC} makedoc.c -o makedoc
}

SRC_URI[archive.md5sum] = "b2c1eb45fd958f6589ee52a98f2a3ce1"
SRC_URI[archive.sha256sum] = "03fa1f45d4743cd395b634d19aebbc2c1918cf6b683e0af51076ccc79f643a9a"
SRC_URI[patch1.md5sum] = "f4724392ca865125bc2be80b643d175c"
SRC_URI[patch1.sha256sum] = "ed0dc2337148ab4a884a94fd9472a76a13f74659372facef771f8b0eda5e4846"
SRC_URI[patch2.md5sum] = "414606ce18de730d1bb6478899532644"
SRC_URI[patch2.sha256sum] = "9385915adb106abba6f1576be58901f368688b1d55ef454e3993394828ee17e1"
SRC_URI[patch3.md5sum] = "93276f86e544e69a0e83808279f3b175"
SRC_URI[patch3.sha256sum] = "4afe6cc178b08ebd735d04053198f6539c87a0cdc1c5a8a51affc3598504e3a5"
