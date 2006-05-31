include olsrd.inc
PR = "r2"

SRC_URI += "file://0.4.9-httpinfo-makefile.diff;patch=1"

do_compile() {
	oe_runmake OS=linux clean
	touch .depend
	touch src/cfgparser/.depend
	oe_runmake OS=linux all libs
}
