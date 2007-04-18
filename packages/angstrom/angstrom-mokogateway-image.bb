#Angstrom moko gateway image
# tries to be a companion for openmoko based phones
LICENSE = "MIT"
PR = "r2"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base"
RDEPENDS = " \
	    task-boot \
	    task-base-bluetooth \
	    bluez-utils \
	    blueprobe \
	   "
export IMAGE_BASENAME = "mokogateway-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

