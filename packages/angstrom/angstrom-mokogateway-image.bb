#Angstrom moko gateway image
# tries to be a companion for openmoko based phones
LICENSE = "MIT"
PR = "r1"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base"
RDEPENDS = " \
	    task-base \
	    bluez-utils \
	    blue-probe \
	   "
RRECOMMENDS = " \
    kernel-module-bluetooth \
    kernel-module-l2cap \
    kernel-module-rfcomm \
    kernel-module-hci-vhci \
    kernel-module-bnep \
    kernel-module-hidp \
    kernel-module-hci-uart \
    kernel-module-sco \
    ${@base_contains("COMBINED_FEATURES", "usbhost", "kernel-module-hci-usb", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "pcmcia", "kernel-module-bluetooth3c-cs", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "pcmcia", "kernel-module-bluecard-cs", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "pcmcia", "kernel-module-bluetoothuart-cs", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "pcmcia", "kernel-module-dtl1-cs", "",d)} \
   "

export IMAGE_BASENAME = "mokogateway-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

