DESCRIPTION = "Meta package to make alsa transparently use pulseaudio"
LICENSE = "GPLv2"

PR = "r1"

SRC_URI = "file://asound.conf.pulseaudio"

RDEPENDS = "hal \
	pulseaudio-server \
	pulseaudio-misc \
	pulseaudio-module-alsa-sink \
	pulseaudio-module-alsa-source \
	pulseaudio-module-hal-detect \
	pulseaudio-module-volume-restore \
	pulseaudio-module-default-device-restore \
	pulseaudio-module-rescue-streams \
	pulseaudio-module-suspend-on-idle \
	libasound-module-ctl-pulse \
	libasound-module-pcm-pulse \
"

do_install() {
	install -d ${D}/${sysconfdir}
	install -m 0644 ${WORKDIR}/asound.conf.pulseaudio ${D}/${sysconfdir}
}

PACKAGE_ARCH = "all"

pkg_postinst_${PN} () {
#!/bin/sh
if [ "x$D" != "x" ]; then
        exit 1
fi

mkdir -p /etc/pulse || true
# Remove existing entries
if [ -e /etc/pulse/session ] ; then
        sed -i -e /load-module\ module-hal-detect/d /etc/pulse/session
fi
# Load hal-detect module to avoid alsa->pulse-alsa-pulse->.. loops
echo "load-module module-hal-detect" >> /etc/pulse/session
}

