require sdcc_${PV}.bb
inherit native
DEPENDS = ""

# don't need native-tools patch here
SRC_URI = "${SOURCEFORGE_MIRROR}/sdcc/sdcc-${PV}.tar.gz \
           file://gcc4.patch;patch=1"

do_stage() {
	autotools_stage_all
	for i in bin/as-*; do
		install -m 0755 $i ${STAGING_BINDIR}
	done
}

