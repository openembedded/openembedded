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

SRC_URI[md5sum] = "db93ab31c6d1b7f1e213771bb81bde58"
SRC_URI[sha256sum] = "1ea5bd257f755ffcae2c7a1935c37147c7392478922410e0870361eea08b6c27"
