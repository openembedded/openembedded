require linux-omap.inc

PV = "2.6.x+git${SRCDATE}"
PR = "r1"

COMPATIBLE_MACHINE = "davinci-dvevm"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
