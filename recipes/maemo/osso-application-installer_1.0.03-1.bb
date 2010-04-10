PR         = "r0"
LICENSE    = "GPL"

DEPENDS = "hildon-lgpl hildon-base-lib libosso hildon-libs hildon-control-panel shared-mime-info"
RDEPENDS = "shared-mime-info"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz \
           file://fix-buildsystem.patch;patch=1"

S = "${WORKDIR}/osso-application-installer-1.0.03"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0 ${libdir}/hildon-control-panel/*.so ${datadir}/applications ${datadir}/mime"

pkg_postinst () {
  echo "Updating MIME database... this may take a while."
  ${bindir}/update-mime-database ${datadir}/mime
}

SRC_URI[md5sum] = "05e47346d432bd4c78736b12f262d612"
SRC_URI[sha256sum] = "f7129c56cd7e561c10457d101f37ebf3a8b02df83f42a30cb90b46eb0de5dede"
