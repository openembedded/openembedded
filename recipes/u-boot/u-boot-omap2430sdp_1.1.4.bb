require u-boot.inc
PR ="r1"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://linux.omap.com/pub/bootloader/2430sdp/source/u-boot-SEP1106.tar.gz \
           file://u-boot-makefile-3.81.patch;patch=1 \
          "

S = "${WORKDIR}/u-boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#inherit base
