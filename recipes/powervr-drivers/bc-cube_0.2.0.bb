DESCRIPTION = "TI Texture streaming using bufferclass API demo (spinning video cube)"
LICENSE = "TI-BSD/GPLv2"
DEPENDS = "virtual/egl"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/apps_processors/OMAP35x_AM35x_Video_Texture_Streaming/1_0/exports/bc-cat-${PV}.tar.gz;name=bccat \
           file://bc-cat-0.2.0.patch;patch=1 \
           file://bc-cube.desktop \
"

SRC_URI[bccat.md5sum] = "4d6f2e637f57ee6cf5f85b024ac88741"
SRC_URI[bccat.sha256sum] = "5c486590d843da6ac38fe8c6cfcb851de94ac496cf4f3b4b3092092656bf727a"

S = "${WORKDIR}/bc-cat-${PV}"

CFLAGS += " -DGLES_20 -DLINUX -I../include -I${STAGING_INCDIR}/services4/3rdparty/bufferclass_ti/ -I${STAGING_INCDIR}/include4"
LDFLAGS += "-lGLESv2 -lEGL"

# build both fb and x11 version
do_compile() {
	cd test
	sed -i -e s:video3:video0:g webcam.c
	oe_runmake GLES_20=1 -e clean
	oe_runmake GLES_20=1 -e
	mv gles2_bc_mmap gles2_bc_mmap-fb
	mv gles2_bc_webcam gles2_bc_webcam-fb

	oe_runmake GLES_20=1 -e clean
	CFLAGS="${CFLAGS} -DX11" oe_runmake -e GLES_20=1 X11BUILD=1
	mv gles2_bc_webcam gles2_bc_webcam-x11

}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/test/gles2_bc_mmap-* ${D}${bindir}
	install -m 0755 ${S}/test/gles2_bc_webcam-* ${D}${bindir}

	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/bc-cube.desktop ${D}${datadir}/applications/
}

PACKAGES =+ "${PN}-fb ${PN}-x11"
FILES_${PN}-x11 = "${bindir}/*x11 ${datadir}/applications"
FILES_${PN}-fb = "${bindir}/*fb"

