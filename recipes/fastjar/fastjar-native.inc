DEPENDS = "zlib-native"

S = "${WORKDIR}/fastjar-${PV}"

inherit native

do_configure () {
	gnu-configize || die "failure running gnu-configize"
	oe_runconf
}

do_make() {
	oe_runmake bin_PROGRAMS
}

do_stage() {
	oe_runmake install-binPROGRAMS
}
