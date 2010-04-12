DESCRIPTION = "Export your X session on-the-fly via VNC"
HOMEPAGE = "http://www.karlrunge.com/x11vnc/"
AUTHOR = "Karl Runge"
SECTION = "x11/utils"
LICENSE = "GPL"
DEPENDS = "openssl virtual/libx11 libxtst libxext avahi jpeg zlib"

PR = "r1"
SRC_URI = "${SOURCEFORGE_MIRROR}/libvncserver/x11vnc-${PV}.tar.gz \
	   file://x11vnc-0.9.8-xshm-header-fix.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "13e41380fe9ba2581db180061d1cbd22"
SRC_URI[sha256sum] = "235549a5dad84c20c6d4aba920d95e3b98999b91ca5347bdde22fa0326818342"
