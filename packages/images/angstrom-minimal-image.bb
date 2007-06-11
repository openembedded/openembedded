#Angstrom minimalist image
#gives you a small images with ssh access
LICENSE = "MIT"
PR = "r1"

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

RDEPENDS = "task-boot \
            ${DISTRO_SSH_DAEMON} \
	   "

export IMAGE_BASENAME = "minimalist-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

