LICENSE = MIT
PR = "r6"

IMAGE_BASENAME = "unslung"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

DEPENDS  = "unslung-kernel unslung-rootfs \
	glibc slingbox ipkg wget cpio findutils portmap-unslung \
	devio \
	${UNSLUNG_EXTRA_DEPENDS}"

IPKG_INSTALL = "unslung-rootfs \
	libc6-unslung slingbox ipkg wget cpio findutils portmap-unslung \
	devio \
	${UNSLUNG_EXTRA_INSTALL}"

IMAGE_PREPROCESS_COMMAND += "unslung_clean_image; "
		
inherit image_ipk

# Note that anything in this function must be repeatable without having to rebuild the rootfs
unslung_clean_image () {
	# Remove the patches
	rm -rf ${IMAGE_ROOTFS}/patches
	# Remove the kernel image
	rm -rf ${IMAGE_ROOTFS}/boot
	# Remove info from the local feed used to build the image
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/lists/*
	rm -f ${IMAGE_ROOTFS}/${sysconfdir}/version
	# Tidy up some thing which are in the wrong place
	mv ${IMAGE_ROOTFS}${libdir}/libipkg* ${IMAGE_ROOTFS}/lib/
	# Remove the ipkg symlink - unsling puts it back in
	rm -f ${IMAGE_ROOTFS}${bindir}/ipkg
	# Hack out the modutils stuff - it's too hard to make it work
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/update-modules.postinst
	rm -rf ${IMAGE_ROOTFS}/etc/rcS.d
	echo "#!/bin/sh" > ${IMAGE_ROOTFS}/usr/sbin/update-modules
	echo "exit 0" >> ${IMAGE_ROOTFS}/usr/sbin/update-modules
	chmod ugo+x ${IMAGE_ROOTFS}/usr/sbin/update-modules
	echo "#!/bin/sh" > ${IMAGE_ROOTFS}/sbin/depmod
	echo "exit 0" >> ${IMAGE_ROOTFS}/sbin/depmod
	chmod ugo+x ${IMAGE_ROOTFS}/sbin/depmod
}

python () {
	# Don't build unslung images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'unslung':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}
