#Angstrom minimalist image
#gives you a small images with ssh access
LICENSE = "MIT"
PR = "r3"

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"
IMAGE_LINGUAS = " "

RDEPENDS = "task-boot \
            ${DISTRO_SSH_DAEMON} \
            angstrom-version \
	   "

export IMAGE_BASENAME = "minimalist-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

