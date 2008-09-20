DESCRIPTION = "A dictionary application for Qt/E based Palmtop Environments"
HOMEPAGE = "http://bedic.sourceforge.net/"
AUTHOR = "Rafal Mantiuk <rafm@users.sourceforge.net>"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libbedic"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/misc"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/zbedic_${PV}-2.tgz \
           file://opie-icons.patch;patch=1 \
           file://qtopia17.patch;patch=1"

S = "${WORKDIR}"

inherit opie
export OE_QMAKE_LINK="${CXX}"
export OE_QMAKE_CXXFLAGS=" -DVERSION=\\"${PV}.2\\" -DPREFIX_PATH=\\"/usr\\""

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/libbedic LIBS+=-lbedic LIBS+=-lsqlite3 TARGET=zbedic"

do_configure_prepend() {
	rm -f Makefile
	qmake -project
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

PACKAGES = "${PN}-dbg ${PN}-doc ${PN} ${PN}-dev"

FILES_${PN}-doc += "${palmtopdir}/help"
