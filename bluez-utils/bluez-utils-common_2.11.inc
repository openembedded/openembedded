DESCRIPTION = "Linux Bluetooth Stack Userland Utilities."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "bluez-libs pcmcia-cs"
RPROVIDES = "bluez-pan bluez-sdp bluez-utils"
LICENSE = "GPL"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-utils-${PV}.tar.gz \
	file://hcid.conf"
S = "${WORKDIR}/bluez-utils-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR} --enable-pcmcia --enable-initscripts"

do_install_append() {
	install -d ${D}/sbin ${D}/bin/
	mv ${D}${sbindir}/* ${D}/sbin/
	mv ${D}${bindir}/* ${D}/bin/
	rmdir ${D}${bindir} ${D}${sbindir}
	chmod u+s ${D}/sbin/hciattach ${D}/sbin/hciconfig
	chmod 755 ${D}/etc/pcmcia/bluetooth
	install -m 0644 ${WORKDIR}/hcid.conf ${D}/etc/bluetooth/
}

inherit autotools update-rc.d

INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "defaults"

