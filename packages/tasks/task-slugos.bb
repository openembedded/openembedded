# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Task packages for the SlugOS distribution"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r2"
PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

# CONFIG:
# SLUGOS_EXTRA_RDEPENDS: set in conf, things to add to the image
# SLUGOS_SUPPORT:        set here, see below, added to the image.
# SLUGOS_KERNEL:         set here, kernel modules added to the image
#
# Do not override the last two unless you really know what you
# are doing - there is more information below.

# diff, cpio and find are required for reflash and turnup ram.
# Removing these probably leaves the system bootable, but standard
# openslug and ucslugc stuff won't work, so only take these out in
# very non-standard turnkey slugos builds.
#
# udev is the default way of handling devices, there is no guarantee
# that the static device table is completely correct (it is just
# known to be sufficient for boot.)
SLUGOS_SUPPORT ?= "diffutils cpio findutils udev"

SLUGOS_KERNEL ?= ""

SLUGOS_EXTRA_RDEPENDS ?= ""

RDEPENDS = "kernel ixp4xx-npe \
	base-files base-passwd netbase \
        busybox initscripts-slugos slugos-init \
        update-modules sysvinit tinylogin \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	portmap \
	dropbear \
	beep \
	e2fsprogs-blkid \
	util-linux-mount \
	util-linux-umount \
	util-linux-swaponoff \
	util-linux-losetup \
	${SLUGOS_SUPPORT} \
	${SLUGOS_KERNEL} \
	${SLUGOS_EXTRA_RDEPENDS}"
