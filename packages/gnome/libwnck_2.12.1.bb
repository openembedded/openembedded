LICENSE =	"LGPL"
DEPENDS = 	"gtk+"
DESCRIPTION =	"Window navigation construction toolkit"
HOMEPAGE =	""

inherit gnome

do_stage() {        
	autotools_stage_all      
}
