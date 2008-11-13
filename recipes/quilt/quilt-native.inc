require quilt.inc

SRC_URI_append_build-darwin = " file://non-gnu.patch"
SRC_URI_append_build-linux = " file://dont-allow-optional-quiltrc.patch"

RDEPENDS_${PN} = "diffstat-native patch-native bzip2-native util-linux-native"

FILESPATHPKG =. quilt-${PV}
INHIBIT_AUTOTOOLS_DEPS = "1"

inherit autotools native

PATCHTOOL = "patch"
EXTRA_OECONF = "--disable-nls"
EXTRA_OECONF_append_darwin = " --without-getopt"

do_configure () {
	oe_runconf
}

do_install () {
	oe_runmake 'BUILD_ROOT=${D}' install
}

do_test() {
    oe_runmake check
}

