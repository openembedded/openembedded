DESCRIPTION = "Framebuffer VNC server"
LICENSE = "GPL"
SECTION = "console/utils"
#DEPENDS = "libvncserver jpeg zlib"
# using older version due of error with libvncserver-0.7.1
# fbvncserver.c:577: error: structure has no member named `rfbAlwaysShared'
# fbvncserver.c:602: error: structure has no member named `rfbClientHead'
DEPENDS = "libvncserver-0.6 jpeg zlib"
RDEPENDS = "fbvncserver-kmodule libvncserver-storepasswd libvncserver-javaapplet"
PR = "r2"

SRC_URI = "http://sdgsystems.com/download/fbvncserver-${PV}.tar.gz \
           file://libvncs0.6.patch;patch=1 \
           file://paths.patch;patch=1 \
           file://kernelinclude.patch;patch=1 \
	   file://buildfix.patch;patch=1 \
	   file://ipaq.patch;patch=1 \
           file://init"
	  
S = "${WORKDIR}/fbvncserver-${PV}"

export INCLUDES = "-I${STAGING_INCDIR}"

export LIBS = "-L${STAGING_LIBDIR} -lpthread"
export VNCSERVER_DIR = "${STAGING_LIBDIR}"
export ZAURUS_ZLIB_LIBS = "${STAGING_LIBDIR}"
export ZAURUS_JPEG_LIBS = "${STAGING_LIBDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "fbvncinput"
INITSCRIPT_PARAMS = "defaults 97"

FBVNCSERVER_SYSTEM = "zaurus"
FBVNCSERVER_SYSTEM_h3600 = "ipaq"
FBVNCSERVER_SYSTEM_h3900 = "ipaq"

do_compile () {
	oe_runmake ${FBVNCSERVER_SYSTEM}_fbvncserver ${FBVNCSERVER_SYSTEM}_tssimd
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${FBVNCSERVER_SYSTEM}_fbvncserver ${D}${bindir}/fbvncserver
	install -m 0755 ${FBVNCSERVER_SYSTEM}_tssimd ${D}${bindir}/tssimd
	
	install -d ${D}${datadir}/fbvncserver
	install -m 0644 ${FBVNCSERVER_SYSTEM}_panel.jpg ${D}${datadir}/fbvncserver/
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/fbvncinput
}

FILES_${PN} += " /usr/share/fbvncserver/*.jpg"

