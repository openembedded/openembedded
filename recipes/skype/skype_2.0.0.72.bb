DEPENDS = "virtual/libx11 qt4-x11-free glibc-gconv-utf-16"
HOMEPAGE="www.skype.com"
SRC_URI = "http://download.skype.com/linux/skype-2.0.0.72.tar.bz2"

S="${WORKDIR}/${PN}-${PV}"

do_install() {
    install -d ${D}/usr/bin
    cp skype ${D}/usr/bin/

    install -d ${D}/usr/share/skype
    cp -R sounds lang avatars ${D}/usr/share/skype

    install -d ${D}/usr/share/pixmaps
    cp -R icons/SkypeBlue_48x48.png ${D}/usr/share/pixmaps/skype.png
}

FILES_${PN} += "${datadir}/skype"

COMPATIBLE_HOST = "i.86.*-linux"
