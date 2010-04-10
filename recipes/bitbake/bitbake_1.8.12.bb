require bitbake.inc
PR = "r0"

SRC_URI = "http://download.berlios.de/bitbake/bitbake-${PV}.tar.gz"
S = "${WORKDIR}/bitbake-${PV}"

SRC_URI[md5sum] = "01f6404d96cfa1d165d07921d754271e"
SRC_URI[sha256sum] = "ee81df164f8476dfe44c1841a27b3a0db49dea382c38d5ffb7e19a4747ca17af"
