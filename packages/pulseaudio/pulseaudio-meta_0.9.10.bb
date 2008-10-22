DESCRIPTION = "Pulseaudio Meta package w/ initscript et. al."
SECTION = "audio"
RDEPENDS = "\
  pulseaudio-server \
  pulseaudio-module-alsa-sink \
  pulseaudio-module-alsa-source \
  pulseaudio-module-cli \
  pulseaudio-module-default-device-restore \
  pulseaudio-module-detect\
  pulseaudio-module-esound-protocol-unix \
  pulseaudio-module-simple-protocol-tcp \
  pulseaudio-module-native-protocol-unix \
  pulseaudio-module-cli-protocol-unix \
  pulseaudio-module-rescue-streams\
  pulseaudio-module-suspend-on-idle \
  pulseaudio-module-volue-restore \
  gst-plugin-pulse \
  libasound-module-ctl-pulse \
  libasound-module-pcm-pulse \
"
PR = "r3"

inherit update-rc.d

export TARGET_PFPU = "${TARGET_FPU}"
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
	install -m 0755 ${WORKDIR}/session ${D}/${sysconfdir}/pulse/session.pulseaudio-meta
	install -m 0644 ${WORKDIR}/asound.conf ${D}/${sysconfdir}/asound.conf.pulseaudio-meta

    if [ "x${TARGET_PFPU}" == "xsoft" ] ; then
         sed -i -e s:resample-method=sinc-fastest:resample-method=trivial: ${D}${sysconfdir}/init.d/pulseaudio
    fi
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

pkg_postinst_${PN} () {
#!/bin/sh
if [ "x$D" != "x" ]; then
        exit 1
fi

# Overwrite existing configfiles, yuck!
cp /etc/pulse/session.pulseaudio-meta /etc/pulse/session
cp /etc/asound.conf.pulseaudio-meta /etc/asound.conf
}


CONFFILES_${PN} = "\
  ${sysconfdir}/init.d/pulseaudio \
  ${sysconfdir}/pulse/session.pulseaudio-meta \
  ${sysconfdir}/asound.conf.pulseaudio-meta \
"
