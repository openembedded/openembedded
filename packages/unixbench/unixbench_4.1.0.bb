DESCRIPTION = "The BYTE UNIX Benchmarks"
# NOTE: There are no copyright headers or license information of any kind in
# the unixbench source tree.  Not sure what to make of this.
LICENSE = "unknown"
SRC_URI = "http://www.tux.org/pub/tux/benchmarks/System/unixbench/unixbench-${PV}.tgz"
S = "${WORKDIR}/unixbench-${PV}"
EXTRA_OEMAKE = "'CC=${CC}'"
FILES_${PN} = "${prefix}/src/unixbench-${PV}"

do_install () {
	install -d ${D}${prefix}/src
	cp -a ${S} ${D}${prefix}/src/
}
