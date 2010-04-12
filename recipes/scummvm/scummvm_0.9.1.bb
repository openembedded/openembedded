require scummvm.inc

DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"

SRC_URI += "file://makefile-nostrip.patch;patch=1 \
            file://scummvm-targetcheck.patch;patch=1"
SRC_URI_append_openmoko = " file://openmoko-scummvm \
                           file://scummvm.desktop"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

EXTRA_OECONF += "--enable-lure \
		 --enable-agi \
		 --enable-cine \
		 "

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

SRC_URI[md5sum] = "30a82ad466bae223875e66ee14b94904"
SRC_URI[sha256sum] = "5cd5d9c06281a4f81d85d9a9f9b0410045d4a764a855f06f574183b528c15d1a"
