SECTION = "unknown"
DESCRIPTION = "Murasaki automatically loads and unloads modules for \
USB, Cardbus, and other hot-pluggable devices using the new Hotplug \
feature in Linux 2.4."
LICENSE = "GPL"
SRC_URI = "http://www.dotaster.com/~shuu/linux/murasaki/0.8/8/murasaki-${PV}.tar.gz \
	   file://fix-compile.patch;patch=1"

EXTRA_OEMAKE = 'OPT="-DPATH_MAX" DEBUG= INC="-I ../inc ${CFLAGS}"'

do_install () {
	install -d ${D}${base_sbindir} ${D}${sysconfdir}/${PN} \
		   ${D}${sysconfdir}/init.d
	oe_runmake install 'BIN_DIR=${D}${base_sbindir}' 'CONF_DIR=${D}${sysconfdir}/${PN}' \
		   'RC_DIR=${D}${sysconfdir}/rc.d' \
		   'RC_INIT_DIR=${D}${sysconfdir}/init.d' \
		   'INST_SCRIPT_DIR=${D}${sysconfdir}/murasaki' \
		   'INST_FIRMWARE_DIR=${D}${sysconfdir}/firmware'
}
