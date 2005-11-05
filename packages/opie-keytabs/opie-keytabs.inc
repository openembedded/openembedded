DESCRIPTION = "Opie keytabs for terminal applications"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe"
MAINTAINER = "Team Opie <opie-devel@handhelds.org>"
APPTYPE = "binary"


do_install() {
        install -d ${D}${palmtopdir}/etc/keytabs/
        install -m 0644 ${WORKDIR}/etc/keytabs/*.* ${D}${palmtopdir}/etc/keytabs/
}

FILES_${PN} = "${palmtopdir}/etc/keytabs/*"
