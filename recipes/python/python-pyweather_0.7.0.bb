DESCRIPTION = "PyWeather is a collection of weather related modules \
that are capable of performing conversion calculations for many common meteorological units."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "weather"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/meta-tools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "ce547183f7b455d837d654a484b29a83"
SRC_URI[sha256sum] = "fabdec4b04d50b50558b6062d35884c60b419e65b3738b08be07d729b6f3d46a"
