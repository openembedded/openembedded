require libosso.inc

PR = "r2"

SRC_URI = "\
  http://repository.maemo.org/pool/maemo4.0/free/source/libo/${PN}/${PN}_${PV}-1.1fix.tar.gz \
  file://libosso-buildfix.patch;patch=1 \
  file://libosso-dont-use-inline.patch;patch=1 \
  "

PACKAGES += "${PN}-outo ${PN}-outo-dev ${PN}-outo-dbg ${PN}-outo-bin-dbg ${PN}-outo-bin"

FILES_${PN}-outo = "${libdir}/outo/lib*.so"
FILES_${PN}-outo-dev = "${libdir}/outo/*.la ${libdir}/outo/*.a"
FILES_${PN}-outo-dbg = "${libdir}/outo/.debug/lib*.so
FILES_${PN}-outo-bin-dbg = "${libdir}/outo/.debug/*bin"
FILES_${PN}-outo-bin = "${libdir}/outo/*bin ${libdir}/outo/mimedummy.doc"

SRC_URI[md5sum] = "92c51a937120eb1f230f84f58ce08da7"
SRC_URI[sha256sum] = "998a13a713c826a6ddbc69f956fbb78deef18b63e65f450a430df39930bcadb4"
