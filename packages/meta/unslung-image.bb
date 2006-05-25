LICENSE = MIT
PR = "r16"

IMAGE_BASENAME = "unslung"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

DEPENDS  = "virtual/kernel \
	${UNSLUNG_EXTRA_DEPENDS}"

RDEPENDS  = "kernel update-modules unslung-rootfs \
	libc6-unslung slingbox ipkg \
	cpio \
	findutils \
	${UNSLUNG_EXTRA_RDEPENDS}"

IPKG_INSTALL = "kernel update-modules unslung-rootfs \
	libc6-unslung slingbox ipkg \
	cpio \
	findutils \
	${UNSLUNG_EXTRA_INSTALL}"

IMAGE_PREPROCESS_COMMAND += "unslung_clean_image; "
		
inherit image_ipk

# Note that anything in this function must be repeatable without having to rebuild the rootfs
unslung_clean_image () {

	# Remove the patches
	rm -rf ${IMAGE_ROOTFS}/patches

	# Remove the kernel image
	rm -rf ${IMAGE_ROOTFS}/boot
	# And remove the post and pre scripts for the kernel; saves flash space
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/kernel.postinst
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/kernel.postrm

	# Remove info from the local feed used to build the image
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/lists/*
	rm -f ${IMAGE_ROOTFS}/${sysconfdir}/version

	# Tidy up some thing which are in the wrong place
	mv ${IMAGE_ROOTFS}${libdir}/libipkg* ${IMAGE_ROOTFS}/lib/

	# Remove the ipkg symlink - unsling puts it back in
	rm -f ${IMAGE_ROOTFS}${bindir}/ipkg
	# and make the ipkg symlink point to the ipkg-fl utility instead.
	ln -s ipkg-fl ${IMAGE_ROOTFS}${bindir}/ipkg

	# Hack out the modutils stuff - it's too hard to make it work
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/update-modules.postinst
	rm -rf ${IMAGE_ROOTFS}/etc/rcS.d
	echo "#!/bin/sh" > ${IMAGE_ROOTFS}/usr/sbin/update-modules
	echo "exit 0" >> ${IMAGE_ROOTFS}/usr/sbin/update-modules
	chmod ugo+x ${IMAGE_ROOTFS}/usr/sbin/update-modules
	echo "#!/bin/sh" > ${IMAGE_ROOTFS}/sbin/depmod
	echo "exit 0" >> ${IMAGE_ROOTFS}/sbin/depmod
	chmod ugo+x ${IMAGE_ROOTFS}/sbin/depmod

	# Don't need this empty directory hanging around
	rm -rf ${IMAGE_ROOTFS}/lib/modules/2.4.22-xfs/pcmcia

	# Strip symbols and fix permissions on the libgcc_s.so.1 library
	${STRIP} ${IMAGE_ROOTFS}/lib/libgcc_s.so.1
	chmod ugo+x ${IMAGE_ROOTFS}/lib/libgcc_s.so.1

	# We need cpio and find, but we don't need any of the other stuff in the
	# packages (users can install the full package with ipkg after unsling).
	# (make sure that if the package is not included (i.e. using slingbox
	# instead) that the files are not deleted; they might be part of slingbox)

	#-- these are for cpio:
	rm -f ${IMAGE_ROOTFS}/usr/bin/mt
	rm -rf ${IMAGE_ROOTFS}/usr/libexec

	#-- and these for find:
	rm -f ${IMAGE_ROOTFS}/usr/bin/locate
	rm -f ${IMAGE_ROOTFS}/usr/bin/updatedb
	rm -f ${IMAGE_ROOTFS}/usr/bin/xargs
}

python () {
	# Don't build unslung images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}
