DESCRIPTION = "Finger friendly alarms"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
HOMEPAGE = "http://ffalarms.projects.openmoko.org/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "elementary libeflvala libical"
RDEPENDS_${PN} = "atd alsa-utils-amixer ttf-dejavu-sans libical"
RSUGGESTS_${PN} = "mplayer alsa-utils-aplay frameworkd"
PV = "0.4+gitr${SRCPV}"
PR = "r6"

SRC_URI = "git://git.shr-project.org/repo/ffalarms.git;protocol=http;branch=master"

SRCREV = "084e4268045b4f3d1c644fe3a1d5a9c49b161713"
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

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications ${datadir}/pixmaps"

MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
