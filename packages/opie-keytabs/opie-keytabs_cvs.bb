DESCRIPTION = "Opie keytabs for terminal applications"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe"
MAINTAINER = "Team Opie <opie-devel@handhelds.org>"
PV = "1.1.9+cvs-${CVSDATE}"
APPTYPE = "binary"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/etc "

do_install() {
        install -d ${D}${palmtopdir}/etc/keytabs/
        install -m 0644 ${WORKDIR}/etc/keytabs/*.* ${D}${palmtopdir}/etc/keytabs/
}

FILES_${PN} = "${palmtopdir}/etc/keytabs/*"
