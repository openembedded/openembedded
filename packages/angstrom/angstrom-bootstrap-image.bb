#Angstrom bootstrap image
LICENSE = "MIT"
PR = "r3"

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base"
RDEPENDS = "task-base-core-default \
	    task-base \
	    ${ANGSTROM_EXTRA_INSTALL} \
	   "

export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

#zap root password
ROOTFS_POSTPROCESS_COMMAND += "zap_root_password; "

inherit image

