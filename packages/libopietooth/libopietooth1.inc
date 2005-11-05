DESCRIPTION = "Opie Bluetooth library"
SECTION = "opie/libs"
PRIORITY = "optional"
DEPENDS = "libopie2"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "LGPL"


S = "${WORKDIR}/lib"

inherit opie

do_stage() {
    install -d ${STAGING_INCDIR}/opietooth/
    install -m 0644 *.h ${STAGING_INCDIR}/opietooth/
    oe_libinstall -so libopietooth1 ${STAGING_LIBDIR}/
}

do_install() {
    oe_libinstall -so libopietooth1 ${D}${palmtopdir}/lib
}

