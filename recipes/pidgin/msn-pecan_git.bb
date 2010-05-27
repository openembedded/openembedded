DESCRIPTION="Alternative MSN protocol plug-in for pidgin"
HOMEPAGE="http://code.google.com/p/msn-pecan/"
SECTION = "x11/network"
LICENSE="GPL-2"
RDEPENDS="pidgin"
DEPENDS="pidgin"
SRCREV = "e795b33b29d792f19fcf699275eb966dc68be257"
PV="0.0.1+gitr${SRCREV}"
PR="r0"

inherit pkgconfig

SRC_URI="git://github.com/felipec/msn-pecan.git;protocol=http"
S="${WORKDIR}/git"

do_compile() {
        oe_runmake "DESTDIR=${D}"
}
do_install() {
	oe_runmake "DESTDIR=${D}" install
}

FILES_${PN} = "${libdir}/purple-2/*.so"
FILES_${PN}-dbg = "${libdir}/purple-2/.debug/"
