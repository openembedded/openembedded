require u-boot.inc

PR = "r3"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-1.1.6.tar.bz2 \
           file://devkit-idp.patch;patch=1 \
"

SRC_URI_append_sarge-at91 = " file://sarge-uboot.patch;patch=1"

SRC_URI_append_mpc8323e-rdb = "  file://u-boot-1.1.6-fsl-1-mpc83xx-20061206.patch;patch=1 \
                                 file://u-boot-1.1.6-fsl-1-Fix-the-UEC-driver-bug-of-QE.patch;patch=1 \
                                 file://u-boot-1.1.6-fsl-1-streamline-the-83xx-immr-head-file.patch;patch=1 \
                                 file://u-boot-1.1.6-fsl-1-Add-support-for-the-MPC832XEMDS-board.patch;patch=1 \
                                 file://u-boot-1.1.6-fsl-1-Add-the-MPC832XEMDS-board-readme.patch;patch=1 \
                                 file://u-boot-1.1.6-fsl-1-Added-MPC8323E-RDB-board-support-2.patch;patch=1 \
                                 file://u-boot-1.1.6-fsl-1-UEC-remove-udelay.patch;patch=1 \
                                 file://u-boot-1.1.6-83xx-optimizations.patch;patch=1 \ 
"



PACKAGE_ARCH = "${MACHINE_ARCH}"

UBOOT_MACHINE_sarge-at91 = "sarge_config"
