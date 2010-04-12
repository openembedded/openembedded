DESCRIPTION = "U-boot bootloader OS env. access tools"
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "mtd-utils"
PR = "r9"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
        file://fw_env.c.patch;patch=1 \
        file://tools-Makefile.patch;patch=1 \
        file://env-Makefile.patch;patch=1 \
        file://fw_env.config"

S = "${WORKDIR}/u-boot-${PV}"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX}"
TARGET_LDFLAGS = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/u-boot-${PV}"

do_configure() {
        :
}

do_compile () {
        oe_runmake Sandpoint8240_config
        oe_runmake tools
}

do_install () {
        install -d      ${D}/sbin
        install -d      ${D}${sysconfdir}
        install -m 644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
        install -m 755 ${S}/tools/env/fw_printenv ${D}/sbin/fw_printenv
        install -m 755 ${S}/tools/env/fw_printenv ${D}/sbin/fw_setenv
}


SRC_URI[md5sum] = "17aeee76ca4c07887bbfea8a52d40884"
SRC_URI[sha256sum] = "62192ddf019c5d24f6538b33c9e69b6e5792bf5b0f464c0149061e2f0871108b"
