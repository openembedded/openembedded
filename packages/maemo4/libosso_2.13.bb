require libosso.inc

PR = "r0"

SRC_URI = "\
  http://repository.maemo.org/pool/maemo4.0/free/source/libo/${PN}/${PN}_${PV}-1.1fix.tar.gz \
  file://libosso-buildfix.patch;patch=1 \
  "

PACKAGES += "${PN}-outo ${PN}-outo-dev ${PN}-outo-dbg ${PN}-outo-bin-dbg ${PN}-outo-bin"

FILES_${PN}-outo = "${libdir}/outo/lib*.so"
FILES_${PN}-outo-dev = "${libdir}/outo/*.la ${libdir}/outo/*.a"
FILES_${PN}-outo-dbg = "${libdir}/outo/.debug/lib*.so
FILES_${PN}-outo-bin-dbg = "${libdir}/outo/.debug/*bin"
FILES_${PN}-outo-bin = "${libdir}/outo/*bin ${libdir}/outo/mimedummy.doc"
