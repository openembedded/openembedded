DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "gtk+"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxWidgets-${PV}.tar.gz"
S = "${WORKDIR}/wxWidgets-${PV}"

inherit autotools pkgconfig

do_configure() {
	oe_runconf
}

#FIXME add sane packaging
