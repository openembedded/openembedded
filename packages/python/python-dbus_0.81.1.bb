DESCRIPTION = "Python bindings for DBus, a socket-based message bus system for interprocess communication"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "GPL"
DEPENDS = "expat glib-2.0 virtual/libintl python-pyrex-native python"
RDEPENDS = "dbus python-threading python-io python-stringold python-logging"
PR = "ml1"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-python/dbus-python-${PV}.tar.gz \
           file://allow-older-autotools.patch;patch=1 \
	   file://python-path.patch;patch=1"

S = "${WORKDIR}/dbus-python-${PV}"

inherit distutils-base autotools

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

