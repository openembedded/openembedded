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

KLIBC_FETCHDIR = "1.5"

SRC_URI[md5sum] = "db2152a8a03bd81e21a5f451f537ae3d"
SRC_URI[sha256sum] = "8b5334ef88b075f374b031695181b4302c3e5621bf2737a39fdf28262b0f80f4"

do_install_append() {
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sync ${D}${base_bindir}
}
