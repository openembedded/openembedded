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
