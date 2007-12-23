# This image is intended to provide a configuration
# for a network attached storage server device.

# Key features are:
# 
# 1) Must be able to mount attached storage devices like
# internal disks, external USB disks, etc.  Should support
# various filesystem choices, but ext2 at a minimum.
#
# 2) Must be able to boot from internal flash, or directly
# from a filesystem stored on the attached storage.
#
# 3) Must be able to share that storage across the network
# using various protocols like Samba, NFS, etc.
#
# 4) Bonus points for being able to support other central
# network services like a central gateway machine might.

# Although it is tested with the Angstrom distro, it is
# intended to be distro-agnostic.

DISTRO_SSH_DAEMON ?= "dropbear"
DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"

DEPENDS = "task-boot task-base-apex \
            task-distro-base task-machine-base \
            ${DISTRO_SSH_DAEMON} \
            ${DISTRO_PACKAGE_MANAGER} \
            task-base-usbhost task-base-ext2 \
	    task-nas-server-everything \
           "

IMAGE_INSTALL_TASKS = "\
            task-nas-server-everything \
           "

IMAGE_INSTALL = "task-boot task-base-apex \
            ${DISTRO_SSH_DAEMON} \
            ${DISTRO_PACKAGE_MANAGER} \
            task-base-usbhost task-base-ext2 \
            ${IMAGE_INSTALL_TASKS} \
	   "

export IMAGE_BASENAME = "nas-server-image"
IMAGE_LINGUAS = ""

inherit image
