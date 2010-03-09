# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Task packages for the SlugOS distribution"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r25"
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(nslu2|ixp4xx|sheevaplug)"
ALLOW_EMPTY = "1"

#----------------------------------------------------------------------------------
# FIRMWARE CONFIGURATION
#----------------------------------------------------------------------------------
# EXTRA PACKAGES
# --------------
# The standard firmware contents and additional packages built as requirements
# of the firmware are defined here in SLUGOS_STANDARD_RDEPENDS.  This represents
# the standard set of software for the 8-MByte NSLU2 device.
SLUGOS_STANDARD_RDEPENDS = ""
SLUGOS_STANDARD_RRECOMMENDS = ""
SLUGOS_MACHINE_RDEPENDS = ""
SLUGOS_MACHINE_RRECOMMENDS = ""

# The full cpio (non-busybox) is required for turnup and sysconfig.
SLUGOS_STANDARD_RRECOMMENDS += "\
cpio \
"

# These lines add support for formatting ext2 and ext3 file systems
# on a hard disk attached to the NSLU2.  ext3 is the standard Linux
# file system.
SLUGOS_STANDARD_RRECOMMENDS += "\
e2fsprogs-mke2fs \
util-linux-ng-fsck \
e2fsprogs-e2fsck \
e2fsprogs-badblocks \
util-linux-ng-blkid \
"

# Filesystem selection.  Adding entries here adds the module to the
# image.  The module must be built as part of nslu2-kernel (i.e. it
# must be specified as a module in the defconfig file).  The NLS
# support charset modules must be given explicitly and must match
# the codepage/iocharset and NLS handling for the file systems which
# require them.  The installed lanugage set is minimal but sufficient
# for any file system (since it uses utf8).  See
# http://www.nslu2-linux.orgwiki/HowTo/MountFATFileSystems
# for more information on the language behaviour of the DOS file
# systems.
#
# KERNEL LEVEL FILE SYSTEM SUPPORT
# --------------------------------
# NOTE: removing kernel-module-nfs from this list will prevent NFS
# boot (however you can do a simple flash file system boot - no
# attached disk - and install the nfs modules from ssh.)
# The altboot mechanism requires kernel-module-loop.
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-ext2 \
kernel-module-jbd \
kernel-module-ext3 \
kernel-module-vfat \
kernel-module-nls-cp437 \
kernel-module-nls-utf8 \
kernel-module-nfs \
"

# Add modules required for usb support
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-ehci-hcd \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
"

# Add packages and modules required for RAID-1 support
SLUGOS_STANDARD_RRECOMMENDS += "\
mdadm \
kernel-module-md-mod \
kernel-module-raid1 \
"

# Add the machine-specific RRECOMMENDS stuff -- kernel modules required for
# network support.
SLUGOS_MACHINE_RRECOMMENDS_nslu2 = "\
kernel-module-mii \
kernel-module-ixp4xx-mac \
kernel-module-ixp4xx-qmgr \
"

# Add machine-specific RDEPENDS stuff - packages such as the NPE firmware
SLUGOS_MACHINE_RDEPENDS_nslu2 = "\
ixp4xx-npe \
"

DISTRO_EXTRA_DEPENDS ?= ""
DEPENDS += "${DISTRO_EXTRA_DEPENDS}"

DISTRO_EXTRA_RDEPENDS ?= ""

## This comment block is temporary, to be removed once SlugOS 5.0 stabilizes
##RDEPENDS += "\
##	kernel ixp4xx-npe \
##	base-files base-passwd netbase \
##        busybox initscripts-slugos slugos-init \
##        update-modules sysvinit tinylogin udev \
##	module-init-tools modutils-initscripts \
##        ipkg-collateral ipkg ipkg-link \
##	libgcc \
##	beep \
##	util-linux-mount \
##	util-linux-umount \
##	util-linux-swaponoff \
##	util-linux-losetup \
##	${SLUGOS_STANDARD_RDEPENDS} \
##	${DISTRO_EXTRA_RDEPENDS}"
## SlugOS 5.0 - original RDEPENDS above for reference; tinylogin and the
## util-linux-* utilities are now replaced by busybox tools.  Also, ipkg
## is replaced by a trimmed-down version of opkg (no package signatures,
## and it uses the busybox wget command instead of libcurl - MJW
## SlugOS 5.0 - module-init-tools replaced by busybox as well - MJW
## SlugOS 5.2 - module-init-tools reinstated due to busybox bugs - MJW
## SlugOS 5.4 - util-linux-mount reinstated due to busybox bugs - MJW

RDEPENDS += "\
	kernel \
	base-files base-passwd netbase \
        busybox initscripts-slugos slugos-init \
        update-modules sysvinit udev \
	module-init-tools modutils-initscripts \
        opkg-collateral ${IPKG_VARIANT} \
	libgcc \
	beep \
	util-linux-mount \
	${SLUGOS_STANDARD_RDEPENDS} \
	${SLUGOS_MACHINE_RDEPENDS} \
	${DISTRO_EXTRA_RDEPENDS}"

DISTRO_EXTRA_RRECOMMENDS ?= ""
RRECOMMENDS += "\
	openssh \
	${SLUGOS_STANDARD_RRECOMMENDS} \
        ${SLUGOS_MACHINE_RRECOMMENDS} \
	${DISTRO_EXTRA_RRECOMMENDS}"
