DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/kernel fakeroot-native"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz \
           file://lirc_sir-sa1100.patch;patch=1"
S = "${WORKDIR}/lirc-${PV}"

inherit autotools module-base

EXTRA_OECONF = "--with-kerneldir=${STAGING_KERNEL_DIR}"
EXTRA_OECONF_append_epia = " --with-driver=serial"
EXTRA_OECONF_append_collie = " --with-driver=sa1100 --without-x"
EXTRA_OECONF_append_h3600 = " --with-driver=sa1100 --without-x"
EXTRA_OECONF_append_beagle = " --with-driver=sa1100 --without-x"
EXTRA_OECONF_append_simpad = " --with-driver=sa1100 --without-x"

export TOPDIR = "${STAGING_KERNEL_DIR}"

do_compile() {
	cd drivers && oe_runmake CC="${KERNEL_CC}" LD="${KERNEL_LD}"
}

fakeroot do_install() {
	oe_runmake -C drivers DESTDIR="${D}" moduledir="/lib/modules/${KERNEL_VERSION}/lirc" install
	rm -rf ${D}/dev
}

pkg_postinst() {
#!/bin/sh
 mknod /dev/lirc c 61 0
 if [ -n $D ]; then exit 1; fi
}

FILES_${PN} = "/lib/modules"
