DESCRIPTION = "Linux Bluetooth Stack Userland Utilities."
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "gstreamer gst-plugins-base bluez-libs-${PV} libusb dbus cups"
PROVIDES = "bluez-utils-dbus"
RPROVIDES_${PN} = "bluez-pan bluez-sdp bluez-utils-dbus"
RREPLACES = "bluez-utils-dbus"
RCONFLICTS_${PN} = "bluez-utils-nodbus"
LICENSE = "GPL"

SRC_URI = "http://bluez.sourceforge.net/download/bluez-utils-${PV}.tar.gz \
	file://hcid.conf \
	file://hciattach-ti-bts.patch;patch=1 \
        file://handle-eintr.patch;patch=1;status=applied"
SRC_URI_append_r1000      = " file://hciattach.sh"
SRC_URI_append_ghi270      = " file://hciattach.sh"

# Almost all serial CF cards w/ manfid 0x0000,0x0000 seem to use the bcs protocol
# Let's default to that instead of 'any' until further notice...
SRC_URI += " file://default-manfid-0x0-to-bcps.patch;patch=1"

S = "${WORKDIR}/bluez-utils-${PV}"

EXTRA_OECONF = "--enable-initscripts --enable-bccmd   --enable-bcm203x --enable-hid2hci --enable-cups"
#  --enable-obex           enable OBEX support
#  --enable-alsa           enable ALSA support
#  --enable-cups           install CUPS backend support
#  --enable-bccmd          install BCCMD interface utility
#  --enable-avctrl         install Audio/Video control utility
#  --enable-hid2hci        install HID mode switching utility
#  --enable-dfutool        install DFU firmware upgrade utility

inherit autotools update-rc.d

INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "defaults 23 19"

do_install_append() {
	install -d ${D}${base_sbindir} ${D}${base_bindir}/  ${D}${sysconfdir}/apm/event.d/
	mv ${D}${sbindir}/* ${D}${base_sbindir}/
	mv ${D}${bindir}/* ${D}${base_bindir}/
	rmdir ${D}${bindir} ${D}${sbindir}
	chmod u+s ${D}${base_sbindir}/hciattach ${D}${base_sbindir}/hciconfig
	install -m 0644 ${WORKDIR}/hcid.conf ${D}${sysconfdir}/bluetooth/
        install -m 0755 ${S}/daemon/.libs/passkey-agent ${D}${base_bindir}/
}

do_install_append_r1000() {
        install -d ${D}${sysconfdir} ${D}${sysconfdir}/bluetooth
        install -m 0755 ${WORKDIR}/hciattach.sh ${D}${sysconfdir}/bluetooth/hciattach
}

do_install_append_ghi270() {
        install -d ${D}${sysconfdir} ${D}${sysconfdir}/bluetooth
        install -m 0755 ${WORKDIR}/hciattach.sh ${D}${sysconfdir}/bluetooth/hciattach
}

CONFFILES_${PN} = "${sysconfdir}/bluetooth/hcid.conf ${sysconfdir}/bluetooth/rfcomm.conf \
	${sysconfdir}/default/bluetooth"

PACKAGES =+ " bluez-cups-backend"

FILES_${PN} += " ${libdir}/alsa-lib/*.so "
FILES_${PN}-dev += " ${libdir}/alsa-lib/*.la "

FILES_bluez-cups-backend = "${libdir}/cups/backend/bluetooth"
RDEPENDS_bluez-cups-backend = "cups"
