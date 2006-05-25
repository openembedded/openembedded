SECTION = "console/network"
DEPENDS = readline
LICENSE = "GPL"
	       
inherit autotools

EXTRA_OECONF='--disable-cups --with-readline=${STAGING_LIBDIR}/.. \
	      --without-ads --without-automount --without-smbmount --without-syslog \
	      --without-ldapsam --without-quotas --without-nisplus-home \
	      --without-sys-quotas --without-libsmbclient --without-winbind \
	      --without-acl-support'
	      
do_configure_prepend () {
	./script/mkversion.sh
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}

do_compile () {
	oe_runmake proto_exists
	base_do_compile
}

do_install_append() {
	rm -f ${D}${bindir}/*.old
	rm -f ${D}${sbindir}/*.old
	
	mkdir -p ${D}/sbin/
}

do_install_prepend() {

        mkdir -p ${D}/sbin/
       
}

