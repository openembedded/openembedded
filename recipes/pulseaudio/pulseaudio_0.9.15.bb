require pulseaudio.inc

DEPENDS += "gdbm speex"
PR = "${INC_PR}.6"

inherit gettext

SRC_URI += "\
  file://configure-ac.patch \
  file://buildfix.patch \
  file://alsaerror.patch \
  file://periodfix.patch \
  file://fallback.patch \
  file://autoconf_version.patch \
  file://gettext.patch \
  file://fixbluezbuild.patch \
  file://tls_m4.patch \
  file://sbc-thumb.patch \
  file://CVE-2009-1299.patch \
  file://CVE-2009-1894.patch \
"

do_compile_prepend() {
    cd ${S}
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}

SRC_URI[md5sum] = "4510364eeab219fd100bd1b373b1a002"
SRC_URI[sha256sum] = "1e8ad5b7c5cf3485bd0738c296274ff2c99d26d12a25a225dc250eddea25b9f1"
