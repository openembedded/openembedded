DESCRIPTION = "Pulseaudio is a sound server for Linux and Unix-like operating systems."
HOMEPAGE = "http://www.pulseaudio.org"
AUTHOR = "Lennart Poettering"
SECTION = "libs/multimedia"
LICENSE = "LGPL"

DEPENDS = "liboil avahi libsamplerate0 libsndfile1 libtool"
# optional
DEPENDS += "alsa-lib"

RPROVIDES = "esound esd"

PR = "r4"

SRC_URI = "http://0pointer.de/lennart/projects/pulseaudio/pulseaudio-${PV}.tar.gz"

SRC_URI += "file://volatiles.04_pulse"


inherit autotools pkgconfig

EXTRA_OECONF = "\
                --disable-lynx \
		--without-x \
		--without-glib \
		--without-jack \
		--with-alsa \
		--with-oss \
		"

PARALLEL_MAKE = ""


do_install_append() {
	install -m 0644 ${WORKDIR}/volatiles.04_pulse  ${D}${sysconfdir}/default/volatiles/volatiles.04_pulse
}


LEAD_SONAME = "libpulse.so"

PACKAGES =+ "${PN}-bin ${PN}-conf"
PACKAGES_DYNAMIC = "pulseaudio-module-* pulseaudio-lib-*"

FILES_${PN}-conf = "${sysconfdir}"
FILES_${PN}-bin = "${bindir}/* \
                   ${sysconfdir}/default/volatiles/volatiles.04_pulse"

CONFFILES_${PN}-conf = "\ 
                       ${sysconfdir}/pulse/default.pa \
		       ${sysconfdir}/pulse/daemon.conf \
		       ${sysconfdir}/pulse/client.conf \
		       "
pkg_postinst_${PN}-bin() {
if test "x$D" != "x"; then
        exit 1
else
        grep -q pulse: /etc/group || addgroup pulse
        grep -q pulse: /etc/passwd || \
            adduser --disabled-password --home=/var/run/pulse/ --system \
                    --ingroup pulse --no-create-home -g "Pulse audio daemon" pulse                                            
        /etc/init.d/populate-volatile.sh update
fi
}

pkg_postrm${PN}-bin() {
if test "x$D" != "x"; then
        exit 1
else
        deluser pulse
fi
}




do_stage() {
	autotools_stage_all
}


python populate_packages_prepend() {
        #bb.data.setVar('PKG_pulseaudio', 'pulseaudio', d)

        plugindir = bb.data.expand('${libdir}/pulse-0.9/modules/', d)
        do_split_packages(d, plugindir, '^module-(.*)\.so$', 'pulseaudio-module-%s', 'PulseAudio module for %s', extra_depends='' )
	do_split_packages(d, plugindir, '^lib(.*)\.so$', 'pulseaudio-lib-%s', 'PulseAudio library for %s', extra_depends='' )
}
