DESCRIPTION = "EXT2 Filesystem Utilities"
HOMEPAGE = "http://e2fsprogs.sf.net"
LICENSE = "GPL"
SECTION = "base"
DEPENDS = "gettext-native util-linux-ng"
DEPENDS_virtclass-native = "gettext-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/e2fsprogs/e2fsprogs-${PV}.tar.gz"

S = "${WORKDIR}/e2fsprogs-${PV}"

INC_PR = "r22"

inherit autotools

#if uclibc ntpl is merged into trunk we can enable tls for armv4 again
EXTRA_OECONF = "${@['','--disable-tls'][bb.data.getVar('ARM_ABI', d, 1) == 'oabi' and \
		bb.data.getVar('TARGET_OS', d, 1).find('uclibc') >= 0 ]} \
		--enable-elf-shlibs \
		--enable-dynamic-e2fsck --disable-nls --sbindir=${base_sbindir} \
		--disable-libuuid --disable-libblkid --disable-fsck"

PARALLEL_MAKE = ""

do_compile_prepend () {
	find ./ -print|xargs chmod u=rwX
	( cd util; ${BUILD_CC} subst.c -o subst )
}

do_install_append () {

    	oe_runmake install-libs DESTDIR=${D}

	mv ${D}${base_sbindir}/e2fsck ${D}${base_sbindir}/e2fsck.${PN}
	rm ${D}${base_sbindir}/fsck.ext2
	rm ${D}${base_sbindir}/fsck.ext3
	rm ${D}${base_sbindir}/fsck.ext4*
	mv ${D}${base_sbindir}/mke2fs ${D}${base_sbindir}/mke2fs.${PN}
	rm ${D}${base_sbindir}/mkfs.ext2
	rm ${D}${base_sbindir}/mkfs.ext3
	rm ${D}${base_sbindir}/mkfs.ext4*

	cd ${D}/${base_sbindir}
	ln -sf ./e2fsck.${PN} fsck.ext2.${PN}
	ln -sf ./e2fsck.${PN} fsck.ext3.${PN}
	ln -sf ./e2fsck.${PN} fsck.ext4.${PN}
	ln -sf ./e2fsck.${PN} fsck.ext4dev.${PN}
	ln -sf ./mke2fs.${PN} mkfs.ext2.${PN}
	ln -sf ./mke2fs.${PN} mkfs.ext3.${PN}
	ln -sf ./mke2fs.${PN} mkfs.ext4.${PN}
	ln -sf ./mke2fs.${PN} mkfs.ext4dev.${PN}

	ln -sf ./tune2fs findfs
	ln -sf ./tune2fs e2label

	mv ${D}${bindir}/chattr ${D}${bindir}/chattr.${PN}
}

pkg_postinst_e2fsprogs () {
	update-alternatives --install ${base_bindir}/chattr chattr chattr.${PN} 100
}

pkg_prerm_e2fsprogs () {
	update-alternatives --remove chattr chattr.${PN}
}


pkg_postinst_e2fsprogs-blkid () {
    update-alternatives --install ${base_sbindir}/blkid blkid blkid.${PN} 100
}

pkg_prerm_e2fsprogs-blkid () {
    update-alternatives --remove blkid blkid.${PN}
}

pkg_postinst_e2fsprogs-e2fsck () {
	update-alternatives --install ${base_sbindir}/e2fsck e2fsck e2fsck.${PN} 100
	update-alternatives --install ${base_sbindir}/fsck.ext2 fsck.ext2 fsck.ext2.${PN} 100
	update-alternatives --install ${base_sbindir}/fsck.ext3 fsck.ext3 fsck.ext3.${PN} 100
	update-alternatives --install ${base_sbindir}/fsck.ext4 fsck.ext4 fsck.ext4.${PN} 100
	update-alternatives --install ${base_sbindir}/fsck.ext4dev fsck.ext4dev fsck.ext4dev.${PN} 100
}

pkg_prerm_e2fsprogs-e2fsck () {
	update-alternatives --remove e2fsck e2fsck.${PN}
	update-alternatives --remove fsck.ext2 fsck.ext2.${PN}
	update-alternatives --remove fsck.ext3 fsck.ext3.${PN}
	update-alternatives --remove fsck.ext4 fsck.ext4.${PN}
	update-alternatives --remove fsck.ext4dev fsck.ext4dev.${PN}
}

pkg_postinst_e2fsprogs-mke2fs () {
	update-alternatives --install ${base_sbindir}/mke2fs mke2fs mke2fs.${PN} 100
	update-alternatives --install ${base_sbindir}/mkfs.ext2 mkfs.ext2 mkfs.ext2.${PN} 100
	update-alternatives --install ${base_sbindir}/mkfs.ext3 mkfs.ext3 mkfs.ext3.${PN} 100
	update-alternatives --install ${base_sbindir}/mkfs.ext4 mkfs.ext4 mkfs.ext4.${PN} 100
	update-alternatives --install ${base_sbindir}/mkfs.ext4dev mkfs.ext4dev mkfs.ext4dev.${PN} 100
}

pkg_prerm_e2fsprogs-mke2fs () {
	update-alternatives --remove mke2fs mke2fs.${PN}
	update-alternatives --remove mkfs.ext2 mkfs.ext2.${PN}
	update-alternatives --remove mkfs.ext3 mkfs.ext3.${PN}
	update-alternatives --remove mkfs.ext4 mkfs.ext4.${PN}
	update-alternatives --remove mkfs.ext4dev mkfs.ext4dev.${PN}
}

# blkid used to be part of e2fsprogs but is useful outside, add it
# as an RDEPENDS so that anything relying on it being in e2fsprogs
# still works
RDEPENDS_e2fsprogs = "util-linux-ng e2fsprogs-badblocks"

FILES_${PN} += "${libdir}/e2initrd_helper"

PACKAGES =+ "e2fsprogs-e2fsck e2fsprogs-mke2fs e2fsprogs-tune2fs e2fsprogs-badblocks libcomerr libss"
FILES_e2fsprogs-e2fsck = "${base_sbindir}/e2fsck.${PN} ${base_sbindir}/fsck.ext*.${PN}"
FILES_e2fsprogs-mke2fs = "${base_sbindir}/mke2fs.${PN} ${base_sbindir}/mkfs.ext*.${PN}"
FILES_e2fsprogs-tune2fs = "${base_sbindir}/tune2fs ${base_sbindir}/e2label ${base_sbindir}/findfs"
FILES_e2fsprogs-badblocks = "${base_sbindir}/badblocks"
FILES_libcomerr = "${libdir}/libcom_err.so.*"
FILES_libss = "${libdir}/libss.so.*"

BBCLASSEXTEND = "native"
