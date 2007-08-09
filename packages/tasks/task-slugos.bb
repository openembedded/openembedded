# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Task packages for the SlugOS distribution"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r13"
PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

#----------------------------------------------------------------------------------
# FIRMWARE CONFIGURATION
#----------------------------------------------------------------------------------
# EXTRA PACKAGES
# --------------
# The standard firmware contents and additional packages built as requirements
# of the firmware are defined here in SLUGOS_STANDARD_RDEPENDS.
SLUGOS_STANDARD_RDEPENDS = ""
SLUGOS_STANDARD_RRECOMMENDS = ""

# diff, cpio and find are required for reflash and turnup ram.
# Removing these probably leaves the system bootable, but standard
# openslug and ucslugc stuff won't work, so only take these out in
# very non-standard turnkey slugos builds.
#
# udev is the default way of handling devices, there is no guarantee
# that the static device table is completely correct (it is just
# known to be sufficient for boot.)
SLUGOS_STANDARD_RRECOMMENDS += "diffutils cpio findutils udev"

# These lines add support for formatting ext2 and ext3 file systems
# on a hard disk attached to the NSLU2.  ext3 is the standard Linux
# file system.
SLUGOS_STANDARD_RRECOMMENDS += "e2fsprogs-mke2fs e2fsprogs-fsck e2fsprogs-e2fsck e2fsprogs-badblocks"

# These lines add support for an X/Y/ZModem package called lrzsz
# (this is of use for people with modified NSLU2 hardware which
# supports a serial port.)
SLUGOS_STANDARD_RRECOMMENDS += "lrzsz"

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
kernel-module-isofs \
kernel-module-udf \
kernel-module-nfs \
kernel-module-loop \
kernel-module-nls-cp437 \
kernel-module-nls-utf8 \
"


# Add daemon required for HW RNG support
SLUGOS_RNG_TOOLS_PACKAGE = "rng-tools"
SLUGOS_RNG_TOOLS_PACKAGE_linux-uclibc = ""
SLUGOS_STANDARD_RRECOMMENDS += "\
${SLUGOS_RNG_TOOLS_PACKAGE} \
"

# Add modules required for usb support
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
"

# Add modules required for IDE support
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-libata \
kernel-module-pata-artop \
"

# Add modules required for Network support
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-mii \
kernel-module-ixp4xx-mac \
kernel-module-ixp4xx-qmgr \
kernel-module-via-velocity \
"

# Add modules required for Wifi support
SLUGOS_STANDARD_RRECOMMENDS += "\
madwifi-ng-modules madwifi-ng-tools wireless-tools \
"

## Other wireless tools that should be considered
## should space be available in the rootfs
# wpa-supplicant \
# zd1211-firmware kernel-module-zd1211rw \

# Add kexec tools for rebooting alternate kernels
SLUGOS_STANDARD_RRECOMMENDS += "\
kexec-tools \
"

# Add modules required for Network Console support
# NOTE: This module is desirable for systems lacking a physical
# console, but is usually only enabled if specific needs or issues
# arise.  If space in the flash is at a premium, it can be omitted.
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-netconsole \
"

DISTRO_EXTRA_DEPENDS ?= ""
DEPENDS += "${DISTRO_EXTRA_DEPENDS}"

DISTRO_EXTRA_RDEPENDS ?= ""
RDEPENDS += "\
	kernel ixp4xx-npe \
	base-files base-passwd netbase \
        busybox initscripts-slugos slugos-init \
        update-modules sysvinit tinylogin \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	portmap \
	beep \
	e2fsprogs-blkid \
	util-linux-mount \
	util-linux-umount \
	util-linux-swaponoff \
	util-linux-losetup \
	${SLUGOS_STANDARD_RDEPENDS} \
	${DISTRO_EXTRA_RDEPENDS}"

RRECOMMENDS += "\
	dropbear \
	${SLUGOS_STANDARD_RRECOMMENDS} \
	${DISTRO_EXTRA_RRECOMMENDS}"
