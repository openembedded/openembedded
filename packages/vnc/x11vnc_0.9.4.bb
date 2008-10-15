DESCRIPTION = "Export your X session on-the-fly via VNC"
HOMEPAGE = "http://www.karlrunge.com/x11vnc/"
AUTHOR = "Karl Runge"
SECTION = "x11/utils"
LICENSE = "GPL"
DEPENDS = "openssl virtual/libx11 libxtst libxext avahi jpeg zlib"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/x11vnc-${PV}.tar.gz"

inherit autotools
