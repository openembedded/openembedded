DESCRIPTION = "Python bindings for DBus, a socket-based message bus system for interprocess communication"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "MIT"
DEPENDS = "expat glib-2.0 virtual/libintl python-pyrex-native python"
RDEPENDS = "dbus python-threading python-io python-stringold python-logging"
PR = "ml0"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-python/dbus-python-${PV}.tar.gz"
S = "${WORKDIR}/dbus-python-${PV}"

inherit distutils-base autotools

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

do_stage() {
	autotools_stage_all
}

