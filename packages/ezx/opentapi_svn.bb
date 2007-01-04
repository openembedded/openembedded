DESCRIPTION = "Open implementation of motorola's tapisrc"
LICENSE = "GPLv2"

PV = "0.0+svn${SRCDATE}"

SRC_URI = "svn://svn.openezx.org/trunk/src/userspace/;module=opentapi;proto=http \
           file://opentapi.init \
          "

inherit update-rc.d

INITSCRIPT_NAME = "opentapi"
INITSCRIPT_PARAMS = "defaults"


S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}${bindir}
	install -m 755 opentapi ${D}${bindir}
        
	install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/opentapi.init ${D}${sysconfdir}/init.d/opentapi
}

