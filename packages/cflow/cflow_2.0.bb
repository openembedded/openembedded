DESCRIPTION = "Utility for viewing function call flow."
SECTION = "devel"
SRC_URI = "http://www.ibiblio.org/pub/Linux/devel/lang/c/cflow-${PV}.tar.gz \
	   file://compile.patch;patch=1"
LICENSE = "PD"

do_install () {
	install -d ${D}${bindir}
	oe_runmake 'PREFIX=${D}' 'BINDIR=${D}${bindir}' install
}
