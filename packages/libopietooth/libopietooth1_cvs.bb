DESCRIPTION = "Opie Bluetooth library"
SECTION = "opie/libs"
PRIORITY = "optional"
DEPENDS = "libopie2"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "LGPL"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opietooth/lib"
PV = "1.2.0+cvs-${CVSDATE}"

inherit opie

S = "${WORKDIR}/lib"

do_stage() {
        install -m 0644 *.h ${STAGING_INCDIR}/
	oe_libinstall -so libopietooth1 ${STAGING_LIBDIR}/
}
 
do_install() {
	oe_libinstall -so libopietooth1 ${D}${palmtopdir}/lib
}

