DESCRIPTION = "Enables apps on external media"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "opie-update-symlinks"
APPTYPE = "binary"


S = "${WORKDIR}/symlinker"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 ${S}/opie-update-symlinks ${D}${palmtopdir}/bin/
}

