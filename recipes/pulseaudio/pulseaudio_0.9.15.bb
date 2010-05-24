require pulseaudio.inc

DEPENDS += "gdbm speex"
PR = "${INC_PR}.6"

inherit gettext

SRC_URI += "\
  file://buildfix.patch;apply=yes \
  file://alsaerror.patch;apply=yes \
  file://periodfix.patch;apply=yes \
  file://fallback.patch;apply=yes \
  file://autoconf_version.patch;apply=yes \
  file://gettext.patch;apply=yes \
  file://fixbluezbuild.patch;apply=yes \
  file://tls_m4.patch;apply=yes \
  file://sbc-thumb.patch;apply=yes \
  file://CVE-2009-1299.patch;apply=yes \
  file://CVE-2009-1894.patch;apply=yes \
"

do_compile_prepend() {
    cd ${S}
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}

SRC_URI[md5sum] = "4510364eeab219fd100bd1b373b1a002"
SRC_URI[sha256sum] = "1e8ad5b7c5cf3485bd0738c296274ff2c99d26d12a25a225dc250eddea25b9f1"
