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
	   http://www.mutt.org.ua/download/mutt-1.5.9/patch-1.5.9.rr.compressed.gz;patch=1;name=rr \
	   http://www.mutt.org.ua/download/mutt-1.5.9/patch-1.5.9.vvv.nntp.gz;patch=1;name=nntp \
	   http://www.mutt.org.ua/download/mutt-1.5.9/patch-1.5.9.vvv.initials.gz;patch=1;name=initials \
	   http://www.mutt.org.ua/download/mutt-1.5.9/patch-1.5.9.vvv.quote.gz;patch=1;name=quote \
	   file://patch-1.5.9i.sidebar.20050628.txt.hackedfornntp;patch=1 \
	   file://sidebar-nntp-clash.patch;patch=1 \
	   file://cppflags.patch;patch=1 \
	   file://posix1_lim.patch;patch=1 \
	   file://makedoc.patch;patch=1 "
#	   file://configure.patch;patch=1"
S = "${WORKDIR}/mutt-1.5.9"

DEFAULT_PREFERENCE = "-1"

inherit autotools

EXTRA_OECONF = "--enable-gpgme --with-curses=${STAGING_LIBDIR}/.. \
	        --enable-pop --enable-imap --with-gnutls --enable-compressed --enable-nntp"

do_compile_prepend () {
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} makedoc.c -o makedoc
}

SRC_URI[archive.md5sum] = "c5318eba3404ebd78a15c680fa1b6056"
SRC_URI[archive.sha256sum] = "d80142bfe7dd2c8ee9c2345c71fedded8b971267a9a29a853d48c562dd0605d4"
SRC_URI[rr.md5sum] = "9d9ef4ec0e970f9fc3de2d5c6219a349"
SRC_URI[rr.sha256sum] = "f28c30428119c9a82a91799ddd513c211db5b699b2c1d4868bbf2db6c38ccd1d"
SRC_URI[nntp.md5sum] = "f7cf37af82169eefe94c6c42c6f3b9cd"
SRC_URI[nntp.sha256sum] = "a09388316dff4346bf9e5ea4966157886c182a32d88f13d92877b1ccd37cd6e1"
SRC_URI[initials.md5sum] = "149c52991b23b9ab3d6add27cb27e151"
SRC_URI[initials.sha256sum] = "fddb48945e979c3e179ff6a90ab3d0c27f32c4c32910d51d32e904965865504d"
SRC_URI[quote.md5sum] = "08329134d8995c05a28dd8258174a668"
SRC_URI[quote.sha256sum] = "f4664f3d8f616a440e8b6d8b10d40087961cb6d0892809d12975c83e54a9b79d"
