require pulseaudio.inc

DEPENDS += "gdbm speex"
PR = "${INC_PR}.6"

inherit gettext

SRC_URI += "\
  file://buildfix.patch;patch=1 \
  file://alsaerror.patch;patch=1 \
  file://periodfix.patch;patch=1 \
  file://fallback.patch;patch=1 \
  file://autoconf_version.patch;patch=1 \
  file://gettext.patch;patch=1 \
  file://fixbluezbuild.patch;patch=1 \
  file://tls_m4.patch;patch=1 \
  file://sbc-thumb.patch;patch=1 \
  file://CVE-2009-1299.patch;patch=1 \
  file://CVE-2009-1894.patch;patch=1 \
"

do_compile_prepend() {
    cd ${S}
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}

SRC_URI[md5sum] = "4510364eeab219fd100bd1b373b1a002"
SRC_URI[sha256sum] = "1e8ad5b7c5cf3485bd0738c296274ff2c99d26d12a25a225dc250eddea25b9f1"
