DESCRIPTION = "RoadMap is a program that provides a car navigation for Linux and UNIX. \
It displays a map of the streets, tracks the position provided by a NMEA-compliant \
GPS receiver, identifies the street matching this GPS position and announces the name \
of the crossing street at the next intersection."
SECTION = "opie/applications"
PRIORITY = "optional"
AUTHOR = "Pascal Martin <pascal.martin@iname.com>"
HOMEPAGE = "http://roadmap.digitalomaha.net/maps.html"
DEPENDS = "popt expat"
LICENSE = "GPL"
PV = "1.0.12+cvs-${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://qt2-fixes-r1.patch;pnum=1;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz \
           file://zroadgps.png"
S = "${WORKDIR}/roadmap/src"

inherit palmtop

QT_LIBRARY = '${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "qte-mt", "qte",d)}'
QT_LIBRARY_append_c7x0 = " -laticore"

EXTRA_OEMAKE = 'DESKTOP=QPE MOC=${OE_QMAKE_MOC} UIC=${OE_QMAKE_UIC} QTDIR=${QTDIR} \
                CFLAGS="-DQWS -DQT_NO_ROTATE -I${S} ${OE_QMAKE_CXXFLAGS} -I${OE_QMAKE_INCDIR_QT}" \
                LDFLAGS="${OE_QMAKE_LDFLAGS} -L${OE_QMAKE_LIBDIR_QT} -Wl,-rpath-link,${OE_QMAKE_LIBDIR_QT}" '
PARALLEL_MAKE = ""

do_configure() {
	echo removing pregenerated stuff
	find . -name "moc*"|xargs rm -f
}

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
        install -m 0755 qt/qtroadmap ${D}${palmtopdir}/bin/roadmap
	install -m 0755 qt/qtroadgps ${D}${palmtopdir}/bin/roadgps
	install -m 0644 roadmap.png ${D}${palmtopdir}/pics/zroadmap.png
	install -m 0644 ${WORKDIR}/zroadgps.png ${D}${palmtopdir}/pics/zroadgps.png
        install -m 0644 qt/ipkg/*.desktop ${D}${palmtopdir}/apps/
	install -d ${D}${palmtopdir}/share/roadmap/
        install -m 0644 sprites schema preferences ${D}${palmtopdir}/share/roadmap/
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${palmtopdir}/share/roadmap/
}
