DESCRIPTION = "A dictionary application for Qt/E based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "libbedic"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/misc"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/zbedic_0.9.4-0.tgz \
file://qtopia17.patch;patch=1;pnum=0"

S = "${WORKDIR}/"

inherit opie
export OE_QMAKE_LINK="${CXX}"

do_configure() {
	cd ${S} && rm -rf *~ && qmake -project && qmake -makefile -spec ${QMAKESPEC} -after \
        INCLUDEPATH=${STAGING_INCDIR}/libbedic DEFINES+=QWS LIBS+=-lqpe LIBS+=-lbedic DESTDIR=${S} TARGET=zbedic
}

do_install() {
	install -d ${D}${palmtopdir}/pics/zbedic/
	install -d ${D}${palmtopdir}/help/html/
	install -m 0644 ${S}/misc/*.png ${D}${palmtopdir}/pics/zbedic/
	install -m 0644 ${S}/misc/zbedic.png ${D}${palmtopdir}/pics/
	install -m 0644 ${S}/doc/manual/*.html ${D}${palmtopdir}/help/html/
	rm ${D}${palmtopdir}/pics/zbedic/zbedic.png
}

PACKAGES =+ "zbedic-help-en"
FILES_zbedic-help-en = "${palmtopdir}/help/html/*"
