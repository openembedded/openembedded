LICENSE = MIT
PR = "r11"

IMAGE_BASENAME = "unslung"

IMAGE_LINGUAS = ""
USE_DEVFS = "1"

DEPENDS  = "virtual/kernel \
	${UNSLUNG_EXTRA_DEPENDS}"

RDEPENDS  = "kernel unslung-rootfs \
	libc6-unslung slingbox ipkg cpio findutils \
	${UNSLUNG_EXTRA_RDEPENDS}"

IPKG_INSTALL = "unslung-rootfs \
	libc6-unslung slingbox ipkg cpio findutils \
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
	${STRIP} ${IMAGE_ROOTFS}/lib/libgcc_s.so.1
	chmod ugo+x ${IMAGE_ROOTFS}/lib/libgcc_s.so.1

	# Remove some of the Samba codepages to make space
	# 437 (USA) - keep
	# 737 (Greek)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.737
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/unicode_map.737
	# 850 (Latin1) - keep
	# 852 (Latin2)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.852
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/unicode_map.852
	# 861 (Iceland)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.861
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/unicode_map.861
	# 866 (Russian)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.866
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/unicode_map.866
	# 932 (Japanese Shift-JIS)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.932
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/unicode_map.932
	# 936 (Simplified Chinese)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.936
	# 949 (Korean)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.949
	# 950 (Chinese BIG-5)
	rm -f ${IMAGE_ROOTFS}/etc/samba/codepages/codepage.950
	# ISO8859-1 (Latin 1) - keep
}

python () {
	# Don't build unslung images unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}
