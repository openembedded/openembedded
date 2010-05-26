DESCRIPTION = "read-edid elucidates various very useful informations from a conforming PnP monitor"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://john.fremlin.de/programs/linux/read-edid/read-edid-${PV}.tar.gz;name=archive \
           http://ftp.de.debian.org/debian/pool/main/r/read-edid/read-edid_1.4.1-2.1.diff.gz;name=patch "

inherit autotools

do_compile() {
	oe_runmake parse-edid get-edid
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 0755 parse-edid ${D}/${sbindir}/
	install -m 0755 get-edid ${D}/${sbindir}/
}

PACKAGES =+ "parse-edid get-edid"
FILES_parse-edid = "${sbindir}/parse-edid"
FILES_get-edid = "${sbindir}/parse-edid"

SRC_URI[archive.md5sum] = "aadc9a21ea4a1c9819757cda973372f4"
SRC_URI[archive.sha256sum] = "bffac0107bf6a64a35291e4ca1afc8823996ca6b334f05e6debe9fa558934947"
SRC_URI[patch.md5sum] = "77a18acd52ece9540d62859e964943bf"
SRC_URI[patch.sha256sum] = "4d129037dd239adf58280cd7f1110622995d5c1ce428d53b17cbdf32cfbadb96"
