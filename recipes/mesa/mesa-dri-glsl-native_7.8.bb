inherit native

PR = "0"

DEPENDS = "makedepend-native"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "85cb891eecb89aae4fdd3499cccd934b"
SRC_URI[archive.sha256sum] = "8c85db5844303b806b18fc6bd40a9dccb02d90b54878a94f910674673ba0aa35"

S = "${WORKDIR}/Mesa-7.8/src/glsl/"

do_configure_prepend() {
  ln -s ${S}/../../configs/default ${S}/../../configs/current
}

do_stage() {
  install -d ${bindir}
  install -m 755 ${S}/apps/compile ${bindir}/glsl-compile
}
