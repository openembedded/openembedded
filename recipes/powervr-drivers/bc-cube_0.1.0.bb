DESCRIPTION = "TI Texture streaming using bufferclass API demo (spinning video cube)"
LICENSE = "TI-BSD/GPLv2"
DEPENDS = "virtual/egl"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/apps_processors/OMAP35x_AM35x_Video_Texture_Streaming/1_0/exports/bc-cat-${PV}.tar.gz \
           file://bc-cat-0.1.0-BC_PIX_FMT_.patch;patch=1;pnum=0"

S = "${WORKDIR}/bc-cat-${PV}"

CFLAGS += " -DLINUX -I../include -I${STAGING_INCDIR}/services4/3rdparty/bufferclass_ti/ -I${STAGING_INCDIR}/include4"
LDFLAGS += "-lGLES_CM -lEGL"

do_configure() {
	cd test
	sed -i -e s:pixel_fmt:fourcc:g *.c
}

# build both fb and x11 version
do_compile() {
	cd test
	oe_runmake -e clean
	oe_runmake -e
	mv gles1_bc_mmap gles1_bc_mmap-fb
	mv gles1_bc_webcam gles1_bc_webcam-fb

	oe_runmake -e clean
	CFLAGS="${CFLAGS} -DX11" oe_runmake -e X11BUILD=1
 	mv gles1_bc_mmap gles1_bc_mmap-x11
	mv gles1_bc_webcam gles1_bc_webcam-x11

}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/test/gles1_bc_mmap-* ${D}${bindir}
	install -m 0755 ${S}/test/gles1_bc_webcam-* ${D}${bindir}
}

PACKAGES =+ "${PN}-fb ${PN}-x11"
FILES_${PN}-x11 = "${bindir}/*x11"
FILES_${PN}-fb = "${bindir}/*fb"

