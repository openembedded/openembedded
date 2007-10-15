require usbpath_svn.bb
inherit native

do_stage () {
	autotools_stage_all
}

