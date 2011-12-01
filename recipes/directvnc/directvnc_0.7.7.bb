DESCRIPTION = "DirectVNC provides a very thin VNC client for unix framebuffer systems."
HOMEPAGE = "http://drinkmilk.github.com/directvnc/"
SECTION = "utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=cbbd794e2a0a289b9dfcc9f513d1996e"

DEPENDS = "zlib libpng jpeg directfb"

SRC_URI = "https://github.com/downloads/drinkmilk/directvnc/directvnc-${PV}.tar.gz"
SRC_URI[md5sum] = "e30f1a0e45b440443c044148fb62ad6e"
SRC_URI[sha256sum] = "ac8c0a6b6aaf0702411e71dd3626c655287c903233b659389fc07113114c9de3"

inherit autotools
