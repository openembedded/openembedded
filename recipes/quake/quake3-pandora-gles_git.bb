DESCRIPTION = "OpenGL ES quake3 port to the omap3-pandora"
LICENSE = "GPL"

SRCREV = "39d08bf6e81f7cdc29380858dfe671b0722332a3"
PR_append = "+gitr${SRCREV}"
PV = "0.0"

DEPENDS = "virtual/libsdl libgles-omap3"

SRC_URI = "git://github.com/Cpasjuste/quake3_pandora_gles.git;branch=master;protocol=git \ 
           file://quake3_makefile.patch \
"
S = "${WORKDIR}/git"

export PNDSDK="${STAGING_DIR}"

do_compile() {
	cd pandora 
	sed -i -e s:=arm-none-linux-gnueabi-:=${TARGET_PREFIX}:g Makefile
	oe_runmake 
}

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${libdir}/quake3/baseq3/

	install -m 0755 ${S}/pandora/release${TARGET_ARCH}/baseq3/*.so ${D}/${libdir}/quake3/baseq3
	install -m 0755 ${S}/pandora/release${TARGET_ARCH}/quake3 ${D}/${libdir}/quake3

	install -m 0755 ${S}/pandora/autoexec.cfg  ${D}/${libdir}/quake3/baseq3
	install -m 0755 ${S}/pandora/autoexec_high_detail.cfg  ${D}/${libdir}/quake3
	install -m 0755 ${S}/pandora/autoexec_medium_detail.cfg  ${D}/${libdir}/quake3
	install -m 0755 ${S}/pandora/autoexec_low_detail.cfg  ${D}/${libdir}/quake3
	install -m 0755 ${S}/pandora/run.sh  ${D}/${libdir}/quake3
}

FILES_${PN} += "${libdir}"
FILES_${PN}-dbg += "${libdir}/quake3/.debug ${libdir}/quake3/baseq3/.debug"

