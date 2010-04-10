require u-boot.inc
PR ="r1"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://linux.omap.com/pub/bootloader/2430sdp/source/u-boot-SEP1106.tar.gz \
           file://u-boot-makefile-3.81.patch;patch=1 \
          "

S = "${WORKDIR}/u-boot"


#inherit base

SRC_URI[md5sum] = "49c07dec9e1be69fd01d46f47ec03731"
SRC_URI[sha256sum] = "a090786113b02647413ebc15888af269f2e6d50f73cbb94b0619cc1702911dae"
