MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
PV = ${DISTRO_VERSION}

do_compile() {
	mkdir -p ${D}${sysconfdir}
	echo "OpenZaurus ${DISTRO_VERSION}" > ${D}${sysconfdir}/openzaurus-version

}
