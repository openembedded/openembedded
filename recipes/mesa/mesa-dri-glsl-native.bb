inherit native

PV = "7.7.999"
PR = "0"
PR_append = "+gitr${SRCREV}"

DEPENDS = "makedepend-native"

SRCREV = "f88b43e8d09bf359e7d5770b133cb433b25f9848"

SRC_URI = "git://anongit.freedesktop.org/git/mesa/mesa;protocol=git"

S = "${WORKDIR}/git/src/glsl/"

do_configure_prepend() {
  ln -s ${S}/../../configs/default ${S}/../../configs/current
}

do_stage() {
  install -d ${bindir}
  install -m 755 ${S}/apps/compile ${bindir}/glsl-compile
}
