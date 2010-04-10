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
	cp -pPR ${S} ${D}${prefix}/src/
}

SRC_URI[md5sum] = "3561ae1f067f9dfb9707c062f536acac"
SRC_URI[sha256sum] = "4605f3f0001afd3af91ffb554dfd65c5cd313b6b9ada52ae8b2efdccf894cfa2"
