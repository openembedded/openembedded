DESCRIPTION = "A dictionary application for Qt/E based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/zbedic/misc"
CVSDATE = "${PV}"
PR = "r1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/bedic;module=zbedic \
           cvs://anonymous@cvs.sourceforge.net/cvsroot/bedic;module=libbedic \
           file://file.h file://file.cpp \
           file://qtopia17.patch;patch=1;pnum=0"
S = "${WORKDIR}/libbedic"
ZS = "${WORKDIR}/zbedic"

inherit opie
export OE_QMAKE_LINK="${CXX}"

do_configure() {
	qmake -project && qmake -makefile -t lib -spec ${QMAKESPEC} CONFIG=console CONFIG+=staticlib -after \
        INCLUDEPATH+=../include TARGET=bedic DESTDIR=${STAGING_LIBDIR} HEADERS+=src/file.h SOURCES+=src/file.cpp
	cd ${ZS} && rm -rf *~ && qmake -project && qmake -makefile -spec ${QMAKESPEC} -after \
        INCLUDEPATH=${S}/include DEFINES+=QWS LIBS+=-lqpe LIBS+=-lbedic DESTDIR=${S} TARGET=zbedic
}

do_compile() {
	install -m 0644 ${WORKDIR}/file.* ${S}/src/
	oe_runmake
	cd ${ZS} && oe_runmake
}

do_install() {
	install -d ${D}${palmtopdir}/pics/zbedic/
	install -d ${D}${palmtopdir}/help/html/
	install -m 0644 ${ZS}/misc/*.png ${D}${palmtopdir}/pics/zbedic/
	install -m 0644 ${ZS}/misc/zbedic.png ${D}${palmtopdir}/pics/
	install -m 0644 ${ZS}/doc/manual/*.html ${D}${palmtopdir}/help/html/
	rm ${D}${palmtopdir}/pics/zbedic/zbedic.png
}

PACKAGES =+ "zbedic-help-en"
FILES_zbedic-help-en = "${palmtopdir}/help/html/*"
