#QtopiaCore 'console' image
#gives you a small images with ssh access

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"
DEPENDS = "task-boot task-qtopia-core-gui task-qtopia-core-gui"

IMAGE_INSTALL = "task-boot \
            util-linux-mount util-linux-umount \
            ${DISTRO_SSH_DAEMON} \
            angstrom-version \
            task-qtopia-core-console \
            task-qtopia-core-gui \
	   "

export IMAGE_BASENAME = "trolltech-qtopia-core-gui-image"
IMAGE_LINGUAS = ""

inherit image

