require btsco.inc

#there are some bogus macros putting -I/usr/include into C(PP)FLAGS, lets fix that
do_configure() {
	libtoolize --force
	gnu-configize
	sed -i 's:-I${bluez_prefix}/include::g' configure
	oe_runconf
}
