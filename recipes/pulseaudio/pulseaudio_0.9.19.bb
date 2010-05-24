require pulseaudio.inc

DEPENDS += "gdbm speex"

DEFAULT_PREFERENCE_om-gta01 = "-1"
DEFAULT_PREFERENCE_om-gta02 = "-1"
DEFAULT_PREFERENCE_motorola-ezx = "-1"

PR = "${INC_PR}.0"

inherit gettext

SRC_URI += "\
  file://buildfix.patch;apply=yes \
  file://autoconf_version.patch;apply=yes \
  file://tls_m4.patch;apply=yes \
  file://configure_silent_rules.patch;apply=yes \
  file://gettext.patch;apply=yes \
  file://fixbluezbuild.patch;apply=yes \
"

do_compile_prepend() {
    cd ${S}
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}

SRC_URI[md5sum] = "02adc2b99252675f0271db3b9edd432e"
SRC_URI[sha256sum] = "e47e27083deb79571fb2b9215874ddc26d77c3dec2a7dc8de5ecec9058e4b806"
