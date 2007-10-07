# Image for kernel debugging and development testing
# It includes all useful "kernel userspace" utilities, but
# only shell and dropbear are loaded by default.
# Allows to login via serial and real console or SSH

DEVIMAGE_EXTRA_RDEPENDS ?= ""
IMAGE_INSTALL = "devimage busybox dropbear udev \
            module-init-tools pcmciautils \
	    wireless-tools wpa-supplicant \
	    irda-utils acx-firmware \
	    ${DEVIMAGE_EXTRA_RDEPENDS}"

export IMAGE_BASENAME = "devimage"
IMAGE_LINGUAS = ""

inherit image
