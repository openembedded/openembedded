DESCRIPTION = "mg is Micro GNU/emacs, this is a portable version of the mg maintained by the OpenBSD team"
HOMEPAGE = "http://homepage.boetes.org/software/mg/"
LICENSE = "public domain"
SECTION = "console/editors"
DEPENDS = "ncurses"
PR = "r0"

SRC_URI = "http://homepage.boetes.org/software/mg/${PN}-${PV}.tar.gz \
           file://patches/000-fix-Makefile.in.patch;striplevel=1 \
           file://patches/001-initialize-pointer-to-NULL.patch;striplevel=1"

SRC_URI[md5sum] = "f25a139da44c3a2f760ffec531bd996e"
SRC_URI[sha256sum] = "a1702268b2607dacfcc22c5ffd80845113dff5f82b794139c801d875f87ff048"

inherit autotools

do_configure() {
    ./configure
}
