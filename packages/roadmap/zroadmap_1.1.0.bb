require zroadmap.inc

DEPENDS = "expat"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/roadmap/roadmap-${PV}-src.tar.gz \
           file://cross.patch;patch=1;pnum=2 \
           file://qt/qt2-fixes.patch;patch=1 \
           file://qt/qt_canvas.patch;patch=1 \
           file://qt/qt_main.patch;patch=1 \
           file://qt/roadmap_main.patch;patch=1 \
           file://roadmap.desktop.patch;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tar.gz \
           file://zroadgps.png"

S = "${WORKDIR}/roadmap-${PV}/src"

EXTRA_OEMAKE = 'DESKTOP=QPE MOC=${OE_QMAKE_MOC} UIC=${OE_QMAKE_UIC} QTDIR=${QTDIR} POPT=NO \
                CFLAGS="-DQWS -I${S} ${OE_QMAKE_CFLAGS} -I${OE_QMAKE_INCDIR_QT}" \
                LDFLAGS="${OE_QMAKE_LDFLAGS} -L${OE_QMAKE_LIBDIR_QT} -Wl,-rpath-link,${OE_QMAKE_LIBDIR_QT}" '

do_compile() {
	oe_runmake libguiroadmap.a libguiroadgps.a libroadmap.a
	oe_runmake -C gpx libgpx.a
	oe_runmake -C unix libosroadmap.a
	oe_runmake -C qt qtroadmap qtroadgps
}

do_install() {
        install -d ${D}${palmtopdir}/bin
	install -d ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/pics
        install -d ${D}${palmtopdir}/share/roadmap

        install -m 0755 qt/qtroadmap ${D}${palmtopdir}/bin/roadmap
	install -m 0755 qt/qtroadgps ${D}${palmtopdir}/bin/roadgps

	install -m 0644 icons/*.png ${D}${palmtopdir}/pics/
	install -m 0644 ${WORKDIR}/zroadgps.png ${D}${palmtopdir}/pics/zroadgps.png

        install -m 0644 *.desktop ${D}${palmtopdir}/apps/Applications/
	
        install -m 0644 sprites preferences ${D}${palmtopdir}/share/roadmap/
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${palmtopdir}/share/roadmap/
}
