DESCRIPTION = "Sugar datastore"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "sugar-toolkit python-xappy "
RDEPENDS_${PN} = "sugar-toolkit sugar-base python-xappy python-cjson xapian-bindings-python"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-datastore/${PN}-${PV}.tar.bz2"

inherit autotools

FILES_${PN} += "${datadir}/dbus-1"


SRC_URI[md5sum] = "e57580e9fd44ecc2cb7a947dd8854817"
SRC_URI[sha256sum] = "6049dddd3863110b95ec7c7b53c15f6ef8c7b627e3a04f0e9053978685a699db"
