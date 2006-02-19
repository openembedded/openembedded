MAINTAINER = "Koen Kooi <koen@handhelds.org>"
PV = ${DISTRO_VERSION}

do_compile() {
	mkdir -p ${D}${sysconfdir}
	echo "Angstrom ${DISTRO_VERSION}" > ${D}${sysconfdir}/angstrom-version

}
