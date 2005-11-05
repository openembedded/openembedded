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

