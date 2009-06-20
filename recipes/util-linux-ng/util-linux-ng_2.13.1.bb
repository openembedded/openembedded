require util-linux-ng.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/util-linux-ng/v2.13/util-linux-ng-${PV}${RC}.tar.bz2"
#SRC_URI += "file://util-linux_2.12r-12.diff.gz;patch=1"
#SRC_URI += "file://glibc-fix.patch;patch=1"
#SRC_URI += "file://glibc-umount2.patch;patch=1"

PR = "${INC_PR}"
