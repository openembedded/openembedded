DESCRIPTION = "Python bindings to the Lightweight media scanner"
SECTION = "devel/python"
AUTHOR = "Gustavo Barbieri"
LICENSE = "LGPL"
DEPENDS = "lightmediascanner python-cython-native"
PE = "1"

SRC_URI = "https://garage.maemo.org/frs/download.php/4627/python-lightmediascanner-${PV}.tar.gz"

inherit distutils

SRC_URI[md5sum] = "e06900198a6d63422f96b5b74468d5da"
SRC_URI[sha256sum] = "0f7e5ee678c4430b4eeb0728cc106fba11386af53d0f798a6c6ecb3f3aebd77f"
