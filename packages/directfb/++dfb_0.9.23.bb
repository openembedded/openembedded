DESCRIPTION = "A C++ Wrapper for the directfb framebuffer library."
HOMEPAGE = "http://directfb.org"
SECTION = "libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "directfb"
LICENSE = "LGPL"

SRC_URI = "http://www.directfb.org/downloads/Extras/++DFB-${PV}.tar.gz"
S = "${WORKDIR}/++DFB-${PV}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}
