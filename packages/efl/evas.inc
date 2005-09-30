DESCRIPTION = "Evas is a hardware-accelerated canvas API that can draw \
anti-aliased text, smooth super and sub-images, alpha-blend, as well as drop \
down to using normal X11 primitives such as pixmaps, lines and rectangles if \
your CPU or graphics hardware are too slow."
LICENSE = "MIT"
# can also depend on valgrind (?)
DEPENDS = "freetype libpng jpeg eet edb"
PROVIDES += "virtual/evas"

inherit efl

export FREETYPE_CONFIG		= "${STAGING_BINDIR}/freetype-config${@binconfig_suffix(d)}"

SRC_URI = "http://enlightenment.freedesktop.org/files/evas-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/libs/evas/m4/ac_expand_dir.m4?rev=1.1 \
           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/libs/evas/m4/ac_path_generic.m4?rev=1.2 \
           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/libs/evas/m4/pkg.m4?rev=1.2"

S = "${WORKDIR}/evas-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/evas"

EXTRA_OECONF = "<override me>"

do_configure_prepend() {
	install -D "${WORKDIR}/ac_expand_dir.m4?rev=1.1" "${S}/m4/ac_expand_dir.m4"
	mv "${WORKDIR}/ac_path_generic.m4?rev=1.2" "${S}/m4/ac_path_generic.m4"
	mv "${WORKDIR}/pkg.m4?rev=1.2" "${S}/m4/pkg.m4"
	aclocal -I m4
}

do_configure () {
	autotools_do_configure
	#find ${S} -type f | xargs sed -i 's:@FREETYPE_CFLAGS@:-I${STAGING_INCDIR}/freetype2:'
	#find ${S} -name Makefile | xargs sed -i 's:--tag=CC:-lfreetype --tag=CC:'
}

headers = "<override me>"
libraries = "libevas"

