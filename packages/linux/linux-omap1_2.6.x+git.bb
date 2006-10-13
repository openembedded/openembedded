require linux-omap1.inc

PR = "r1"

SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=http \
           file://defconfig"

S = "${WORKDIR}/git"

KERNEL_RELEASE = "2.6.18-omap1"
