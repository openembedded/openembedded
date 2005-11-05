SECTION = "console/network"
DESCRIPTION = "tn5250 is a 5250 terminal emulator, used for connecting \
to IBM's AS/400 (now known as eServer iSeries) midrange computers."
HOMEPAGE = "http://tn5250.sourceforge.net/"
LICENSE = "LGPL"
DEPENDS = "ncurses openssl"
PR="r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/tn5250/tn5250-${PV}.tar.gz \
	   file://compile.patch;patch=1"

inherit autotools

PACKAGES = "lib5250-0 tn5250-dev tn5250-doc tn5250"
FILES_${PN} = "${bindir}/tn5250"
FILES_lib5250-0 = "${libdir}/lib*.so.*"
AUTO_LIBNAME_PKGS = "lib5250"

do_stage() {
	autotools_stage_includes
        oe_libinstall -so -a -C src lib5250 ${STAGING_LIBDIR}
}
