DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "kernel lirc-modules-${PV}"
DEPENDS = "virtual/kernel"
PR = "r7"

S = "${WORKDIR}/lirc"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/lirc;module=lirc;date=20040918;method=pserver \
	file://split-hauppauge.patch;patch=1 \
	file://lircd.init file://lircmd.init"

inherit autotools module-base update-rc.d

INITSCRIPT_NAME = "lirc"
INITSCRIPT_PARAMS = "defaults 20"

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

	oe_libinstall -so -C tools liblirc_client ${D}${libdir}/
	install -d ${D}${includedir}
	install -m 0644 tools/lirc_client.h ${D}${includedir}/

	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/lircd.init ${D}${sysconfdir}/init.d/lircd

	install -d ${D}${datadir}/lirc/
	cp -pPR remotes ${D}${datadir}/lirc/
	find ${D}${datadir}/lirc -name CVS -o -name '*~*' | xargs rm -rf
}

