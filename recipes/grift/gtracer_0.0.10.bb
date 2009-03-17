DESCRIPTION = "g-tracer is a gsignal run-time inspection and debugging utility"
HOMEPAGE = "http://sf.net/project/gtracer"
SECTION = "x11/devel"
LICENSE = "BSD"
DEPENDS = "glib-2.0 gtk+ intltool-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtracer/gtracer-${PV}.tar.bz2"

inherit autotools
