require klibc-common.inc
PR = "r3"

KLIBC_FETCHDIR = "Testing"

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

FILESPATHPKG =. "klibc-${PV}:"

# We only want the static utils. klibc build both. So we install only what we want.
do_install() {
        install -d ${D}${base_bindir}
        install -d ${D}${base_sbindir}
        install -m 755 usr/dash/sh ${D}${base_bindir}
        install -m 755 usr/gzip/gzip ${D}${base_bindir}
        install -m 755 usr/kinit/kinit ${D}${base_bindir}
        install -m 755 usr/kinit/fstype/static/fstype ${D}${base_bindir}
        install -m 755 usr/kinit/ipconfig/static/ipconfig ${D}${base_bindir}
        install -m 755 usr/kinit/nfsmount/static/nfsmount ${D}${base_bindir}
        install -m 755 usr/kinit/resume/static/resume ${D}${base_bindir}
        install -m 755 usr/kinit/run-init/static/run-init ${D}${base_bindir}
        install -m 755 usr/utils/static/cat ${D}${base_bindir}
        install -m 755 usr/utils/static/chroot ${D}${base_bindir}
        install -m 755 usr/utils/static/cpio ${D}${base_bindir}
        install -m 755 usr/utils/static/dd ${D}${base_bindir}
        install -m 755 usr/utils/static/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/static/false ${D}${base_bindir}
        install -m 755 usr/utils/static/halt ${D}${base_bindir}
        install -m 755 usr/utils/static/kill ${D}${base_bindir}
        install -m 755 usr/utils/static/ln ${D}${base_bindir}
        install -m 755 usr/utils/static/minips ${D}${base_bindir}
        install -m 755 usr/utils/static/mkdir ${D}${base_bindir}
        install -m 755 usr/utils/static/mkfifo ${D}${base_bindir}
        install -m 755 usr/utils/static/mknod ${D}${base_bindir}
        install -m 755 usr/utils/static/mount ${D}${base_bindir}
        install -m 755 usr/utils/static/nuke ${D}${base_bindir}
        install -m 755 usr/utils/static/pivot_root ${D}${base_bindir}
        install -m 755 usr/utils/static/poweroff ${D}${base_bindir}
        install -m 755 usr/utils/static/readlink ${D}${base_bindir}
        install -m 755 usr/utils/static/reboot ${D}${base_bindir}
        install -m 755 usr/utils/static/sleep ${D}${base_bindir}
        install -m 755 usr/utils/static/sync ${D}${base_bindir}
        install -m 755 usr/utils/static/true ${D}${base_bindir}
        install -m 755 usr/utils/static/umount ${D}${base_bindir}
        install -m 755 usr/utils/static/uname ${D}${base_bindir}
        install -m 755 usr/utils/static/modprobe ${D}${base_sbindir}
        install -m 755 usr/utils/static/losetup ${D}${base_bindir}
        install -m 755 usr/utils/static/wc ${D}${base_bindir}
        cd ${D}${base_bindir}
        ln -s gzip gunzip
        ln -s gzip zcat
        cd -
}

PACKAGES = "klibc-utils-static-sh klibc-utils-static-gzip \
        klibc-utils-static-kinit klibc-utils-static-fstype \
        klibc-utils-static-ipconfig klibc-utils-static-nfsmount \
        klibc-utils-static-resume klibc-utils-static-run-init \
        klibc-utils-static-cat klibc-utils-static-chroot \
        klibc-utils-static-cpio klibc-utils-static-dd \
        klibc-utils-static-dmesg klibc-utils-static-false \
        klibc-utils-static-halt klibc-utils-static-kill \
        klibc-utils-static-ln klibc-utils-static-minips \
        klibc-utils-static-mkdir klibc-utils-static-mkfifo \
        klibc-utils-static-mknod klibc-utils-static-mount \
        klibc-utils-static-nuke klibc-utils-static-pivot-root \
        klibc-utils-static-poweroff klibc-utils-static-readlink \
        klibc-utils-static-reboot klibc-utils-static-sleep \
        klibc-utils-static-sync \
        klibc-utils-static-true klibc-utils-static-umount \
        klibc-utils-static-uname klibc-utils-static-modprobe \
        klibc-utils-static-losetup klibc-utils-static-wc"

FILES_klibc-utils-static-sh = "${base_bindir}/sh"
FILES_klibc-utils-static-gzip = "${base_bindir}/gzip ${base_bindir}/gunzip ${base_bindir}/zcat"
FILES_klibc-utils-static-kinit = "${base_bindir}/kinit"
FILES_klibc-utils-static-fstype = "${base_bindir}/fstype"
FILES_klibc-utils-static-ipconfig = "${base_bindir}/ipconfig"
FILES_klibc-utils-static-nfsmount = "${base_bindir}/nfsmount"
FILES_klibc-utils-static-resume = "${base_bindir}/resume"
FILES_klibc-utils-static-run-init = "${base_bindir}/run-init"
FILES_klibc-utils-static-cat = "${base_bindir}/cat"
FILES_klibc-utils-static-chroot = "${base_bindir}/chroot"
FILES_klibc-utils-static-cpio = "${base_bindir}/cpio"
FILES_klibc-utils-static-dd = "${base_bindir}/dd"
FILES_klibc-utils-static-dmesg = "${base_bindir}/dmesg"
FILES_klibc-utils-static-false = "${base_bindir}/false"
FILES_klibc-utils-static-halt = "${base_bindir}/halt"
FILES_klibc-utils-static-kill = "${base_bindir}/kill"
FILES_klibc-utils-static-ln = "${base_bindir}/ln"
FILES_klibc-utils-static-minips = "${base_bindir}/minips"
FILES_klibc-utils-static-mkdir = "${base_bindir}/mkdir"
FILES_klibc-utils-static-mkfifo = "${base_bindir}/mkfifo"
FILES_klibc-utils-static-mknod = "${base_bindir}/mknod"
FILES_klibc-utils-static-mount = "${base_bindir}/mount"
FILES_klibc-utils-static-nuke = "${base_bindir}/nuke"
FILES_klibc-utils-static-pivot-root = "${base_bindir}/pivot_root"
FILES_klibc-utils-static-poweroff = "${base_bindir}/poweroff"
FILES_klibc-utils-static-readlink = "${base_bindir}/readlink"
FILES_klibc-utils-static-reboot = "${base_bindir}/reboot"
FILES_klibc-utils-static-sleep = "${base_bindir}/sleep"
FILES_klibc-utils-static-sync = "${base_bindir}/sync"
FILES_klibc-utils-static-true = "${base_bindir}/true"
FILES_klibc-utils-static-umount = "${base_bindir}/umount"
FILES_klibc-utils-static-uname = "${base_bindir}/uname"
FILES_klibc-utils-static-modprobe = "${base_sbindir}/modprobe"
FILES_klibc-utils-static-losetup = "${base_bindir}/losetup"
FILES_klibc-utils-static-wc = "${base_bindir}/wc"
