DESCRIPTION = "framebuffer VNC server"
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "libvncserver jpeg zlib"
RDEPENDS = "fbvncserver-kmodule libvncserver-storepasswd libvncserver-javaapplet"
PR = "r1"

SRC_URI = "http://sdgsystems.com/download/fbvncserver-${PV}.tar.gz \
           file://libvncs0.6.patch;patch=1 \
           file://paths.patch;patch=1 \
           file://kernelinclude.patch;patch=1 \
           file://zaurus_panel.jpg \
           file://init"
	  
export INCLUDES = "-I${STAGING_INCDIR}"

export LIBS = "-L${STAGING_LIBDIR} -lpthread"
export VNCSERVER_DIR = "${STAGING_LIBDIR}"
export ZAURUS_ZLIB_LIBS = "${STAGING_LIBDIR}"
export ZAURUS_JPEG_LIBS = "${STAGING_LIBDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "fbvncinput"
INITSCRIPT_PARAMS = "defaults 97"

do_compile () {
	oe_runmake zaurus_fbvncserver zaurus_tssimd
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 zaurus_fbvncserver ${D}${bindir}/fbvncserver
	install -m 0755 zaurus_tssimd ${D}${bindir}/tssimd
	
	install -d ${D}${datadir}/fbvncserver
	install -m 0644 ${WORKDIR}/zaurus_panel.jpg ${D}${datadir}/fbvncserver/
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/fbvncinput
}
