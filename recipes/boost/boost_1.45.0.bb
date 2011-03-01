require boost-with-bjam.inc

PR = "${INC_PR}.3"

ARM_INSTRUCTION_SET = "arm"

SRC_URI = " \
  http://downloads.sourceforge.net/project/boost/boost/1.45.0/boost_1_45_0.tar.gz \
  file://01-fix-default-python-config.patch \
  file://no_rpath.patch \
"

S = "${WORKDIR}/boost_1_45_0"

SRC_URI[md5sum] = "739792c98fafb95e7a6b5da23a30062c"
SRC_URI[sha256sum] = "7cd7a327ebe0f43db829eccce024b7f3b0d9d4d382422d59dc710793d55c6a12"
