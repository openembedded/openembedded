require u-boot.inc

COMPATIBLE_MACHINE = "omap3-pandora"

# Latest SRCREV for the final shipping boards.
SRCREV = "0ffcce5dad2153f5f3094f9114b1ae50aef2f5ad"

# Latest SRCREV for the rev2 < boards.
#SRCREV = "f1cc097b8a8c3c5e1bb6fbec906cfedd939c5be3"

PROVIDES = "u-boot"

PV = "pandora+${PR}+gitr${SRCREV}"
PR ="r2"
PE = "1"

SRC_URI = "git://git.openpandora.org/pandora-u-boot.git;branch=master;protocol=git \
"

# Rev 2 tree
#SRC_URI = "git://git.openpandora.org/pandora-u-boot.git;branch=rev3;protocol=git \
#"

UBOOT_MACHINE_omap3-pandora = "omap3_pandora_config"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
