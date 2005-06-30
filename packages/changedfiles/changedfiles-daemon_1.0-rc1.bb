include changedfiles.inc
PR = "r1"

SRC_URI += "file://autofoo.patch;patch=1"

inherit autotools 

do_compile() {
	oe_runmake daemon
}

do_install() {
	oe_runmake -C daemon install bindir=${D}${bindir} sysconfdir=${D}${sysconfdir}
}
