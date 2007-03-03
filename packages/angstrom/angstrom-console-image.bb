#Angstrom bootstrap image
LICENSE = "MIT"
PR = "r4"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base"
RDEPENDS = "task-base-core-default \
	    task-base \
	    ${ANGSTROM_EXTRA_INSTALL} \
	   "

export IMAGE_BASENAME = "console-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

