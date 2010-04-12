DESCRIPTION = "Matchbox window manager Sato themes"
LICENSE = "CC-BY-SA3"
DEPENDS = "matchbox-wm"
SECTION = "x11/wm"

PACKAGE_ARCH = "all"

SRC_URI = "http://pokylinux.org/releases/sato/matchbox-theme-sato-0.1.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/themes"


SRC_URI[md5sum] = "72ae272ef7803141a3dcb69e670cff97"
SRC_URI[sha256sum] = "5b59f9646edbfb907a309332db3bd6fa7080dc1fe24df549480cfae7d974a3fb"
