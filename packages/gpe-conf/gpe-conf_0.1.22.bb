PR = "r6"
LICENSE = "GPL"
inherit gpe

SRC_URI += "file://gpe-conf-0.1.22-20041124.patch;patch=1;pnum=0 \
	file://desktop-categories.patch;patch=1 \
	file://fix-wificonfig.patch;patch=1;pnum=0 \
	file://serial_tts.patch;patch=1 \
	file://battery_with_no_lifetime.patch;patch=1 \
	file://ignore_invalid_battery_values.patch;patch=1"

DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ipaq-sleep ntp gpe-login gpe-icons"
RDEPENDS_${PN} = "xst xset ipaq-sleep ntpdate gpe-login gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"
FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
		${datadir}/applications ${datadir}/gpe/pixmaps \
		${datadir}/gpe-conf"

do_compile () {
	oe_runmake PREFIX=${prefix}
	oe_runmake all-desktop PREFIX=${prefix}
}

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}

