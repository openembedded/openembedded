require avrdude.inc

# Patches courtesy of Debian/Ubuntu
SRC_URI += "\
	file://02-manpage_fix.patch \
	file://03-fix_auto_reset.patch \
"

PR = "r2"

SRC_URI[md5sum] = "69b082683047e054348088fd63bad2ff"
SRC_URI[sha256sum] = "81501b63d5b8699874d00c9eca42837b85695bc0820ba9843b17f573ce38be5e"
