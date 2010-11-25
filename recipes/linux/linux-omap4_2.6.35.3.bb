COMPATIBLE_MACHINE = "omap4430-panda"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "6aba79f8f85b937596373cda8e266b823395996e"

SRC_URI = "git://kernel.ubuntu.com/ubuntu/ubuntu-maverick.git;protocol=git;branch=ti-omap4 \
           file://defconfig"

S = "${WORKDIR}/git"
