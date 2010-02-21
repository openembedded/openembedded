require klibc-common.inc

SRC_URI += "file://fstype-sane-vfat-and-jffs2-for-1.5.patch;patch=1 \
            file://modprobe.patch;patch=1 \
            file://losetup.patch;patch=1 \
            file://dash_readopt.patch;patch=1 \
            file://wc.patch;patch=1 \
            file://staging.patch;patch=1 \
            file://klibc_kexecsyscall.patch;patch=1 \
            file://mntproc-definitions.patch;patch=1 \
            file://signal-cleanup.patch;patch=1 \
            file://isystem.patch;patch=1 \
            "

# we want only the shared programms and the lib so we chose them manually
do_install() {
        install -d ${D}${base_bindir}
        install -m 755 usr/dash/sh.shared ${D}${base_bindir}/sh
        install -m 755 usr/gzip/gzip ${D}${base_bindir}
        install -m 755 usr/kinit/kinit.shared ${D}${base_bindir}/kinit
        install -m 755 usr/kinit/fstype/shared/fstype ${D}${base_bindir}
        install -m 755 usr/kinit/ipconfig/shared/ipconfig ${D}${base_bindir}
        install -m 755 usr/kinit/nfsmount/shared/nfsmount ${D}${base_bindir}
        install -m 755 usr/kinit/resume/shared/resume ${D}${base_bindir}
        install -m 755 usr/kinit/run-init/shared/run-init ${D}${base_bindir}
        install -m 755 usr/utils/shared/cat ${D}${base_bindir}
        install -m 755 usr/utils/shared/chroot ${D}${base_bindir}
        install -m 755 usr/utils/shared/cpio ${D}${base_bindir}
        install -m 755 usr/utils/shared/dd ${D}${base_bindir}
        install -m 755 usr/utils/shared/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/shared/false ${D}${base_bindir}
        install -m 755 usr/utils/shared/halt ${D}${base_bindir}
        install -m 755 usr/utils/shared/kill ${D}${base_bindir}
        install -m 755 usr/utils/shared/ln ${D}${base_bindir}
        install -m 755 usr/utils/shared/minips ${D}${base_bindir}
        install -m 755 usr/utils/shared/mkdir ${D}${base_bindir}
        install -m 755 usr/utils/shared/mkfifo ${D}${base_bindir}
        install -m 755 usr/utils/shared/mknod ${D}${base_bindir}
        install -m 755 usr/utils/shared/mount ${D}${base_bindir}
        install -m 755 usr/utils/shared/nuke ${D}${base_bindir}
        install -m 755 usr/utils/shared/pivot_root ${D}${base_bindir}
        install -m 755 usr/utils/shared/poweroff ${D}${base_bindir}
        install -m 755 usr/utils/shared/readlink ${D}${base_bindir}
        install -m 755 usr/utils/shared/reboot ${D}${base_bindir}
        install -m 755 usr/utils/shared/sleep ${D}${base_bindir}
        install -m 755 usr/utils/shared/sync ${D}${base_bindir}
        install -m 755 usr/utils/shared/true ${D}${base_bindir}
        install -m 755 usr/utils/shared/umount ${D}${base_bindir}
        install -m 755 usr/utils/shared/uname ${D}${base_bindir}
        install -m 755 usr/utils/shared/modprobe ${D}${base_bindir}
        install -m 755 usr/utils/shared/losetup ${D}${base_bindir}
        install -m 755 usr/utils/shared/wc ${D}${base_bindir}

        install -d ${D}${base_libdir}
        install -m 755 usr/klibc/klibc-*.so ${D}${base_libdir}
        cd ${D}${base_libdir}
        ln -s klibc-*.so klibc.so
        cd -
        cd ${D}${base_bindir}
        ln -s gzip gunzip
        ln -s gzip zcat
        cd -
}

export INST=${STAGING_DIR_TARGET}
do_stage() {
        oe_runmake  install
        cp '${STAGING_DIR_TARGET}/bin/klcc'  '${CROSS_DIR}/bin/${TARGET_PREFIX}klcc'
}

