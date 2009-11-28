require scummvm.inc

CCACHE = ""

DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"

SRC_URI += " file://scummvm.desktop \
             file://no-strip.patch;patch=1 \
           "

SRC_URI_append_openmoko = " file://openmoko-scummvm "
SRC_URI_append_shr = " file://openmoko-scummvm "

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

EXTRA_OECONF += " \
		--disable-scumm-7-8 \ 
		--disable-he \
		"

# Workaround, because some env variables aren't recognised correctly
do_configure_append() {
	sed -i "s/AS := as/AS := ${AS}/" ${S}/config.mk
	sed -i "s/AR := ar cru/AR := ${AR} cru/" ${S}/config.mk
	sed -i "s/STRIP := strip/STRIP := ${STRIP}/" ${S}/config.mk
	sed -i "s/RANLIB := ranlib/RANLIB := ${RANLIB}/" ${S}/config.mk
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
}
