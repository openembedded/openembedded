# iMote2 mage based on Angstrom minimalist image

DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
            util-linux-ng-mount util-linux-ng-umount \
            ${DISTRO_SSH_DAEMON} \
            lowpan-tools \
            ibrdtn \
            angstrom-version \
	   "

export IMAGE_BASENAME = "imote2-image"
IMAGE_LINGUAS = ""

inherit image
