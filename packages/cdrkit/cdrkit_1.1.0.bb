DESCRIPTION = "portable command-line CD/DVD recorder software"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
LICENSE = "GPL"
SECTION = "optional"
DEPENDS = "cmake-native libcap"

SRC_URI = "http://cdrkit.org/releases/${PN}-${PV}.tar.gz"

inherit autotools

do_install () {
	oe_runmake 'DESTDIR=${D}' 'PREFIX=/usr' install
}
