require genext2fs.inc

PR = "r3"

SRC_URI = "${DEBIAN_MIRROR}/main/g/genext2fs/genext2fs_${PV}.orig.tar.gz \
	   file://misc.patch;patch=1"
S = "${WORKDIR}/genext2fs-${PV}.orig"

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "1342f26b75d8edb1daa01999ce330d29"
SRC_URI[sha256sum] = "8e7dfa34f3919226550dc6507a23753f9fda55e78b15b264291ecf5940d837e9"
