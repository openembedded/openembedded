DESCRIPTION = "MadButterfly is a SVG browser. It can be used to be GUI environment of embedded system or desktop."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "BSD"
DEPENDS = "cairo pango"
SRCREV = "ecd1842714b5e982f3138cbdd358517d57be6aa3"
PV = "0.0.1+gitr${SRCREV}"

SRC_URI = "git://git.gitorious.org/madbutterfly/mainline.git;protocol=git \
           file://001_makefile.am_bugs.patch;patch=1"

S = "${WORKDIR}/git"

inherit autotools

FILES_${PN} += "/bin/* ${libdir}/*.so"
FILES_${PN}-dev += "${libdir}/*a ${libdir}/pkgconfig/* ${includedir}/* ${datadir}/*"
