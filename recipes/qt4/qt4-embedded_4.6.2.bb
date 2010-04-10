require qt4-embedded.inc

PR = "${INC_PR}.1"

QT_CONFIG_FLAGS_append_armv6 = " -no-neon "

require qt-${PV}.inc


SRC_URI[md5sum] = "eb651ee4b157c01696aa56777fc6e0e5"
SRC_URI[sha256sum] = "176f51ddb06dce67ab4b2efc6b327dc21ed8f764c5d97acc15ff1f907c2affae"
