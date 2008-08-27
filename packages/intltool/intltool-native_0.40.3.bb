require intltool_${PV}.bb

PR = "r1"

inherit native
DEPENDS = "libxml-parser-perl-native"

export PERL = "/usr/bin/env perl"

do_configure_prepend() {
	cd ${S}
	for i in intltool*.in ; do 
	 	sed -i -e s:-w::g $i 
	done	
}
