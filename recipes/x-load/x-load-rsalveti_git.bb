require x-load.inc

PV = "1.41rs+${PR}+gitr${SRCREV}"

SRCREV = "1f96474d8df8ebcd1d982ec89241f508775aceb1"
SRC_URI = "git://gitorious.org/~rsalveti/pandaboard/rsalveti-x-loader.git;branch=omap4_panda_es2.1;protocol=git \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
