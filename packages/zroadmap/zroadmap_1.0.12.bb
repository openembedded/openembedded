DESCRIPTION = "RoadMap is a program that provides a car navigation for Linux and UNIX. \
It displays a map of the streets, tracks the position provided by a NMEA-compliant \
GPS receiver, identifies the street matching this GPS position and announces the name \
of the crossing street at the next intersection. A rudimentary trip feature allows \
RoadMap to display some basic navigation information (distance to the destination, \
direction, speed, etc..). Voice messages are generated that duplicate some of the screen information."
SECTION = "opie/applications"
PRIORITY = "optional"
AUTHOR = "Pascal Martin <pascal.martin@iname.com>"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
HOMEPAGE = "http://roadmap.digitalomaha.net/maps.html"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.roadmap.digitalomaha.net/roadmap/roadmap_1_0_12p2_src.tar.gz \
           file://qt2-fixes.patch;pnum=2;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz \
           file://zroadgps.png"
S = "${WORKDIR}/roadmap-${PV}/src"

inherit palmtop

QT_LIBRARY = '${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "qte-mt", "qte",d)}'
QT_LIBRARY_append_c7x0 = " -laticore"

EXTRA_OEMAKE = 'DESKTOP=QPE MOC=${OE_QMAKE_MOC} UIC=${OE_QMAKE_UIC} \
                GUICFLAGS="-I${OE_QMAKE_INCDIR_QT} -I${S} -DQWS" \
                GUILDFLAGS="-lz -lpng -ljpeg -lts -l${QT_LIBRARY} -lqpe -Wl,-rpath-link,${STAGING_LIBDIR} -L${STAGING_LIBDIR} -L${QTDIR}/lib"'
PARALLEL_MAKE = ""

do_configure() {
	echo removing pregenerated stuff
	find . -name "moc*"|xargs rm -f
}

do_compile() {
	oe_runmake libguiroadmap.a libguiroadgps.a libroadmap.a unix/libosroadmap.a
	cd qt && oe_runmake
}

do_install() {
	cd qt
        install -d ${D}${palmtopdir}/bin
	install -d ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/pics
        install -m 0755 qtroadmap ${D}${palmtopdir}/bin/roadmap
	install -m 0755 qtroadgps ${D}${palmtopdir}/bin/roadgps
	install -m 0644 ../roadmap.png ${D}${palmtopdir}/pics/zroadmap.png
	install -m 0644 ${WORKDIR}/zroadgps.png ${D}${palmtopdir}/pics/zroadgps.png
        install -m 0644 ipkg/*.desktop ${D}${palmtopdir}/apps/
	install -d ${D}${palmtopdir}/share/roadmap/
        install -m 0644 ../sprites ../schema ../preferences ${D}${palmtopdir}/share/roadmap/
	install -m 0644 ${WORKDIR}/usdir.rdm ${D}${palmtopdir}/share/roadmap/
}
