require sdcc_${PV}.bb
inherit native
DEPENDS = ""

# don't need native-tools patch here
SRC_URI = "${SOURCEFORGE_MIRROR}/sdcc/sdcc-${PV}.tar.gz \
           file://gcc4.patch;patch=1"

do_stage() {
	oe_runmake install
}

#do_stage() {
#	find bin -type f -perm -0755 -exec install -m 0755 {} ${STAGING_BINDIR} \;
#}

