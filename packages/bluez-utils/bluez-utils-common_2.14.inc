DESCRIPTION = "Linux Bluetooth Stack Userland Utilities."
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "bluez-libs-2.14 pcmcia-cs"
RPROVIDES_${PN} = "bluez-pan bluez-sdp bluez-utils"
LICENSE = "GPL"
PACKAGES =+ "${PN}-ciptool ${PN}-bluepin"
PR = "r4"

FILES_${PN}-ciptool = "/bin/ciptool"
FILES_${PN}-bluepin = "/bin/bluepin"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-utils-${PV}.tar.gz \
	file://hcid.conf \
	file://bluetooth.default"

S = "${WORKDIR}/bluez-utils-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR} --enable-pcmcia --enable-initscripts"

do_install_append() {
	install -d ${D}${base_sbindir} ${D}${base_bindir}/
	mv ${D}${sbindir}/* ${D}${base_sbindir}/
	mv ${D}${bindir}/* ${D}${base_bindir}/
	rmdir ${D}${bindir} ${D}${sbindir}
	chmod u+s ${D}${base_sbindir}/hciattach ${D}${base_sbindir}/hciconfig
	chmod 755 ${D}${sysconfdir}/pcmcia/bluetooth
	install -m 0644 ${WORKDIR}/hcid.conf ${D}${sysconfdir}/bluetooth/
	install -m 0644 ${WORKDIR}/bluetooth.default ${D}${sysconfdir}/default/bluetooth
}

inherit autotools update-rc.d

INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "defaults 23 19"

CONFFILES_${PN} = "${sysconfdir}/bluetooth/hcid.conf ${sysconfdir}/bluetooth/rfcomm.conf \
	${sysconfdir}/bluetooth/pin ${sysconfdir}/default/bluetooth"
