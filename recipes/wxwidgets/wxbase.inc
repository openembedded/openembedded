DESCRIPTION = "wxBase is a library for programming \
non-GUI (console) applications using the base wxWidgets functionality."
HOMEPAGE = "http://www.wxwidgets.org/"
LICENSE = "wxWindows"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib expat"

SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxBase-${PV}.tar.bz2"

S = "${WORKDIR}/wxBase-${PV}"

inherit autotools pkgconfig

do_configure() {
       oe_runconf
}
