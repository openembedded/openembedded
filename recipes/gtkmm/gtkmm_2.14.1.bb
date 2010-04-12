require gtkmm.inc

DEPENDS += "pangomm"

PR = "r0"

# Hack! Remove once gtkmm likes libtool 2x
do_cconfigure() {
	gnu-configize
	oe_runconf
}	

SRC_URI[archive.md5sum] = "0209b424987a74c956ea6b70fddaaa37"
SRC_URI[archive.sha256sum] = "f8675340d929346333b5a58cd4d05482dd8b76cf8606fed85b526022bf9c5e47"
