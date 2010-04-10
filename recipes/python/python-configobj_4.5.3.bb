DESCRIPTION = "ConfigObj is a simple but powerful config file reader and writer"
LICENSE = "BSD"

SRC_URI = "http://pypi.python.org/packages/source/C/ConfigObj/configobj-${PV}.tar.gz"

inherit distutils

S = "${WORKDIR}/configobj-${PV}"



SRC_URI[md5sum] = "6e2b37301439705831bd510d2a198431"
SRC_URI[sha256sum] = "4276fcc96d81f0ba923f3a8c44c3cb55ac72c00fa79d35f1e3ccb4d410b3d7c5"
