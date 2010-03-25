DESCRIPTION = "Finger friendly alarms"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
HOMEPAGE = "http://ffalarms.projects.openmoko.org/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "elementary libeflvala libical"
RDEPENDS = "atd alsa-utils-amixer ttf-dejavu-sans libical"
RSUGGESTS = "mplayer alsa-utils-aplay frameworkd"
PV = "0.4+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/ffalarms.git;protocol=http;branch=master"

SRCREV = "f8175d83d7807eea9577a555016d6e41210196bb"
S = "${WORKDIR}/git"

inherit vala

do_compile() {
        oe_runmake VAPIDIR=${STAGING_DATADIR}/vala/vapi
}
do_install() {
        oe_runmake install DESTDIR=${D} SYSCONFDIR=${sysconfdir}
}

pkg_postinst_${PN}() {
#!/bin/sh
/etc/init.d/dbus-1 reload
}

pkg_postrm_${PN}() {
#!/bin/sh
/etc/init.d/dbus-1 reload
}

# needed because there is do_stage_append in vala.bbclass and do_stage() was removed..
do_stage() {

}

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
