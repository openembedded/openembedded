KLIBC_UTILS_VARIANT ?= "shared"
KLIBC_UTILS_PKGNAME ?= "klibc-utils"

# modprobe and losetup go to ${base_sbindir}

do_install_append() {
        install -d ${D}${base_bindir}
        install -d ${D}${base_sbindir}
        install -m 755 usr/gzip/gzip ${D}${base_bindir}
        install -m 755 usr/kinit/fstype/${KLIBC_UTILS_VARIANT}/fstype ${D}${base_bindir}
        install -m 755 usr/kinit/ipconfig/${KLIBC_UTILS_VARIANT}/ipconfig ${D}${base_bindir}
        install -m 755 usr/kinit/nfsmount/${KLIBC_UTILS_VARIANT}/nfsmount ${D}${base_bindir}
        install -m 755 usr/kinit/resume/${KLIBC_UTILS_VARIANT}/resume ${D}${base_bindir}
        install -m 755 usr/kinit/run-init/${KLIBC_UTILS_VARIANT}/run-init ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/cat ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/chroot ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/cpio ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dd ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/false ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/halt ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/kill ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/ln ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/losetup ${D}${base_sbindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/ls ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/minips ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/mkdir ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/mkfifo ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/mknod ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/modprobe ${D}${base_sbindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/mount ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/nuke ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/pivot_root ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/poweroff ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/readlink ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/reboot ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sleep ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sync ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/true ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/umount ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/uname ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/wc ${D}${base_bindir}
        ln -s gzip ${D}${base_bindir}/gunzip
        ln -s gzip ${D}${base_bindir}/zcat
}

PACKAGES += "${KLIBC_UTILS_PKGNAME}-sh \
             ${KLIBC_UTILS_PKGNAME}-kinit \
             ${KLIBC_UTILS_PKGNAME}-gzip \
             ${KLIBC_UTILS_PKGNAME}-fstype \
             ${KLIBC_UTILS_PKGNAME}-ipconfig \
             ${KLIBC_UTILS_PKGNAME}-nfsmount \
             ${KLIBC_UTILS_PKGNAME}-resume \
             ${KLIBC_UTILS_PKGNAME}-run-init \
             ${KLIBC_UTILS_PKGNAME}-cat \
             ${KLIBC_UTILS_PKGNAME}-chroot \
             ${KLIBC_UTILS_PKGNAME}-cpio \
             ${KLIBC_UTILS_PKGNAME}-dd \
             ${KLIBC_UTILS_PKGNAME}-dmesg \
             ${KLIBC_UTILS_PKGNAME}-false \
             ${KLIBC_UTILS_PKGNAME}-halt \
             ${KLIBC_UTILS_PKGNAME}-kill \
             ${KLIBC_UTILS_PKGNAME}-ln \
             ${KLIBC_UTILS_PKGNAME}-losetup \
             ${KLIBC_UTILS_PKGNAME}-ls \
             ${KLIBC_UTILS_PKGNAME}-minips \
             ${KLIBC_UTILS_PKGNAME}-mkdir \
             ${KLIBC_UTILS_PKGNAME}-mkfifo \
             ${KLIBC_UTILS_PKGNAME}-mknod \
             ${KLIBC_UTILS_PKGNAME}-modprobe \
             ${KLIBC_UTILS_PKGNAME}-mount \
             ${KLIBC_UTILS_PKGNAME}-nuke \
             ${KLIBC_UTILS_PKGNAME}-pivot-root \
             ${KLIBC_UTILS_PKGNAME}-poweroff \
             ${KLIBC_UTILS_PKGNAME}-readlink \
             ${KLIBC_UTILS_PKGNAME}-reboot \
             ${KLIBC_UTILS_PKGNAME}-sleep \
             ${KLIBC_UTILS_PKGNAME}-sync \
             ${KLIBC_UTILS_PKGNAME}-true \
             ${KLIBC_UTILS_PKGNAME}-umount \
             ${KLIBC_UTILS_PKGNAME}-uname \
             ${KLIBC_UTILS_PKGNAME}-wc"

FILES_${KLIBC_UTILS_PKGNAME}-sh = "${base_bindir}/sh"
FILES_${KLIBC_UTILS_PKGNAME}-kinit = "${base_bindir}/kinit"
FILES_${KLIBC_UTILS_PKGNAME}-gzip = "${base_bindir}/gzip ${base_bindir}/gunzip ${base_bindir}/zcat"
FILES_${KLIBC_UTILS_PKGNAME}-fstype = "${base_bindir}/fstype"
FILES_${KLIBC_UTILS_PKGNAME}-ipconfig = "${base_bindir}/ipconfig"
FILES_${KLIBC_UTILS_PKGNAME}-nfsmount = "${base_bindir}/nfsmount"
FILES_${KLIBC_UTILS_PKGNAME}-resume = "${base_bindir}/resume"
FILES_${KLIBC_UTILS_PKGNAME}-run-init = "${base_bindir}/run-init"
FILES_${KLIBC_UTILS_PKGNAME}-cat = "${base_bindir}/cat"
FILES_${KLIBC_UTILS_PKGNAME}-chroot = "${base_bindir}/chroot"
FILES_${KLIBC_UTILS_PKGNAME}-cpio = "${base_bindir}/cpio"
FILES_${KLIBC_UTILS_PKGNAME}-dd = "${base_bindir}/dd"
FILES_${KLIBC_UTILS_PKGNAME}-dmesg = "${base_bindir}/dmesg"
FILES_${KLIBC_UTILS_PKGNAME}-false = "${base_bindir}/false"
FILES_${KLIBC_UTILS_PKGNAME}-halt = "${base_bindir}/halt"
FILES_${KLIBC_UTILS_PKGNAME}-kill = "${base_bindir}/kill"
FILES_${KLIBC_UTILS_PKGNAME}-ln = "${base_bindir}/ln"
FILES_${KLIBC_UTILS_PKGNAME}-losetup = "${base_sbindir}/losetup"
FILES_${KLIBC_UTILS_PKGNAME}-ls = "${base_bindir}/ls"
FILES_${KLIBC_UTILS_PKGNAME}-minips = "${base_bindir}/minips"
FILES_${KLIBC_UTILS_PKGNAME}-mkdir = "${base_bindir}/mkdir"
FILES_${KLIBC_UTILS_PKGNAME}-mkfifo = "${base_bindir}/mkfifo"
FILES_${KLIBC_UTILS_PKGNAME}-mknod = "${base_bindir}/mknod"
FILES_${KLIBC_UTILS_PKGNAME}-modprobe = "${base_sbindir}/modprobe"
FILES_${KLIBC_UTILS_PKGNAME}-mount = "${base_bindir}/mount"
FILES_${KLIBC_UTILS_PKGNAME}-nuke = "${base_bindir}/nuke"
FILES_${KLIBC_UTILS_PKGNAME}-pivot-root = "${base_bindir}/pivot_root"
FILES_${KLIBC_UTILS_PKGNAME}-poweroff = "${base_bindir}/poweroff"
FILES_${KLIBC_UTILS_PKGNAME}-readlink = "${base_bindir}/readlink"
FILES_${KLIBC_UTILS_PKGNAME}-reboot = "${base_bindir}/reboot"
FILES_${KLIBC_UTILS_PKGNAME}-sleep = "${base_bindir}/sleep"
FILES_${KLIBC_UTILS_PKGNAME}-sync = "${base_bindir}/sync"
FILES_${KLIBC_UTILS_PKGNAME}-true = "${base_bindir}/true"
FILES_${KLIBC_UTILS_PKGNAME}-umount = "${base_bindir}/umount"
FILES_${KLIBC_UTILS_PKGNAME}-uname = "${base_bindir}/uname"
FILES_${KLIBC_UTILS_PKGNAME}-wc = "${base_bindir}/wc"
