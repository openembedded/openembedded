PR = "r0"
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ipaq-sleep ntp gpe-login gpe-mixer"
RDEPENDS = "xst xset ipaq-sleep ntpdate gpe-login gpe-mixer"
SECTION = "gpe"
PRIORITY = "optional"
FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps ${datadir}/gpe-conf"

SRC_URI = "${GPE_MIRROR}/gpe-conf-${PV}.tar.gz \
            file://password-if.patch;patch=1;pnum=0 \
            file://meminfo26.patch;patch=1;pnum=0 \
            file://misc1.patch;patch=1;pnum=0 \
            file://hwclock.patch;patch=1;pnum=0 \
            file://ntpdate.patch;patch=1;pnum=0"

do_compile () {
	oe_runmake PREFIX=${prefix}
	oe_runmake all-desktop PREFIX=${prefix}
}

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
	rm -f ${D}${datadir}/applications/gpe-conf.desktop
}
