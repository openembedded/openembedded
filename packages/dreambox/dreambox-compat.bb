DESCRIPTION = "Dreambox compatibility links"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV = "1.0"
PR = "r0"

FILES = "/lib/libgcc_s_nof.so.1"

do_install() {
	install -d ${D}/lib
	ln -sf libgcc_s.so.1 ${D}/lib/libgcc_s_nof.so.1
}
