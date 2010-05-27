DESCRIPTION = "The Linux Kernel Stream Control Transmission Protocol (lksctp) project"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2"

S = "${WORKDIR}/${BPN}-${PV}"

INC_PR = "r0"

BBCLASSEXTEND = "native"

inherit autotools pkgconfig binconfig

export LDFLAGS += "-ldl"

do_install_append_virtclass-native() {
	:
}

DEBIANNAME_${PN} = "lksctp"

PACKAGES =+ "${PN}-tools"
FILES_${PN} = "${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_libdir}/*${SOLIBS}"

FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-utils = ""
