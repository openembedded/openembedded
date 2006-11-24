DESCRIPTION = "Bluetooth-alsa headset tool"
HOMEPAGE = "http://bluetooth-alsa.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "alsa-lib bluez-libs"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/bluetooth-alsa/btsco-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"

CFLAGS += " -I${STAGING_INCDIR} "

#there are some bogus macros putting -I/usr/include into C(PP)FLAGS, lets fix that
do_configure() {
	libtoolize --force
	gnu-configize 
	sed -i 's:-I${bluez_prefix}/include::g' configure
	oe_runconf
}	
