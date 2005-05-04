PR = "r10"

IMAGE_BASENAME = "openslug"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

OPENSLUG_HIDDEN_PACKAGES = "ipkg-native ipkg-utils-native fakeroot-native ${PATCH_DEPENDS} virtual/armeb-linux-uclibc-gcc \
	virtual/libc makedevs-native mtd-utils-native slugimage-native nslu2-linksys-firmware "

DEPENDS = "virtual/kernel base-files base-passwd \
        busybox dropbear hotplug-ng initscripts netbase \
        sysvinit tinylogin lrzsz portmap \
        ixp4xx-csr ixp425-eth openslug-init \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link diffutils \
	cpio findutils e2fsprogs mtd-utils \
        ${OPENSLUG_EXTRA_DEPENDS}"

# NOTE: file system kernel modules are defined in openslug.conf
# (OPENSLUG_EXTRA_FILESYSTEMS, included in OPENSLUG_EXTRA_INSTALL)
IPKG_INSTALL = "base-files base-passwd \
        busybox dropbear hotplug-ng initscripts netbase \
        update-modules sysvinit tinylogin lrzsz portmap \
        ixp4xx-csr ixp425-eth openslug-init \
	module-init-tools modutils-initscripts \
        ipkg-collateral ipkg ipkg-link diffutils \
	cpio findutils e2fsprogs-mke2fs \
	e2fsprogs-fsck e2fsprogs-e2fsck \
        ${OPENSLUG_EXTRA_INSTALL}"

inherit image_ipk

python () {
	# Don't build openslug images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'openslug':
		raise bb.parse.SkipPackage("OpenSlug only builds for the Linksys NSLU2")
}
LICENSE = MIT
