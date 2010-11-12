DESCRIPTION = "The Linux Kernel Stream Control Transmission Protocol (lksctp) project"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2"

S = "${WORKDIR}/${BPN}-${PV}"

INC_PR = "r1"

BBCLASSEXTEND = "native"

inherit autotools pkgconfig binconfig

do_install_append_virtclass-native() {
	:
}

RREPLACES = "lksctp"

LEAD_SONAME = "libsctp.so"

PACKAGES =+ "${PN}-withsctp ${PN}-utils"

FILES_${PN} = "${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_libdir}/*${SOLIBS}"

FILES_${PN}-withsctp = " \
  ${libdir}/lksctp-tools/lib*"

FILES_${PN}-dev += " \
  ${datadir}/lksctp-tools/checksctp.c \
  ${datadir}/lksctp-tools/sctp_socket.c \
  ${datadir}/lksctp-tools/sctp_bind.c \
  ${datadir}/lksctp-tools/sctp_darn.c \
  ${datadir}/lksctp-tools/sctp_load_libs.c \
  ${datadir}/lksctp-tools/sctp_sockopt.c \
  ${datadir}/lksctp-tools/sctp_socket.h \
  ${datadir}/lksctp-tools/sctp_test.c \
  ${datadir}/lksctp-tools/sctp_darn.h"

FILES_${PN}-utils = " \
  ${bindir}/sctp_test \
  ${bindir}/sctp_darn \
  ${bindir}/checksctp \
  ${bindir}/withsctp"
