require roadmap.inc

DEPENDS = "gtk+"
PR = "r0"

SRC_URI = "http://www.roadmap.digitalomaha.net/roadmap/roadmap_1_0_12p2_src.tar.gz \
           file://roadmap.desktop.patch;patch=1 \
           file://roadgps.desktop.patch;patch=1 \
	   http://www.roadmap.digitalomaha.net/maps-1.0.12/usdir.rdm.tgz \
           file://zroadgps.png "

S = "${WORKDIR}/roadmap-${PV}/src"

DESKTOP = "GTK2"
CFLAGS += " -I${STAGING_INCDIR}/atk-1.0 -I${STAGING_INCDIR}/cairo  -I${STAGING_INCDIR}/pango-1.0 \
            -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_INCDIR}/gtk-2.0 -I${STAGING_LIBDIR}/gtk-2.0/include -I${S} "

do_compile() {
        oe_runmake libguiroadmap.a libguiroadgps.a libroadmap.a unix/libosroadmap.a
	cd gtk2 && oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -d ${D}${datadir}/roadmap

        install -m 0755 gtk2/gtkroadmap ${D}${bindir}/roadmap
        install -m 0755 gtk2/gtkroadgps ${D}${bindir}/roadgps

        install -m 0644 icons/*png ${D}${datadir}/pixmaps/
        install -m 0644 roadmap.png ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/zroadgps.png ${D}${datadir}/pixmaps/roadgps.png
        
        install -m 0644 roadmap.desktop ${D}${datadir}/applications/
        install -m 0644 qt/ipkg/zroadgps.desktop ${D}${datadir}/applications/roadgps.desktop
        
        install -m 0644 sprites schema preferences ${D}${datadir}/roadmap/
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${datadir}/roadmap/
}

FILES_${PN} += "${datadir}/roadmap"

