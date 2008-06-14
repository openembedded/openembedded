DESCRIPTION = "Drop-in Esound replacement"
LICENSE = "GPLv2"

PR = "r1"

RCONFLICTS = "esd"
RREPLACES = "esd"

RDEPENDS = " \
	pulseaudio-server \
	pulseaudio-misc \
	pulseaudio-lib-protocol-esound \
	pulseaudio-module-esound-compat-spawnfd \
	pulseaudio-module-esound-compat-spawnpid \
	pulseaudio-module-esound-protocol-tcp \
	pulseaudio-module-esound-protocol-unix \
"

do_install() {
	install -d ${D}/${bindir}
	ln -sf ${bindir}/esdcompat ${D}/${bindir}/esd 
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
        sed -i -e /load-module\ module-esound-protocol-unix/d -e /load-module\ module-esound-protocol-tcp/d /etc/pulse/session
fi
# Load esound modules
echo "load-module module-esound-protocol-tcp" >> /etc/pulse/session
echo "load-module module-esound-protocol-unix" >> /etc/pulse/session
}

