SECTION = "console/network"
DEPENDS = "ncurses openssl"
DESCRIPTION = "Mutt is a small but very powerful text-based \
MIME mail client. It is highly configurable, and is well-suited \
to the mail power user with advanced features like key \
bindings, keyboard macros, mail threading, regular expression \
searches, and a powerful pattern matching language for selecting \
groups of messages."
LICENSE = "GPL"
PR = "r1"
SRC_URI = "ftp://ftp.mutt.org/mutt/devel/mutt-${PV}.tar.gz;name=archive \
	   http://mutt.kiev.ua/download/mutt-1.5.4/patch-1.5.4.rr.compressed.gz;patch=1;name=patch1 \
	   http://mutt.kiev.ua/download/mutt-1.5.4/patch-1.5.4.vvv.nntp.gz;patch=1;name=patch2 \
	   http://mutt.kiev.ua/download/mutt-1.5.4/patch-1.5.4.vvv.initials.gz;patch=1;name=patch3 \
	   http://mutt.kiev.ua/download/mutt-1.5.4/patch-1.5.4.vvv.quote.gz;patch=1;name=patch4 \
	   file://cppflags.patch;patch=1 \
	   file://posix1_lim.patch;patch=1 \
	   file://keymap.h.patch;patch=1 \
	   file://configure.patch;patch=1"
S = "${WORKDIR}/mutt-1.5.4"

inherit autotools

EXTRA_OECONF = "--disable-pgp --without-mixmaster --with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-ssl --enable-compressed --enable-nntp"

do_compile_prepend () {
	${BUILD_CC} makedoc.c -o makedoc
}

SRC_URI[archive.md5sum] = "3d4088f25892af6d71148eef26604f33"
SRC_URI[archive.sha256sum] = "f89af1816b839736eaf5fd188c4574fc52bdd37a7dabc465edafe6d8c3914847"
SRC_URI[patch1.md5sum] = "a7b37150c35ea65049b3cd1edab5079d"
SRC_URI[patch1.sha256sum] = "a4780e1dcfe717567ef6a676fa4f9b9d9f2d44bb27dbc2374d7e3a01667f53bd"
SRC_URI[patch2.md5sum] = "d0cb0f609aa0461d1b17137bd49c14cb"
SRC_URI[patch2.sha256sum] = "f3e5fd05f7a1b9d57513f369c85c3af56bc4c7e75d765506da53b43c342073d4"
SRC_URI[patch3.md5sum] = "d92517da934f5c32692aecf7ece596b7"
SRC_URI[patch3.sha256sum] = "16b5845600aa2839d0ea2ff71868f2a15109542a693b8b2f305c0a18574cab4f"
SRC_URI[patch4.md5sum] = "80d91491679b426b0f670fa965ae3777"
SRC_URI[patch4.sha256sum] = "92e2dc76784a3cb49ac4d03b80d47830ee4cafd2d48323ddb81382a6f249d428"
