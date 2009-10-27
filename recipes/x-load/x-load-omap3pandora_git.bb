require x-load.inc

COMPATIBLE_MACHINE = "omap3-pandora"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-${MACHINE}/${MACHINE}"

SRCREV = "ea866e76420f629614ae3fc828f1525a77e051e8"

PROVIDES = "x-load"

PV = "1.42+${PR}+gitr${SRCREV}"
PR ="r1"
PE = "1"

SRC_URI = "git://git.openpandora.org/pandora-x-loader.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

XLOAD_MACHINE = "pandora_config"
