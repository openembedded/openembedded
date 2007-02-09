MAINTAINER = "Philippe De Swert <philippedeswert@scarlet.be>"
LICENSE = "LGPL"
inherit gpe autotools

DEFAULT_PREFERENCE = "-1"

PV = "0.3+svn${SRCDATE}"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN} \
           file://gtkinput.sh"

S = "${WORKDIR}/${PN}"

FILES_${PN} += "${libdir}"


do_install_append() {
        install -d ${D}/${sysconfdir}/X11/Xsession.d
        install -m 755 ${WORKDIR}/gtkinput.sh ${D}/${sysconfdir}/X11/Xsession.d/46gtkinput
}

