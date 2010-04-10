require gtkmm.inc

PR = "r0"

# Hack! Remove once gtkmm likes libtool 2x
do_configure() {
	gnu-configize
	oe_runconf
}	

SRC_URI[archive.md5sum] = "ad199f4a392799134c128deab48fee30"
SRC_URI[archive.sha256sum] = "4e58c9ad827759a2375b3c0d39952b5b2983111ab16ee329b10a34792fb1d9eb"
