require curl-common.inc
inherit native
DEPENDS = "zlib-native"
PR = "r1"

do_stage () {
	autotools_stage_all
}

do_install() {
	:
}
