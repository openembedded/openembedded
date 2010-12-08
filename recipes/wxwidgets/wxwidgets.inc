DESCRIPTION = "wxWidgets is a cross platform application framework utilizing native widgets."
HOMEPAGE = "http://www.wxwidgets.org"
SECTION = "x11/libs"
LICENSE = "wxWindows"
DEPENDS = "gtk+ jpeg tiff libpng zlib expat libxinerama"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxWidgets-${PV}.tar.bz2"

S = "${WORKDIR}/wxWidgets-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-gpe --disable-visibility "

CXXFLAGS := "${@oe_filter_out('-fvisibility-inlines-hidden', '${CXXFLAGS}', d)}"


do_configure() {
       oe_runconf
}

FILES_${PN} += "${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"
