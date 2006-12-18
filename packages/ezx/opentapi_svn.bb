DESCRIPTION = "Open implementation of motorola's tapisrc"
LICENSE = "GPLv2"

PV = "0.0+svn${SRCDATE}"

SRC_URI = "svn://svn.openezx.org/trunk/src/userspace/;module=opentapi;proto=http"

S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}${bindir}
	install -m 755 opentapi ${D}${bindir}	
}	

