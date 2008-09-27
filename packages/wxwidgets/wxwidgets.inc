DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "gtk+ jpeg tiff libpng zlib expat"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxWidgets-${PV}.tar.gz"

S = "${WORKDIR}/wxWidgets-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-gpe "

do_configure() {
       oe_runconf
}

FILES_${PN} += "${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"
