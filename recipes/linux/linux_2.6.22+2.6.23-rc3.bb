require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "1"

BASE_KERNEL_VERSION = "2.6.22"
KERNEL_VERSION = "2.6.23-rc3"
KERNEL_RELEASE = "2.6.23-rc3"

PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${BASE_KERNEL_VERSION}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.23/patch-${KERNEL_VERSION}.bz2;patch=1;name=patch \
           file://defconfig \
           "

SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.23-rc3-at91.patch.gz;patch=1;name=at91patch \
                        "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.23-rc3-at91.patch.gz;patch=1;name=at91patch \
                               "

S = "${WORKDIR}/linux-${BASE_KERNEL_VERSION}"



SRC_URI[kernel.md5sum] = "2e230d005c002fb3d38a3ca07c0200d0"
SRC_URI[kernel.sha256sum] = "73c10604c53f1a6ee65ef805293d23903696f8cef864f42d7de9506f0d2ba4c7"
SRC_URI[patch.md5sum] = "736ea68a03158c24e55aa95e0ab15ceb"
SRC_URI[patch.sha256sum] = "4d2c13dee5ea7bd8b5cdbf63afa9383b45f6bad1f75b163c49e086a5030a04de"
SRC_URI[at91patch.md5sum] = "822f2f85b658fb1f39b8a20fab781cfc"
SRC_URI[at91patch.sha256sum] = "e8ead43fa562cc76ac34d0d4841fd1e4f4964a830403801433e34961d1ce0e84"
