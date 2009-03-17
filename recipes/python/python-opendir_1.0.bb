DESCRIPTION = "POSIX opendir support for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PD"
HOMEPAGE = "http://rabenfrost.net/mokopedia/opendir/"
DEPENDS = "python-pyrex-native python-cython-native"
PR = "ml1"

SRC_URI = "\
  file://opendir.pyx \
  file://setup.py \
"
S = "${WORKDIR}"

inherit distutils
