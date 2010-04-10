LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "ef31d47010108518c6d214516f3d0cad"
SRC_URI[sha256sum] = "0793ec9d173dbe600c14a0a8cf8b89f418271176d75b5a02e0a840a55910c119"
