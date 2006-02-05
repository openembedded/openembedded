LICENSE = "LGPL"
DEPENDS = "gtk+"
GPE_TARBALL_SUFFIX = "bz2"
PR = "r1"

inherit gpe autotools

SRC_URI += "file://gtkinput.sh"

FILES_${PN} = "/etc ${libdir}/gtk-2.0/2.4.0/modules/*.so*"



do_install_append() {
        install -d ${D}/${sysconfdir}/X11/Xsession.d
        install -m 755 ${WORKDIR}/gtkinput.sh ${D}/${sysconfdir}/X11/Xsession.d/46gtkinput
}

