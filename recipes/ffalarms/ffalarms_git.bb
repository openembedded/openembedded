DESCRIPTION = "Finger friendly alarms"
HOMEPAGE = "http://ffalarms.projects.openmoko.org/"
LICENSE = "GPLv3"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "elementary libeflvala libical"

SRCREV = "b054defaaa5a09a83e1ddbd5b43229bdd1ab107e"
PV = "0.3.2+gitr${SRCPV}"
PR = "r0"

# needed because there is do_stage_append in vala.bbclass and do_stage() was removed..
do_stage() {

}

inherit vala

SRC_URI = "git://git.shr-project.org/repo/ffalarms.git;protocol=http;branch=master"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

RDEPENDS = "atd alsa-utils-amixer alsa-utils-alsactl virtual/alsa-scenarios ttf-dejavu-sans libical"

RSUGGESTS = "mplayer alsa-utils-aplay frameworkd"

do_compile() {
	oe_runmake VAPIDIR=${STAGING_DATADIR}/vala/vapi
}

do_install() {
	oe_runmake install DESTDIR=${D}
}
