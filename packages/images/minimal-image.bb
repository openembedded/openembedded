#Angstrom minimalist image
#gives you a small images with ssh access

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_INSTALL = "task-boot \
            util-linux-mount util-linux-umount \
            ${DISTRO_SSH_DAEMON} \
            angstrom-version \
	   "

export IMAGE_BASENAME = "minimalist-image"
IMAGE_LINGUAS = ""

inherit image

