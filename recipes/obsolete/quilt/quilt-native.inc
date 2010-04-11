require quilt.inc

SRC_URI_append_build-darwin = "?   file://non-gnu.patch;patch=1 "
RDEPENDS_${PN} = "diffstat-native patch-native bzip2-native util-linux-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/quilt-${PV}"

INHIBIT_AUTOTOOLS_DEPS = "1"

inherit autotools native

PATCHTOOL = "patch"
EXTRA_OECONF = "--disable-nls --without-date"

do_configure () {
	oe_runconf
}

do_test() {
    oe_runmake check
}

