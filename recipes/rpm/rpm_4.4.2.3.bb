inherit distutils-base gettext

DEPENDS = "zlib beecrypt file popt python sed-native"
require ${PN}-${PV}.inc
FILES_${PN}-dbg += "${libdir}/${PN}/.debug"
