COMPATIBLE_MACHINE = "omap4430-panda"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "a25c0585b701b048f5fba298bd56cb5495c97bd2"

SRC_URI = "git://git.mansr.com/linux-panda;protocol=git;branch=mru \
           file://defconfig"

S = "${WORKDIR}/git"
