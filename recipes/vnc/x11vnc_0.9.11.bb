DESCRIPTION = "Export your X session on-the-fly via VNC"
HOMEPAGE = "http://www.karlrunge.com/x11vnc/"
AUTHOR = "Karl Runge"
SECTION = "x11/utils"
LICENSE = "GPL"
DEPENDS = "libxinerama openssl virtual/libx11 libxtst libxext avahi jpeg zlib"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/x11vnc-${PV}.tar.gz \
 file://0001-replaced-pointer-with-x11vnc_pointer.patch \
"
SRC_URI[md5sum] = "db89b693065f7ff4ec7d6f41e0a0b8ed"
SRC_URI[sha256sum] = "fbc7a9e6d38afcfbb832d48ea4084823fa6bb9c0e37a925898229ca73639e7f5"

inherit autotools

