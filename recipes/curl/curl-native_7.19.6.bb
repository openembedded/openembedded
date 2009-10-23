require curl-common.inc
inherit native
DEPENDS = "zlib-native"

do_stage () {
	autotools_stage_all
}

do_install() {
	:
}
