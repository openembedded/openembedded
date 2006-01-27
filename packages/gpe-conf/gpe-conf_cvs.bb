DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${PN}"
PV = "0.1.29+cvs${SRCDATE}"
PR = "r1"

inherit gpe

SRC_URI =	"${HANDHELDS_CVS};module=gpe/base/${PN} \
		 file://Makefile.dpkg_ipkg \
    		 file://Makefile.translation"

PACKAGES = "gpe-conf gpe-conf-panel"
LICENSE = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"


DEPENDS = "gtk+ libgpewidget libxsettings libxsettings-client pcmcia-cs xst xset ipaq-sleep ntp gpe-login gpe-icons"
RDEPENDS_${PN} = "xst xset ipaq-sleep ntpdate gpe-login gpe-icons"
RDEPENDS_gpe-conf-panel = "gpe-conf"
FILES_${PN} = "${sysconfdir} ${bindir} ${datadir}/pixmaps \
		${datadir}/applications/gpe-conf-* ${datadir}/gpe/pixmaps \
		${datadir}/gpe-conf"
FILES_gpe-conf-panel = "${datadir}/applications/gpe-conf.desktop"


do_compile () {
	sed -i 's:CVSBUILD = yes:CVSBUILD = no:' Makefile
	mkdir build
	cp ${WORKDIR}/Makefile.* build/
	oe_runmake PREFIX=${prefix}
	oe_runmake all-desktop PREFIX=${prefix}
}

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}


