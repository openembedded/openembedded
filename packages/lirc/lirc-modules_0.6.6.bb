DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "linux-${KERNEL_VERSION}"
DEPENDS = "virtual/kernel"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz"
S = "${WORKDIR}/lirc-${PV}"

inherit autotools module-base

EXTRA_OECONF_collie = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"
EXTRA_OECONF_h3600 = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"
EXTRA_OECONF_beagle = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"
EXTRA_OECONF_simpad = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"

export TOPDIR = "${STAGING_KERNEL_DIR}"

do_compile() {
	cd drivers && oe_runmake CC="${KERNEL_CC}" LD="${KERNEL_LD}"
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/char
	install -m 0644 drivers/lirc_sir/lirc_sir.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/char/lirc_sir.o
}

pkg_postinst() {
#!/bin/sh
 mknod /dev/lirc c 61 0
 if [ -n $D ]; then exit 1; fi
}

FILES_${PN}="/lib/modules"
