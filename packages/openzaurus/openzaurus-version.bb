MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
PACKAGE_ARCH = "all"
PV = "${DISTRO_VERSION}"
PR = "release"

do_compile() {
	mkdir -p ${D}${sysconfdir}
	echo "OpenZaurus ${DISTRO_VERSION}" > ${D}${sysconfdir}/openzaurus-version

}
