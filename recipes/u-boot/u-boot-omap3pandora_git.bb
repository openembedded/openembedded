require u-boot.inc

COMPATIBLE_MACHINE = "omap3-pandora"

# Latest SRCREV for the final shipping boards.
SRCREV = "c71d8dbe09d69feda7e57745bd3909727d3cc33f"

PROVIDES = "u-boot"

PV = "pandora+${PR}+gitr${SRCREV}"
PR ="r4"
PE = "1"

SRC_URI = "git://git.openpandora.org/pandora-u-boot.git;branch=master;protocol=git \
"

UBOOT_MACHINE_omap3-pandora = "omap3_pandora_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
