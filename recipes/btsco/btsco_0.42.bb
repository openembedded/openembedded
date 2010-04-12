require btsco.inc

#there are some bogus macros putting -I/usr/include into C(PP)FLAGS, lets fix that
do_configure() {
	libtoolize --force
	gnu-configize
	sed -i 's:-I${bluez_prefix}/include::g' configure
	oe_runconf
}

SRC_URI[md5sum] = "b0b6bc4d6df04468349f2ad320b05fa9"
SRC_URI[sha256sum] = "e4f5bc9be311a746bd37f5607d3c225462d7d9294e8b3c692f9a39717b65d843"
