PR         = "r0"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

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
