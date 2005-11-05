DESCRIPTION = "Klimt is a software OpenGL rendering library for Qt/Embedded based Palmtop Environments"
SECTION = "opie/libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/klimt/klimt-src-${PV}.zip"
S = "${WORKDIR}/klimt/build/LinuxQTE"

EXTRA_QMAKEVARS_POST += " QMAKE_CXXFLAGS+=-fpermissive"

inherit opie

do_stage() {
	oe_libinstall -so libKlimt ${STAGING_LIBDIR}/
	cp -pPR ${S}/../../include/* ${STAGING_INCDIR}/
}

do_install() {
	oe_libinstall -so libKlimt ${D}${palmtopdir}/lib
}
