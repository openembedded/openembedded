DESCRIPTION = "RoadMap is a program that provides a car navigation for Linux and UNIX. \
It displays a map of the streets, tracks the position provided by a NMEA-compliant \
GPS receiver, identifies the street matching this GPS position and announces the name \
of the crossing street at the next intersection."
AUTHOR = "Pascal Martin <pascal.martin@iname.com>"
HOMEPAGE = "http://roadmap.digitalomaha.net/maps.html"
DEPENDS = "popt expat gtk+"
LICENSE = "GPL"
PV = "1.0.12+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://cross.patch;patch=1;pnum=2 \
	   http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz \
           "

S = "${WORKDIR}/roadmap/src"

PARALLEL_MAKE = ""
CFLAGS += " -I${S} "


do_compile() {
        oe_runmake
	oe_runmake gtk2
}

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/roadmap

        install -m 0755 gtk2/gtkroad* ${D}${bindir}

        install -m 0644 icons/*png ${D}${datadir}/pixmaps
        
        install -m 0644 sprites preferences ${D}${datadir}/roadmap
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${datadir}/roadmap/
}


FILES_${PN} += "${datadir}/roadmap"

