DESCRIPTION = "NSD is an authoritative only, high performance, simple and opensource name server"
SECTION = "console/network"
PRIORITY = "optional"

DEPENDS = "openssl"

SRC_URI = "http://www.nlnetlabs.nl/downloads/nsd/nsd-${PV}.tar.gz;name=src"
SRC_URI[src.md5sum] = "0c394fd713d194bde24a1035e56d5a79"
SRC_URI[src.sha256sum] = "41ed4a3e21d7381379c85d46ee7131937195aa780f120b03e5d4d878d397c769"
LICENSE = "nsd"
inherit autotools

EXTRA_OECONF = " --with-ssl=${STAGING_DIR_HOST}${exec_prefix} "

