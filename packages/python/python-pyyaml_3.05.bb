DESCRIPTION = "Python support for YAML"
HOMEPAGE = "http://www.pyyaml.org"
SECTION = "devel/python"
LICENSE = "MIT"
PR = "ml0"

SRC_URI = "http://pyyaml.org/download/pyyaml/PyYAML-3.05.tar.gz"
S = "${WORKDIR}/PyYAML-${PV}"

inherit distutils
