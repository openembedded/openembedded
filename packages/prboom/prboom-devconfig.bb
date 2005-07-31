DESCRIPTION = "Device specific configuration for prboom"
SECTION = "games"
PRIORITY = "optional"
MAINTAINER = "coredump@handhelds.org"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "file://prboom.cfg"

S = "${WORKDIR}/${PN}"

FILES_${PN} = "/usr/share/games/doom/prboom.cfg"

do_install() {
	install -d ${D}/usr/share/games/doom/
	
	install -m 644 ${WORKDIR}/prboom.cfg ${D}/usr/share/games/doom/
}
