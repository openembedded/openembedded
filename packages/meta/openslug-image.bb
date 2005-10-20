# This describes a generic NSLU2 image, even though the bb file is
# called 'openslug-image.bb' the OpenSlug specific configuration is
# done in conf/distro/openslug.conf
#
PR = "r15"

IMAGE_BASENAME = "openslug"

IMAGE_LINGUAS = ""
# Setting USE_DEVFS prevents *any* entries being created initially
# in /dev
USE_DEVFS = "1"

# diff, cpio and find are required for reflash and turnup ram.
# Removing these probably leaves the system bootable, but standard
# openslug and ucslugc stuff won't work, so only take these out in
# very non-standard turnkey ucslugc builds.
OPENSLUG_SUPPORT ?= "diffutils cpio findutils"

# NOTE: file system kernel modules are defined in openslug.conf
# (OPENSLUG_EXTRA_FILESYSTEMS, included in OPENSLUG_EXTRA_INSTALL)
# kernel-module-af-packet must be in the image for DHCP to work
OPENSLUG_KERNEL ?= "kernel-module-af-packet kernel-module-netconsole"
       
# The things explicitly included in the following lists are the
# absolute minimum to have any chance of a bootable system.
DEPENDS = "virtual/kernel base-files base-passwd \
        busybox dropbear hotplug-ng initscripts-openslug netbase \
        sysvinit tinylogin portmap \
        virtual/ixp-eth openslug-init \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	${OPENSLUG_SUPPORT} \
        ${OPENSLUG_EXTRA_DEPENDS}"

IPKG_INSTALL = "base-files base-passwd \
        busybox dropbear hotplug-ng initscripts-openslug netbase \
        update-modules sysvinit tinylogin portmap \
        ${PREFERRED_PROVIDER_virtual/ixp-eth} openslug-init \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	${OPENSLUG_SUPPORT} \
	${OPENSLUG_KERNEL} \
	${OPENSLUG_EXTRA_INSTALL}"

inherit image_ipk

python () {
	# Don't build openslug images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("OpenSlug only builds for the Linksys NSLU2")
}
LICENSE = MIT
