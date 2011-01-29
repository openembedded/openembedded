require ecore.inc

PR = "${INC_PR}.0"

SRC_URI = "\
  ${E_MIRROR}/${SRCNAME}-${PV}.tar.gz \
  file://fix-ecore-fb-initialization.patch \
  file://exit_uclibc.patch \
"

SRC_URI[md5sum] = "db2ef62d7c877e54087a4ce805368419"
SRC_URI[sha256sum] = "8a1f89a7cef27d93d87155d53d54f651b3fae810f8995b3c634b4d709ef4e1fa"
