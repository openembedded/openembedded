require klibc-common.inc

SRC_URI += "file://fstype-sane-vfat-and-jffs2-for-1.5.patch \
            file://modprobe.patch \
            file://losetup.patch \
            file://dash_readopt.patch \
            file://wc.patch \
            file://staging.patch \
            file://klibc_kexecsyscall.patch \
            file://mntproc-definitions.patch \
            file://signal-cleanup.patch \
            file://isystem.patch \
            "

KLIBC_FETCHDIR = "1.5"

SRC_URI[md5sum] = "db2152a8a03bd81e21a5f451f537ae3d"
SRC_URI[sha256sum] = "8b5334ef88b075f374b031695181b4302c3e5621bf2737a39fdf28262b0f80f4"

do_install_append() {
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sync ${D}${base_bindir}
}
