LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ipaq-sleep ntp gpe-mixer"
RDEPENDS = "xset xst ipaq-sleep ntpdate"
SECTION = "gpe"
PRIORITY = "optional"
FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps ${datadir}/gpe-conf"
PR = "r1"

do_compile () {
	oe_runmake PREFIX=${prefix}
	oe_runmake all-desktop PREFIX=${prefix}
}

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
	rm -f ${D}${datadir}/applications/gpe-conf.desktop
}

