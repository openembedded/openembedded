DESCRIPTION = "Conserver provides remote access to serial port \
consoles and logs all data to a central host."
HOMEPAGE = "http://www.conserver.com/"
SECTION = "console/network"
LICENSE = "BSD"

SRC_URI = "http://www.conserver.com/conserver-${PV}.tar.gz \
           file://conserver.init \
           file://conserver.default"

inherit autotools update-rc.d

# Stop install being called with -s so it doesn't try and run the host strip command
EXTRA_OEMAKE = " INSTALL_PROGRAM=install"

# Include the init script and default settings in the package
do_install_append () {
        install -m 0755 -d ${D}${sysconfdir}/default ${D}${sysconfdir}/init.d
        install -m 0644 ${WORKDIR}/conserver.default ${D}${sysconfdir}/default/conserver
        install -m 0755 ${WORKDIR}/conserver.init ${D}${sysconfdir}/init.d/conserver
}

# Include the examples in the documentation package
FILES_${PN}-doc += "${datadir}/examples/conserver"

# Make sure .debug files end up in the correct place
FILES_${PN} = "${sysconfdir} ${bindir}/* ${libdir}/${PN}/* ${sbindir}/*"
FILES_${PN}-dbg = "${bindir}/.debug ${sbindir}/.debug ${libdir}/${PN}/.debug"

# Indicate that the default file is a configuation file
CONFFILES_${PN} = "${sysconfdir}/default/conserver"

# Settings for the initscript
INITSCRIPT_NAME = "conserver"
INITSCRIPT_PARAMS = "defaults 98 2"
