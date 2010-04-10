LICENSE = "LGPL"
DEPENDS = "gtk+"
GPE_TARBALL_SUFFIX = "bz2"
PR = "r2"

inherit gpe autotools

SRC_URI += "file://gtkinput.sh"

FILES_${PN} = "/etc ${libdir}/gtk-2.0/*/modules/*.so*"



do_install_append() {
        install -d ${D}/${sysconfdir}/X11/Xsession.d
        install -m 755 ${WORKDIR}/gtkinput.sh ${D}/${sysconfdir}/X11/Xsession.d/46gtkinput
}


SRC_URI[md5sum] = "259328c5749a0075502bd474dcb9a383"
SRC_URI[sha256sum] = "3915bd4e713b2a30f6af86d415d49edaad0846ecd440a6b7062d0c0935ad8f93"
