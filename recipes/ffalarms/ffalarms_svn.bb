DESCRIPTION = "Finger friendly alarms"
HOMEPAGE = "http://ffalarms.projects.openmoko.org/"
LICENSE = "GPLv3"
AUTHOR = "?ukasz Pankowski <lukpank@o2.pl>"
MAINTAINER = "?ukasz Pankowski <lukpank@o2.pl>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "elementary libeflvala"

PV = "0.2.4+svnr${SRCREV}"
PR = "r0"

inherit vala

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/ffalarms;module=trunk;proto=https"
SRC_URI_append_shr += "file://shr.patch;patch=1"

S = "${WORKDIR}/trunk"

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

RDEPENDS = "atd alsa-utils-amixer alsa-utils-alsactl openmoko-alsa-scenarios ttf-dejavu-sans"

RSUGGESTS = "mplayer alsa-utils-aplay frameworkd"

do_compile() {
	oe_runmake VAPIDIR=${STAGING_DATADIR}/vala/vapi
}

do_install() {
	oe_runmake install DESTDIR=${D}
}
