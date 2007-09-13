LICENSE =	"LGPL"
DEPENDS = 	"gtk+"
DESCRIPTION =	"Window navigation construction toolkit"

inherit gnome

do_stage() {
	autotools_stage_all
}
