DESCRIPTION = "Bonjour is a networking technology that lets you create an instant network of computers and devices without any configuration."
SECTION = "network"
LICENSE = "Apache-2.0"

RDEPENDS_bonjour = "update-rc.d"

PR = "r3"

SRC_URI = "http://www.opensource.apple.com/darwinsource/tarballs/other/mDNSResponder-${PV}.tar.gz \
           file://bonjour.conf \
           file://bonjour.init \
          "

S = "${WORKDIR}/mDNSResponder-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "bonjour"
INITSCRIPT_PARAMS = "defaults 50"

EXTRA_OEMAKE = 'CC="${CC} ${LDFLAGS}" os=linux -C ${S}/mDNSPosix SAResponder'
PARALLEL_MAKE = ""

do_install() {

	install -d ${D}${sbindir}
	install -m 0755 mDNSPosix/build/prod/mDNSResponderPosix ${D}${sbindir}/mdnsd

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/bonjour.init	${D}${sysconfdir}/init.d/bonjour
	install -m 0640 ${WORKDIR}/bonjour.conf ${D}${sysconfdir}/

}

SRC_URI[md5sum] = "aa4e0e5c57f94489463ea6576591ce9d"
SRC_URI[sha256sum] = "43d427d3d5c78aef57a49898def469cc4cae28190462205368be1f3a0fcc0165"
