require intltool.inc

PR = "r2"

do_configure_prepend() {
	sed -i -e s:\\\$\(PERL\):/usr/bin/perl:g Makefile.am
}	

do_configure_append() {
	sed -i -e s:head\ -1:head\ -n1:g intltool.m4 
}	
