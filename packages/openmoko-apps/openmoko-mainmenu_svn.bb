DESCRIPTION = "The OpenMoko Main Menu"
SECTION = "openmoko/applications"
PV = "0.0.1+svn${SRCDATE}"

inherit openmoko

do_compile_prepend() {
	sed -i -e 's:$(AM_LDFLAGS):$(AM_LDFLAGS)\ -lmb:' src/Makefile
}
