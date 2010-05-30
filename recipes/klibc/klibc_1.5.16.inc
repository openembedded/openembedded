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
            file://socket.h.patch \
            file://arm-signal-cleanup.patch \
            file://isystem.patch \
            "

DEFAULT_PREFERENCE = "1"

KLIBC_FETCHDIR = "1.5"

SRC_URI[md5sum] = "7d27f601cc4adeba6bf6fbb4eb9b5dee"
SRC_URI[sha256sum] = "8e0d38c690f7d48f0df79a9edc4d6dee51689f294add5052a1d786bf5d685d2d"

do_install_append() {
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sync ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/ls ${D}${base_bindir}
}
