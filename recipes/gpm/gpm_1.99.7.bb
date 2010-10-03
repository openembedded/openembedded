DESCRIPTION = "GPM (General Purpose Mouse) is a mouse server \
for the console and xterm, with sample clients included \
(emacs, etc)."
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "ncurses"

PR = "r1"

SRC_URI = "ftp://arcana.linux.it/pub/gpm/gpm-${PV}.tar.bz2 \
	   file://no-docs.patch \
	   file://processcreds.patch \
	   file://init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "gpm"
INITSCRIPT_PARAMS = "defaults"

#export LIBS = "-lm"

do_install () {
	oe_runmake 'ROOT=${D}' install
	install -m 0644 src/headers/gpm.h ${D}${includedir}
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/gpm
	cd ${D}${libdir} && ln -sf libgpm.so.1.19.0 libgpm.so.1
}
SRC_URI[md5sum] = "9fdddf5f53cb11d40bb2bb671d3ac544"
SRC_URI[sha256sum] = "6071378b24494e36ca3ef6377606e7e565040413c86704753a162d2180af32ee"

