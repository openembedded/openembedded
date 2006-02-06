LICENSE = "LGPL"
inherit gpe autotools

CVSDATE_${PN} = "20060122"
PV = "0.1+cvs${SRCDATE}"
SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN} \
	   file://gtkinput.sh"

S = "${WORKDIR}/${PN}"

FILES_${PN} += "${libdir}"


do_install_append() {
        install -d ${D}/${sysconfdir}/X11/Xsession.d
        install -m 755 ${WORKDIR}/gtkinput.sh ${D}/${sysconfdir}/X11/Xsession.d/46gtkinput
}

