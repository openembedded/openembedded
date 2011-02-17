# Copyright (C) 2011 Bug Labs, Inc

PR = "r88"

ALLOW_EMPTY = "1"

PACKAGES += "${PN}-java ${PN}-java-osgi ${PN}-audio ${PN}-devlangs ${PN}-x11 ${PN}-network ${PN}-x11-debug ${PN}-debug"

PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "${MACHINE_EXTRA_RRECOMMENDS} \
                  bug-udev \
                  repo-feed-configs \
                  diffutils \
                  logrotate \
                  bug-logrotate \
                  lrzsz \
                  kernel-headers \
                  ntpclient \
                  tzdata \
                  nano \
                  lsof \
                  file \
"
RDEPENDS_${PN}_append_bug20 = "bug2v4l2"

RDEPENDS_${PN}-network = "\
                  dnsmasq \
                  hostap-daemon \
                  iptables \
                  eject \
                  usb-modeswitch \
                  iperf \
		  connman \
		  connman-plugin-wifi \
#		  connman-plugin-ofono \
#		  connman-plugin-ethernet \
"

RDEPENDS_${PN}-x11-debug = "\
                  xinput \
                  xsetroot \
                  xrandr \
                  x11vnc \
                  "

RDEPENDS_${PN}-debug = "\
                  ${PN}-x11-debug \
                  tslib-tests \
                  tslib-calibrate \
"

RDEPENDS_${PN}-x11 = "\
                  dbus-x11 \
                  matchbox-theme-bug-dark \
                  mb-bug-icon-theme \
                  pcmanfm \
                  bug-reboot-icon \
                  bug-shutdown-icon \
                  xinput-calibrator \
                  synergy \
"

RDEPENDS_${PN}-devlangs = "\
                  ruby \
                  lua5.1 \
                  python-modules \
                  python-misc \
		  python-pygobject \
		  python-dbus \
		  python-pybluez \
                  perl-modules \
                  task-native-sdk \
"

RDEPENDS_${PN}-java =  " \
                  openjdk-6-jre \
                  felix-init \
		  felix \
		  felix-configadmin \
                  zip \
"

RDEPENDS_${PN}-java-osgi =  " \
                  ${PN}-java \
                  com.buglabs.app.appui \
                  com.buglabs.bug.base \
                  com.buglabs.bug.bmi \
                  com.buglabs.bug.event \
                  com.buglabs.bug.jni.common \
		  com.buglabs.bug.jni.accelerometer \
                  com.buglabs.bug.jni.gps \
                  com.buglabs.bug.jni.input \
                  com.buglabs.bug.jni.lcd \
                  com.buglabs.bug.jni.rxtx \
                  com.buglabs.bug.jni.vonhippel \
                  com.buglabs.bug.jni.camera \
                  com.buglabs.bug.module.camera \
                  com.buglabs.bug.module.vonhippel \
                  com.buglabs.bug.module.gps \
                  com.buglabs.bug.module.lcd \
		  com.buglabs.bug.module.video \
                  com.buglabs.bug.module \
                  com.buglabs.bug.program \
                  com.buglabs.bug.service \
                  com.buglabs.common \
                  com.buglabs.nmea \
                  com.buglabs.osgi.http \
                  com.buglabs.osgi.sewing \
                  com.buglabs.osgi.shell \
                  com.sun.javax.servlet \
                  com.buglabs.bug.jni.libmatthew \
                  org.freedesktop.dbus \
	          bug-avahi \
"

RDEPENDS_${PN}-audio = "\
                  alsa-state \
                  alsa-utils-alsamixer \
                  alsa-utils-midi \
                  alsa-utils-aplay \
                  alsa-utils-amixer \
                  alsa-utils-aconnect \
                  alsa-utils-iecset \
                  alsa-utils-speakertest \
                  alsa-utils-aseqnet \
                  alsa-utils-alsactl \
"
