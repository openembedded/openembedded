DESCRIPTION = "Telepathy Mission Control"
HOMEPAGE = "http://mission-control.sourceforge.net/"
LICENSE = "LGPL"
SECTION = "libs"
DEPENDS = "libtelepathy dbus-glib gconf"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/mission-control/telepathy-mission-control-${PV}.tar.gz"

inherit autotools_stage 

PACKAGES =+ " \
	libmissioncontrol \
	libmissioncontrol-config \
	libmissioncontrol-server \
	libmissioncontrol-dev \
	libmissioncontrol-config-dev \
	libmissioncontrol-server-dev \
	libmissioncontrol-dbg \
	libmissioncontrol-config-dbg \
	libmissioncontrol-server-dbg \
"

FILES_${PN} += "${datadir}/dbus*"

FILES_libmissioncontrol = "${libdir}/libmissioncontrol.so.*"
FILES_libmissioncontrol-config = "${libdir}/libmissioncontrol-config.so.*"
FILES_libmissioncontrol-server = "${libdir}/libmissioncontrol-server.so.*"

FILES_libmissioncontrol-dev = "${libdir}/libmissioncontrol.* \
                               ${includedir}/libmissioncontrol/ \
                	       ${libdir}/pkgconfig/libmissioncontrol.pc"
FILES_libmissioncontrol-config-dev = "${libdir}/libmissioncontrol-config.*"
FILES_libmissioncontrol-server-dev = "${libdir}/libmissioncontrol-server.*"

FILES_libmissioncontrol-dbg += "${libdir}/.debug/libmissioncontrol.so.*"
FILES_libmissioncontrol-config-dbg += "${libdir}/.debug/libmissioncontrol-config.so.*"
FILES_libmissioncontrol-server-dbg += "${libdir}/.debug/libmissioncontrol-server.so.*"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_append() {
        for i in ${S}/*.pc ; do
            sed -i -e s:${STAGING_DIR_TARGET}::g \
                   -e s:/${TARGET_SYS}::g \
                      $i
        done
}


SRC_URI[md5sum] = "0a547e7af4a33355bac3638dd2e40859"
SRC_URI[sha256sum] = "326b82519a49a238a476c028097bde5820c4b58af500dbb5b715cdfd6fe0bfcd"
