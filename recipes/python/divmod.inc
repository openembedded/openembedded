SRC_URI = "http://divmod.org/trac/attachment/wiki/SoftwareReleases/${REALPN}-${PV}.tar.gz?format=raw"

DEPENDS += "python-twisted-native"

do_unpack2() {
	cd ${WORKDIR}
	tar zxvf ${REALPN}-${PV}.tar.gz?format=raw
}

addtask unpack2 after do_unpack before do_configure

inherit distutils

S = "${WORKDIR}/${REALPN}-${PV}"



