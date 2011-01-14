DESCRIPTION = "C++ bindings for dbus"
HOMEPAGE = "http://dbus-cxx.sourceforge.net/"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "boost dbus libsigc++-2.0"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/dbus-cxx/${PV}/dbus-cxx-${PV}.tar.bz2 \
  file://cppcompliance.patch;apply=yes \
"
S = "${WORKDIR}/dbus-cxx-${PV}"

SRC_URI[md5sum] = "4197900e5c231066dd283b05f2d9a14f"
SRC_URI[sha256sum] = "92218bd35240f76e359e767b7d5db54674599434f6b5bc568e5ab60f43cadfc2"

inherit autotools

BBCLASSEXTEND = "native"
DEPENDS_virtclass-native = "dbus-native libsigc++-2.0-native"
