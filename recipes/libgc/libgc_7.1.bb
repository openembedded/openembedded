DESCRIPTION 	= "Garbage collector for C and C++"
LICENSE 	= "As is"
HOMEPAGE	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/"

SRC_URI 	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/gc_source/gc-${PV}.tar.gz"

inherit autotools_stage

S = "${WORKDIR}/gc-${PV}"

do_configure() {
	gnu-configize
	oe_runconf
}

LEAD_SONAME = "libgc.so.1"

FILES_${PN}-doc += "${datadir}/gc/"

