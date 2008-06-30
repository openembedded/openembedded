DESCRIPTION = "Pulseaudio Meta package w/ initscript et. al."
SECTION = "audio"
RDEPENDS = "\
  pulseaudio-server \
  pulseaudio-module-alsa-sink \
  pulseaudio-module-alsa-source \
  pulseaudio-module-cli \
  pulseaudio-module-esound-protocol-unix \
  pulseaudio-module-simple-protocol-tcp \
  pulseaudio-module-native-protocol-unix \
  pulseaudio-module-cli-protocol-unix \
  pulseaudio-module-suspend-on-idle \
  gst-plugin-pulse \
  libasound-module-ctl-pulse \
  libasound-module-pcm-pulse \
"
PR = "r1"

inherit update-rc.d

INITSCRIPT_NAME = "pulseaudio"
INITSCRIPT_PARAMS = "defaults 35"

SRC_URI = "\
  file://pulseaudio \
  file://session \
  file://asound.conf \
"
S = "${WORKDIR}"

do_install() {
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/pulseaudio ${D}/${sysconfdir}/init.d/
    install -d ${D}/${sysconfdir}/pulse
	install -m 0755 ${WORKDIR}/session ${D}/${sysconfdir}/pulse/session
	install -m 0644 ${WORKDIR}/asound.conf ${D}/${sysconfdir}
}

PACKAGE_ARCH = "all"

CONFFILES_${PN} = "\
  ${sysconfdir}/pulse/session \
  ${sysconfdir}/asound.conf \
"
