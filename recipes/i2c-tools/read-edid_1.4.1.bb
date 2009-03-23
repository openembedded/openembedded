DESCRIPTION = "read-edid elucidates various very useful informations from a conforming PnP monitor"
LICENSE = "GPL"

SRC_URI = "http://john.fremlin.de/programs/linux/read-edid/read-edid-${PV}.tar.gz \
           http://ftp.de.debian.org/debian/pool/main/r/read-edid/read-edid_1.4.1-2.1.diff.gz;patch=1 "

inherit autotools

do_compile() {
	oe_runmake parse-edid
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 0755 parse-edid ${D}/${sbindir}/
}

PACKAGES =+ "parse-edid"
FILES_parse-edid = "${sbindir}/parse-edid"
