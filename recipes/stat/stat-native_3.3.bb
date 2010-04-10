SECTION = "console/utils"
require stat_${PV}.bb
inherit native
S = "${WORKDIR}/stat-${PV}"

do_stage() {
	install -m 755 stat ${STAGING_BINDIR}

}

do_install() {
	true
}

SRC_URI[md5sum] = "37e247e8e400ad9205f1b0500b728fd3"
SRC_URI[sha256sum] = "7071f0384a423a938dd542c1f08547a02824f6359acd3ef3f944b2c4c2d1ee09"
