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


SRC_URI[md5sum] = "d6d2a16ccd1562b2ae63314f30a4ebf9"
SRC_URI[sha256sum] = "45b73399b8affd1a81ecd370d37e066c046c49e1777b43d0affe6b520082a604"
