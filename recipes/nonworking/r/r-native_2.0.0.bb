DEPENDS = "ncurses-native perl-native"

SRC_URI = "http://www.stats.bris.ac.uk/R/src/base/R-2/R-${PV}.tar.gz"

EXTRA_OECONF = "--without-x --without-readline --without-gnome --without-tcltk --without-libpng \
	        --without-jpeglib"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/R-${PV}"

S = "${WORKDIR}/R-${PV}"

inherit autotools native

do_configure() {
	oe_runconf
}

do_stage() {
	install -m 0755 ${S}/bin/R ${STAGING_BINDIR}/R
}
