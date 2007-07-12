# Image for kernel debugging and development testing
# Contains minimal userspace shim (no udev, etc.), but all useful 
# "kernel userspace" utilities (feel free to add missing).
# Allows to login via serial and real console or SSH
LICENSE = "MIT"
PR = "r1"

RDEPENDS = "devimage busybox dropbear module-init-tools wireless-tools wpa-supplicant irda-utils acx-firmware"

export IMAGE_BASENAME = "devimage"
export IMAGE_LINGUAS = ""

PACKAGE_INSTALL = "${RDEPENDS}"

inherit image
