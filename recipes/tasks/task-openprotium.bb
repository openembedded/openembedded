DESCRIPTION = "Basic image for openprotium"
HOMEPAGE = "http://www.openprotium.org"
ALLOW_EMPTY = "1"
PR = "r2"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"
# be sure to build the kernel:
DEPENDS = "virtual/kernel"

# always make this one for testing.
DISTRO_KERNEL_MODULES = "kernel-module-dummy"
# do we still need this?
DISTRO_KERNEL_MODULES += "kernel-module-af-packet"
# unused for now
#DISTRO_KERNEL_MODULES += "kernel-module-netconsole"

# these are listed separately because the are not needed 
# for boot, but are needed by reflash, etc.
DISTRO_EXTRA_RDEPENDS += "diffutils cpio findutils"

# pick up the fw_set/get env utils.
DISTRO_EXTRA_RDEPENDS += "u-boot-utils"

RDEPENDS = " kernel \
	base-files \
	base-passwd \
	netbase \
	busybox \
	openprotium-init \
	initscripts-openprotium \
	update-modules \
	module-init-tools \  
	modutils-initscripts \
	ipkg-collateral ipkg ipkg-link \
	portmap \
	util-linux-ng-blkid \
	mdadm \
	hdparm \
	mtd-utils \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_DEV_MANAGER} \
	${DISTRO_INIT_MANAGER} \
	${DISTRO_LOGIN_MANAGER} \
	${DISTRO_KERNEL_MODULES} \
	${MACHINE_EXTRA_RDEPENDS} \
	${DISTRO_EXTRA_RDEPENDS} "

RRECOMMENDS += " \
	${DISTRO_EXTRA_RRECOMMENDS} \
	${MACHINE_EXTRA_RRECOMMENDS}"
