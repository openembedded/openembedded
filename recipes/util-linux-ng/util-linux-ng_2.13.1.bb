require util-linux-ng.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/util-linux-ng/v2.13/util-linux-ng-${PV}${RC}.tar.bz2"

PR = "${INC_PR}"

SRC_URI[md5sum] = "424badc1832e4b5291a2ec04e9e244f4"
SRC_URI[sha256sum] = "e67d86683adef0855220b6f5a4b7ca2c51a15faa142e2ecd69925ede76854a4d"
