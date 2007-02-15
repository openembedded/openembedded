DESCRIPTION = "A simple example panel plugin for OpenMoko"
SECTION = "openmoko/examples"
DEPENDS += "libmatchbox"
PV = "0.0.1+svn${SRCDATE}"

inherit openmoko

do_configure_prepend() {
	sed -i -e s:-Werror::g src/Makefile.am
}	

