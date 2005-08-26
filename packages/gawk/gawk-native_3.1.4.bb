INHIBIT_AUTOTOOLS_DEPS = "1"
include gawk_${PV}.bb

inherit native

DEPENDS = ""
PATCH_DEPENDS = ""
PATCHCLEANCMD = ""
PATCHCMD = "num='%s'; name='%s'; file='%s'; patch -p "$num" -i "$file""

S = "${WORKDIR}/gawk-${PV}"

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 gawk ${STAGING_BINDIR}
}
