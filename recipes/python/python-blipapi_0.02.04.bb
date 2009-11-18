DESCRIPTION = "Library to communicate with blip.pl API"
AUTHOR = "Marcin Sztolcman <marcin@urzenia.net>"
HOMEPAGE = "http://blipapi.googlecode.com/"
DEPENDS = "python-setuptools"
LICENSE = "GPL"
RDEPENDS += "python-json"
PR = "r0"
inherit setuptools

SRC_URI = "http://blipapi.googlecode.com/files/BlipApiPY-0.02.04.tar.bz2"
S = "${WORKDIR}/blipapi"

