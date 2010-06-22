inherit native

DEPENDS = "makedepend-native"

SRC_URI = "ftp://ftp.freedesktop.org/pub/mesa/${PV}/MesaLib-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "6be2d343a0089bfd395ce02aaf8adb57"
SRC_URI[archive.sha256sum] = "505bf418dceba05837f4ea1b1972b9620c35f8cb94bc4d1e6d573c15f562576d"

S = "${WORKDIR}/Mesa-7.8.2/src/glsl/"

do_configure_prepend() {
  ln -s ${S}/../../configs/default ${S}/../../configs/current
}

NATIVE_INSTALL_WORKS = "1"
do_install() {
  install -d ${bindir}
  install -m 755 ${S}/apps/compile ${bindir}/glsl-compile
}
