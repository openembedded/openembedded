#Angstrom bootstrap image
LICENSE = "MIT"
PR = "r5"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base  psplash-zap"
RDEPENDS = "task-base \
	    ${ANGSTROM_EXTRA_INSTALL} \
	    psplash-zap
	   "

export IMAGE_BASENAME = "console-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

