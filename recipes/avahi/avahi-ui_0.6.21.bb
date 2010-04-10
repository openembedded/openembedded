require avahi.inc

PR = "r8"

DEPENDS += "avahi gtk+"

SRC_URI += "file://dbus-pre-1.1.1-support.patch;patch=1"
AVAHI_GTK = "--enable-gtk"

S = "${WORKDIR}/avahi-${PV}"

do_stage() {
        install -d ${STAGING_INCDIR}/avahi-ui
	cp ${S}/avahi-ui/*.h ${STAGING_INCDIR}/avahi-ui/
        oe_libinstall -C avahi-ui -a -so libavahi-ui ${STAGING_LIBDIR}
}

PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${libdir}/libavahi-ui*.so.*"
FILES_${PN}-dbg += "${libdir}/.debug/libavah-ui*"

SRC_URI[md5sum] = "9cc68f79c50c9dd9e419990c3c9b05b9"
SRC_URI[sha256sum] = "d817c35f43011861476eab02eea14edd123b2bc58b4408d9d9b69b0c39252561"
