DESCRIPTION = "Industrial is a flat looking theme engine for GTK+ 1.x"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "gtk+-1.2"

SRC_URI = "http://jlime.com/downloads/development/software/gtk-engine-industrial-0.2.36.tar.gz"

FILES_${PN} = "/etc/gtk /usr/lib/gtk/themes/engines /usr/share/themes"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "88513408ab24c5a97cacc9ff55e79d2d"
SRC_URI[sha256sum] = "a8ccf2c029490bcef947359635622674ef00e9b873e37fc5fee728f71c2a8b07"
