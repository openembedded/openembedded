DESCRIPTION = "HP Linux Imaging and Printing"
LICENSE = "GPL, MIT, BSD"

# currently, we build a stripped down version that only includes IJS
# and components required to implement a minimal printing system
# for embedded systems.

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz \
	"

PR = "r1"
DEFAULT_PREFERENCE = "-1"

inherit autotools

EXTRA_OECONF = ' \
                BUILD_SYS="" HOST_SYS="" \
		--enable-hpijs-install \
                --disable-network-build \
                --disable-doc-build \
                --disable-pp-build \
                --disable-scan-build \
                --disable-gui-build \
                --disable-fax-build \
                --disable-dbus-build \
                --disable-foomatic-drv-install \
                --disable-foomatic-rip-hplip-install \
               '

# needed by python checks in configure
EXTRA_OEMAKE = 'BUILD_SYS="" HOST_SYS=""'

PACKAGES += "${PN}-ppd ${PN}-cups ${PN}-backend ${PN}-filter"
RDEPENDS_${PN} += "python-syslog python-pprint python-compression python-shell python-xml python-unixadmin python-html python-resource python-terminal"

# need to snag the debug file or OE will fail on backend package
FILES_${PN}-dbg += "\
     ${libdir}/cups/backend/.debug \
     ${libdir}/python2.6/site-packages/.debug \
     ${libdir}/cups/filter/.debug "

FILES_${PN}-ppd = "\
     ${datadir}/ppd"

FILES_${PN}-cups = "\
     ${datadir}/cups"

FILES_${PN}-backend = "\
     ${libdir}/cups/backend"

FILES_${PN}-filter = "\
     ${libdir}/cups/filter"

FILES_${PN} += "\
     ${libdir}/python2.6/site-packages/*.so"

SRC_URI[md5sum] = "96c36e3baf35e93cf9436a772f0c9ef4"
SRC_URI[sha256sum] = "3ee0e68a613d2b966dcb6df9fd8e074c4c3e590249e61c0d792de3373b84fdeb"