PACKAGES = "${PN} ${PN}-dev klibc-utils-sh klibc-utils-kinit \
        klibc-utils-fstype klibc-utils-ipconfig \
        klibc-utils-nfsmount klibc-utils-resume \
        klibc-utils-run-init klibc-utils-cat \
        klibc-utils-chroot klibc-utils-cpio \
        klibc-utils-dd klibc-utils-dmesg \
        klibc-utils-false klibc-utils-halt \
        klibc-utils-kill klibc-utils-ln \
        klibc-utils-minips klibc-utils-mkdir \
        klibc-utils-mkfifo klibc-utils-mknod \
        klibc-utils-mount klibc-utils-nuke \
        klibc-utils-pivot-root klibc-utils-poweroff \
        klibc-utils-readlink klibc-utils-reboot \
        klibc-utils-sleep \
        klibc-utils-sync klibc-utils-true \
        klibc-utils-umount klibc-utils-uname \
        klibc-utils-gzip klibc-utils-modprobe \
        klibc-utils-losetup klibc-utils-wc"

FILES_${PN} = "${base_libdir}/klibc-*.so"
FILES_${PN}-dev = "${base_libdir}/klibc.so"
FILES_klibc-utils-sh = "${base_bindir}/sh"
FILES_klibc-utils-gzip = "${base_bindir}/gzip ${base_bindir}/gunzip ${base_bindir}/zcat"
FILES_klibc-utils-kinit = "${base_bindir}/kinit"
FILES_klibc-utils-fstype = "${base_bindir}/fstype"
FILES_klibc-utils-ipconfig = "${base_bindir}/ipconfig"
FILES_klibc-utils-nfsmount = "${base_bindir}/nfsmount"
FILES_klibc-utils-resume = "${base_bindir}/resume"
FILES_klibc-utils-run-init = "${base_bindir}/run-init"
FILES_klibc-utils-cat = "${base_bindir}/cat"
FILES_klibc-utils-chroot = "${base_bindir}/chroot"
FILES_klibc-utils-cpio = "${base_bindir}/cpio"
FILES_klibc-utils-dd = "${base_bindir}/dd"
FILES_klibc-utils-dmesg = "${base_bindir}/dmesg"
FILES_klibc-utils-false = "${base_bindir}/false"
FILES_klibc-utils-halt = "${base_bindir}/halt"
FILES_klibc-utils-kill = "${base_bindir}/kill"
FILES_klibc-utils-ln = "${base_bindir}/ln"
FILES_klibc-utils-minips = "${base_bindir}/minips"
FILES_klibc-utils-mkdir = "${base_bindir}/mkdir"
FILES_klibc-utils-mkfifo = "${base_bindir}/mkfifo"
FILES_klibc-utils-mknod = "${base_bindir}/mknod"
FILES_klibc-utils-mount = "${base_bindir}/mount"
FILES_klibc-utils-nuke = "${base_bindir}/nuke"
FILES_klibc-utils-pivot-root = "${base_bindir}/pivot_root"
FILES_klibc-utils-poweroff = "${base_bindir}/poweroff"
FILES_klibc-utils-readlink = "${base_bindir}/readlink"
FILES_klibc-utils-reboot = "${base_bindir}/reboot"
FILES_klibc-utils-sleep = "${base_bindir}/sleep"
FILES_klibc-utils-sync = "${base_bindir}/sync"
FILES_klibc-utils-true = "${base_bindir}/true"
FILES_klibc-utils-umount = "${base_bindir}/umount"
FILES_klibc-utils-uname = "${base_bindir}/uname"
FILES_klibc-utils-modprobe = "${base_bindir}/modprobe"
FILES_klibc-utils-losetup = "${base_bindir}/losetup"
FILES_klibc-utils-wc = "${base_bindir}/wc"

# Yes we want exactly the klibc that was compiled with the utils
RDEPENDS_klibc-utils-sh = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-kinit = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-fstype = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-ipconfig = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-nfsmount = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-resume = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-run-init = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-cat = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-chroot = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-cpio = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-dd = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-dmesg = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-false = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-halt = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-kill = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-ln = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-minips = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-mkdir = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-mkfifo = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-mknod = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-mount = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-nuke = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-pivot-root = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-poweroff = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-readlink = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-reboot = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-sleep = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-sync = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-true = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-umount = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-uname = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-modprobe = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-losetup = "${PN} (=${PV}-${PR})"
RDEPENDS_klibc-utils-wc = "${PN} (=${PV}-${PR})"
