inherit distutils-base gettext

DEPENDS = "zlib beecrypt file popt python sed-native"
require ${PN}-${PV}.inc
FILES_${PN}-dbg += "${libdir}/${PN}/.debug"

SRC_URI[md5sum] = "b8f0661ac765ce1a2de66ca53e37af83"
SRC_URI[sha256sum] = "a8168b8884ab40aadebba0ba696b889e25020d32a88e646d4f4bc56f2236b184"
