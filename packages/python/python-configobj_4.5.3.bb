DESCRIPTION = "ConfigObj is a simple but powerful config file reader and writer"
LICENSE = "BSD"

SRC_URI = "http://pypi.python.org/packages/source/C/ConfigObj/configobj-${PV}.tar.gz"

inherit distutils

S = "${WORKDIR}/configobj-${PV}"


