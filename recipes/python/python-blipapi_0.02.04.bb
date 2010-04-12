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


SRC_URI[md5sum] = "38892df4239376e51300e5455a319664"
SRC_URI[sha256sum] = "b433ec324dbc0c63966cb383e370225afaf4eb5abf97471a49a5e893ceffb818"
