PR = "r2"
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ipaq-sleep ntp gpe-login gpe-icons"
RDEPENDS = "xst xset ipaq-sleep ntpdate gpe-login gpe-icons"
SECTION = "gpe"
PRIORITY = "optional"
FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps ${datadir}/gpe-conf"

SRC_URI = "${GPE_MIRROR}/gpe-conf-${PV}.tar.gz \
            file://icons.patch;patch=1;pnum=0"

do_compile () {
	oe_runmake PREFIX=${prefix}
	oe_runmake all-desktop PREFIX=${prefix}
}

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}

