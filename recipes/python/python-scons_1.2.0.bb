DESCRIPTION = "A Software Construction Tool"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "scons"

SRC_URI = "${SOURCEFORGE_MIRROR}/scons/scons-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "53b6aa7281811717a57598e319441cf7"
SRC_URI[sha256sum] = "2806451e02a42789decb6d08098b798b6b81a0a39d8d3b2fbdd3fe84ebd8a246"
