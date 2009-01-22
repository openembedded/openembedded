require scummvm.inc

DEPENDS = "libsdl-qpe tremor libogg zlib ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"

S = "${WORKDIR}/scummvm-${PV}/"
