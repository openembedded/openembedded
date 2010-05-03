require klibc-common.inc

SRC_URI += "file://fstype-sane-vfat-and-jffs2-for-1.5.patch;patch=1 \
            file://modprobe.patch;patch=1 \
            file://dash_readopt.patch;patch=1 \
            file://wc.patch;patch=1 \
            file://staging.patch;patch=1 \
            file://klibc_kexecsyscall.patch;patch=1 \
            file://mntproc-definitions.patch;patch=1 \
            file://isystem.patch;patch=1 \
	    "

DEFAULT_PREFERENCE = "-1"

KLIBC_FETCHDIR = "1.5"

KLIBC_ARCH_x86 = 'x86'
KLIBC_ARCH_i486 = 'x86'
KLIBC_ARCH_i586 = 'x86'
KLIBC_ARCH_i686 = 'x86'
KLIBC_ARCH_pentium = 'x86'

EXTRA_OEMAKE = "'KLIBCARCH=${KLIBC_ARCH}' \
                'CROSS_COMPILE=${TARGET_PREFIX}' \
		'KLIBCKERNELSRC=${STAGING_KERNEL_DIR}' \
                "

do_configure () {
	ln -sf ${STAGING_KERNEL_DIR} linux
	cd ${S}/usr/klibc/arch/
	ln -s i386 x86
	cd ${S}/usr/include/arch/
	ln -s i386 x86
	cd ${S}
}

SRC_URI[md5sum] = "5c8b6577b9acb3809cace6e118cdd55b"
SRC_URI[sha256sum] = "e4104f8b34a5f354222bd4622f50b58c6218bf70614450d68539cbef666b6446"

do_install_append() {
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/dmesg ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/sync ${D}${base_bindir}
        install -m 755 usr/utils/${KLIBC_UTILS_VARIANT}/ls ${D}${base_bindir}
}
