DESCRIPTION = "Opie keytabs for terminal applications"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie-devel@handhelds.org>"
DEPENDS = "virtual/libqpe"
APPTYPE = "binary"
PR = "r0"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/etc "

do_install() {
        install -d ${D}${palmtopdir}/etc/keytabs/
        install -m 0644 ${WORKDIR}/etc/keytabs/*.* ${D}${palmtopdir}/etc/keytabs/
}

FILES_${PN} = "${palmtopdir}/etc/keytabs/*"
