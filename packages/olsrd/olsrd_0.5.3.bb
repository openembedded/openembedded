require olsrd.inc
PR = "r0"

SRC_URI="http://www.olsr.org/releases/0.5/olsrd-${PV}.tar.bz2 \
        file://init \
        file://olsrd.conf \
        file://unbreak-makefile.patch;patch=1"

do_compile() {
	oe_runmake OS=linux clean
	touch .depend
	touch src/cfgparser/.depend
	oe_runmake OS=linux all libs
}
