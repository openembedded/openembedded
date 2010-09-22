require linux.inc

DESCRIPTION = "2.6 Linux Kernel for IGEP based platforms"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(igep0020|igep0030)"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_igep0020 = "1"
DEFAULT_PREFERENCE_igep0030 = "1"

KV = "${PV}-0"

SRC_URI = "http://downloads.igep.es/sources/linux-omap-${KV}.tar.gz \
	   file://defconfig"

S = "${WORKDIR}/linux-omap-${KV}"

SRC_URI[md5sum] = "61ce79815d2778d45082a33d9ebac779"
SRC_URI[sha256sum] = "a14af39dbb8f4c7d0748e858943069dc9a34a87a27f5147df5881195142d6ea4"
