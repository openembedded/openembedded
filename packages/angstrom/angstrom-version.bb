MAINTAINER = "Koen Kooi <koen@linuxtogo.org>"
PV = ${DISTRO_VERSION}

do_compile() {
	mkdir -p ${D}${sysconfdir}
	echo "Angstrom ${DISTRO_VERSION}" > ${D}${sysconfdir}/angstrom-version

}
