inherit efl_base

SRC_URI = "${E_CVS};module=e17/libs/${SRCNAME}"
S = "${WORKDIR}/${SRCNAME}"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/${PN} ${bindir}/*_* ${datadir}"
FILES_${PN}-dev += "${bindir}/*-config ${libdir}/${PN}/*.a ${libdir}/${PN}/*.la ${libdir}/${PN}/*/*.a ${libdir}/${PN}/*/*.la"
FILES_${PN} = "${libdir}/*.so*"
