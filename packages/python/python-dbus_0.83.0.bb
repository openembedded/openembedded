DESCRIPTION = "Python bindings for DBus, a socket-based message bus system for interprocess communication"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "MIT"
DEPENDS = "expat dbus dbus-glib virtual/libintl python-pyrex-native"
RDEPENDS = "python-io python-logging python-stringold python-threading python-xml"
PR = "ml0"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-python/dbus-python-${PV}.tar.gz"
S = "${WORKDIR}/dbus-python-${PV}"

inherit distutils-base autotools pkgconfig

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

do_stage() {
	autotools_stage_all
}

FILES_${PN}-dev += "${libdir}/pkgconfig 
