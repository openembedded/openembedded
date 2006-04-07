DESCRIPTION = "A dictionary application for Qt/E based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
DEPENDS = "libbedic"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/misc"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/zbedic_${PV}-0.tgz \
           file://opie-icons.patch;patch=1 \
           file://version.patch;patch=1 \
           file://qtopia17.patch;patch=1"

S = "${WORKDIR}"

inherit opie
export OE_QMAKE_LINK="${CXX}"


do_configure() {
	cd ${S} && rm -rf *~ && qmake -project && qmake -makefile -spec ${QMAKESPEC} -after \
        INCLUDEPATH=${STAGING_INCDIR}/libbedic DEFINES+=QWS \
	LIBS+=-lqpe LIBS+=-lbedic LIBS+=-lsqlite3 DESTDIR=${S} TARGET=zbedic
}

do_install() {
	install -d ${D}${palmtopdir}/pics/zbedic/
	install -d ${D}${palmtopdir}/help/html/
	# we copy small icons - in other way QVGA users will complain
	install -m 0644 ${S}/misc/small_icons/*.png ${D}${palmtopdir}/pics/zbedic/
	install -m 0644 ${S}/misc/large_icons/zbedic.png ${D}${palmtopdir}/pics/
	install -m 0644 ${S}/doc/manual/*.html ${D}${palmtopdir}/help/html/
	rm ${D}${palmtopdir}/pics/zbedic/zbedic.png

	# those ones are taken from OPIE so they have proper size (depend on device)
	rm ${D}${palmtopdir}/pics/zbedic/back.png
	rm ${D}${palmtopdir}/pics/zbedic/forward.png
}

PACKAGES =+ "zbedic-help-en"
FILES_zbedic-help-en = "${palmtopdir}/help/html/*"
