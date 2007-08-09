# Image for kernel debugging and development testing
# It includes all useful "kernel userspace" utilities, but
# only shell and dropbear are loaded by default.
# Allows to login via serial and real console or SSH
LICENSE = "MIT"
PR = "r2.2"

DEVIMAGE_EXTRA_RDEPENDS ?= ""
RDEPENDS = "devimage busybox dropbear udev \
            module-init-tools pcmciautils \
	    wireless-tools wpa-supplicant \
	    irda-utils acx-firmware \
	    ${DEVIMAGE_EXTRA_RDEPENDS}"

export IMAGE_BASENAME = "devimage"
export IMAGE_LINGUAS = ""

PACKAGE_INSTALL = "${RDEPENDS}"

inherit image
