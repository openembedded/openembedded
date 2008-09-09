require intltool.inc

PR = "r2"

EXTRA_OEMAKE = "'PERL_TARGET=/usr/bin/perl'"

do_configure_prepend() {
	sed -i -e s:\\\$\(PERL\):\$\(PERL_TARGET\):g Makefile.am
}	

do_configure_append() {
	sed -i -e s:head\ -1:head\ -n1:g intltool.m4 
}	
