PR = "r2"

IMAGE_BASENAME = "openslug"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

OPENSLUG_HIDDEN_PACKAGES = "ipkg-native ipkg-utils-native fakeroot-native ${PATCH_DEPENDS} virtual/armeb-linux-uclibc-gcc \
	virtual/libc makedevs-native mtd-utils-native slugimage-native nslu2-linksys-firmware nslu2-switchbox-firmware "

DEPENDS = "base-files base-passwd-3.5.7 \
        busybox dropbear hotplug initscripts netbase \
        sysvinit tinylogin lrzsz portmap \
        ixp4xx-csr ixp425-eth \
        ipkg-collateral ipkg ipkg-link \
        ${OPENSLUG_EXTRA_DEPENDS}"

IPKG_INSTALL = "base-files base-passwd \
        busybox dropbear hotplug initscripts netbase \
        update-modules sysvinit tinylogin lrzsz portmap \
        ixp4xx-csr ixp425-eth \
        ipkg-collateral ipkg ipkg-link \
        ${OPENSLUG_EXTRA_INSTALL}"

inherit image_ipk

python () {
	# Don't build openslug images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'openslug':
		raise bb.parse.SkipPackage("OpenSlug only builds for the Linksys NSLU2")
}
