PR = "r3"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

UNSLUNG_BASE_DEPENDS = "glibc slingbox ipkg wget cpio findutils portmap-unslung"
UNSLUNG_BASE_PACKAGES = "libc6-unslung slingbox ipkg wget cpio findutils portmap-unslung"

IMAGE_VARIANT ?= "standard"

export IMAGE_BASENAME = "unslung-${IMAGE_VARIANT}"

IPKG_INSTALL = "unslung-${IMAGE_VARIANT}-rootfs \
		${UNSLUNG_BASE_PACKAGES} ${UNSLUNG_EXTRA_PACKAGES}"

DEPENDS  = "unslung-${IMAGE_VARIANT}-kernel unslung-${IMAGE_VARIANT}-rootfs \
		${UNSLUNG_BASE_DEPENDS} ${UNSLUNG_EXTRA_DEPENDS}"

RDEPENDS = "${UNSLUNG_BASE_PACKAGES} ${UNSLUNG_EXTRA_RDEPENDS}"

RRECOMMENDS = "${UNSLUNG_EXTRA_RRECOMMENDS}"

IMAGE_PREPROCESS_COMMAND += "unslung_clean_image; "
		
inherit image_ipk

# Note that anything in this function must be repeatable without having to rebuild the rootfs
unslung_clean_image () {
	# Remove info from the local feed used to build the image
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/lists/*
	rm -f ${IMAGE_ROOTFS}/${sysconfdir}/version
}

python () {
	# Don't build unslung images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'unslung':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}
LICENSE = MIT
