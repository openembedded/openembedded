DESCRIPTION = "Meta package to enable zeroconf audio with pulseaudio"
DEPENDS = "avahi pulseaudio"
RDEPENDS = "pulseaudio-module-zeroconf-publish avahi-daemon"

do_compile() {
	:
}

PACKAGE_ARCH = "all"
ALLOW_EMPTY_${PN} = "1"

pkg_postinst_${PN} () {
#!/bin/sh
if [ "x$D" != "x" ]; then
        exit 1
fi

mkdir -p /etc/pulse || true
# Remove existing entries
if [ -e /etc/pulse/session ] ; then
	sed -i -e /load-module\ module-native-protocol-tcp/d -e /load-module\ module-zeroconf-publish/d /etc/pulse/session
fi
# Enable network and zeroconf plugins, allow localhost and usbnet access (where available)
echo "load-module module-native-protocol-tcp auth-ip-acl=127.0.0.1;192.168.0.0/16" >> /etc/pulse/session
echo "load-module module-zeroconf-publish" >> /etc/pulse/session
}
