DESCRIPTION = "Anki is a program designed to help you remember facts \
(such as words and phrases in a foreign language) \
as easily, quickly and efficiently as possible"
HOMEPAGE = "http://ichi2.net/anki/"
AUTHOR = "Damien Elmes"
PRIORITY = "optional"
LICENSE = "GPLv2"
RDEPENDS_${PN} = "python-pyqt"
RRECOMMENDS_${PN} = "kakasi virtual-japanese-font"

SRC_URI = "http://ichi2.net/anki/download/anki-${PV}.tgz"

inherit setuptools

PACKAGE_ARCH = "all"
