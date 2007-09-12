DESCRIPTION = "Full-featured IRC chat client with scripting support"
LICENSE = "GPL"
HOMEPAGE = "http://www.xchat.org"
SECTION = "x11/network"
DEPENDS = "libgcrypt zlib gtk+"
DEPENDS += "gdk-pixbuf-csource-native"
PR = "r0"

SRC_URI = "http://www.xchat.org/files/source/2.8/xchat-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "\
  --disable-perl \
  --disable-python \
"

FILES_${PN}-dbg += "${libdir}/xchat/plugins/.debug"
