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

inherit distutils
