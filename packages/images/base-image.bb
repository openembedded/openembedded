# This image is intended to provide a basic configuration that allows
# you to access a newly flashed device over the network or via the
# native console, and use ipkg to install (from feeds accessible via
# the network) any further features you require into internal flash
# memory or onto attached storage.

# It should be as small as possible, while still achieving that goal.

# The rationale for naming it 'base-image' is that this image is the
# base upon which you can install any other functionality you desire.

# See the end of this file for further rationale and policy regarding
# the contents of this image, and the criteria which are used to make
# decisions about adding and removing packages from this image.

# Although it is only fully tested with the Angstrom distro, this
# image is intended to be distro-agnostic.

DISTRO_SSH_DAEMON ?= "dropbear"

DISTRO_PACKAGE_MANAGER ?= "ipkg ipkg-collateral"

# FIXME: We need a distro-indendent way of specifying feed configs.
# Once the RFC for the DISTRO_FEED_CONFIGS variable name is approved,
# we can remove this default definition and set it in the distro config.
DISTRO_FEED_CONFIGS ?= "${ANGSTROM_FEED_CONFIGS}"

DEPENDS = "\
	task-boot \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_PACKAGE_MANAGER} \
	${DISTRO_FEED_CONFIGS} \
	${@base_contains('MACHINE_FEATURES', 'ext2', 'task-base-ext2', '', d)} \
	${@base_contains('MACHINE_FEATURES', 'usbhost', 'task-base-usbhost', '', d)} \
	"

IMAGE_INSTALL = "\
	task-boot \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_PACKAGE_MANAGER} \
	${DISTRO_FEED_CONFIGS} \
	${@base_contains('MACHINE_FEATURES', 'ext2', 'task-base-ext2', '', d)} \
	${@base_contains('MACHINE_FEATURES', 'usbhost', 'task-base-usbhost', '', d)} \
	"

export IMAGE_BASENAME = "base-image"
IMAGE_LINGUAS = ""

inherit image

# Key features of this image are:

# 1) Must be able to mount attached storage devices like SD cards, CF
# cards, internal disks, external USB disks, etc.  Should support
# various filesystem choices, but ext2 at a minimum.  The rationale
# for this is that you need storage to be able to install significant
# new functionality.

# 2) Must be able to boot from internal flash, or directly from a
# filesystem stored on the attached storage.  The rationale for this
# is that you will want to boot from attached storage instead of
# messing around with ipkg-link.

# Rationale and policy:

# 'base-image' is the smallest possible image which allows you to ssh
# into a device via it's native network interface, and install
# packages from feeds across the network into internal flash or onto
# an attached storage device.

# It is "larger" than minimal-image (which is strictly only that which
# is required to boot and get ssh access to the device, and nothing
# else), but is "smaller" than console-image (which has a whole lot of
# stuff in it which could easily be ipkg installed after boot rather
# than being in the initial rootfs).

# It is required to always be small enough to fit in the internal
# flash rootfs partition of an NSLU2 (as an example of the smaller end
# of flash sizes that OE supports), and features will be removed from
# the image to ensure that this is always the case.  Any feature that
# can be installed over the network using the package manager after
# the first boot is always fair game for removal at any time, and
# patches are welcome to make base-image as small as possible while
# still retaining the ability to subsequently install that feature.
