require linux.inc

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "igep0020"

DEFAULT_PREFERENCE_igep0020 = "1"

SRC_URI = "http://downloads.myigep.com/sources/kernel/linux-omap-2.6.28.10-igep0020b-0.tar.gz \
	   file://defconfig"

SRC_URI_append = " \
	file://twl-asoc-fix-record.diff;patch=1 \
"

S = "${WORKDIR}/linux-omap-2.6.28.10-igep0020b-0"

SRC_URI[md5sum] = "c50ae11485ca9b2ee1612d531c5321d9"
SRC_URI[sha256sum] = "f7a944bab388ed87d5535e21af52054917eb55999a654e1b2c160cbf0c1a8d5a"
