require linux-omap.inc

PR = "r1"

COMPATIBLE_MACHINE = "davinci_dvevm"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://defconfig.eabi \
           file://defconfig"

S = "${WORKDIR}/git"
