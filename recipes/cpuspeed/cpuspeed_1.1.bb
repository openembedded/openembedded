DESCRIPTION = "Userspace cpufreq governor"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://carlthompson.net/dl/cpuspeed/cpuspeed-${PV}.tar.gz"
S = "${WORKDIR}/cpuspeed-${PV}"

FILES_${PN} = "/sbin/cpuspeed"

do_compile() {
	${CXX} ${TARGET_CXXFLAGS} ${LDFLAGS} -o cpuspeed cpuspeed.cc
}

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 cpuspeed ${D}${base_sbindir}/cpuspeed
}


SRC_URI[md5sum] = "ed3972d0e4f77c0278e336392be47c65"
SRC_URI[sha256sum] = "93da5b3a30c5c7c06583635e5b93e9f04f687c01a044779872a29050c4f860e8"
