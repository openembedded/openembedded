DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "2ebce9f1217553112ac35abc35360050"
SRC_URI[sha256sum] = "ee28209d7cdcb759338ef0061e2f7c6ec7a021369659790adeef2cd888b58696"
