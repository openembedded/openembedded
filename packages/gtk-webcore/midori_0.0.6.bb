DESCRIPTION = "Midori is a lightweight web browser."
LICENSE = "GPLv2"

DEPENDS = "webkit-gtk libsexy" 

inherit autotools pkgconfig

SRC_URI = "http://software.twotoasts.de/media/midori/midori-${PV}.tar.gz \ 
           file://midori.desktop"

do_install_append() {
        if  [ -f ${WORKDIR}/midori.desktop ]; then
                install -d ${D}${datadir}/applications
                install -m 0644 ${WORKDIR}/midori.desktop ${D}${datadir}/applications
        fi

}

