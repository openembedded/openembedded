require cacao.inc

PR = "r11"

SRC_URI = "\
  http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2 \
  file://cacao-codegen-arm1.patch \
  file://cacao-codegen-arm2.patch \
  file://cacao-arm-race.patch \
  file://vfp-compat.patch \
  file://cacao-disable-stackbase-check.patch \
  file://cacao_PR99_C_0.99.3.patch \
  "

SRC_URI[md5sum] = "db93ab31c6d1b7f1e213771bb81bde58"
SRC_URI[sha256sum] = "1ea5bd257f755ffcae2c7a1935c37147c7392478922410e0870361eea08b6c27"
