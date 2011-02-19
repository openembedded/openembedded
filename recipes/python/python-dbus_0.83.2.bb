DESCRIPTION = "Python bindings for DBus, a socket-based message bus system for interprocess communication"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "MIT"
DEPENDS = "expat dbus dbus-glib virtual/libintl python-pyrex-native python-epydoc-native"
PR = "ml0"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-python/dbus-python-${PV}.tar.gz"
S = "${WORKDIR}/dbus-python-${PV}"

inherit distutils-base autotools pkgconfig

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

do_configure_append() {
	find ${S} -name Makefile | xargs -n 1 sed -i 's,prefix}lib,prefix}/lib,g'
}

SRC_URI[md5sum] = "4ebcaa905bdcb4132b915196b0a3691b"
SRC_URI[sha256sum] = "883729c98f40790021e3be0f7028ae863ee1c4a7b922a5578c1342592adfff64"
