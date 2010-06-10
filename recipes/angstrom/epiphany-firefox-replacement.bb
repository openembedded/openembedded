# This is a hack because $*#($*($# e17 doesn't check if firefox is present and puts it in the menu blindly

RDEPENDS_${PN} = "epiphany"
RCONFLICTS_${PN} = "firefox"

do_install() {
	install -d ${D}/${bindir}
	ln -sf ${bindir}/epiphany ${D}/${bindir}/firefox
} 

