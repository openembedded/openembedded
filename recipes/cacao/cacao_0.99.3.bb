require cacao.inc

PR = "r8"

SRC_URI = "\
  http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2 \
  file://cacao-codegen-arm1.patch;patch=1 \
  file://cacao-codegen-arm2.patch;patch=1 \
  file://cacao-arm-race.patch;patch=1 \
  file://vfp-compat.patch;patch=1 \
  file://cacao-disable-stackbase-check.patch;patch=1 \
  file://cacao_PR99_C_0.99.3.patch;patch=1 \
  "
