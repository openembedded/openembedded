require klibc-common.inc

# temporary override here in the recipe
# until 1.5.16 is released

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/klibc/${KLIBC_FETCHDIR}/klibc-1.5.15.tar.bz2 \
            file://1.5.15+1.5.16.patch \
            "

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
            file://socket.h.patch \
            "

S = "${WORKDIR}/klibc-1.5.15"

# end temporary overrides

DEFAULT_PREFERENCE = "-1"

KLIBC_FETCHDIR = "1.5"

SRC_URI[md5sum] = "db2152a8a03bd81e21a5f451f537ae3d"
SRC_URI[sha256sum] = "8b5334ef88b075f374b031695181b4302c3e5621bf2737a39fdf28262b0f80f4"

do_install_append() {
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sync ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/ls ${D}${base_bindir}
}
