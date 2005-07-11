DESCRIPTION = "Linux Bluetooth Stack Userland Utilities."
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "bluez-libs-${PV} pcmcia-cs"
RPROVIDES_${PN} = "bluez-pan bluez-sdp bluez-utils"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-utils-${PV}.tar.gz \
	file://base.patch;patch=1 \
	file://blueboxes.patch;patch=1 \
	file://hcid.conf \
	file://bluetooth.default \
	file://bluetooth.conf "

# Almost all serial CF cards w/ manfid 0x0000,0x0000 seem to use the bcs protocol
# Let's default to that instead of 'any' and see if we break something with that
SRC_URI_append_familiar   = " file://default-manfid-0x0-to-bcps.patch"
SRC_URI_append_openzaurus = " file://default-manfid-0x0-to-bcps.patch"

S = "${WORKDIR}/bluez-utils-${PV}"

EXTRA_OECONF = "--with-bluez-libs=${STAGING_LIBDIR} --with-bluez-includes=${STAGING_INCDIR} \
                --enable-pcmcia --enable-initscripts"

inherit autotools update-rc.d

INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "defaults 23 19"

do_install_append() {
	install -d ${D}${base_sbindir} ${D}${base_bindir}/
	mv ${D}${sbindir}/* ${D}${base_sbindir}/
	mv ${D}${bindir}/* ${D}${base_bindir}/
	rmdir ${D}${bindir} ${D}${sbindir}
	chmod u+s ${D}${base_sbindir}/hciattach ${D}${base_sbindir}/hciconfig
	chmod 755 ${D}${sysconfdir}/pcmcia/bluetooth
	install -m 0644 ${WORKDIR}/hcid.conf ${D}${sysconfdir}/bluetooth/
	install -m 0644 ${WORKDIR}/bluetooth.default ${D}${sysconfdir}/default/bluetooth
	cat ${WORKDIR}/bluetooth.conf >> ${D}${sysconfdir}/pcmcia/bluetooth.conf
}

CONFFILES_${PN} = "${sysconfdir}/bluetooth/hcid.conf ${sysconfdir}/bluetooth/rfcomm.conf \
	${sysconfdir}/bluetooth/pin ${sysconfdir}/default/bluetooth"

PACKAGES =+ "${PN}-ciptool ${PN}-bluepin"
FILES_${PN}-ciptool = "/bin/ciptool"
FILES_${PN}-bluepin = "/bin/bluepin"
