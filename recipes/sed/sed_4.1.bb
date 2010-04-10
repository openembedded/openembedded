LICENSE = "GPL"
SECTION = "console/utils"
DESCRIPTION = "sed is a Stream EDitor."

SRC_URI = "${GNU_MIRROR}/sed/sed-${PV}.tar.gz \
	   file://fchmod.patch;patch=1"
S = "${WORKDIR}/sed-${PV}"

inherit autotools

SRC_URI[md5sum] = "d8a08cc12fda1826deb2028dd729e189"
SRC_URI[sha256sum] = "57c86e7c17b8af6d6ecbdc17086ad22ec72d815f0db8a475a1d9adef2879f922"
