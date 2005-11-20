DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
PR = "r6"

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz"
S = "${WORKDIR}/lirc-${PV}"

inherit autotools module-base

EXTRA_OECONF_epia = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=serial"
EXTRA_OECONF_collie = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"
EXTRA_OECONF_h3600 = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"
EXTRA_OECONF_simpad = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=sa1100 --without-x"

EXTRA_OEMAKE = 'SUBDIRS="daemons tools"'

do_stage() {
        oe_libinstall -so -C tools liblirc_client ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/lirc/
	install -m 0644 tools/lirc_client.h ${STAGING_INCDIR}/lirc/
}

do_install() {
	install -d ${D}${bindir}

	install -m 755 daemons/irrecord ${D}${bindir}/irrecord
	install -m 755 daemons/lircd ${D}${bindir}/lircd
	install -m 755 tools/rc ${D}${bindir}/rc

	oe_libinstall -so -C tools liblirc_client ${D}${libdir}/
	install -d ${D}${includedir}
	install -m 0644 tools/lirc_client.h ${D}${includedir}/
}

