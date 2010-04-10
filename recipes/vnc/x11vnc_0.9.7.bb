DESCRIPTION = "Export your X session on-the-fly via VNC"
HOMEPAGE = "http://www.karlrunge.com/x11vnc/"
AUTHOR = "Karl Runge"
SECTION = "x11/utils"
LICENSE = "GPL"
DEPENDS = "openssl virtual/libx11 libxtst libxext avahi jpeg zlib"

SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/x11vnc-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "30a167577f657909b3355421e14e2ddb"
SRC_URI[sha256sum] = "fd21224ec09ca5294ba0627433e4d2cb726d389c7818d162f152374e6d693342"
