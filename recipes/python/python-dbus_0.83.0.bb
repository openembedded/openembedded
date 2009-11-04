DESCRIPTION = "Python bindings for DBus, a socket-based message bus system for interprocess communication"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "MIT"
DEPENDS = "expat dbus dbus-glib virtual/libintl python-pyrex-native python-epydoc-native"
PR = "ml2"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-python/dbus-python-${PV}.tar.gz"
S = "${WORKDIR}/dbus-python-${PV}"

inherit distutils-base autotools_stage pkgconfig

export BUILD_SYS
export HOST_SYS

RDEPENDS_${PN} = "\
  python-io \
  python-lang \
  python-logging \
  python-threading \
  python-xml \
"

FILES_${PN}-dev += "\
  ${libdir}/pkgconfig \
"
