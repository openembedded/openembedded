require zroadmap.inc

PR = "r1"

SRC_URI = "http://www.roadmap.digitalomaha.net/roadmap/roadmap_1_0_12p2_src.tar.gz \
           file://qt2-fixes.patch;pnum=2;patch=1 \
           http://www.roadmap.digitalomaha.net/maps-1.0.12/usdir.rdm.tgz \
           file://zroadgps.png"

S = "${WORKDIR}/roadmap-${PV}/src"

EXTRA_OEMAKE = 'DESKTOP=QPE MOC=${OE_QMAKE_MOC} UIC=${OE_QMAKE_UIC} \
                GUICFLAGS="-I${OE_QMAKE_INCDIR_QT} -I${S} -DQWS" \
                GUILDFLAGS="-lz -lpng -ljpeg -lts -l${QT_LIBRARY} -lqpe -Wl,-rpath-link,${STAGING_LIBDIR} -L${STAGING_LIBDIR} -L${QTDIR}/lib"'

do_compile() {
	oe_runmake libguiroadmap.a libguiroadgps.a libroadmap.a unix/libosroadmap.a
	cd qt && oe_runmake
}

do_install() {
        install -d ${D}${palmtopdir}/bin
	install -d ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/pics
        install -d ${D}${palmtopdir}/share/roadmap

        install -m 0755 qt/qtroadmap ${D}${palmtopdir}/bin/roadmap
	install -m 0755 qt/qtroadgps ${D}${palmtopdir}/bin/roadgps

        install -m 0644 icons/*.png ${D}${palmtopdir}/pics/
	install -m 0644 roadmap.png ${D}${palmtopdir}/pics/zroadmap.png
	install -m 0644 ${WORKDIR}/zroadgps.png ${D}${palmtopdir}/pics/zroadgps.png

        install -m 0644 qt/ipkg/*.desktop ${D}${palmtopdir}/apps/Applications/
	
        install -m 0644 sprites schema preferences ${D}${palmtopdir}/share/roadmap/
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${palmtopdir}/share/roadmap/
}
