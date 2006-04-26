require anthy_${PV}.bb
inherit native

do_stage() {
	autotools_stage_all
}

