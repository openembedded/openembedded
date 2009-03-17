require scummvm.inc

CCACHE = ""

DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"

SRC_URI += " file://scummvm.desktop "

SRC_URI_append_openmoko = " file://openmoko-scummvm "


SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

EXTRA_OECONF += " \
		--disable-scumm-7-8 \
		--disable-he \
		"

do_compile() {
	oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="${CFLAGS}" \
                   CXXFLAGS="${CXXFLAGS}" \
                   LDFLAGS="${LDFLAGS} ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '-lmpeg2', d)}" \
                   DEFINES="-DUNIX -DSCUMM_NEED_ALIGNMENT -DUSE_VORBIS -DUSE_ZLIB -DUSE_MPEG2 ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '-DUSE_MAD -DUSE_MPEG2', d)}"
}


do_install_append() {
	if [ -f ${WORKDIR}/openmoko-scummvm ]; then
		install -d ${D}${bindir}
		install -m 0755 ${WORKDIR}/openmoko-scummvm ${D}${bindir}/openmoko-scummvm
	fi
	if  [ -f ${WORKDIR}/scummvm.desktop ]; then
		install -d ${D}${datadir}/applications
		install -m 0644 ${WORKDIR}/scummvm.desktop ${D}${datadir}/applications
	fi
	install -d ${D}${datadir}/scummvm
	install -m 0644 gui/themes/modern.ini ${D}${datadir}/scummvm/ 
	install -m 0644 gui/themes/modern.zip ${D}${datadir}/scummvm/
}
