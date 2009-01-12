DESCRIPTION = "Python bindings to the Lightweight media scanner"
SECTION = "devel/python"
AUTHOR = "Gustavo Barbieri"
LICENSE = "LGPL"
DEPENDS = "lightmediascanner python-cython-native"
PE = "1"

SRC_URI = "https://garage.maemo.org/frs/download.php/4627/python-lightmediascanner-${PV}.tar.gz"

inherit distutils
