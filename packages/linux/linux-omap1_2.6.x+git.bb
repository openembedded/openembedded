require linux-omap.inc

PR = "r1"

COMPATIBLE_MACHINE = "omap5912osk"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=http \
           file://defconfig"

S = "${WORKDIR}/git"
