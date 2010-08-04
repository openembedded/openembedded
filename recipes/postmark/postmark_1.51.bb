DESCRIPTION = "Benchmarks filesystem under workload similar to that of a mail server."
LICENSE = "Artistic"
PR = "r0"

SRC_URI = "${DEBIAN_MIRROR}/main/p/${PN}/${PN}_${PV}.orig.tar.gz \
	   ${DEBIAN_MIRROR}/main/p/${PN}/${PN}_${PV}-7.diff.gz;name=patch"

SRC_URI[md5sum] = "b494167c2df1850004110ab28e5ad164"
SRC_URI[sha256sum] = "7cb7c31d4e7725ce8d8e11fb7df62ed700dee4dbd5ca1e31bf3a9161fc890b41"
SRC_URI[patch.md5sum] = "c2aafa2c1cc5aafe96390d582e119181"
SRC_URI[patch.sha256sum] = "345d2b656699e331774a77ef337178ba3e702f96d20e2aefc18e6ce4b50f4a23"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	${CC} ${CFLAGS} -o ${PN} ${PN}-${PV}.c
}

do_install () {
	install -d ${D}/usr/bin
	install -m 0755 ${PN} ${D}/usr/bin
}
