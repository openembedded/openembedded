DESCRIPTION = "Utility for viewing function call flow."
SECTION = "devel"
SRC_URI = "http://www.ibiblio.org/pub/Linux/devel/lang/c/cflow-${PV}.tar.gz \
	   file://compile.patch;patch=1"
LICENSE = "PD"

do_install () {
	install -d ${D}${bindir}
	oe_runmake 'PREFIX=${D}' 'BINDIR=${D}${bindir}' install
}

SRC_URI[md5sum] = "09d6131980aa770289938f71401e8976"
SRC_URI[sha256sum] = "f377e4be57862a260e924c3778a241a2a424772fb98ba8b8cc5f04050ff12ac5"
