# This image is intended to provide a basic configuration that allows
# you to access a newly flashed device over the network or via the
# native console, and use ipkg to install (from feeds accessible via
# the network) any further features you require into internal flash
# memory or onto attached storage.

# It should be as small as possible, while still achieving that goal.

# The rationale for naming it 'base-image' is that this image is the
# base upon which you can install any other functionality you desire.

# Key features are:

# 1) Must be able to mount attached storage devices like SD cards, CF
# cards, internal disks, external USB disks, etc.  Should support
# various filesystem choices, but ext2 at a minimum.  The rationale
# for this is that you need storage to be able to install significant
# new functionality.

# 2) Must be able to boot from internal flash, or directly from a
# filesystem stored on the attached storage.  The rationale for this
# is that you will want to boot from attached storage instead of
# messing around with ipkg-link.

# Although it is only fully tested with the Angstrom distro, this
# image is intended to be distro-agnostic.

DISTRO_SSH_DAEMON ?= "dropbear"
DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"

DEPENDS = "\
	task-boot \
	task-distro-base task-machine-base \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_PACKAGE_MANAGER} \
	task-base-usbhost task-base-ext2 \
	"

IMAGE_INSTALL_TASKS = "\
	"

IMAGE_INSTALL = "\
	task-boot \
	task-distro-base task-machine-base \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_PACKAGE_MANAGER} \
	task-base-usbhost task-base-ext2 \
	${IMAGE_INSTALL_TASKS} \
	"

export IMAGE_BASENAME = "base-image"
IMAGE_LINGUAS = ""

inherit image
