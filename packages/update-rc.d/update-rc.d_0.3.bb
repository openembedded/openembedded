SECTION = "base"
PRIORITY = "standard"
DESCRIPTION = "Manage symlinks in /etc/rcN.d"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
S = ${WORKDIR}/update-rc.d
LICENSE = "GPL"
SRC_URI = "${HANDHELDS_CVS};module=apps/update-rc.d;tag=r0_3"

do_compile() {
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 0755 ${S}/update-rc.d ${D}/${sbindir}/update-rc.d
}

