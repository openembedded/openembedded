# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Task packages for the SlugOS distribution"
HOMEPAGE = "http://www.nslu2-linux.org"
LICENSE = "MIT"
PR = "r15"
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

# diff, cpio and find are required for turnup and ipkg.
SLUGOS_STANDARD_RRECOMMENDS += "\
diffutils \
cpio \
findutils \
"

# These lines add support for formatting ext2 and ext3 file systems
# on a hard disk attached to the NSLU2.  ext3 is the standard Linux
# file system.
SLUGOS_STANDARD_RRECOMMENDS += "\
e2fsprogs-mke2fs \
e2fsprogs-fsck \
e2fsprogs-e2fsck \
e2fsprogs-badblocks \
e2fsprogs-blkid \
"

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
kernel-module-ehci-hcd \
kernel-module-ohci-hcd \
kernel-module-uhci-hcd \
"

# Add modules required for IDE support
# SLUGOS_STANDARD_RRECOMMENDS += "\
# "

# Add modules required for Network support
SLUGOS_STANDARD_RRECOMMENDS += "\
kernel-module-mii \
kernel-module-ixp4xx-mac \
kernel-module-ixp4xx-qmgr \
kernel-module-via-velocity \
"

# Other candidate packages that have been considered and
# are intentionally excluded from the base flash image.
#
# portmap \
# kexec-tools \
# kernel-module-nfs \
# kernel-module-isofs \
# kernel-module-udf \
# kernel-module-loop \
# kernel-module-libata \
# kernel-module-pata-artop \
# kernel-module-netconsole \
# wpa-supplicant \
# zd1211-firmware kernel-module-zd1211rw \
# madwifi-ng-modules madwifi-ng-tools wireless-tools \

DISTRO_EXTRA_DEPENDS ?= ""
DEPENDS += "${DISTRO_EXTRA_DEPENDS}"

DISTRO_EXTRA_RDEPENDS ?= ""
RDEPENDS += "\
	kernel ixp4xx-npe \
	base-files base-passwd netbase \
        busybox initscripts-slugos slugos-init \
        update-modules sysvinit tinylogin udev \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	beep \
	util-linux-mount \
	util-linux-umount \
	util-linux-swaponoff \
	util-linux-losetup \
	${SLUGOS_STANDARD_RDEPENDS} \
	${DISTRO_EXTRA_RDEPENDS}"

DISTRO_EXTRA_RRECOMMENDS ?= ""
RRECOMMENDS += "\
	openssh \
	${SLUGOS_STANDARD_RRECOMMENDS} \
	${DISTRO_EXTRA_RRECOMMENDS}"
