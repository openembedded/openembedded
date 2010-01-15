#Angstrom minimalist image
#gives you a small image with ssh access

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
            util-linux-ng-mount util-linux-ng-umount \
            ${DISTRO_SSH_DAEMON} \
            ${ANGSTROM_EXTRA_INSTALL} \
            angstrom-version \
            ${SPLASH} \
	   "

export IMAGE_BASENAME = "minimalist-image"
IMAGE_LINGUAS = ""

inherit image

