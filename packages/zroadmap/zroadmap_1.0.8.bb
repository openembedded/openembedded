DESCRIPTION = "RoadMap is a program that provides a car navigation for Linux and UNIX. \
It displays a map of the streets, tracks the position provided by a NMEA-compliant \
GPS receiver, identifies the street matching this GPS position and announces the name \
of the crossing street at the next intersection. A rudimentary trip feature allows \
RoadMap to display some basic navigation information (distance to the destination, \
direction, speed, etc..). Voice messages are generated that duplicate some of the screen information."
SECTION = "opie/applications"
PRIORITY = "optional"
AUTHOR = "Pascal Martin <pascal.martin@iname.com>"
HOMEPAGE = "http://roadmap.digitalomaha.net/maps.html"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://roadmap.digitalomaha.net/roadmap/roadmap_1_0_8_src.tar.gz \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tgz \
           file://zroadgps.png"

S = "${WORKDIR}/roadmap-${PV}/src/qt"

inherit palmtop

EXTRA_OEMAKE = 'DESKTOP=QPE MOC=${OE_QMAKE_MOC} UIC=${OE_QMAKE_UIC} \
                GUILDFLAGS="-lz -lpng -ljpeg -lts -lqte -lqpe -L${STAGING_LIBDIR} -L${QTDIR}/lib"'
PARALLEL_MAKE = ""

do_configure() {
	rm -rf moc*
}

do_install() {
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
