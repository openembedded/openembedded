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

SRC_URI[md5sum] = "3900bca37cabb4b76b8d736d51cc9251"
SRC_URI[sha256sum] = "a06c3546400503e6d4ca4505c3f838b9bbd03fab6a3cbab7993f6d9115b68b64"
