DEPENDS_prepend = "coreutils-native virtual/libintl intltool-native "
GPE_TARBALL_SUFFIX ?= "gz"
SRC_URI = "${GPEPHONE_MIRROR}/${PN}-${PV}/${PN}-${PV}.tar.${GPE_TARBALL_SUFFIX}"
FILES_${PN} += "${datadir}/gpe ${datadir}/application-registry"
SECTION ?= "gpe"

inherit gettext autotools
