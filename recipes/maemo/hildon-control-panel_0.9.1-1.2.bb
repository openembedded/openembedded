PR         = "r2"
LICENSE    = "GPL"

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
SRC_URI[md5sum] = "72c8b814ebeec8668cea575e08bb1548"
SRC_URI[sha256sum] = "bbe77d297c7560d3fdad343ab49f23c9c0aa1574db77108d1b97845fb7bb26d5"
