PR         = "r2"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = "hildon-lgpl hildon-base-lib osso-af-settings libosso hildon-libs osso-af-settings libosso-help"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://config-path.patch;patch=1;pnum=0 \
           file://noWerror.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-control-panel-0.9.1"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0 ${datadir}/applications"

do_stage() {
        install -d ${STAGING_INCDIR}/hildon-cp-plugin
        install -m 644 *.h ${STAGING_INCDIR}/hildon-cp-plugin
}