DESCRIPTION = "UBL and second stage bootloader flasher for davinci"
HOMEPAGE = "http://www.hugovil.com/en/dvnixload/"
LICENSE = "GPLv2"
SRC_URI = "http://www.hugovil.com/repository/dvnixload-0.2.6.tar.gz"

inherit autotools

BBCLASSEXTEND="native"


SRC_URI[md5sum] = "33308f47405c0e96a8248c7b1229dee5"
SRC_URI[sha256sum] = "5b76e9cb0ee843208c17053315926e0e168db8a89fe960655a0d0f4871e2b9da"
