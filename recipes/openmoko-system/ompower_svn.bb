DESCRIPTION = "Openmoko Power State handling daemon via DBUS"
LICENSE = "MIT BSD"
DEPENDS = "ecore edbus"
PV = "0.0.0+svnr${SRCPV}"
PR = "r4"
RDEPENDS = "initscripts"

SRCNAME = "ompower"
S = "${WORKDIR}/${PN}"

inherit e

#SRC_URI = "file://${HOME}/work/ompower"
SRC_URI = "svn://svn.openmoko.org/developers/raster/;module=ompower;proto=http"

SRC_URI += "file://ompower-init"
inherit update-rc.d
do_install_prepend() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/ompower-init ${D}${sysconfdir}/init.d/ompower
}

INITSCRIPT_NAME = "ompower"
INITSCRIPT_PARAMS = "defaults 21"
