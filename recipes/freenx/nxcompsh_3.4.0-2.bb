LICENSE = "GPL"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           file://iostream.patch \
           "

SRC_URI[md5sum] = "f94501249ad7d4453524f88ef0cfb1ff"
SRC_URI[sha256sum] = "d6d29c59f070ea1ff65901a33e2013902abb3765dc6a8858f5bd6d09eccb6bf0"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install

        install -p ${S}/Connector.h ${STAGING_INCDIR}
        install -p ${S}/Dispatcher.h ${STAGING_INCDIR}
        install -p ${S}/Display.h ${STAGING_INCDIR}
        install -p ${S}/Event.h ${STAGING_INCDIR}
        install -p ${S}/Listener.h ${STAGING_INCDIR}
        install -p ${S}/Logger.h ${STAGING_INCDIR}
        install -p ${S}/Misc.h ${STAGING_INCDIR}
        install -p ${S}/Process.h ${STAGING_INCDIR}
        install -p ${S}/Request.h ${STAGING_INCDIR}
        install -p ${S}/Runnable.h ${STAGING_INCDIR}
        install -p ${S}/Socket.h ${STAGING_INCDIR}
        install -p ${S}/System.h ${STAGING_INCDIR}
        install -p ${S}/Timestamp.h ${STAGING_INCDIR}
	install -p ${S}/libXcompsh* ${STAGING_LIBDIR}
}
