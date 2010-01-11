require e2fsprogs.inc

DEPENDS += "gettext-native"

do_configure() {
        oe_runconf
}

do_compile_prepend () {
	find ./ -print|xargs chmod u=rwX
	( cd util; ${BUILD_CC} subst.c -o subst )
}

ext2fsheaders = "ext2_ext_attr.h bitops.h ext2_err.h \
		 ext2_types.h ext2_fs.h ext2_io.h \
		 ext2fs.h"
e2pheaders = "e2p.h"

do_stage () {
	oe_libinstall -a -C lib libe2p ${STAGING_LIBDIR}/
	oe_libinstall -a -C lib libext2fs ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/e2p
	for h in ${e2pheaders}; do
		install -m 0644 lib/e2p/$h ${STAGING_INCDIR}/e2p/ || die "failed to install $h"
	done
	install -d ${STAGING_INCDIR}/ext2fs
	for h in ${ext2fsheaders}; do
		install -m 0644 lib/ext2fs/$h ${STAGING_INCDIR}/ext2fs/ || die "failed to install $h"
	done
	autotools_stage_all
}

# blkid used to be part of e2fsprogs but is useful outside, add it
# as an RDEPENDS so that anything relying on it being in e2fsprogs
# still works
RDEPENDS_e2fsprogs = "e2fsprogs-blkid e2fsprogs-uuidgen e2fsprogs-badblocks"

FILES_${PN} += "${libdir}/e2initrd_helper"

PACKAGES =+ "e2fsprogs-blkid e2fsprogs-uuidgen e2fsprogs-e2fsck e2fsprogs-mke2fs e2fsprogs-fsck e2fsprogs-tune2fs e2fsprogs-badblocks"
FILES_e2fsprogs-blkid = "${base_sbindir}/blkid.${PN}"
FILES_e2fsprogs-uuidgen = "${bindir}/uuidgen"
FILES_e2fsprogs-fsck = "${base_sbindir}/fsck.${PN}"
FILES_e2fsprogs-e2fsck = "${base_sbindir}/e2fsck.${PN} ${base_sbindir}/fsck.ext*.${PN}"
FILES_e2fsprogs-mke2fs = "${base_sbindir}/mke2fs.${PN} ${base_sbindir}/mkfs.ext*.${PN}"
FILES_e2fsprogs-tune2fs = "${base_sbindir}/tune2fs ${base_sbindir}/e2label ${base_sbindir}/findfs"
FILES_e2fsprogs-badblocks = "${base_sbindir}/badblocks"

do_install_append () {
	mv ${D}${base_sbindir}/fsck ${D}${base_sbindir}/fsck.${PN}
	mv ${D}${base_sbindir}/blkid ${D}${base_sbindir}/blkid.${PN}
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
}

pkg_postinst_e2fsprogs () {
	update-alternatives --install ${base_bindir}/chattr chattr chattr.${PN} 100
}

pkg_postinst_e2fsprogs-fsck () {
	update-alternatives --install ${base_sbindir}/fsck fsck fsck.${PN} 100
}

pkg_prerm_e2fsprogs-fsck () {
	update-alternatives --remove fsck fsck.${PN}
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
