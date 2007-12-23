require roadmap.inc

DEPENDS = "expat gtk+"
PV = "1.0.12+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://cross.patch;patch=1;pnum=2 \
	   http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz \
           "

S = "${WORKDIR}/roadmap/src"

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

