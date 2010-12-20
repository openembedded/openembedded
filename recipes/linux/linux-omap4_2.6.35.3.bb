COMPATIBLE_MACHINE = "omap4430-panda"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "35528f5b0481485654a6577306f7a80d9e6a5cf5"

SRC_URI = "git://dev.omapzoom.org/pub/scm/integration/kernel-ubuntu.git;protocol=git;branch=ti-ubuntu-L24.11 \
           file://defconfig"

S = "${WORKDIR}/git"
