DESCRIPTION = "A Python package with bindings to the 'Virtual Instrument Software Architecture' \
(VISA) library, in order to control measurement devices and test equipment via GPIB, RS232, or USB."
SECTION = "devel/python"
HOMEPAGE = "http://pyvisa.sourceforge.net/"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "PyVISA"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyvisa/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

export HOME=/tmp/foo

SRC_URI[md5sum] = "19ecf6cfcd000392c8405eceb488efb0"
SRC_URI[sha256sum] = "35fe5623906ebb8ebe27b2d5c9f793f2dce1698e32d8bdada3b69e42349994d8"
