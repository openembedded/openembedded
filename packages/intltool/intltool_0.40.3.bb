require intltool.inc

PR = "r1"

do_configure_append() {
	sed -i -e s:head\ -1:head\ -n1:g intltool.m4 
}	
