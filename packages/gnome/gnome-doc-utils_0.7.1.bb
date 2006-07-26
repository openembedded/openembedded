LICENSE = "GPL/LGPL"
DEPENDS = "libxml2 libxslt"

inherit gnome

FILES_${PN} += "${datadir}/xml*"

do_stage() {
	autotools_stage_all
	}


