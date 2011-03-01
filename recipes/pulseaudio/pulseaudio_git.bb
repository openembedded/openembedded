require pulseaudio.inc

SRCREV = "f834150aceccd753e3ac5bab9f7d64bed9993624"
PV = "0.9.22+git"
PR = "${INC_PR}.0-r${SRCPV}"

DEPENDS += "orc gdbm speex"

DEFAULT_PREFERENCE = "-1"

FILESPATHPKG =. "pulseaudio-0.9.21:"

inherit gettext

SRC_URI = "git://git.0pointer.de/pulseaudio.git;protocol=git \
           file://gcc4-compile-fix.patch \
           file://volatiles.04_pulse \
           file://autoconf_version.patch \
           file://tls_m4.patch \
"

S = "${WORKDIR}/git"

do_configure_prepend() {
	touch config.rpath
}

# orc.m4 calls pkg-config ----variable=orcc orc-0.4 to get the path to orcc,
# resulting in /usr/bin/orcc. Force it to use the staged orcc.
do_configure_append() {
    for i in $(find ${S} -name "Makefile") ; do
        sed -i -e s:${bindir}/orcc:${STAGING_BINDIR_NATIVE}/orcc:g $i
    done
}


