require linux-omap.inc

PV = "2.6.x+git${SRCDATE}"
PR = "r1"

COMPATIBLE_MACHINE = "(davinci-dvevm|davinci-sffsdr)"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://defconfig"

SRC_URI_append_davinci-sffsdr = " file://sffsdr.patch;patch=1"

S = "${WORKDIR}/git"
