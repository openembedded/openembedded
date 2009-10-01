DESCRIPTION = "Python keyring"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python python-pygtk python-xml python-netclient python-numeric pydes"

ARCH_pyring = "all"

SRC_URI = "http://handheldshell.com/software/pyring_${PV}.tgz "

inherit distutils

S = ${WORKDIR}/pyring-${PV}

do_configure_prepend() {
	cp ${S}/setup_freerunner.py ${S}/setup.py
        exit 0
}

FILES_${PN} += "${datadir}"

