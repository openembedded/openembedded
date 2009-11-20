require u-boot.inc

COMPATIBLE_MACHINE = "omap3-pandora"

# Latest SRCREV for the final shipping boards.
SRCREV = "70532c1152662f88ba1e0627c96307d93536508f"

PROVIDES = "u-boot"

PV = "pandora+${PR}+gitr${SRCREV}"
PR ="r3"
PE = "1"

SRC_URI = "git://git.openpandora.org/pandora-u-boot.git;branch=master;protocol=git \
"

UBOOT_MACHINE_omap3-pandora = "omap3_pandora_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
