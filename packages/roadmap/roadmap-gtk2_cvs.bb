require roadmap.inc

DEPENDS = "agg expat gtk+"
PV = "1.1.0+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://cross.patch;patch=1;pnum=2 \
	   http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz \
           file://zroadgps.png"

S = "${WORKDIR}/roadmap/src"

DESKTOP = "GTK2"
AGG = "rgba32"
CFLAGS += " -I${STAGING_INCDIR}/atk-1.0 -I${STAGING_INCDIR}/cairo  -I${STAGING_INCDIR}/pango-1.0 \
            -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_INCDIR}/gtk-2.0 -I${STAGING_LIBDIR}/gtk-2.0/include -I${S} "

do_compile() {
        oe_runmake libguiroadmap.a libguiroadgps.a libroadmap.a
        oe_runmake -C gpx libgpx.a
        oe_runmake -C unix libosroadmap.a
	oe_runmake -C gtk2 gtkroadmap gtkroadgps
}

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/roadmap

        install -m 0755 gtk2/gtkroadmap ${D}${bindir}/roadmap
        install -m 0755 gtk2/gtkroadgps ${D}${bindir}/roadgps

        install -m 0644 icons/*png ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/zroadgps.png ${D}${datadir}/pixmaps/roadgps.png
        
        install -m 0644 roadmap.desktop ${D}${datadir}/applications/
        
        install -m 0644 sprites preferences ${D}${datadir}/roadmap/
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${datadir}/roadmap/
}

FILES_${PN} += "${datadir}/roadmap"

