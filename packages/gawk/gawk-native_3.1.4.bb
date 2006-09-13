INHIBIT_AUTOTOOLS_DEPS = "1"
require gawk_${PV}.bb

inherit native

DEPENDS = ""
PATCHTOOL = "patch"

S = "${WORKDIR}/gawk-${PV}"

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 gawk ${STAGING_BINDIR}
}
