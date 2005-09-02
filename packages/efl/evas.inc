DESCRIPTION = "Evas is a hardware-accelerated canvas API that can draw \
anti-aliased text, smooth super and sub-images, alpha-blend, as well as drop \
down to using normal X11 primitives such as pixmaps, lines and rectangles if \
your CPU or graphics hardware are too slow."
LICENSE = "MIT"
# can also depend on valgrind (?)
DEPENDS = "freetype libpng jpeg eet edb"
PROVIDES += "virtual/evas"

inherit efl

SRC_URI = "http://enlightenment.freedesktop.org/files/evas-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           file://pkg.m4"
S = "${WORKDIR}/evas-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/evas"

EXTRA_OECONF = "<override me>"

do_configure () {
	install -m 0644 ${WORKDIR}/pkg.m4 acinclude.m4
	autotools_do_configure
}

headers = "<override me>"
libraries = "libevas"

