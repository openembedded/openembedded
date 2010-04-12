DESCRIPTION = "g-tracer is a gsignal run-time inspection and debugging utility"
HOMEPAGE = "http://sf.net/project/gtracer"
SECTION = "x11/devel"
LICENSE = "BSD"
DEPENDS = "glib-2.0 gtk+ intltool-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtracer/gtracer-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "8f21636a60ed57265feb34806ffe4b00"
SRC_URI[sha256sum] = "ce2a88a784c73d49b3600b5927f65624f665460684dc4b479989ad1c53e565c5"
