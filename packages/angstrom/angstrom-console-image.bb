#Angstrom bootstrap image
LICENSE = "MIT"
PR = "r8"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base-extended \
           ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

RDEPENDS = "task-base-extended \
	    ${ANGSTROM_EXTRA_INSTALL} \
	    ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)} \
	   "

export IMAGE_BASENAME = "console-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

