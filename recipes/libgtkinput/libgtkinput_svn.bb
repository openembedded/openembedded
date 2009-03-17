LICENSE = "LGPL"
PV = "0.3+svn${SRCDATE}"

inherit gpe autotools

SRC_URI = "${GPE_SVN} \
           file://gtkinput.sh"

S = "${WORKDIR}/${PN}"

do_install_append() {
        install -d ${D}/${sysconfdir}/X11/Xsession.d
        install -m 755 ${WORKDIR}/gtkinput.sh ${D}/${sysconfdir}/X11/Xsession.d/46gtkinput
}

FILES_${PN} += "${libdir}"

DEFAULT_PREFERENCE = "-1"
