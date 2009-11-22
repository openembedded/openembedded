DESCRIPTION = "Finger friendly alarms"
HOMEPAGE = "http://ffalarms.projects.openmoko.org/"
LICENSE = "GPLv3"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "elementary libeflvala libical"

PV = "0.3.1+svnr${SRCPV}"
PR = "r0"

# needed because there is do_stage_append in vala.bbclass and do_stage() was removed..
do_stage() {

}

inherit vala

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/ffalarms;module=trunk;proto=https"

S = "${WORKDIR}/trunk"

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

RDEPENDS = "atd alsa-utils-amixer alsa-utils-alsactl virtual/alsa-scenarios ttf-dejavu-sans libical"

RSUGGESTS = "mplayer alsa-utils-aplay frameworkd"

do_compile() {
	oe_runmake VAPIDIR=${STAGING_DATADIR}/vala/vapi
}

do_install() {
	oe_runmake install DESTDIR=${D}
}
