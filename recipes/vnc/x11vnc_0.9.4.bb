DESCRIPTION = "Export your X session on-the-fly via VNC"
HOMEPAGE = "http://www.karlrunge.com/x11vnc/"
AUTHOR = "Karl Runge"
SECTION = "x11/utils"
LICENSE = "GPL"
DEPENDS = "openssl virtual/libx11 libxtst libxext avahi jpeg zlib"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/x11vnc-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "0683a56108ca6d0c4329c7b9a5b7fbde"
SRC_URI[sha256sum] = "e3f8a224af7a8df4defc2c0b3567e1a697486443a2e073fa56122c4a4e439d65"
