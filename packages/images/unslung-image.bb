COMPATIBLE_MACHINE = "nslu2"

IMAGE_BASENAME = "unslung"
IMAGE_NAME = "${IMAGE_BASENAME}-${MACHINE}-${DISTRO_VERSION}"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

DEPENDS  = "virtual/kernel \
	${UNSLUNG_EXTRA_DEPENDS}"

IMAGE_INSTALL = "kernel update-modules unslung-rootfs \
	libc6-unslung slingbox ipkg libipkg \
	kernel-module-netconsole \
	${UNSLUNG_EXTRA_INSTALL}"

IMAGE_PREPROCESS_COMMAND += "unslung_clean_image; "

inherit image

# Note that anything in this function must be repeatable without having to rebuild the rootfs
unslung_clean_image () {

	# Remove the patches
	rm -rf ${IMAGE_ROOTFS}/patches

	# Remove the kernel image
	rm -rf ${IMAGE_ROOTFS}/boot
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/alternatives/zImage
	# And remove the post and pre scripts for the kernel; saves flash space
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/kernel.postinst
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/kernel.postrm

	# Remove all the postinst scripts; don't need them.  But keep the
	# postrm scripts just in case we need to remove something.
	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/info/*.postinst

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

	# FIXME: change made 24 Jul 2006 by the OE folks changes the "strip"
	# behavior to create an extra file named .debug/<filename> containing
	# the stripped symbols.  These files are supposed to be packaged
	# separately by the standard bb routines, but for some reason this
	# does not alway occur.  This extremely ugly step is to remove the
	# debug cruft from the rootfs if any are left in the obvious locations.
	# Once someone figures out why and what the right way is to fix this,
	# this code should be removed.

	rm -rf ${IMAGE_ROOTFS}/bin/.debug
	rm -rf ${IMAGE_ROOTFS}/sbin/.debug
	rm -rf ${IMAGE_ROOTFS}/lib/.debug
	rm -rf ${IMAGE_ROOTFS}/usr/bin/.debug
	rm -rf ${IMAGE_ROOTFS}/usr/sbin/.debug
	rm -rf ${IMAGE_ROOTFS}/usr/lib/.debug

# MJW - Experimental - just to make space; remove before releasing!
#	#### Hack to make space for testing!  REMOVE THIS!
#	rm -rf ${IMAGE_ROOTFS}/etc/samba/codepages/unicode_map.850
#	rm -rf ${IMAGE_ROOTFS}/bin/ftp
#	#### End of Hack!

}


# Override this function for unslung, since we don't need Apex.

nslu2_pack_image () {
	slugimage -p \
		-b ${STAGING_LIBDIR}/nslu2-binaries/RedBoot \
		-s ${STAGING_LIBDIR}/nslu2-binaries/SysConf \
		-k ${DEPLOY_DIR_IMAGE}/zImage-${MACHINE}.bin \
		-r Ramdisk:1,Flashdisk:${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		-m ${STAGING_FIRMWARE_DIR}/NPE-B \
		-t ${STAGING_LIBDIR}/nslu2-binaries/Trailer \
		-o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-nslu2.bin
}
