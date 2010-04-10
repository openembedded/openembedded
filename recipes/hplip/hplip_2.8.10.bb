DESCRIPTION = "HP Linux Imaging and Printing"
LICENSE = "GPL, MIT"

# currently, we build a stripped down version that only includes IJS
# and components required to implement a minimal printing system
# for embedded systems.

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz \
           file://cross-build.patch;patch=1"

PR = "r1"

inherit autotools

EXTRA_OECONF = ' \
                BUILD_SYS="" HOST_SYS="" \
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

PACKAGES += "${PN}-ppd ${PN}-cups ${PN}-backend"

# need to snag the debug file or OE will fail on backend package
FILES_${PN}-dbg += "\
     ${libdir}/cups/backend/.debug

FILES_${PN}-ppd = "\
     ${datadir}/ppd"

FILES_${PN}-cups = "\
     ${datadir}/cups"

FILES_${PN}-backend = "\
     ${libdir}/cups/backend"


SRC_URI[md5sum] = "a9ad78c4f0d884caac6b176b3cb9bf21"
SRC_URI[sha256sum] = "8e34e2bc5974fd0f4ab71fbb42ac76fe3074fb2a09960452e4a1a157a77e00f1"
