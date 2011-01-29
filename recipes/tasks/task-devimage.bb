DESCRIPTION = "Image for development testing"
PR = "r7"
LICENSE = "MIT"

inherit task

DEVIMAGE_EXTRA_RDEPENDS ?= ""
DEVIMAGE_EXTRA_RRECOMMENDS ?= ""

RDEPENDS_${PN} = "\
    devimage \
    busybox dropbear udev \
    util-linux-mount \
    module-init-tools pcmciautils \
    wireless-tools wpa-supplicant \
    irda-utils acx-firmware \
    kexec kdump \
    ${DEVIMAGE_EXTRA_RDEPENDS} \
    "

RRECOMMENDS_${PN} = "\
    kernel \
    kernel-image \
    kernel-module-msdos \
    kernel-module-vfat \
    kernel-modules \
    ${DEVIMAGE_EXTRA_RRECOMMENDS} \
    "
PACKAGE_ARCH = "${MACHINE_ARCH}"
